import java.util.Random;
import java.util.Scanner;

public class Ass02_Craps {
    //By Aidan Oates

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        boolean good = true;
        int point;
        int numW = 0;
        int numL = 0;
        int noGood = 0;
        String playAgain = "";


        System.out.println("Welcome to Craps!");
        //dice roll

        while (good) {
            System.out.println("The Dice are Rolling:");
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.println("Die 1: " + die1 + ",  Die 2: " + die2);
            System.out.println("  Sum: " + sum);

            //the test
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You Crapped out! ");
                numL += 1;
                do {
                    if (noGood > 0) {
                        System.out.print("Invalid input. ");
                    }
                    System.out.print("Would you like to play again? (y/n) ");
                    noGood += 1;
                    playAgain = in.nextLine();
                } while (!playAgain.equals("n") && !playAgain.equals("y"));

            } else if (sum == 7 || sum == 11) {
                System.out.println("You win Craps!");
                numW += 1;
                noGood = 0;
                do {
                    if (noGood > 0) {
                        System.out.print("Invalid input. ");
                    }
                    System.out.print("Do you like to play again? (y/n) ");
                    noGood += 1;
                    playAgain = in.nextLine();
                } while (!playAgain.equals("n") && !playAgain.equals("y"));
            } else {
                point = sum;
                System.out.println("Your total points are: " + point);
                do {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("Roll: " + sum);
                    if (sum == 7) {
                        System.out.println("Crapped out!");
                        numL += 1;
                        noGood = 0;
                        do {
                            if (noGood > 0) {
                                System.out.print("Invalid input. ");
                            }
                            System.out.print("Would you like to play again? (y/n) ");
                            noGood += 1;
                            playAgain = in.nextLine();
                        } while (!playAgain.equals("n") && !playAgain.equals("y"));


                    } else if (sum == point) {
                            System.out.println("You win!");
                            numW += 1;
                            noGood = 0;

                            do {
                                if (noGood > 0) {
                                    System.out.print("Invalid input. ");
                                }
                                System.out.print("Would you like to play again? (y/n) ");
                                noGood += 1;
                                playAgain = in.nextLine();
                            } while (!playAgain.equals("n") && !playAgain.equals("y"));

                    } else {
                        System.out.println("Trying for point. Rolling...");
                        die1 = rnd.nextInt(6) + 1;
                        die2 = rnd.nextInt(6) + 1;
                        sum = die1 + die2;
                    }
                } while (sum != 7 && sum != point);
            }
                //end Game
            if (playAgain.equals("n")) {
                good = false;
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        }
    }
}