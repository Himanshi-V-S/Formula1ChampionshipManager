import java.util.ArrayList;
import java.util.Objects;

public class Race {
    private String raceDate;
    private static ArrayList <String> driverRankingRecord = new ArrayList<>();

    public Race(){
    }

    public Race(String raceDate){
        this.raceDate = raceDate;
    }

    public String getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(String raceDate) {
        this.raceDate = raceDate;
    }

    public void setDriverRankingRecord(ArrayList <String> driverRankingRecord) {
        this.driverRankingRecord = driverRankingRecord;
    }

    public ArrayList<String> getDriverRankingRecord() {
        return driverRankingRecord;
    }


    public void saveDriverRankingRecord(String driverName) {
        driverRankingRecord.add(driverName);
    }


}
