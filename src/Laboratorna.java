import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;
import java.io.*;

public class Laboratorna {
    public static void main(String[] args) throws Exception {
        int count = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Введіть назву папки: ");
        String folder_1 = input.nextLine();
        int counter = 0;
        int l = CountOfTeam();
        String[][] BoardOfResults = new String[l][5];
    }

    public static int CountOfTeam() throws Exception {
        int teams = 0;
        File folder = new File("FootballTeam");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                Scanner sc = new Scanner(new File(file.getName()));
                String[] splitted;
                String line_first;
                line_first = sc.nextLine();
                int k = Integer.parseInt(String.valueOf(line_first));
                teams += k;

            }
        }return teams;
    }
}