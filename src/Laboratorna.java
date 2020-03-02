
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

        File folder = new File(folder_1);
        File[] listOfFiles = folder.listFiles();
        int p =  listOfFiles.length;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                Scanner sc = new Scanner(new File(file.getName()));
                String[] splitted;
                String line_first;
                line_first = sc.nextLine();
                int k = Integer.parseInt(String.valueOf(line_first));

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
            }if(counter >= p){
                bubbleSort(BoardOfResults, l);
                OutPut(BoardOfResults);
            }
        }
        writeCsv(BoardOfResults, l);

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
        }
        return teams;
    }

    public static void writeCsv(String[][] BoardOfResults, int l)
    {
        try {
            File file = new File("result.csv");
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < l; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    writer.write(BoardOfResults[i][j]);
                    if (j != 4)
                    {
                        writer.write(';');
                    }
                }
                if(i != l - 1)
                {
                    writer.newLine();
                }
            }
            writer.close();
        } catch(Exception e) {}
    }
    public static void bubbleSort(String[][] BoardOfResults, int k) {
        int Min = 0;
        int a2 = 0;
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < k - i - 1; j++) {
                try {
                    s1 = BoardOfResults[j][1];
                    s2 = BoardOfResults[j + 1][1];
                    Min = Integer.parseInt(s1);
                    a2 = Integer.parseInt(s2);
                    if (Min < a2) {

                        for (int e = 0; e < 5; e++) {
                            String temp = BoardOfResults[j][e];
                            BoardOfResults[j][e] = BoardOfResults[j + 1][e];
                            BoardOfResults[j + 1][e] = temp;
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }
    public static void OutPut(String[][] BoardOfResults) throws IOException {
        System.out.println("____________Команда____О_______В_______Н_______П ");
        for (int i = 0; i < BoardOfResults.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    System.out.printf("%20s", BoardOfResults[i][j]);
                } else {
                    System.out.print("   " + BoardOfResults[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}