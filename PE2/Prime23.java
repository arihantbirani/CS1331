public class Prime23 {
    public static void main(String[] args){
        int numToCheck = 100;
        int numFactors = 2;
        int smallestFactor = numToCheck;
        int currentFactor = numToCheck - 1;

        System.out.println("Checking if " + numToCheck + " is prime...");

        while (currentFactor >= 2) {
            if (numToCheck % currentFactor == 0){
                System.out.printf(currentFactor + " divides %s!%n ",  + numToCheck);
                if (currentFactor < smallestFactor){
                    smallestFactor = currentFactor;
                }
                currentFactor--;
                numFactors++;
            }
            else {
                System.out.printf(numToCheck + " is not a multiple of %s!%n ",  + currentFactor);
                currentFactor--;
            }
        }

        System.out.println("Number to check for primality: " + numToCheck);
        System.out.println("Smallest Factor: " + smallestFactor);
        
        switch (numFactors){
            case 2: 
                System.out.println("The number is prime!");
                break;
            case 3:
                System.out.println("This number has three factors, so it is not prime.");
                break;
            case 4:
                System.out.println("This number has four factors, so it is not prime.");
                break;
            case 5:
                System.out.println("This number has five factors, so it is not prime.");
                break;
            default:
                System.out.printf("Wow! " + numFactors + " is a lot of factors! This number is not prime.");
                break;
            }
        }
    }

