package stackQue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class stackOperation {

    public static void main(String [] args) {

        Scanner inp = new Scanner(System.in);
        ArrayDeque<String> numbers = new ArrayDeque<>();
        int [] commands;
         commands =  Arrays.stream(inp.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


         Arrays.stream(inp.nextLine().split(" ")).limit(commands[0]).forEach(numbers::push);

         for (int i =0;i<commands[1];i++){
             numbers.pop();
         }
            if(numbers.isEmpty()){
                System.out.println("0");
            }
         else if (numbers.contains(Integer.toString(commands[2]))){
             System.out.println("true");
         }
         else{
             int res = numbers.stream().mapToInt(Integer::parseInt).sorted().min().getAsInt();
             System.out.println(res);

         }

    }
}
