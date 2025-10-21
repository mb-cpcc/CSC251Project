/**
 * Models a single insurance policy for one person.
 * Uses fields for policy data and calculates BMI and price on demand
 * to avoid stale data.
 */
public class Policy {
    // Instance fields
    private String policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    // store exactly "smoker" or "non-smoker"
    private String policyholderSmokingStatus;
    private double policyholderHeightInches;
    private double policyholderWeightPounds;

    /** No-arg constructor: initializes with simple defaults. */
    public Policy() {
        policyNumber = "";
        providerName = "";
        policyholderFirstName = "";
        policyholderLastName = "";
        policyholderAge = 0;
        policyholderSmokingStatus = "non-smoker";
        policyholderHeightInches = 0.0;
        policyholderWeightPounds = 0.0;
    }

    /**
     * Full-arg constructor to fully initialize a Policy.
     * @param policyNumber policy number
     * @param providerName provider/company name
     * @param firstName policyholder first name
     * @param lastName policyholder last name
     * @param age policyholder age (years)
     * @param smokingStatus "smoker" or "non-smoker"
     * @param heightInches policyholder height (inches)
     * @param weightPounds policyholder weight (pounds)
     */
    public Policy(String policyNumber, String providerName,
                  String firstName, String lastName,
                  int age, String smokingStatus,
                  double heightInches, double weightPounds) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = firstName;
        this.policyholderLastName = lastName;
        this.policyholderAge = age;
        this.policyholderSmokingStatus = smokingStatus;
        this.policyholderHeightInches = heightInches;
        this.policyholderWeightPounds = weightPounds;
    }

    /** @return the policy number */
    public String getPolicyNumber() { return policyNumber; }
    /** @param policyNumber sets the policy number */
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    /** @return the provider name */
    public String getProviderName() { return providerName; }
    /** @param providerName sets the provider name */
    public void setProviderName(String providerName) { this.providerName = providerName; }

    /** @return policyholder first name */
    public String getPolicyholderFirstName() { return policyholderFirstName; }
    /** @param policyholderFirstName sets policyholder first name */
    public void setPolicyholderFirstName(String policyholderFirstName) { this.policyholderFirstName = policyholderFirstName; }

    /** @return policyholder last name */
    public String getPolicyholderLastName() { return policyholderLastName; }
    /** @param policyholderLastName sets policyholder last name */
    public void setPolicyholderLastName(String policyholderLastName) { this.policyholderLastName = policyholderLastName; }

    /** @return policyholder age in years */
    public int getPolicyholderAge() { return policyholderAge; }
    /** @param policyholderAge sets policyholder age in years */
    public void setPolicyholderAge(int policyholderAge) { this.policyholderAge = policyholderAge; }

    /** @return "smoker" or "non-smoker" */
    public String getPolicyholderSmokingStatus() { return policyholderSmokingStatus; }
    /** @param policyholderSmokingStatus must be "smoker" or "non-smoker" */
    public void setPolicyholderSmokingStatus(String policyholderSmokingStatus) { this.policyholderSmokingStatus = policyholderSmokingStatus; }

    /** @return height in inches */
    public double getPolicyholderHeightInches() { return policyholderHeightInches; }
    /** @param policyholderHeightInches sets height in inches */
    public void setPolicyholderHeightInches(double policyholderHeightInches) { this.policyholderHeightInches = policyholderHeightInches; }

    /** @return weight in pounds */
    public double getPolicyholderWeightPounds() { return policyholderWeightPounds; }
    /** @param policyholderWeightPounds sets weight in pounds */
    public void setPolicyholderWeightPounds(double policyholderWeightPounds) { this.policyholderWeightPounds = policyholderWeightPounds; }

    /**
     * Calculates BMI using (weight * 703) / (height^2).
     * @return BMI to two decimals when formatted; returns 0.0 if height is 0 to avoid divide by zero
     */
    public double getBMI() {
        if (policyholderHeightInches == 0) {
            return 0.0;
        }
        return (policyholderWeightPounds * 703) /
               (policyholderHeightInches * policyholderHeightInches);
    }

    /**
     * Calculates the policy price based on rules:
     * base $600, +$75 if age > 50, +$100 if smoker, + (BMI-35)*20 if BMI > 35.
     * @return computed policy price
     */
    public double getPrice() {
        double price = 600.0;

        if (policyholderAge > 50) {
            price += 75.0;
        }
        if (policyholderSmokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }
        double bmi = getBMI();
        if (bmi > 35.0) {
            price += (bmi - 35.0) * 20.0;
        }
        return price;
    }
}