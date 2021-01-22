package com.example.Cut;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Controller {
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL="jdbc:mysql://localhost:3306/barbershop?serverTimezone=GMT%2B8";
    private static String USER = "root";
    private static String PASSWORD="131125fei";

    private static Connection connection;
    private static PreparedStatement pstmt;
    private static ResultSet rst;

    private static String findMemberStr = "select count(*) from Member where telephone = ?";
    private static String findBarberStr = "select count(*) from Barber where telephone = ?";
    private static String findAdminStr = "select count(*) from Administrator where telephone = ?";

    private static String registerMemberStr = "insert into Member(telephone, name, password) values(?, ?, ?)";
    private static String registerBarberStr = "insert into Barber values(?, ?, ?)";

    private static String getBalanceStr = "select balance from Member where telephone = ?";
    private static String checkMemberPasswordStr = "select password from Member where telephone = ?";
    private static String checkBarberPasswordStr = "select password from Barber where telephone = ?";
    private static String checkAdminPasswordStr = "select password from Administrator where telephone = ?";


    private static String depositStr="update Member set balance = ? where telephone = ?";

    private static String memberLogOffStr = "delete from Member where telephone = ?";
    private static String barberLogOffStr = "delete from Barber where telephone = ?";

    private static String barberInfo = "select telephone, name from Barber";
    private static String queryBill = "select actionTime, amount from Record where memberId = ?";

    private static String addBill = "insert into Record values(?, ?, ?)";

    private static String subscribeStr = "insert into Subscribe values(?,?,?,?)";
    private static String memberViewSubInfoStr = "select subscribeTime, barberId, project from Subscribe where memberId = ?";
    private static String barberViewSubInfoStr = "select subscribeTime, memberId, project from Subscribe where barberId = ?";


    //    本理发店提供的服务项目
    public String[] projects={"wash", "cut"};

    public Controller() {
        initializeJdbc();
    }
    //    连接数据库
    private void initializeJdbc() {
        try{
            Class.forName(DRIVER);
            System.out.println("Driver loaded");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected");
        }catch (Exception ignored){}
    }

//    管理员登录 返回反馈信息 （管理员姓名/对不起，您不是管理员）
    public int adminLogin(String telephone, String password) {
        try {
//            检查是否是管理员身份
            if (!hasRegistered(telephone, 0))
                return 1;

//            判断密码是否正确
            if (!checkPassword(telephone, password, 0))
                return 2;
            return 0;
//            返回该管理员的姓名用于打招呼
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 2;
    }

    //    注册
    public int register(String name, String telephone, String password, String confirm, int id) {
//        判断密码是否不一致
        if (!confirm.equals(password))
            return 3;
        else {
            try {
//            该号码已经被注册
                if (hasRegistered(telephone, id))
                    return 1;

                else {
                    //                注册
                    if (id == 1)
                        pstmt = connection.prepareStatement(registerMemberStr);
                    else
                        pstmt = connection.prepareStatement(registerBarberStr);
                    pstmt.setString(1, telephone);
                    pstmt.setString(2, name);
                    pstmt.setString(3, password);
                    pstmt.executeUpdate();

//                    如果是会员注册 将注册记录记入record
                    if (id == 1) {
                        pstmt = connection.prepareStatement(addBill);
                        pstmt.setString(1, String.valueOf(new java.sql.Timestamp(new Date().getTime())));
                        pstmt.setString(2, telephone);
                        pstmt.setString(3, "0");
                        pstmt.executeUpdate();
                    }

                    return 0;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return 2;
            }
        }
    }

    //    充值/消费
    public int ConsumeOrDeposit(String telephone, String password, double amount, boolean isDeposit) {
        try {
//            检查是否注册
            if (!hasRegistered(telephone, 1))
                return 1;

//            检验密码是否正确
            if (!checkPassword(telephone, password, 1))
                return 3;

            System.out.println("error password");

//            查看余额
            double balance = getBalance(telephone);
            if (balance < 0)
                return 2;

//            判断是充值还是消费
            pstmt = connection.prepareStatement(depositStr);
            if (!isDeposit)
                amount *= -1;
            balance += amount;
            if (balance < 0)
                return 4;
            else {
                pstmt.setString(1, String.valueOf(balance));
                pstmt.setString(2, telephone);
                pstmt.executeUpdate();

//                加入记录
                pstmt = connection.prepareStatement(addBill);
                pstmt.setString(1, String.valueOf(new java.sql.Timestamp(new Date().getTime())));
                pstmt.setString(2, telephone);
                pstmt.setString(3, String.valueOf(amount));
                pstmt.executeUpdate();
            }

            return 0;
        } catch (SQLException ignored) {
            return 2;
        }
    }

//    查询 充值/消费记录
    public ArrayList<Record> checkBill(String telephone, String password) {
        ArrayList<Record> records = new ArrayList<>();

        try {
            pstmt = connection.prepareStatement(queryBill);
            pstmt.setString(1, telephone);
            rst = pstmt.executeQuery();
            while (rst.next()) {
                records.add(new Record(rst.getTimestamp(1).toString(), rst.getDouble(2)));
            }
        }catch (SQLException ignored) { }

        return records;
    }

//  预约
    public int subscribe(String telephone, String password, String barberId, String project, String time) {
        try {
            pstmt = connection.prepareStatement(subscribeStr);
            pstmt.setString(1, time);
            pstmt.setString(2, telephone);
            pstmt.setString(3, barberId);
            pstmt.setString(4, project);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 2;
        }
        return 0;
    }

//    查看预约信息
    public ArrayList<Subscription> viewSubInfo(String telephone, String password, boolean isMember) {
        ArrayList<Subscription> subscriptions = new ArrayList<>();

        try{
            pstmt = connection.prepareStatement(isMember? memberViewSubInfoStr: barberViewSubInfoStr);
            pstmt.setString(1,  telephone);
            rst = pstmt.executeQuery();
            while (rst.next()) {
                String time = rst.getString(1);
                String id = rst.getString(2);
                String pro = rst.getString(3);

//                根据id获取客户或者理发师的名字
                String name = getNameByTel(id, isMember);
                subscriptions.add(new Subscription(time, id, name, pro));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return subscriptions;
    }

    //    删除会员
    public int logOff(String telephone, String password, int id) {
        try{
//            检查是否注册
            if (!hasRegistered(telephone, 1))
                return 1;
//            检查密码是否正确
            if (!checkPassword(telephone, password, id))
                return 3;
//                注销会员
            if (id == 1)
                pstmt = connection.prepareStatement(memberLogOffStr);
            else if (id == 2)
                pstmt = connection.prepareStatement(barberLogOffStr);
            pstmt.setString(1, telephone);
            pstmt.executeUpdate();

            return 0;
        }catch (SQLException ignored) {
            return 2;
        }
    }

//    本店的理发师名单
    public ArrayList<String[]> getBarbers() {
        ArrayList<String[]> barbers= new ArrayList<>();

        try {
            pstmt = connection.prepareStatement(barberInfo);
            rst = pstmt.executeQuery();
            while (rst.next())
                barbers.add(new String[]{rst.getString(1), rst.getString(2)});
        }catch (SQLException ignored){}

        return barbers;
    }

    public boolean checkPassword(String telephone, String password, int id) throws SQLException {
        if (id == 1)
            pstmt = connection.prepareStatement(checkMemberPasswordStr);
        else if (id == 2)
            pstmt = connection.prepareStatement(checkBarberPasswordStr);
        else
            pstmt = connection.prepareStatement(checkAdminPasswordStr);
        pstmt.setString(1, telephone);
        rst = pstmt.executeQuery();
        return !rst.next() || rst.getString(1).equals(password);
    }

    public boolean hasRegistered(String telephone, int id) throws SQLException {
        if (id == 1)
            pstmt = connection.prepareStatement(findMemberStr);
        else if (id == 2)
            pstmt = connection.prepareStatement(findBarberStr);
        else
            pstmt = connection.prepareStatement(findAdminStr);

        pstmt.setString(1, telephone);
        rst = pstmt.executeQuery();
        if (rst.next())
            return !rst.getString(1).equals("0");
        return false;
    }

    public double getBalance(String telephone) throws SQLException {
        pstmt = connection.prepareStatement(getBalanceStr);
        pstmt.setString(1, telephone);
        rst = pstmt.executeQuery();
        if (rst.next())
            return Double.parseDouble(rst.getString(1));
        else
            return -1;
    }

    public String getNameByTel(String id, boolean isMember) throws SQLException {
        Statement stmt = connection.createStatement();
        System.out.println(id);

        ResultSet tmpRst;
//        如果是会员 需要查询的是理发师名字
        if (isMember)
            tmpRst = stmt.executeQuery("select name from Barber where telephone = " + "\"" + id + "\"");
        else
            tmpRst = stmt.executeQuery("select name from Member where telephone = " + "\"" + id + "\"");
        if (tmpRst.next())
            return tmpRst.getString(1);
        return null;
    }
}

