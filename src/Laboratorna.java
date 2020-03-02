import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;

public class Laboratorna {

    public static void main(String[] args) throws Exception {
        int count = 0;
        Scanner sc = new Scanner(new File("premier_league1.csv"));
        String[] splitted;
        String digits;
        String line_first;
        line_first = sc.nextLine();
        int counter = 0;
        int k = Integer.parseInt(String.valueOf(line_first));
        String[][] BoardOfResults = new String[k][5];
        while (sc.hasNext()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            splitted = sc.nextLine().split(",|:");
            for (int i = 1; i < splitted.length; i++) {
                int a = Integer.parseInt(splitted[i]);
                arrayList.add(a);

            }
            int points = 0;
            int wins = 0;
            int loses = 0;
            int draw = 0;
            for (int j = 0; j < arrayList.size(); j = j + 2) {
                if (arrayList.get(j) > arrayList.get(j + 1)) {
                    points += 3;
                    wins += 1;
                } else if (arrayList.get(j) < (arrayList.get(j + 1))) {
                    loses += 1;
                } else {
                    points += 1;
                    draw += 1;
                }
            }
            BoardOfResults[count][0] = splitted[0];
            BoardOfResults[count][1] = Integer.toString(points);
            BoardOfResults[count][2] = Integer.toString(wins);
            BoardOfResults[count][3] = Integer.toString(draw);
            BoardOfResults[count][4] = Integer.toString(loses);

            count++;


        }
        counter++;
    }




}