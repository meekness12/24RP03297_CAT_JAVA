// Class: SoilAnalysis
class SoilAnalysis {
    private String farmerId;
    private String districtName;
    private double nitrogenLevel;
    private double phosphorusLevel;
    private double potassiumLevel;
    private String cropType;

    // Constructor initializing all fields
    public SoilAnalysis(String farmerId, String districtName, double nitrogenLevel, double phosphorusLevel, double potassiumLevel, String cropType) {
        this.farmerId = farmerId;
        this.districtName = districtName;
        this.nitrogenLevel = nitrogenLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.potassiumLevel = potassiumLevel;
        this.cropType = cropType;
    }

    // Getters
    public String getFarmerId() {
        return farmerId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public double getNitrogenLevel() {
        return nitrogenLevel;
    }

    public double getPhosphorusLevel() {
        return phosphorusLevel;
    }

    public double getPotassiumLevel() {
        return potassiumLevel;
    }

    public String getCropType() {
        return cropType;
    }

    // Check if all nutrient levels are between 20 and 100 ppm
    public boolean isBalanced() {
        return (nitrogenLevel >= 20 && nitrogenLevel <= 100)
            && (phosphorusLevel >= 20 && phosphorusLevel <= 100)
            && (potassiumLevel >= 20 && potassiumLevel <= 100);
    }

    // Calculate fertilizer recommendation
    public String calculateFertilizerNeeded() {
        if (nitrogenLevel <= 0 || phosphorusLevel <= 0 || potassiumLevel <= 0) {
            throw new IllegalArgumentException("Invalid nutrient reading");
        }

        if (isBalanced()) {
            return "OPTIMAL - Maintenance fertilizer only";
        }

        StringBuilder recommendation = new StringBuilder();

        if (nitrogenLevel < 20) {
            recommendation.append("DEFICIENT - High application needed for Nitrogen. ");
        }
        if (phosphorusLevel < 20) {
            recommendation.append("DEFICIENT - High application needed for Phosphorus. ");
        }
        if (potassiumLevel < 20) {
            recommendation.append("DEFICIENT - High application needed for Potassium. ");
        }

        if (nitrogenLevel > 100) {
            recommendation.append("EXCESS - Reduce Nitrogen application. ");
        }
        if (phosphorusLevel > 100) {
            recommendation.append("EXCESS - Reduce Phosphorus application. ");
        }
        if (potassiumLevel > 100) {
            recommendation.append("EXCESS - Reduce Potassium application. ");
        }

        return recommendation.toString().trim();
    }
}



// Class: FertilizerAdvisorySystem_24RP03297
public class Question3_FertilizerAdvisorySystem_24RP03297 {

    // Method to process multiple soil samples
    public void processSamples(SoilAnalysis[] samples) {
        int balancedCount = 0;
        int deficientCount = 0;
        int excessCount = 0;
        int invalidCount = 0;

        for (SoilAnalysis s : samples) {
            System.out.println("Farmer ID: " + s.getFarmerId());
            System.out.println("District: " + s.getDistrictName());
            System.out.println("Crop Type: " + s.getCropType());

            try {
                String recommendation = s.calculateFertilizerNeeded();
                System.out.println("Recommendation: " + recommendation);

                if (s.isBalanced()) {
                    balancedCount++;
                } else if (recommendation.toLowerCase().contains("deficient")) {
                    deficientCount++;
                } else if (recommendation.toLowerCase().contains("excess")) {
                    excessCount++;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Recommendation: " + ex.getMessage());
                invalidCount++;
            }

            System.out.println("-----------------------------------------------------");
        }

        // Summary report
        System.out.println("----------- Summary Report -----------");
        System.out.println("Balanced samples: " + balancedCount);
        System.out.println("Deficient samples: " + deficientCount);
        System.out.println("Excess samples: " + excessCount);
        System.out.println("Invalid samples: " + invalidCount);
    }

    // Main method
    public static void main(String[] args) {
        // Create sample SoilAnalysis objects
        SoilAnalysis s1 = new SoilAnalysis("F001", "Kirehe", 60, 70, 80, "Maize");         // Balanced
        SoilAnalysis s2 = new SoilAnalysis("F002", "Gicumbi", 10, 25, 30, "Beans");        // Deficient (Nitrogen)
        SoilAnalysis s3 = new SoilAnalysis("F003", "Nyagatare", 120, 90, 40, "Rice");      // Excess (Nitrogen)
        SoilAnalysis s4 = new SoilAnalysis("F004", "Bugesera", -5, 50, 60, "Sorghum");     // Invalid (Nitrogen <= 0)
        SoilAnalysis s5 = new SoilAnalysis("F005", "Musanze", 15, 10, 12, "Potatoes");     // Deficient (all below 20)

        SoilAnalysis[] samples = { s1, s2, s3, s4, s5 };

        // Process and print results
        Question3_FertilizerAdvisorySystem_24RP03297 system = new Question3_FertilizerAdvisorySystem_24RP03297();
        system.processSamples(samples);
    }
}
