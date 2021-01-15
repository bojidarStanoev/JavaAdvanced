package stackQue.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class reverseNumber {



    public static void main(String [] args){

        Scanner inp = new Scanner(System.in);
        ArrayDeque<String> numbers = new ArrayDeque<>();
        String [] input = inp.nextLine().split(" ");
          //Collections.addAll(numbers,inp.nextLine().split(" "));
        for (String s: input
             ) {
            numbers.push(s);
        }

        for(int i=numbers.size();i>0;i--){
            System.out.print(numbers.pop() + " ");
        }

    }
}
