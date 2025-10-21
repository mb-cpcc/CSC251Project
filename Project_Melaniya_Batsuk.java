import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project_Melaniya_Batsuk {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<Policy>();

        File dataFile = new File("PolicyInformation.txt");
        Scanner fileReader = null;

        try {
            fileReader = new Scanner(dataFile);

            // Read 8 lines per policy until we run out
            while (fileReader.hasNextLine()) {
                String policyNumber = safeReadLine(fileReader);
                if (policyNumber == null) break;

                String providerName = safeReadLine(fileReader);
                if (providerName == null) break;

                String firstName = safeReadLine(fileReader);
                if (firstName == null) break;

                String lastName = safeReadLine(fileReader);
                if (lastName == null) break;

                String ageLine = safeReadLine(fileReader);
                if (ageLine == null) break;
                int age = Integer.parseInt(ageLine.trim());

                String smokingStatus = safeReadLine(fileReader);
                if (smokingStatus == null) break; // "smoker" or "non-smoker"

                String heightLine = safeReadLine(fileReader);
                if (heightLine == null) break;
                double heightInches = Double.parseDouble(heightLine.trim());

                String weightLine = safeReadLine(fileReader);
                if (weightLine == null) break;
                double weightPounds = Double.parseDouble(weightLine.trim());

                Policy p = new Policy(policyNumber, providerName, firstName, lastName,
                                      age, smokingStatus, heightInches, weightPounds);
                policies.add(p);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find PolicyInformation.txt. Place it in the CSC251Project folder and try again.");
            return;
        } finally {
            if (fileReader != null) fileReader.close();
        }

        // Step 3 — display each policy (exact formatting from your course)
        int smokerCount = 0;
        int nonSmokerCount = 0;

        for (int i = 0; i < policies.size(); i++) {
            Policy p = policies.get(i);

            System.out.println("Policy Number: " + p.getPolicyNumber());
            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println("Policyholder's First Name: " + p.getPolicyholderFirstName());
            System.out.println("Policyholder's Last Name: " + p.getPolicyholderLastName());
            System.out.println("Policyholder's Age: " + p.getPolicyholderAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getPolicyholderSmokingStatus());
            System.out.printf("Policyholder's Height: %.1f inches\n", p.getPolicyholderHeightInches());
            System.out.printf("Policyholder's Weight: %.1f pounds\n", p.getPolicyholderWeightPounds());
            System.out.printf("Policyholder's BMI: %.2f\n", p.getBMI());
            System.out.printf("Policy Price: $%.2f\n", p.getPrice());
            System.out.println();

            if (p.getPolicyholderSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        // Step 4 — totals
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }

    private static String safeReadLine(Scanner sc) {
        if (sc.hasNextLine()) return sc.nextLine();
        return null;
    }
}