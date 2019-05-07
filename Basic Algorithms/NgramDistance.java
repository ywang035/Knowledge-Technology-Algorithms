package ApproxMatchAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NgramDistance {

    public static void main(String[] args){

        // set n = 2
        getNgramDistance("mesage", "sages", 2);

    }
    public static int getNgramDistance(String qr, String tr, int n){
        int distance = 0;

        List<String> subString1 = new ArrayList<String>();
        List<String> subString2 = new ArrayList<String>();
        for (int i = 0; i < qr.length() - n + 1; i++){
            subString1.add(qr.substring(i, i + n));
        }

        for (int i = 0; i < tr.length() - n + 1; i++) {
            subString2.add(tr.substring(i, i + n));
        }

        // print out N-gram array
        System.out.println(Arrays.toString(subString1.toArray()));
        System.out.println(Arrays.toString(subString2.toArray()));

        int counter = 0;

        for (int i = 0; i < subString1.size(); i++) {
            if(subString2.contains(subString1.get(i))){
                counter ++;
            }
        }
        System.out.println("first size: " + subString1.size());
        System.out.println("second size: " + subString2.size());
        System.out.println("union size: " + counter);
        distance = subString1.size() + subString2.size() - 2*counter;
        System.out.println(n + " -gram distance: " + distance);

        return distance;
    }
}
