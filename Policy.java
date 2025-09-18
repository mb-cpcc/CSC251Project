public class Policy {

   private String policyNumber;
   private String providerName;
   private String policyholderFirstName;
   private String policyholderLastName;
   private int policyholderAge;
   private String policyholderSmokingStatus;
   private double policyholderHeightInches;
   private double policyholderWeightPounds;
   
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
   
   public Policy(String policyNumber, String providerName, String firstName, String lastName, int age, String smokingStatus, double heightInches, double weightPounds) {

      this.policyNumber = policyNumber;
      this.providerName = providerName;
      this.policyholderFirstName = firstName;
      this.policyholderLastName = lastName;
      this.policyholderAge = age;
      this.policyholderSmokingStatus = smokingStatus;
      this.policyholderHeightInches = heightInches;
      this.policyholderWeightPounds = weightPounds;
    }
    
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public String getPolicyholderFirstName() { return policyholderFirstName; }
    public void setPolicyholderFirstName(String policyholderFirstName) { this.policyholderFirstName = policyholderFirstName; }

    public String getPolicyholderLastName() { return policyholderLastName; }
    public void setPolicyholderLastName(String policyholderLastName) { this.policyholderLastName = policyholderLastName; }

    public int getPolicyholderAge() { return policyholderAge; }
    public void setPolicyholderAge(int policyholderAge) { this.policyholderAge = policyholderAge; }

    public String getPolicyholderSmokingStatus() { return policyholderSmokingStatus; }
    public void setPolicyholderSmokingStatus(String policyholderSmokingStatus) { this.policyholderSmokingStatus = policyholderSmokingStatus; }

    public double getPolicyholderHeightInches() { return policyholderHeightInches; }
    public void setPolicyholderHeightInches(double policyholderHeightInches) { this.policyholderHeightInches = policyholderHeightInches; }

    public double getPolicyholderWeightPounds() { return policyholderWeightPounds; }
    public void setPolicyholderWeightPounds(double policyholderWeightPounds) { this.policyholderWeightPounds = policyholderWeightPounds; }


    public double getBMI() {
      if (policyholderHeightInches == 0) {
         return 0.0;
      }
      return (policyholderWeightPounds * 703) / (policyholderHeightInches * policyholderHeightInches);
    }
    
    public double getPrice() {
      double price = 600.0;

      if (policyholderAge > 50) {
         price = price + 75.0;
      }

      if (policyholderSmokingStatus.equalsIgnoreCase("smoker")) {
         price = price + 100.0;
      }

      double bmi = getBMI();
      if (bmi > 35.0) {
         price = price + (bmi - 35.0) * 20.0;
      }

      return price;
   }
}