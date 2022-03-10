public class Formula1Driver extends Driver{
    private int firstPositions;
    private int secondPositions;
    private int thirdPositions;
    private int points;
    private int raceCount;

    public Formula1Driver(String driverName, String driverLocation) {
        super(driverName, driverLocation);
    }

    public Formula1Driver(String driverName, String driverLocation, int firstPositions, int secondPositions,
                          int thirdPositions, int points, int raceCount) {
        super(driverName, driverLocation);
        this.firstPositions = firstPositions;
        this.secondPositions = secondPositions;
        this.thirdPositions = thirdPositions;
        this.points = points;
        this.raceCount = raceCount;
    }

    //Getters and setters
    public int getFirstPositions() {
        return firstPositions;
    }

    public void setFirstPositions(int firstPositions) {
        this.firstPositions = firstPositions ;
    }

    public int getSecondPositions() {
        return secondPositions;
    }

    public void setSecondPositions(int secondPositions) {
        this.secondPositions = secondPositions;
    }

    public int getThirdPositions() {
        return thirdPositions;
    }

    public void setThirdPositions(int thirdPositions) {
        this.thirdPositions = thirdPositions;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRaceCount() {
        return raceCount;
    }

    public void setRaceCount(int raceCount) {
        this.raceCount = raceCount ;
    }


    //Other functions
    public void incrementFirstPositions() {
        this.firstPositions++ ;
    }

    public void incrementSecondPositions() {
        this.secondPositions++;
    }

    public void incrementThirdPositions() {
        this.thirdPositions++;
    }

    public void incrementPoints(int pointsToAdd) {
        this.points += pointsToAdd;
    }

    public void incrementRaceCount() {
        this.raceCount++ ;
    }
}
