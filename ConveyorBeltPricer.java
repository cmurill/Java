import java.util.Scanner; 

public class ConveyorBeltPricer {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); 
        String continuePricingBelts; 

        do {
            // Get belt dimensions from the user. 
            System.out.print("Please enter the belt's length in meters: "); 
            double length = userInput.nextDouble(); 
            System.out.print("Please enter the belt's width in meters: "); 
            double width = userInput.nextDouble(); 

            // Ask the user whether the customer gets a discount. 
            System.out.print("If user receives a discount, please enter 1. Otherwise, enter 0: "); 
            boolean hasDiscount = userInput.nextInt() == 1; 
			
			ConveyorBelt belt = new ConveyorBelt(); 
			belt.setLength(length); 
			belt.setWidth(width); 
			belt.setHasDiscount(hasDiscount); 

            // Display belt statistics for the user. 
			System.out.println(belt.toString()); 

            // Determine whether the user has another belt they 
            //   would like to price and either exit or prompt 
            //   again for belt dimensions. 
            System.out.printf("Calculate price for an additional belt? (Y or N) "); 
            continuePricingBelts = userInput.next(); 
            System.out.println(); // Prints blank line for readability 
        } while("Y".equals(continuePricingBelts)); 

        System.out.println("Goodbye!"); 
    }

}