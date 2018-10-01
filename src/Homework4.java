import java.util.Random;
import java.util.Scanner;

/**
 * Created by Валентин on 20.09.2018.
 */
public class Homework4 {

    public static void main(String[] args) {
        initField(SIZE_OF_FIELD,field);
        printField(SIZE_OF_FIELD,field);

        while(true){
            playerMove();
            printField(SIZE_OF_FIELD,field);
            if(checkWinner(PLAYER)){
                System.out.println("Player win");
                break;
            }else if(fullField()){
                System.out.println("Field is full!\n" + "It's draw");
                break;
            }
          computerMove();
            System.out.println("\n" + "Now computer move right now");
            printField(SIZE_OF_FIELD,field);
            if (checkWinner(COMP)){
                System.out.println("Bot win");
                break;
            }else if(fullField()){
                System.out.println("Field is full!\n" + "It's draw");
                break;
            }
        }

    }

    static final int COUNT_TO_WIN = 4;
    static final int PLAYER = 1;
    static final int COMP = 0;
    static final int EMPTY = 5;
    static final int SIZE_OF_FIELD = 5;
    static int[][] field = new int[SIZE_OF_FIELD][SIZE_OF_FIELD];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void initField(int size, int[][] field) {
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                field[i][j] = EMPTY;
            }
        }
    }

    public static void printField(int size, int[][] field) {
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                System.out.print("|" + field[i][j] + "| ");
            }
            System.out.println();
        }
    }

    public static void setMove(int x, int y, int chip) {
        field[x][y] = chip;
    }

    public static void playerMove() {

        int x;
        int y;
        do {
            System.out.println("Please enter X and Y from 1 to " + SIZE_OF_FIELD);

            x = scanner.nextInt()-1;
            y = scanner.nextInt()-1;


        } while (!isEmpty(x, y));
        setMove(x, y, PLAYER);
    }

    public static void computerMove() {
        int x;
        int y;
        do {


            x = random.nextInt(SIZE_OF_FIELD);
            y = random.nextInt(SIZE_OF_FIELD);


        } while (!isEmpty(x, y));
        setMove(x, y, COMP);
    }

    public static boolean isEmpty(int x, int y) {
        if (x > SIZE_OF_FIELD - 1 || y > SIZE_OF_FIELD - 1 || x < 0 || y < 0) {
            return false;
        } else if (field[x][y] == EMPTY) {
            return true;
        }
        return false;
    }

    public static boolean fullField() {
        for (int i = 0; i < SIZE_OF_FIELD; i++) {
            for (int j = 0; j < SIZE_OF_FIELD; j++) {
                if (field[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWinner(int sym) {
        int countD1 = 0;
        int countD2 = 0;
        int countX = 0;
        int countY = 0;
        for (int i = 0; i < SIZE_OF_FIELD; i++) {
            countX = 0;
            countY = 0;
            for (int j = 0; j < SIZE_OF_FIELD; j++) {
                if(i == j && field[i][j] == sym){
                    countD1++;
                }
                if(j == SIZE_OF_FIELD-1-i && field[i][SIZE_OF_FIELD-i-1] == sym){
                    countD2++;
                }
                if(field[i][j] == sym){
                    countX++;
                }
                if (field[j][i] == sym){
                    countY++;
                }
            }
            if(countD1 == COUNT_TO_WIN || countD2 == COUNT_TO_WIN || countX == COUNT_TO_WIN || countY == COUNT_TO_WIN){
                return true;
            }
        }

        return false;
    }
}











