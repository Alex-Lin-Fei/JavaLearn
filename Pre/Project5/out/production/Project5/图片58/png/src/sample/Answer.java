package sample;

import javafx.collections.ObservableList;

public class Answer {
    public String res="";
    private int[] num;
    private boolean flag;
    private String[] Sign=new String[4];
    private int[] Operands=new int[4];

    public Answer(int[] num){
        this.num=num;
        solute(0,0);
        if(!flag){
            res="No Answer";
        }

    }

//    深度优先搜索求解二十四点游戏的解
    private void solute(int index,int target){
        if(flag)
            return;
        if(index>=4){
            if(target==24){
                flag=true;
                if((Sign[0].equals("+") || Sign[0].equals("-"))){
                    if(Sign[1].equals("*") || Sign[1].equals("/")){
                        res="("+Operands[0]+ Sign[0]+Operands[1]+")"+Sign[1]+Operands[2]+Sign[2]+Operands[3];
                    }
                    else{
                        if(Sign[2].equals("*") || Sign[2].equals("/")){
                            res="("+Operands[0]+ Sign[0]+Operands[1]+Sign[1]+Operands[2]+")"+Sign[2]+Operands[3];
                        }
                        else
                            res=Operands[0]+ Sign[0]+Operands[1]+Sign[1]+Operands[2]+Sign[2]+Operands[3];
                    }
                }

                else if(( (Sign[1].equals("+") || Sign[1].equals("-")) )&&( (Sign[2].equals("*") || Sign[2].equals("/"))) ) {
                    res="("+Operands[0]+ Sign[0]+Operands[1]+Sign[1]+Operands[2]+")"+Sign[2]+Operands[3];
                }
                else
                    res=Operands[0]+ Sign[0]+Operands[1]+Sign[1]+Operands[2]+Sign[2]+Operands[3];
            }
        }

        else if(index==0){
            for(int i=0;i<4;i++){
                if(num[i]!=0){
                    int TempData=num[i];
                    Operands[0]=num[i];
                    num[i]=0;
                    solute(index+1,TempData);
                    Operands[0]=0;
                    num[i]=TempData;
                }
            }
        }
        else{
            for(int i=0;i<4;i++){
                if(num[i]!=0){
                    int TempData=num[i];
                    Operands[index]=num[i];
                    num[i]=0;
                    Sign[index-1]="+";
                    solute(index+1,target+TempData);
                    Sign[index-1]="-";
                    solute(index+1,target-TempData);
                    Sign[index-1]="*";
                    solute(index+1,target*TempData);
                    if(TempData!=0 && target % TempData == 0){
                        Sign[index-1]="/";
                        solute(index+1,target/TempData);
                    }
                    num[i]=TempData;
                    Operands[index]=0;
                }
            }
        }

    }

}
