import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("input.txt"));
        String proga = scanner.nextLine(); // читаем файл
        int l = proga.length();
        char[] cmdArray = proga.toCharArray();
        int n = 101;
        int[][] matrix = new int[n][n]; // создаем матрицу;
        int result = -1;
        // задать координаты;
        Robot rob = new Robot(n/2, n/2, 0, matrix);

        // запускаем робота;
        for (char cmd : cmdArray) {
            rob.executeCommand(cmd);
            if ( matrix[ rob.getX() ][ rob.getY() ] > 1) {
                result = rob.getStepCounter();
                break;
            }
        }

        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(Integer.toString(result));
        fileWriter.close();

    }
}


