import javax.swing.*;
import java.util.concurrent.Callable;

public class GenericSort  {
    public static void main(String[] args) {
        Integer[] intArray = {new Integer(2),new Integer(4),new Integer(3)};

        Double[] doubleArray = {new Double(3.4),new Double(1.2),new Double(-22.1)};

        Character[] charArray = {new Character('a'),new Character('J'),new Character('R')};

        String[] stringArray = {new String("tom"),new String("john"),new String("fred")};


    }

    public static void sort(Comparable[] list){
        Comparable Min;
        int index;

        for(int i=0;i<list.length-1;i++){
            Min = list[i];
            index = i;

            for(int j=i+1;j<list.length;j++){
                if(Min.compareTo(list[j])> 0)
                {
                    Min = list[j];
                    index = j;
                }
            }
            if(index!=i){
                list[index] = list[i];
                list[i]=Min;
            }
        }
    }
}
