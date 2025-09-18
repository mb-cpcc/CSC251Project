import java.util.Scanner;

public class Project_Melaniya_Batsuk {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the Policy Number: ");
        String policyNumber = keyboard.nextLine();

        System.out.print("Please enter the Provider Name: ");
        String providerName = keyboard.nextLine();

        System.out.print("Please enter the Policyholder’s First Name: ");
        String firstName = keyboard.nextLine();

        System.out.print("Please enter the Policyholder’s Last Name: ");
        String lastName = keyboard.nextLine();

        System.out.print("Please enter the Policyholder’s Age: ");
        int age = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = keyboard.nextLine();

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        double heightInches = keyboard.nextDouble();

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        double weightPounds = keyboard.nextDouble();

        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, heightInches, weightPounds);

        System.out.println();
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getPolicyholderFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getPolicyholderLastName());
        System.out.println("Policyholder’s Age: " + policy.getPolicyholderAge());
        System.out.println("Policyholder’s Smoking Status: " + policy.getPolicyholderSmokingStatus());
        System.out.printf("Policyholder’s Height: %.1f inches\n", policy.getPolicyholderHeightInches());
        System.out.printf("Policyholder’s Weight: %.1f pounds\n", policy.getPolicyholderWeightPounds());
        System.out.printf("Policyholder’s BMI: %.2f\n", policy.getBMI());
        System.out.printf("Policy Price: $%.2f\n", policy.getPrice());
    }
}
