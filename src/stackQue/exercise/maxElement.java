package stackQue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class maxElement {
    public static void main(String [] args) {

        Scanner inp = new Scanner(System.in);
        ArrayDeque<String> numbers = new ArrayDeque<>();
        int lines = Integer.parseInt(inp.nextLine());
        for(int i=0;i<lines;i++){

            String [] line = inp.nextLine().split(" ");
            if(line[0].equals("1")){
                numbers.push(line[1]);

            }
            if (line[0].equals("2")){
                numbers.pop();
            }
            if(line[0].equals("3")){
                if(!numbers.isEmpty())
                {int max = numbers.stream().mapToInt(Integer::parseInt).max().getAsInt();
                System.out.println(max);}
            }
        }
    }
}
