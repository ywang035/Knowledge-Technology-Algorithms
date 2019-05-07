package Default;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;

public class GlobalEditDistance {


    public static void main(String[] args){
       getGedDistance("message", "sages");

    }

    public static void getGedDistance(String qr, String tr){

        // setting query and term length
        int query_length = qr.length();
        int term_length = tr.length();


        // create 2-D matrix for edit distance
        int[][] d_matrix = new int[query_length+1][term_length+1];

        for (int i = 0; i <= query_length; i++) {
            d_matrix[i][0] = -i;
        }
        for (int j = 0; j <= term_length; j++) {
            d_matrix[0][j] = -j;
        }

        // double for loops to find global edit distance
        for (int i = 1; i <= query_length; i++) {
            for (int j = 1; j <= term_length; j++) {

                char q = qr.charAt(i-1);
                char t = tr.charAt(j-1);

                int num1 = d_matrix[i-1][j] - 1;
                int num2 = d_matrix[i][j-1] - 1;

                int num3;
                if(q == t){
                    num3 = d_matrix[i-1][j-1] + 1;
                }else{
                    num3 = d_matrix[i-1][j-1] - 1;
                }
                // get max from 3 numbers
                d_matrix[i][j] = Math.max(num1, Math.max(num2, num3));
            }
        }

        // print out the last number of 2-D matrix, = edit distance of query:term
        int[] lastRow = d_matrix[d_matrix.length - 1];
        int distance = lastRow[lastRow.length - 1];

        // print out 2-D matrix and edit distance
        for(int[] i: d_matrix)
            System.out.println(Arrays.toString(i));

        System.out.println("global edit distance: " + distance);
    }
}
