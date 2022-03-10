public abstract class Driver {
    private String driverName;
    private String driverLocation;
    private Team team;

    public Driver(String driverName, String driverLocation){
        this.driverName = driverName;
        this.driverLocation = driverLocation;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}
