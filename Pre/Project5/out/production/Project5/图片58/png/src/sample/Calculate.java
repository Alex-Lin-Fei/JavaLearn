package sample;

import java.util.Stack;
import java.util.Vector;

public class Calculate {
//    保存算术表达式的结果
    public int res;
    public boolean flag;
//    声明一个存储输入数字的数组
    public int[] nums=new int[4];
//    声明用于转换和保存算术表达式的数据结构，分别为一个栈和一个向量
    private Stack<Integer> stack=new Stack<>();
    private Vector<Integer>vec=new Vector<>();

    public Calculate(String str){
        Trans(str);
        compute();
    }
    private void Trans(String str){
        int i=0;
        int cur=-1;

        while(i<str.length()){
//            如果字符串该位置为数字
            if(isNum(str.charAt(i))){
//                计算出该数并保存在vector向量中
                int num=str.charAt(i)-'0';
                while(i+1<str.length() && isNum(str.charAt(i+1))){
                    num*=10;
                    num+=str.charAt(i+1)-'0';
                    i++;
                }
                cur++;
                nums[cur]=num;
                vec.add(num);
                i++;
            }
//            如果该位置是左括号
            else if(str.charAt(i)=='('){
//                以0为标记存入栈
                stack.push(0);
                i++;


            }

//            如果该位置为右括号
            else if(str.charAt(i)==')'){
//                将栈中的计算符号存入vector向量
                while(stack.peek()!=0){
                    vec.add(stack.peek());
                    stack.pop();
                }
//                如果此时栈中只有左括号，则删除它
                if(stack.peek()==0 && !stack.empty() ){
                    stack.pop();
                }
                i++;

            }

//            如果字符串此位置为运算符
            else{
                if(stack.empty() || stack.peek()==0){
                    if(str.charAt(i)=='+')
                        stack.push(-1);
                    else if(str.charAt(i)=='-')
                        stack.push(-2);
                    else if(str.charAt(i)=='*')
                        stack.push(-3);
                    else
                        stack.push(-4);

                    i++;
                }

                else if((str.charAt(i)=='*' || str.charAt(i)=='/') && (stack.peek()==-1 || stack.peek()==-2)){
                    if(str.charAt(i)=='*')
                        stack.push(-3);
                    else if(str.charAt(i)=='/')
                        stack.push(-4);
                    i++;
                }


                else {

                    while(true){
                        if(stack.empty() || stack.peek()=='0'){
                            if(str.charAt(i)=='+')
                                stack.push(-1);
                            else if(str.charAt(i)=='-')
                                stack.push(-2);
                            else if(str.charAt(i)=='*')
                                stack.push(-3);
                            else
                                stack.push(-4);
                            i++;
                            break;
                        }

                        else if((str.charAt(i)=='*' || str.charAt(i)=='/') && (stack.peek()==-1 || stack.peek()==-2)){
                            if(str.charAt(i)=='*')
                                stack.push(-3);
                            else if(str.charAt(i)=='/')
                                stack.push(-4);
                            i++;
                            break;
                        }
                        else{
                            vec.add(stack.peek());
                            stack.pop();
                        }
                    }
                }
            }
        }
        while(!stack.empty()){
            vec.add(stack.peek());
            stack.pop();
        }
//        设置flag值，如果输入数字个数不为4，则flag值为假，反之为真
        if(nums.length==4)
            flag=true;
        else
            flag=false;
    }

    private boolean isNum(char ch){
        if(ch<='9' && ch>='0')
            return true;
        else
            return false;
    }
//计算输入算术表达式的值
    private void compute(){
        Stack<Integer>stack=new Stack<>();
        for(int elem:vec){
            if(elem>0)
                stack.push(elem);
            else{
                switch (elem){
                    case -1:{
                        int num2=stack.peek();
                        stack.pop();
                        int num1=stack.peek();
                        stack.pop();
                        stack.push(num1+num2);
                    }
                    break;
                    case -2:{
                        int num2=stack.peek();
                        stack.pop();
                        int num1=stack.peek();
                        stack.pop();
                        stack.push(num1-num2);
                    }
                    break;
                    case -3:{
                        int num2=stack.peek();
                        stack.pop();
                        int num1=stack.peek();
                        stack.pop();
                        stack.push(num1*num2);
                    }
                    break;
                    case -4:{
                        int num2=stack.peek();
                        stack.pop();
                        int num1=stack.peek();
                        stack.pop();
                        stack.push(num1/num2);
                    }
                    break;
                }
            }
        }
        res=stack.peek();

    }

}
