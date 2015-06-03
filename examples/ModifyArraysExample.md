```java


import static org.math.array.DoubleArray.*;
 
public class ModifyArraysExample {
        public static void main(String[] args) {
 
                // initial matrix and vector
                double[][] A = { { 1.1, 1.2, 1.3, 1.4 }, { 2.1, 2.2, 2.3, 2.4 }, { 3.1, 3.2, 3.3, 3.4 } };
                double[] a = {  10, 20, 30, 40 };
                double[] b = {  100, 200, 300, 400 };
 
                // delete first and third rows
                double[][] B = deleteRows(A, 0, 2);
                
                // delete first column
                double[][] C = deleteColumns(A, 1);
                
                // delete first TO third elements of b
                double[] b2 = deleteRange(b,0,2);
 
                // insert a between first and second rows of A
                double[][] D = insertRows(A,1,a);
                
                // copy third and second rows of A
                double[][] E = getRowsCopy(A,1,2);
 
                // copy second TO fourth columns of A
                double[][] F = getColumnsRangeCopy(A,1,3);
                
                // merge a with b times
                double[][] G = mergeRows(a,b);
                
                // print matrices in command line
                System.out.println("A = \n" + tostring(A));
                System.out.println("a = \n" + tostring(a));
                System.out.println("b = \n" + tostring(b));
                System.out.println("B = \n" + tostring(B));
                System.out.println("b2 = \n" + tostring(b2));
                System.out.println("C = \n" + tostring(C));
                System.out.println("D = \n" + tostring(D));
                System.out.println("E = \n" + tostring(E));
                System.out.println("F = \n" + tostring(F));
                System.out.println("G = \n" + tostring(G));
 
        }
}


```
