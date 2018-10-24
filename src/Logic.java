/**
 * Created by Валентин on 18.10.2018.
 */
import java.util.Random;
import java.util.Scanner;

public class Logic {






    static  int countToWin ;
    static final int PLAYER1 = 1;
    static final int PLAYER2 = 0;
    static final int AI = 3;
    static final int EMPTY = 5;
    static final int FULL_FIELD = 4;
    static final String CHIP_P1 = "X";
    static final String CHIP_P2 = "O";
    static  int sizeOfField ;
    static final String P1_WIN = "P1 win";
    static final String P2_WIN = "P2 win";
    static final String COMP_WIN = "Comp win";
    static final String FULL = "Field full";
    static Random random = new Random();

    public static void initField(int[][] field) {
        sizeOfField = field.length;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = EMPTY;
            }
        }
    }

    public static String getChip(int x,int y,int[][] field) {
        int i = field[x][y];
        if (i == PLAYER1){
            return CHIP_P1;
        }else if (i == PLAYER2){
            return CHIP_P2;

        }else if(i == AI) {
            return CHIP_P2;
        }else{

            return null;
        }
    }

    public static void setMove(int x, int y, int chip,int[][] field) {
        field[x][y] = chip;
    }

    public static void playerMove(int x,int y,int[][] field,int chip) {
            setMove(x, y, chip, field);


    }

    public static void computerMove(int[][] field) {
        int x;
        int y;
        do {

            x = random.nextInt(sizeOfField);
            y = random.nextInt(sizeOfField);


        } while (!isEmpty(x, y,field));
        setMove(x, y, AI,field);
    }

    public static boolean isEmpty(int x, int y,int[][] field) {
        if(field[x][y] != EMPTY) {
            return false;
        }
        return true;
    }

    public static boolean fullField(int[][] field) {
        for (int i = 0; i < sizeOfField; i++) {
            for (int j = 0; j < sizeOfField; j++) {
                if (field[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

     static boolean checkWinner(int dot,int[][] field) {
        for (int v = 0; v< sizeOfField; v++){
            for (int h= 0; h<sizeOfField; h++) {
//анализ наличие поля для проверки
                if (h + countToWin <= sizeOfField) { //по горизонтале
                    if (checkLineHorisont(v, h, dot,field) >= countToWin) return true;

                    if (v - countToWin > -2) { //вверх по диагонале
                        if (checkDiaUp(v, h, dot,field) >= countToWin) return true;
                    }
                    if (v + countToWin <= sizeOfField) { //вниз по диагонале
                        if (checkDiaDown(v, h, dot,field) >= countToWin) return true;
                    }
                }
                if (v + countToWin <= sizeOfField) { //по вертикале
                    if (checkLineVertical(v, h, dot,field) >= countToWin) return true;
                }
            }
        }
        return false;
    }

//проверка заполнения всей линии по диагонале вверх

    private static int checkDiaUp(int v, int h, int dot,int[][] field) {
        int count=0;
        for (int i = 0, j = 0; j < countToWin; i--, j++) {
            if ((field[v+i][h+j] == dot)) count++;
        }
        return count;
    }
//проверка заполнения всей линии по диагонале вниз

    private static int checkDiaDown(int v, int h, int dot,int[][] field) {
        int count=0;
        for (int i = 0; i < countToWin; i++) {
            if ((field[i+v][i+h] == dot)) count++;
        }
        return count;
    }

    private static int checkLineHorisont(int v, int h, int dot,int[][] field) {
        int count=0;
        for (int j = h; j < countToWin + h; j++) {
            if ((field[v][j] == dot)) count++;
        }
        return count;
    }
    //проверка заполнения всей линии по вертикале
    private static int checkLineVertical(int v, int h, int dot,int[][] field) {
        int count=0;
        for (int i = v; i< countToWin + v; i++) {
            if ((field[i][h] == dot)) count++;
        }
        return count;
    }
}











