public class TeamStats {
    // Raw inputs
    private int shots;
    private int goals;
    private int circlePossessions;
    private int entries25;
    private int penaltyCorners;
    private int pcGoals;

    // Aerial vs unit play retention stats
    private int aerialRetained;
    private int aerialLost;
    private int floorRetained;
    private int floorLost;

    // Baseline probabilities - should score ~30% of PCA's and ~20% of open play shots
    private static final double P_OPEN = 0.08;
    private static final double P_PC = 0.3;

    // Constructor
    public TeamStats(int shots, int goals, int circlePossessions, int entries25,
                     int penaltyCorners, int pcGoals,
                     int aerialRetained, int aerialLost,
                     int floorRetained, int floorLost) {
        this.shots = shots;
        this.goals = goals;
        this.circlePossessions = circlePossessions;
        this.entries25 = entries25;
        this.penaltyCorners = penaltyCorners;
        this.pcGoals = pcGoals;
        this.aerialRetained = aerialRetained;
        this.aerialLost = aerialLost;
        this.floorRetained = floorRetained;
        this.floorLost = floorLost;
    }

    // measures open play shots
    public double getXGOpen() {
        return shots * P_OPEN;
    }

    //estimates expected goals from PCA's
    public double getXGPC() {
        return penaltyCorners * P_PC;
    }
    //Shot Quality Index - measures how dangerous each shot was
    public double getSQI() {
        if (shots > 0) {
            return getXGOpen() / shots;
        } else {
            return 0;
        }
    }

    // Entry to Shot Conversion - measures how often CirclePos's lead to shots
    public double getESC() {
        if (circlePossessions > 0) {
            return (double) shots / circlePossessions;
        } else {
            return 0;
        }
    }

    //expected goals per circle penetration - measures quality of entry
    public double getXGE() {
        if (circlePossessions > 0) {
            return getXGPC() / circlePossessions;
        } else {
            return 0;
        }
    }

    //25 -> Circle Progression Index - progression rate from ATT25 -> CirclePos
    public double getTPI() {
        if (entries25 > 0) {
            return (double) circlePossessions / entries25;
        } else {
            return 0;
        }
    }

    // Ariel Retention rates
    public double getAerialRetentionRate() {
        int total = aerialRetained + aerialLost;
        if (total > 0) {
            return (double) aerialRetained / total;
        } else {
            return 0;
        }
    }

    //Unit Play Retention rate
    public double getFloorRetentionRate() {
        int total = floorRetained + floorLost;
        if (total > 0) {
            return (double) floorRetained / total;
        } else {
            return 0;
        }
    }
}
