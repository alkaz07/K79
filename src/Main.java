import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("input.txt"));
        String proga = scanner.nextLine(); // читаем файл
        int l= proga.length();
        //System.out.println(l);
        char[] cmdArray= proga.toCharArray();

        int[][] matrix = new int[101][101]; // создаем матрицу;
        int counter = 0; // создаем счетчик шагов робота;
        int result=-1;
        // задать координаты;
        Robot rob = new Robot(50, 50, 0, matrix);
        int x = 50;
        int y = 50;
        int direction = 0; //направление
        matrix[x][y] = 1;
        // запускаем робота;
        for (char cmd : cmdArray ) {
            if(cmd == 'S'){
                counter++;
                if(direction == 0)
                    y++;
                if(direction == 90)
                    x++;
                if(direction == 180)
                    y--;
                if(direction == 270)
                    x--;
                if(matrix[x][y]==1){
                    result=counter;
                    break;
                }
                else
                    matrix[x][y]=1;
            }
            if(cmd == 'R'){
                direction = direction+90;
                if(direction == 360)
                    direction=0;
            }
            if(cmd == 'L'){
                direction = direction-90;
                if(direction == -90)
                    direction=270;
            }
        }

        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(Integer.toString(result));
        fileWriter.close();

    }
}