public class MatchAnalysis {
    private TeamStats lboro;
    private TeamStats opp;

    //create team objects
    public MatchAnalysis(TeamStats lboro, TeamStats opp) {
        this.lboro = lboro;
        this.opp = opp;
    }

    // [-1,1]. Compares values relatively.
    private double ratioDiff(double a, double b) {
        if (a + b == 0) return 0;
        return (a - b) / (a + b);
    }

    // Process Dominance Index - combines xG, progression and converison into 1 score
    public double getPDI() {
        return 0.4 * ratioDiff(lboro.getXGOpen(), opp.getXGOpen())
                + 0.3 * ratioDiff(lboro.getXGPC(), opp.getXGPC())
                + 0.2 * ratioDiff(lboro.getTPI(), opp.getTPI())
                + 0.1 * ratioDiff(lboro.getESC(), opp.getESC());
    }

    // Retention vs Loss Differential - comparing ariel vs unit play retention rate
    public double getRLD() {
        return lboro.getAerialRetentionRate() - lboro.getFloorRetentionRate();
    }


    //prints report
    public void printReport() {
        System.out.println("\n--- Match Report ---");
        System.out.printf("Open-play xG: Lboro=%.2f, Opp=%.2f%n", lboro.getXGOpen(), opp.getXGOpen());
        System.out.printf("PC xG: Lboro=%.2f, Opp=%.2f%n", lboro.getXGPC(), opp.getXGPC());
        System.out.printf("SQI (Shot Quality Index): Lboro=%.3f, Opp=%.3f%n", lboro.getSQI(), opp.getSQI());
        System.out.printf("ESC (Entry to Shot Conversion): Lboro=%.3f, Opp=%.3f%n", lboro.getESC(), opp.getESC());
        System.out.printf("xG per circle penetration: Lboro=%.3f, Opp=%.3f%n", lboro.getXGE(), opp.getXGE());
        System.out.printf("25 -> Circle progression rate: Lboro=%.3f, Opp=%.3f%n", lboro.getTPI(), opp.getTPI());
        System.out.printf("Composite Dominance Index (PDI): %.3f%n", getPDI());
        System.out.printf("Retention vs Loss Differential (RLD): %.3f%n", getRLD());
    }
}
