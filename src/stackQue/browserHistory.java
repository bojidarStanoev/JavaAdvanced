package stackQue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class browserHistory {



    public static void main(String [] args){
        Scanner inp = new Scanner(System.in);
        ArrayDeque<String> url = new ArrayDeque<>();

        while(true){

            String line = inp.nextLine();
            if(line.equals("Home")){
            break;
            }
            if(line.equals("back")){
                if(url.size()<=1){System.out.println("no previous URLs");continue;}
                url.pop();System.out.println(url.getFirst());continue;
            }
            url.push(line);
            System.out.println(line);
        }

    }
}
