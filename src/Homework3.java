import java.util.Random;
import java.util.Scanner;

/**
 * Created by Валентин on 19.09.2018.
 */
public class Homework3 {
    public static void main(String[] args) {
        //GuessNumber();
        GuessWord();
    }
    public static void GuessNumber(){
        int count = 3;
        System.out.println("Welcome to Guess what number AI get\n"+"(It could be from 0 to 9)");
        Random random = new Random();
        int AI = random.nextInt(10);


        while(true){
            System.out.println("Tell us what number do you think it is. You now have " + count + " count!");
            try {
                Scanner scan = new Scanner(System.in);
                int playerTry = scan.nextInt();
                count = count - 1;

                if (playerTry > 9 && count != 0) {
                    System.out.println("It could be ONLY from 0 - 9! \n" +
                            "Get what you deserved -1 try!");
                    continue;
                }
                if (count != 0) {
                    if (playerTry == AI) {
                        System.out.println("You win! Press 1 - to continue and 0 - to end this perfect game!");
                        playerTry = scan.nextInt();
                        if (playerTry == 1) {
                            count = 3;
                            AI = random.nextInt(10);
                        } else {
                            break;
                        }
                    } else if (playerTry < AI) {
                        System.out.println("Try again poor child and get a tip - Your number less then AI number!");
                    } else if (playerTry > AI) {
                        System.out.println("Try again poor child and get a tip - Your number bigger then AI number!");
                    }
                } else {
                    System.out.println("You lose! The number was"+ AI +"! Press 1 - to continue and 0 - to end this perfect game!");
                    playerTry = scan.nextInt();
                    if (playerTry == 1) {
                        count = 3;
                        AI = random.nextInt(10);
                    } else {
                        break;
                    }
                }

            }catch (Exception e){
                System.out.println("You need to enter a number not word!");
                count = count-1;


            }
        }
    }
    public static void GuessWord(){
        System.out.println("Welcome to another PERFECT game from me \n"+
        "It called Guess fruit or vegetable");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int num = random.nextInt(words.length);
        Scanner scanner = new Scanner(System.in);
        Boolean win = false;
        while(win == false){
            System.out.println("Please tell us what do you think it is");
            String playerTry = scanner.nextLine().toLowerCase();
            for(String word:words){
                if(words[num].equals(playerTry)){
                    System.out.println("You win!");
                    num = random.nextInt(words.length);
                    win = true;
                    break;
                }else{
                    for (int i = 0; i < words[num].length(); i++) {
                        for (int j = 0; j < playerTry.length(); j++) {
                            if(words[num].charAt(i) == playerTry.charAt(j) /*&& i == j*/){
                                System.out.print("#####"+words[num].charAt(i));

                                break;
                            }
                        }
                    }
                    System.out.println();
                    break;
                }
            }

        }

    }
}
