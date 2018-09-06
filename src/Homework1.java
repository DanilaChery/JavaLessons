import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Валентин on 06.09.2018.
 */
public class Homework1 {
    public static void main(String[] args) {
        optionalTask8(2000);
    }
    byte aByte = 12;
    short aShort = 144;
    int anInt = 100;
    long aLong = 2000;
    float aFloat = 133;
    double aDouble = 1.5;
    boolean aBoolean = true;
    char aChar = 'c';
    String str = "aString";

    public static boolean task4(int num1,int num2){
        if(num1 >= 10 && num1 <= 20 && num2 >= 10 && num2 <=20) {
            return true;
        }else {
            return false;
        }
    }
    public static String task5(int i){
        if(i >= 0){
            return "I think it's more then 0 OR it's a ZERO";
        }else {
            return "disappointed!!! It's less then 0";
        }
    }
    public static boolean task6(int i){
        if(i >= 0){
            return false;
        }else {
            return true;
        }
    }
    public static String task7(String name){
        return ("Hello," + name);
    }
    public static void optionalTask8(int year){
        if (year%4 == 0 && year%100 != 0 || year%400 == 0){
            System.out.println("Год является високосным!");
        }else{
            System.out.println("Год не является високосным...");
        }
    }
}
