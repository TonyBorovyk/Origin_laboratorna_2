import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;

public class Laboratorna {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("premier_league1.csv"));
        String[] splitted;
        String digits;
        String line_first;
        line_first = sc.nextLine();
        int k = Integer.parseInt(String.valueOf(line_first));
        String[][] BoardOfResults = new String[k][5];
        while (sc.hasNext()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            splitted = sc.nextLine().split(",|:");
            for (int i = 1; i < splitted.length; i++) {
                int a = Integer.parseInt(splitted[i]);
                arrayList.add(a);

            }
        }
    }
}
