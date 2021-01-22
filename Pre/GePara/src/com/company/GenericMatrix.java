package com.company;

public abstract class GenericMatrix<E extends Number> {
    /**abstract method for adding two elements of matrices */
    protected abstract E add(E o1,E o2);

    /**abstract method for multiplying two elements of the matrices*/
    protected abstract E multiply(E o1,E o2);

    /**abstract method for defining zero for the matrix element*/
    protected abstract E zero();

    /**add two matrices*/
    public E[][] addMatricx(E[][] matrix1,E[][] matrix2){
        if((matrix1.length!=matrix2.length) || matrix1[0].length!=matrix2[0].length){
            throw new RuntimeException("The matrices do not have the same size");
        }

        E[][] result = (E[][])new Number[matrix1.length][matrix1[0].length];

        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++)
                result[i][j]=add(matrix1[i][j],matrix2[i][j]);
        }

        return result;
    }

    /**mutiply tow matrices*/
    public E[][] multiplyMatrix(E[][] matrix1,E[][] matrix2){
        //check bound
        if(matrix1[0].length!=matrix2.length)
            throw new RuntimeException("the matrices do not have compatible size");

        E[][] result = (E[][])new Number[matrix1.length][matrix2[0].length];

        for(int i=0;i<result.length;i++){
            for(int j = 0;j<result[0].length;j++){
                result[i][j] =zero();

                for(int k = 0;k<matrix1[0].length;k++)
                    result[i][j]=add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));
            }
        }

        return result;
    }

    public static void printResult(Number[][] matrix1,Number[][] matrix2,Number[][] matrix3,char op){
        for (int i=0;i<matrix1.length;i++){
            for(int j=0;j<matrix1[0].length;j++)
                System.out.print(" "+matrix1[i][j]);

            if(i==matrix1.length/2)
                System.out.print(" "+op+" ");
            else
                System.out.print("\t");

            for(int j=0;j<matrix2.length;j++)
                System.out.print(" "+matrix2[i][j]);
            if(i == matrix1.length/2)
                System.out.print(" = ");
            else
                System.out.print("\t");
            for(int j=0;j<matrix3.length;j++)
                System.out.print(matrix3[i][j]+" ");

            System.out.println();


        }

    }


}
