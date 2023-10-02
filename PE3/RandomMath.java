import java.util.Scanner;
import java.util.Random;
public class RandomMath {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1, Powers of a number " );
        System.out.println("2, Random Positive Integer with Maximum ");
        System.out.println("3, Area of Random Circle ");
        System.out.println("4, Area of Random Square ");
        System.out.println("What would you like to do? ");

        int userInput = scan.nextInt();

        while (userInput > 4 || userInput < 1) {
            System.out.print("Invalid user input, type a number 1-4. ");
            userInput = scan.nextInt();
        }

        switch(userInput){
        
        case 1:
            System.out.print("What number would you like to calculate powers of? ");
            userInput = scan.nextInt();
            if (userInput == -1) {
                System.out.print("-1 raised to 0 is 1 \n-1 raised to odd powers greater than 0 is -1 \n-1 raised to even powers greater than 0 is 1. ");
            } else if (userInput == 0) {
                System.out.print("0 raised to the 0 is 1 \n0 raised to powers greater than 0 is 0 ");
            } else if (userInput == 1) {
                System.out.print("1 raised to ANY power is still 1 ");
            } else {
                int power = 0;
                do {
                    System.out.print(userInput + " raised to the " + power + " is " + Math.pow(userInput, power) + " \n");
                    power++;
                } while (Math.abs(Math.pow(userInput, power)) <= 100);
            }
            break;
    
        case 2:
            System.out.println("What is the max value you want your random number to be? ");
            userInput = scan.nextInt();
            if (userInput <= 0) {
                System.out.println("User input must be positive and non-zero.");
            } else {
                Random rand = new Random();
                int randomNumber = rand.nextInt(userInput) + 1;
                System.out.println("Your random number is " + randomNumber + ".");
            }
            break;
        
        case 3:
                int circleRadius = (int) ((Math.random() * 101));
                double circleArea = (circleRadius * circleRadius * Math.PI);
                System.out.printf("A circle of radius %d has an area of %.2f. ", circleRadius, circleArea);
                break;


        case 4:
                int sideLength = (int) ((Math.random() * 101));
                int squareArea = sideLength * sideLength;
                System.out.print("A square of side length " + sideLength + " has an area of " + squareArea + ". ");
                break;
        
        }
         scan.close();
    }
}