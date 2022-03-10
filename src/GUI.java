import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class GUI{
    static List<Formula1Driver> driverList = new ArrayList<>();
    static List <Race> allRaceList = new ArrayList<>();

    //Constructor
    public GUI(List<Formula1Driver> driverList, List<Race> allRaceList){
        this.driverList = driverList;
        this.allRaceList = allRaceList;
    }

    public static void main(String[] args) {
        //Creating main Frame
        JFrame frame = new JFrame();
        //Setting its dimensions
        frame.setSize(1350, 700);

        //Inserting a logo image
        BufferedImage myPicture = null;
        Image newResizedImage = null;
        try {
            myPicture = ImageIO.read(new File("f1logo.png"));
            newResizedImage = myPicture.getScaledInstance(125, 145, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(newResizedImage));
        picLabel.setBounds(-30, 100, 250, 290);
        frame.add(picLabel);

        //Inserting buttons for functions
        JButton sortASCPointsBtn = new JButton("Sort Points(Ascending)");
        sortASCPointsBtn.setBounds(250, 200, 200, 30);
        frame.add(sortASCPointsBtn);

        JButton sortDSCFirstBtn = new JButton("Sort 1st positions(Descending)");
        sortDSCFirstBtn.setBounds(500, 200, 250, 30);
        frame.add(sortDSCFirstBtn);

        JButton showRacesBtn = new JButton("Show All Races");
        showRacesBtn.setBounds(800, 200, 150, 30);
        frame.add(showRacesBtn);

        //Inserting a text field
        JTextField jTextField = new JTextField("Enter Driver Name");
        jTextField.setBounds(1080, 200, 150, 30);
        frame.add(jTextField);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(1230, 200, 80, 30);
        frame.add(searchBtn);



        JButton genRaceBtn = new JButton("Generate random race");
        genRaceBtn.setBounds(250, 280, 200, 30);
        frame.add(genRaceBtn);

        JButton genProbableRaceBtn = new JButton("Generate a race with Probability");
        genProbableRaceBtn.setBounds(500, 280, 250, 30);
        frame.add(genProbableRaceBtn);


        JLabel jLabel = new JLabel();
        jLabel.setBounds(150, 320, 250, 30);

        int x = 100, y = 340, width = 250, height = 30;

        //Labels to display positions
        JLabel jLabel1 = new JLabel();
        jLabel1.setBounds(x, y, width, height);

        JLabel jLabel2 = new JLabel();
        jLabel2.setBounds(x, y + 30 * 1, width, height);

        JLabel jLabel3 = new JLabel();
        jLabel3.setBounds(x, y + 30 * 2, width, height);

        JLabel jLabel4 = new JLabel();
        jLabel4.setBounds(x, y + 30 * 3, width, height);

        JLabel jLabel5 = new JLabel();
        jLabel5.setBounds(x, y + 30 * 4, width, height);

        JLabel jLabel6 = new JLabel();
        jLabel6.setBounds(x, y + 30 * 5, width, height);

        JLabel jLabel7 = new JLabel();
        jLabel7.setBounds(x, y + 30 * 6, width, height);

        JLabel jLabel8 = new JLabel();
        jLabel8.setBounds(x, y + 30 * 7, width, height);

        JLabel jLabel9 = new JLabel();
        jLabel9.setBounds(x, y + 30 * 8, width, height);

        JLabel jLabel10 = new JLabel();
        jLabel10.setBounds(x, y + 30 * 9, width, height);

        //Labels to display drivers
        JLabel jLabelD1 = new JLabel();
        jLabelD1.setBounds(x + 50, y, width, height);

        JLabel jLabelD2 = new JLabel();
        jLabelD2.setBounds(x + 50, y + 30 * 1, width, height);

        JLabel jLabelD3 = new JLabel();
        jLabelD3.setBounds(x + 50, y + 30 * 2, width, height);

        JLabel jLabelD4 = new JLabel();
        jLabelD4.setBounds(x + 50, y + 30 * 3, width, height);

        JLabel jLabelD5 = new JLabel();
        jLabelD5.setBounds(x + 50, y + 30 * 4, width, height);

        JLabel jLabelD6 = new JLabel();
        jLabelD6.setBounds(x + 50, y + 30 * 5, width, height);

        JLabel jLabelD7 = new JLabel();
        jLabelD7.setBounds(x + 50, y + 30 * 6, width, height);

        JLabel jLabelD8 = new JLabel();
        jLabelD8.setBounds(x + 50, y + 30 * 7, width, height);

        JLabel jLabelD9 = new JLabel();
        jLabelD9.setBounds(x + 50, y + 30 * 8, width, height);

        JLabel jLabelD10 = new JLabel();
        jLabelD10.setBounds(x + 50, y + 30 * 9, width, height);

        frame.add(jLabel);
        frame.add(jLabel1);
        frame.add(jLabel2);
        frame.add(jLabel3);
        frame.add(jLabel4);
        frame.add(jLabel5);
        frame.add(jLabel6);
        frame.add(jLabel7);
        frame.add(jLabel8);
        frame.add(jLabel9);
        frame.add(jLabel10);

        frame.add(jLabelD1);
        frame.add(jLabelD2);
        frame.add(jLabelD3);
        frame.add(jLabelD4);
        frame.add(jLabelD5);
        frame.add(jLabelD6);
        frame.add(jLabelD7);
        frame.add(jLabelD8);
        frame.add(jLabelD9);
        frame.add(jLabelD10);

        JLabel racesLabel = new JLabel();
        racesLabel.setBounds(100, 320, 1200, 30);
        frame.add(racesLabel);

        String[] headings = {"DriverName", "TeamName", "Points", "1st Positions", "2nd Positions", "3rd Positions", "RaceCount"};

        String[][] data = {
                {driverList.get(0).getDriverName(), driverList.get(0).getTeam().getTeamName(), String.valueOf(driverList.get(0).getPoints()),
                        String.valueOf(driverList.get(0).getFirstPositions()), String.valueOf(driverList.get(0).getSecondPositions()),
                        String.valueOf(driverList.get(0).getThirdPositions()), String.valueOf(driverList.get(0).getRaceCount())},
                {driverList.get(1).getDriverName(), driverList.get(1).getTeam().getTeamName(), String.valueOf(driverList.get(1).getPoints()),
                        String.valueOf(driverList.get(1).getFirstPositions()), String.valueOf(driverList.get(1).getSecondPositions()),
                        String.valueOf(driverList.get(1).getThirdPositions()), String.valueOf(driverList.get(1).getRaceCount())},
                {driverList.get(2).getDriverName(), driverList.get(2).getTeam().getTeamName(), String.valueOf(driverList.get(2).getPoints()),
                        String.valueOf(driverList.get(2).getFirstPositions()), String.valueOf(driverList.get(2).getSecondPositions()),
                        String.valueOf(driverList.get(2).getThirdPositions()), String.valueOf(driverList.get(2).getRaceCount())},
                {driverList.get(3).getDriverName(), driverList.get(3).getTeam().getTeamName(), String.valueOf(driverList.get(3).getPoints()),
                        String.valueOf(driverList.get(3).getFirstPositions()), String.valueOf(driverList.get(3).getSecondPositions()),
                        String.valueOf(driverList.get(3).getThirdPositions()), String.valueOf(driverList.get(3).getRaceCount())},
                {driverList.get(4).getDriverName(), driverList.get(4).getTeam().getTeamName(), String.valueOf(driverList.get(4).getPoints()),
                        String.valueOf(driverList.get(4).getFirstPositions()), String.valueOf(driverList.get(4).getSecondPositions()),
                        String.valueOf(driverList.get(4).getThirdPositions()), String.valueOf(driverList.get(4).getRaceCount())},
                {driverList.get(5).getDriverName(), driverList.get(5).getTeam().getTeamName(), String.valueOf(driverList.get(5).getPoints()),
                        String.valueOf(driverList.get(5).getFirstPositions()), String.valueOf(driverList.get(5).getSecondPositions()),
                        String.valueOf(driverList.get(5).getThirdPositions()), String.valueOf(driverList.get(5).getRaceCount())},
                {driverList.get(6).getDriverName(), driverList.get(6).getTeam().getTeamName(), String.valueOf(driverList.get(6).getPoints()),
                        String.valueOf(driverList.get(6).getFirstPositions()), String.valueOf(driverList.get(6).getSecondPositions()),
                        String.valueOf(driverList.get(6).getThirdPositions()), String.valueOf(driverList.get(6).getRaceCount())},
                {driverList.get(7).getDriverName(), driverList.get(7).getTeam().getTeamName(), String.valueOf(driverList.get(7).getPoints()),
                        String.valueOf(driverList.get(7).getFirstPositions()), String.valueOf(driverList.get(7).getSecondPositions()),
                        String.valueOf(driverList.get(7).getThirdPositions()), String.valueOf(driverList.get(7).getRaceCount())},
                {driverList.get(8).getDriverName(), driverList.get(8).getTeam().getTeamName(), String.valueOf(driverList.get(8).getPoints()),
                        String.valueOf(driverList.get(8).getFirstPositions()), String.valueOf(driverList.get(8).getSecondPositions()),
                        String.valueOf(driverList.get(8).getThirdPositions()), String.valueOf(driverList.get(8).getRaceCount())},
                {driverList.get(9).getDriverName(), driverList.get(9).getTeam().getTeamName(), String.valueOf(driverList.get(9).getPoints()),
                        String.valueOf(driverList.get(9).getFirstPositions()), String.valueOf(driverList.get(9).getSecondPositions()),
                        String.valueOf(driverList.get(9).getThirdPositions()), String.valueOf(driverList.get(9).getRaceCount())},
        };


            //Sorting the data in descending order of points
            sort2DArrayDESC(data, data.length, 2);

            //Creating a table to display driver information
            JTable jTable = new JTable(data, headings);

            JScrollPane scrollPane = new JScrollPane(jTable);
            frame.add(scrollPane);

            frame.setVisible(true);

            //Sorting and displaying table in Ascending order of points
            sortASCPointsBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Hide previous table
                    jTable.setVisible(false);

                    //Sort previous data in ascending order of points
                    sort2DArrayASC(data, data.length, 2);

                    //Display sorted table
                    jTable.setVisible(true);
                }
            });

            //Sorting and displaying table in descending order of first positions
            sortDSCFirstBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Hide previous table
                    jTable.setVisible(false);

                    //Sort previous data in descending order of 1st positions
                    sort2DArrayDESC(data, data.length, 3);

                    //Display sorted table
                    jTable.setVisible(true);
                }
            });

            //Generate a random race
            genRaceBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Hide previous table
                    jTable.setVisible(false);

                    //An array to store the record of the race
                    String[] driverRanks = new String[11];

                    //Sort previous data in descending order of 1st positions
                    genRandomRace(data, driverRanks);

                    //Display sorted table
                    jTable.setVisible(true);

                    jLabel.setText("TOP TEN IN RACE");

                    jLabel1.setText("1ST");
                    jLabel2.setText("2ND");
                    jLabel3.setText("3RD");
                    jLabel4.setText("4TH");
                    jLabel5.setText("5TH");
                    jLabel6.setText("6TH");
                    jLabel7.setText("7TH");
                    jLabel8.setText("8TH");
                    jLabel9.setText("9TH");
                    jLabel10.setText("10TH");

                    jLabelD1.setText(driverRanks[1]);
                    jLabelD2.setText(driverRanks[2]);
                    jLabelD3.setText(driverRanks[3]);
                    jLabelD4.setText(driverRanks[4]);
                    jLabelD5.setText(driverRanks[5]);
                    jLabelD6.setText(driverRanks[6]);
                    jLabelD7.setText(driverRanks[7]);
                    jLabelD8.setText(driverRanks[8]);
                    jLabelD9.setText(driverRanks[9]);
                    jLabelD10.setText(driverRanks[10]);
                }
            });

            //Generate a random race based on probability
            genProbableRaceBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Hide previous table
                    jTable.setVisible(false);

                    //An array to store the record of the race
                    String[] driverRanks = new String[11];

                    genRaceWithProbabilty(data, driverRanks);

                    //Display sorted table
                    jTable.setVisible(true);

                    jLabel.setText("TOP TEN IN RACE");

                    jLabel1.setText("1ST");
                    jLabel2.setText("2ND");
                    jLabel3.setText("3RD");
                    jLabel4.setText("4TH");
                    jLabel5.setText("5TH");
                    jLabel6.setText("6TH");
                    jLabel7.setText("7TH");
                    jLabel8.setText("8TH");
                    jLabel9.setText("9TH");
                    jLabel10.setText("10TH");

                    jLabelD1.setText(driverRanks[1]);
                    jLabelD2.setText(driverRanks[2]);
                    jLabelD3.setText(driverRanks[3]);
                    jLabelD4.setText(driverRanks[4]);
                    jLabelD5.setText(driverRanks[5]);
                    jLabelD6.setText(driverRanks[6]);
                    jLabelD7.setText(driverRanks[7]);
                    jLabelD8.setText(driverRanks[8]);
                    jLabelD9.setText(driverRanks[9]);
                    jLabelD10.setText(driverRanks[10]);
                }
            });


        //Show all races
        showRacesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i< allRaceList.size(); i++) {
                    String date = allRaceList.get(0).getRaceDate();

                    racesLabel.setText(date + "   " +
                            allRaceList.get(i).getDriverRankingRecord().get(1) + " | " +
                            allRaceList.get(i).getDriverRankingRecord().get(2) + " | " +
                            allRaceList.get(i).getDriverRankingRecord().get(3) + " | " +
                            allRaceList.get(i).getDriverRankingRecord().get(4) + " | " +
                            allRaceList.get(i).getDriverRankingRecord().get(5) + " | " +
                            allRaceList.get(i).getDriverRankingRecord().get(6) + " | " +
                            allRaceList.get(i).getDriverRankingRecord().get(7) + " | " +
                            allRaceList.get(i).getDriverRankingRecord().get(8) + " | " +
                            allRaceList.get(i).getDriverRankingRecord().get(9) + " | " +
                            allRaceList.get(i).getDriverRankingRecord().get(10));
                }

                jLabel.setText("");

                jLabel1.setText("");
                jLabel2.setText("");
                jLabel3.setText("");
                jLabel4.setText("");
                jLabel5.setText("");
                jLabel6.setText("");
                jLabel7.setText("");
                jLabel8.setText("");
                jLabel9.setText("");
                jLabel10.setText("");

                jLabelD1.setText("");
                jLabelD2.setText("");
                jLabelD3.setText("");
                jLabelD4.setText("");
                jLabelD5.setText("");
                jLabelD6.setText("");
                jLabelD7.setText("");
                jLabelD8.setText("");
                jLabelD9.setText("");
                jLabelD10.setText("");
            }
        });

        //Searching all races of a given driver
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.getText();

            }
        });
    }

    /**
     * Method to sort a 2D array in descending order of a given column
     * @param ar
     * @param rows
     * @param columnToSort
     */

    public static void sort2DArrayDESC(String ar[][], int rows, int columnToSort){
        //Bubble sort algorithm
        for (int i = 0; i < rows-1; i++) {
            for (int j = 0; j < rows - i-1; j++) {
                if (Integer.valueOf(ar[j][columnToSort]) < Integer.valueOf(ar[j + 1][columnToSort])) {
                    //swapping rows
                    String[] temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Method to sort a 2D array in ascending order of a given column
     * @param ar
     * @param rows
     * @param columnToSort
     */
    public static void sort2DArrayASC(String ar[][], int rows, int columnToSort){
        //Bubble sort algorithm
        for (int i = 0; i < rows-1; i++) {
            for (int j = 0; j < rows - i-1; j++) {
                //Sorting rows based on points
                if (Integer.valueOf(ar[j][columnToSort]) > Integer.valueOf(ar[j + 1][columnToSort])) {
                    //swapping rows
                    String[] temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Method to generate a random race
     * @param ar
     * @param driverRanks
     */
    public static void genRandomRace(String [][] ar, String [] driverRanks){
        //Creating an array with driver indexes
        Integer[] indexArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> indexList = Arrays.asList(indexArray);
        //Shuffling the drivers(driver indexes)
        Collections.shuffle(indexList);
        indexList.toArray(indexArray);

        //Taking a random driver and assigning 1st place
        ar[indexArray[0]][3] = String.valueOf(Integer.valueOf(ar[indexArray[0]][3]) + 1);
        ar[indexArray[0]][2] = String.valueOf(Integer.valueOf(ar[indexArray[0]][2]) + 25);

        //Taking a random driver and assigning 2nd place
        ar[indexArray[1]][4] = String.valueOf(Integer.valueOf(ar[indexArray[1]][4]) + 1);
        ar[indexArray[1]][2] = String.valueOf(Integer.valueOf(ar[indexArray[1]][2]) + 18);

        //Taking a random driver and assigning 3rd place
        ar[indexArray[2]][5] = String.valueOf(Integer.valueOf(ar[indexArray[2]][5]) + 1);
        ar[indexArray[2]][2] = String.valueOf(Integer.valueOf(ar[indexArray[2]][2]) + 15);

        //Taking a random driver and assigning 4th place
        ar[indexArray[3]][2] = String.valueOf(Integer.valueOf(ar[indexArray[3]][2]) + 12);

        //Taking a random driver and assigning 5th place
        ar[indexArray[4]][2] = String.valueOf(Integer.valueOf(ar[indexArray[4]][2]) + 10);

        //Taking a random driver and assigning 6th place
        ar[indexArray[5]][2] = String.valueOf(Integer.valueOf(ar[indexArray[5]][2]) + 8);

        //Taking a random driver and assigning 7th place
        ar[indexArray[6]][2] = String.valueOf(Integer.valueOf(ar[indexArray[6]][2]) + 6);

        //Taking a random driver and assigning 8th place
        ar[indexArray[7]][2] = String.valueOf(Integer.valueOf(ar[indexArray[7]][2]) + 4);

        //Taking a random driver and assigning 9th place
        ar[indexArray[8]][2] = String.valueOf(Integer.valueOf(ar[indexArray[8]][2]) + 2);

        //Taking a random driver and assigning 10th place
        ar[indexArray[9]][2] = String.valueOf(Integer.valueOf(ar[indexArray[9]][2]) + 1);

        //Incrementing race count for the drivers in the race
        for(int i=0; i<10; i++){
            ar[indexArray[i]][6] = String.valueOf(Integer.valueOf(ar[indexArray[i]][6]) + 1);
        }

        //Storing race record information
        driverRanks[0] = ""; //Keeping 0th position vacant
        for(int i=1; i<=10; i++){
            driverRanks[i] = ar[indexList.get(i-1)][0];
        }

        ArrayList<String> driverRankList= new ArrayList<String>(Arrays.asList(driverRanks));

        Race race = new Race("10/10/2021");
        race.setDriverRankingRecord(driverRankList);
        allRaceList.add(race);


    }

    /**
     * Method to generate random race where the first place is determined based on probability
     * @param ar
     * @param driverRanks
     */

    //Reference: https://towardsdatascience.com/picking-a-random-sample-from-a-non-uniform-distribution-b1fa56973e45
    public static void genRaceWithProbabilty(String [][] ar, String[] driverRanks){
        //Creating a copy of drivers
        Formula1Driver [] driverArray = new Formula1Driver[10];

        for(int i=0; i<10; i++){
            driverArray[i] = driverList.get(i);
        }

        List <Formula1Driver> startPositionOrder = Arrays.asList(driverArray);

        //Randomly assigning positions for the drivers
        Collections.shuffle(startPositionOrder);
        startPositionOrder.toArray(driverArray);

        /*
        WINNING PROBABLITIES
        1ST - 40%
        2ND - 30%
        3RD, 4TH - 10%
        5TH - 9TH - 2%
         */

        //Creating a TreeMap to store start positions and the probability of winning for each start position
        TreeMap <Double, Integer> startPositions = new TreeMap<>();
        startPositions.put(0.4, 0);   //0.4 (1ST PLACE)
        startPositions.put(0.7, 1);   // 0.4 + 0.3 --> 0.7 (2ND PLACE)
        startPositions.put(0.8, 2);   // 0.7 + 0.1 --> 0.8 (3RD PLACE)
        startPositions.put(0.9, 3);   // 0.8 + 0.1 --> 0.9 (4TH PLACE)
        startPositions.put(0.92, 4);  // 0.9 + 0.02 --> 0.92 (5TH PLACE)
        startPositions.put(0.94, 5);  // 0.92 + 0.02 --> 0.94 (6TH PLACE)
        startPositions.put(0.96, 6);  // 0.94 + 0.02 --> 0.96 (7TH PLACE)
        startPositions.put(0.98, 7);  // 0.96 + 0.02 --> 0.98 (8TH PLACE)
        startPositions.put(1.00, 8);  // 0.98 + 0.02 --> 1.00 (9TH PLACE)

        //Generating a random winner based on given probabilties
        int winnerStartPosition = startPositions.higherEntry(Math.random()).getValue();

        int winnerIndex = 0;
        for (int i=0; i<10; i++) {
            //Locating winner in the 2D array
            if (ar[i][0].equalsIgnoreCase(driverArray[winnerStartPosition].getDriverName())) {
                winnerIndex = i;
                break;
            }
        }

        //Assigning 1st place to above determined winner
        ar[winnerIndex][3] = String.valueOf(Integer.valueOf(ar[winnerIndex][3]) + 1);
        ar[winnerIndex][2] = String.valueOf(Integer.valueOf(ar[winnerIndex][2]) + 25);


        //Creating an arraylist with the driver start positions
        ArrayList <Integer> startPosList = new ArrayList<>();
        for(int i=0; i<10; i++){
            startPosList.add(i);
        }

        //Remove the start position of winning driver
        startPosList.remove(winnerIndex);

        //Shuffling drivers
        Collections.shuffle(startPosList);

        //Taking a random driver and assigning 2nd place
        ar[startPosList.get(0)][4] = String.valueOf(Integer.valueOf(ar[startPosList.get(0)][4]) + 1);
        ar[startPosList.get(0)][2] = String.valueOf(Integer.valueOf(ar[startPosList.get(0)][2]) + 18);

        //Taking a random driver and assigning 3rd place
        ar[startPosList.get(1)][5] = String.valueOf(Integer.valueOf(ar[startPosList.get(1)][5]) + 1);
        ar[startPosList.get(1)][2] = String.valueOf(Integer.valueOf(ar[startPosList.get(1)][2]) + 15);

        //Taking a random driver and assigning 4th place
        ar[startPosList.get(2)][2] = String.valueOf(Integer.valueOf(ar[startPosList.get(2)][2]) + 12);

        //Taking a random driver and assigning 5th place
        ar[startPosList.get(3)][2] = String.valueOf(Integer.valueOf(ar[startPosList.get(3)][2]) + 10);

        //Taking a random driver and assigning 6th place
        ar[startPosList.get(4)][2] = String.valueOf(Integer.valueOf(ar[startPosList.get(5)][2]) + 8);

        //Taking a random driver and assigning 7th place
        ar[startPosList.get(5)][2] = String.valueOf(Integer.valueOf(ar[startPosList.get(5)][2]) + 6);

        //Taking a random driver and assigning 8th place
        ar[startPosList.get(6)][2] = String.valueOf(Integer.valueOf(ar[startPosList.get(6)][2]) + 4);

        //Taking a random driver and assigning 9th place
        ar[startPosList.get(7)][2] = String.valueOf(Integer.valueOf(ar[startPosList.get(7)][2]) + 2);

        //Taking a random driver and assigning 10th place
        ar[startPosList.get(8)][2] = String.valueOf(Integer.valueOf(ar[startPosList.get(8)][2]) + 1);


        //Incrementing race count for the drivers in the race
        for(int i=0; i<10; i++){
            ar[i][6] = String.valueOf(Integer.valueOf(ar[i][6]) + 1);
        }

        //Storing race record information
        driverRanks[0] = ""; //Keeping 0th position vacant
        driverRanks[1] = ar[winnerIndex][0]; //Saving name of winner

        for(int i=2; i<=10; i++){
            driverRanks[i] = ar[startPosList.get(i-2)][0]; //Saving names of drivers in positions 2-10
        }
    }
}


