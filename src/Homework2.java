import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Валентин on 12.09.2018.
 */
public class Homework2 {
    public static void main(String[] args) {

    }
    public static void ZeroToOne(int[] mass){
        for (int i = 0; i < mass.length; i++) {
            if(mass[i] == 0 ){
                mass[i] = 1;
            }else mass[i] =0;
        }
    }
    public static void ThreeJumps(){
        int[] mass = new int[8];
        for (int i = 0; i < 8; i++) {mass[i] = i*3;}
    }
    public static void LessThenSix(int[] mass){

        for (int i = 0; i < mass.length; i++) {
            if (mass[i]<6)mass[i]=2;
        }
    }

    public static void XMark(int[][]doubleMassive,int index){

        for (int i = 0; i < index; i++) {
            for (int j = 0;j < index; j++) {
                if (j == i || j == index-i-1 ){doubleMassive[i][j] = 1;}else doubleMassive[i][j] = 0;
            }
        }
    }
    public static void MinAndMax(int[] mass){

        int max = mass[0];
        int min = mass[0];
        for (int i:mass) {
            if(i <= max && i <= min){
                min = i;
            }else max = i;

        }
    }
    public static int[] LineUp(int[] mass,int n){
        if(n > 0 && n < mass.length){
            for (int i = 0; i < mass.length-n; i++) {
                int j = mass[i];
                mass[i] = mass[i+n];
                mass[i+n] = j;

            }

        }else if(n < 0){
            for (int i = 0; i < mass.length+n; i++) {
                int j = mass[i];
                mass[i] = mass[i-n];
                mass[i-n] = j;

            }
        }

        return mass;
    }


}
