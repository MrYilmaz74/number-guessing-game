
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Random rand=new Random();
        Scanner scan=new Scanner(System.in);
        int number=rand.nextInt(100);

        int right=0;
        int selected;
        int[] wrong= new int[5];
        boolean isWin=false;
        boolean isWrong=false;

        while (right < 5){

            System.out.println("Please enter your prediction: ");
             selected=scan.nextInt();
             if (selected < 0 || selected > 99){
                 System.out.println("Please enter a value between 0-100.");
                 if (isWrong){
                     right++;
                     System.out.println("You have made too many incorrect entries. Remaining right: " + (5 - right));

                 }else{
                     isWrong=true;
                     System.out.println("If you enter it incorrectly again, your right will be cut!");
                 }
                 continue;
             }
             if (selected == number){
                 System.out.println("Congratulations,correct guess! The number you guessed:" + number);
                 isWin=true;
                 break;
             }else {

                 System.out.println("Wrong guess!");
                 if (selected > number){
                     System.out.println(selected + " number is greater than the secret number.");
                 }else {
                     System.out.println(selected + " number is smaller than the secret number.");
                 }
                 wrong[right++]=selected;
                 System.out.println("Your remaining rights: " + (5 - right));
             }
             if (!isWin){
                 if (8 - right < right) {
                     System.out.println("You lost!");
                 }

                 if (!isWrong){
                     System.out.println("Your predictions:\n" + Arrays.toString(wrong));
                 }

             }

        }


    }
}
