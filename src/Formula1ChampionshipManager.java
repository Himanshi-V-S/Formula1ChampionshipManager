import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager{
    static Scanner scanner = new Scanner(System.in);

    //Creating an arraylist to store Formula1Driver objects
    static ArrayList<Formula1Driver> driverList = new ArrayList<>();

    //Creating an arraylist to store Race objects
    static ArrayList<Race> allRaceList = new ArrayList<>();

    public static void main(String[] args){
        //A set of sample data to run the program
        Formula1Driver f1Driver1 = new Formula1Driver("Lewis_Hamilton", "United_Kingdom", 15,3,4,370,10);
        Team team1 = new Team("Mercedes");
        f1Driver1.setTeam(team1);

        Formula1Driver f1Driver2 = new Formula1Driver("Max_Verstappen", "Netherlands", 12, 2, 5, 370, 15);
        Team team2 = new Team("Red Bull Racing");
        f1Driver2.setTeam(team2);

        Formula1Driver f1Driver3 = new Formula1Driver("Pierre_Gasly", "France", 2, 4, 5, 100, 20);
        Team team3 = new Team("AlphaTauri");
        f1Driver3.setTeam(team3);

        Formula1Driver f1Driver4 = new Formula1Driver("Fernando_Alonso", "Spain", 4,5,6, 77, 24);
        Team team4 = new Team("Alpine");
        f1Driver4.setTeam(team4);

        Formula1Driver f1Driver5 = new Formula1Driver("Sebastian_Vettel", "Germany", 0,0,0,43,0);
        Team team5 = new Team("Aston Martin");
        f1Driver5.setTeam(team5);

        Formula1Driver f1Driver6 = new Formula1Driver("George_Russell", "England", 1,1,2,15,23);
        Team team6 = new Team("Williams");
        f1Driver6.setTeam(team6);

        Formula1Driver f1Driver7 = new Formula1Driver("Kimi_Räikkönen", "Italy", 3, 2, 4, 10,10);
        Team team7 = new Team("Alfa Romeo Racing");
        f1Driver7.setTeam(team7);

        Formula1Driver f1Driver8 = new Formula1Driver("Mick_Schumacher", "Switzerland", 4, 5, 5, 0, 50);
        Team team8 = new Team("Haas F1 Team");
        f1Driver8.setTeam(team8);

        Formula1Driver f1Driver9 = new Formula1Driver("Daniel_Ricciardo", "Australia", 4, 5, 6, 0, 10);
        Team team9 = new Team("McLaren");
        f1Driver9.setTeam(team9);

        Formula1Driver f1Driver10 = new Formula1Driver("Charles_Leclerc", "Monaco", 1,3,0,0, 12);
        Team team10 = new Team("Ferrari");
        f1Driver10.setTeam(team10);

        Formula1ChampionshipManager.driverList.add(f1Driver1);
        Formula1ChampionshipManager.driverList.add(f1Driver2);
        Formula1ChampionshipManager.driverList.add(f1Driver3);
        Formula1ChampionshipManager.driverList.add(f1Driver4);
        Formula1ChampionshipManager.driverList.add(f1Driver5);
        Formula1ChampionshipManager.driverList.add(f1Driver6);
        Formula1ChampionshipManager.driverList.add(f1Driver7);
        Formula1ChampionshipManager.driverList.add(f1Driver8);
        Formula1ChampionshipManager.driverList.add(f1Driver9);
        Formula1ChampionshipManager.driverList.add(f1Driver10);

        //Calling the menu function
        activateMenu();
    }

    /**
     * Method to display Menu and direct users to the requested part of the program
     */
    public static void activateMenu(){
        int menuChoice = 999; //A value to initialize menuChoice

        while (true || menuChoice != 0) {
            System.out.println();
            System.out.println("Formula 1 Championship Menu");
            System.out.println();
            System.out.println("1: Create a new driver");
            System.out.println("2: Delete a driver and the team");
            System.out.println("3: Change the driver of a team");
            System.out.println("4: Display driver statistics");
            System.out.println("5: Display driver table");
            System.out.println("6: Add completed race record");
            System.out.println("7: Save information to a file");
            System.out.println("8: Recover saved information");
            System.out.println("9: Start GUI");
            System.out.println("0: Exit program");
            System.out.println();

            System.out.print("Enter menu option: ");
            menuChoice = scanner.nextInt();

            if (menuChoice == 1) {
                createDriver();
            } else if (menuChoice == 2) {
                deleteDriver();
            } else if (menuChoice == 3) {
                changeDriver();
            } else if (menuChoice == 4) {
                displayStatistics();
            } else if (menuChoice == 5) {
                displayDriverTable();
            } else if (menuChoice == 6) {
                recordRace();
            } else if (menuChoice == 7) {
                saveInfo();
            } else if (menuChoice == 8) {
                recoverInfo();
            } else if (menuChoice == 9) {
                startGUI(driverList, allRaceList);
            } else if (menuChoice == 0) {
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    /**
     * Method to create a driver object
     * A constructor team is also created and assigned to driver
     */
    public static void createDriver(){
        System.out.print("Enter driver name: ");
        String name = scanner.next();

        System.out.print("Enter driver location: ");
        String location = scanner.next();

        System.out.print("Enter the name of the team: ");
        String teamName = scanner.next();

        //Creating a Formula1Driver object
        Formula1Driver f1Driver = new Formula1Driver(name, location);

        //Creating a Team object
        Team team = new Team(teamName);

        //Assigning team to driver
        f1Driver.setTeam(team);

        //Storing driver object to an arraylist
        driverList.add(f1Driver);

        System.out.println("Driver was created.");
        System.out.println();
    }

    /**
     * Method to delete a driver and the corresponding constructor team
     * Displays a list of drivers with indexes. Index should be entered to delete a driver.
     *
     */
    public static void deleteDriver(){
        //Displaying a list of drivers
        for (int i=0; i < driverList.size(); i++){
            System.out.println(String.valueOf(i)+ ": " + driverList.get(i).getDriverName());
        }
        System.out.print("Enter the number of the driver to delete: ");
        int indexToDelete = scanner.nextInt();

        //Deleting the requested Formula1Driver object
        driverList.set(indexToDelete, null);

        //Removing it(null value) from the arraylist of Formula1Driver objects
        driverList.remove(indexToDelete);

        System.out.println("Driver was deleted.");
        System.out.println();
    }


    /**
     * Method to change driver of a constructor team
     * Displays a list of drivers with indexes. Index should be entered to change a driver.
     *
     */
    public static void changeDriver(){
        //Displaying a list of drivers
        for (int i=0; i < driverList.size(); i++){
            System.out.println(String.valueOf(i)+ ": " + driverList.get(i).getTeam().getTeamName());
        }
        System.out.print("Enter team number to change the driver: ");
        int indexToChange = scanner.nextInt();

        System.out.print("Enter new driver's name: ");
        String name = scanner.next();

        System.out.print("Enter new driver's location: ");
        String location = scanner.next();

        //Saving the team that needs a driver change
        Team team = driverList.get(indexToChange).getTeam();

        //Creating a new driver object
        Formula1Driver f1Driver = new Formula1Driver(name, location);

        //Assigning existing team to the new driver
        f1Driver.setTeam(team);

        //Storing driver in an arraylist
        driverList.set(indexToChange, f1Driver);

        System.out.println("Driver was changed.");
        System.out.println();
    }

    /**
     * Method to display statistics of a driver
     * Displays a list of drivers with indexes. Index should be entered to display statistics of the driver.
     * Statistics displayed: Number of first positions, second positions, third position, points and races participated
     */
    public static void displayStatistics(){
        //Displays a list of drivers
        for (int i=0; i < driverList.size(); i++){
            System.out.println(i+ " :" + driverList.get(i).getDriverName());
        }
        System.out.print("Enter the number of the driver to display statistics: ");
        int driverIndex = scanner.nextInt();

        System.out.println();
        System.out.println("Statistics of " + driverList.get(driverIndex).getDriverName());
        System.out.println();
        System.out.println("Number of First positions    : " + driverList.get(driverIndex).getFirstPositions());
        System.out.println("Number of Second positions   : " + driverList.get(driverIndex).getSecondPositions());
        System.out.println("Number of Third positions    : " + driverList.get(driverIndex).getThirdPositions());
        System.out.println("Total number of points       : " + driverList.get(driverIndex).getPoints());
        System.out.println("Number of races participated : " + driverList.get(driverIndex).getRaceCount());
        System.out.println();
    }

    /**
     * Method to display a table with driver information
     * Information displayed: DriverName, TeamName, Points, Number of first positions,Number of second positions,
       Number of third positions, number of races participated
     * Data is stored into a 2D array first. Then is printed with print formatting.
     */
    public static void displayDriverTable(){
        String [][] driverTable = new String[driverList.size()][7];

        for (int i=0; i< driverList.size(); i++) {
            driverTable[i][0] = driverList.get(i).getDriverName();
            driverTable[i][1] = driverList.get(i).getTeam().getTeamName();
            driverTable[i][2] = String.valueOf(driverList.get(i).getPoints());
            driverTable[i][3] = String.valueOf(driverList.get(i).getFirstPositions());
            driverTable[i][4] = String.valueOf(driverList.get(i).getSecondPositions());
            driverTable[i][5] = String.valueOf(driverList.get(i).getThirdPositions());
            driverTable[i][6] = String.valueOf(driverList.get(i).getRaceCount());
        }

        sort2DArray(driverTable, driverList.size(), 2);

        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Driver_Name","Team","Points","1st_Positions",
                "2nd_Positions", "3rd_Positions", "RaceCount");
        System.out.println();

        for (String [] row: driverTable){
            for (String element: row){
                System.out.printf("%-20s", element);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Method to rearrange the driver records in descending order
     * @param ar
     * @param rows
     * @param columnToSort
     * A bubble sort algorithm is used to sort drivers based on points. If points are equal, records are sorted again
       based on number of first positions.
     */

    public static void sort2DArray(String ar[][], int rows, int columnToSort){
        //Bubble sort algorithm
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < rows - i; j++) {
                //Sorting rows based on points
                if (Integer.valueOf(ar[j][columnToSort]) < Integer.valueOf(ar[j + 1][columnToSort])) {
                    //swapping rows
                    String[] temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
                //If points are equal
                else if (Integer.valueOf(ar[j][columnToSort]) == Integer.valueOf(ar[j + 1][columnToSort])) {
                    //Sorting based on number of first positions
                    if (Integer.valueOf(ar[j][columnToSort+1]) < Integer.valueOf(ar[j + 1][columnToSort+1])) {
                        //swapping rows
                        String[] temp = ar[j];
                        ar[j] = ar[j + 1];
                        ar[j + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * Method to record race details(date, driver positions)
     */
    public static void recordRace() {
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter date of the race(DD/MM/YYYY): ");
        String raceDate = scanner.next();

        if(null != raceDate && raceDate.trim().length() > 0){
            try {
                date = format.parse(raceDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Race race = new Race(raceDate);
        allRaceList.add(race);

        System.out.println();
        System.out.println("Drivers that competed in the race");
        //Display list of existing drivers
        for (int i=0; i < driverList.size(); i++){
            System.out.println(driverList.get(i).getDriverName());
        }

        //Creating an arraylist to store the driver indexes in the winning order
        ArrayList<Integer> winIndexOrder = new ArrayList<>();

        //Iterate only for the available number of drivers
        for(int i=0; i<driverList.size(); i++) {
            int position = i+1;
            System.out.print("Enter name of driver in position " + position + ": ");
            String driverName = scanner.next();

            int driverIndex = 0;
            //Search arraylist for the driver who achieved the above position
            for(int j=0; j<driverList.size();j++){
                if(driverName.equalsIgnoreCase(driverList.get(j).getDriverName())){
                    driverIndex = j;
                    //Storing driver indexes in winning order
                    winIndexOrder.add(j);
                }
            }

            //Allocating points and statistics based position
            if (position == 1) {
                driverList.get(driverIndex).incrementFirstPositions();
                driverList.get(driverIndex).incrementPoints(25);

            } else if (position == 2) {
                driverList.get(driverIndex).incrementSecondPositions();
                driverList.get(driverIndex).incrementPoints(18);

            } else if (position == 3) {
                driverList.get(driverIndex).incrementThirdPositions();
                driverList.get(driverIndex).incrementPoints(15);

            } else if (position == 4) {
                driverList.get(driverIndex).incrementPoints(12);

            } else if (position == 5) {
                driverList.get(driverIndex).incrementPoints(10);

            } else if (position == 6) {
                driverList.get(driverIndex).incrementPoints(8);

            } else if (position == 7) {
                driverList.get(driverIndex).incrementPoints(6);

            } else if (position == 8) {
                driverList.get(driverIndex).incrementPoints(4);

            } else if (position == 9) {
                driverList.get(driverIndex).incrementPoints(2);

            } else if (position == 10) {
                driverList.get(driverIndex).incrementPoints(1);

            }

            //Incrementing race count for every driver
            driverList.get(driverIndex).incrementRaceCount();
        }

        for(int i=0; i<winIndexOrder.size(); i++){
            int winIndex = winIndexOrder.get(i);
            //Saving driver positions for race record
            race.saveDriverRankingRecord(driverList.get(winIndex).getDriverName());
        }

        System.out.println("Race was recorded");
        System.out.println();
    }

    /**
     * Method to store information to a file
     * File f1DriverData.txt stores driver information
     * File f1RaceData.txr stores race records
     */
    public static void saveInfo() {
        //File to store Driver information
        try {
            FileWriter fileWriter = new FileWriter("f1DriverData.txt");
            for (int i = 0; i < driverList.size(); i++) {
                fileWriter.write(driverList.get(i).getDriverName() + ",");
                fileWriter.write(driverList.get(i).getDriverLocation() + ",");
                fileWriter.write(driverList.get(i).getFirstPositions() + ",");
                fileWriter.write(driverList.get(i).getSecondPositions()+ ",");
                fileWriter.write(driverList.get(i).getThirdPositions()+ ",");
                fileWriter.write(driverList.get(i).getPoints() + ",");
                fileWriter.write(driverList.get(i).getRaceCount()+ ",");
                fileWriter.write(driverList.get(i).getTeam().getTeamName()+ ",");
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred when storing f1 data. Try again");
            e.printStackTrace();
        }

        //File to store information about all races
        try {
            FileWriter fileWriter = new FileWriter("f1RaceData.txt");
            for (int i = 0; i < allRaceList.size(); i++) {
                fileWriter.write(allRaceList.get(i).getRaceDate() + ",");
                for (int j = 0; j < 10; j++) {
                    fileWriter.write(allRaceList.get(i).getDriverRankingRecord().get(j) + ",");
                }
                fileWriter.write("\n");
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred when storing f1 data. Try again");
            e.printStackTrace();
        }

        System.out.println("F1 data was saved to the file.");
    }

    /**
     * Method to recover information after program restarts
     */
    public static void recoverInfo() {
        //Recover driver information
        try {
            File dataFile = new File("f1DriverData.txt");
            Scanner dataReader = new Scanner(dataFile);
            while (dataReader.hasNextLine()) {
                for (int i = 0; i < driverList.size(); i++) {
                    String data = dataReader.nextLine();
                    String[] tempf1Details = data.split(",");
                    driverList.get(i).setDriverName(tempf1Details[0]);
                    driverList.get(i).setDriverLocation(tempf1Details[1]);
                    driverList.get(i).setFirstPositions(Integer.valueOf(tempf1Details[2]));
                    driverList.get(i).setSecondPositions(Integer.valueOf(tempf1Details[3]));
                    driverList.get(i).setThirdPositions(Integer.valueOf(tempf1Details[4]));
                    driverList.get(i).setPoints(Integer.valueOf(tempf1Details[5]));
                    driverList.get(i).setRaceCount(Integer.valueOf(tempf1Details[6]));

                    Team team = new Team(tempf1Details[7]);
                    driverList.get(i).setTeam(team);
                }
            }
            dataReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Recover all race information
        ArrayList <String> driverRankList = new ArrayList<>();
        try {
            File dataFile = new File("f1RaceData.txt");
            Scanner dataReader = new Scanner(dataFile);
            while (dataReader.hasNextLine()) {
                for (int i = 0; i < allRaceList.size(); i++) {
                    String data = dataReader.nextLine();
                    String[] tempf1Details = data.split(",");
                    String date = tempf1Details[0];
                    driverRankList.add(tempf1Details[1]);
                    driverRankList.add(tempf1Details[2]);
                    driverRankList.add(tempf1Details[3]);
                    driverRankList.add(tempf1Details[4]);
                    driverRankList.add(tempf1Details[5]);
                    driverRankList.add(tempf1Details[6]);
                    driverRankList.add(tempf1Details[7]);
                    driverRankList.add(tempf1Details[8]);
                    driverRankList.add(tempf1Details[9]);
                    driverRankList.add(tempf1Details[10]);

                    Race race = new Race(date);
                    race.setDriverRankingRecord(driverRankList);
                    allRaceList.add(race);
                }
            }
            dataReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("F1 Data was recovered.");
        System.out.println();

    }

    /**
     * Method to start the GUI
     * @param driverList
     * @param allRaceList
     */
    public static void startGUI(ArrayList <Formula1Driver> driverList, ArrayList <Race> allRaceList){
        String [] args = new String[0];

        GUI gui = new GUI(driverList, allRaceList);
        GUI.main(args);
    }
}

