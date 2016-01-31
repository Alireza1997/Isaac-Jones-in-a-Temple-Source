package isaacGame;
/*

 File Name: ScoresList.java
 Student Name: Raymond Zhao
 Class: ICS4U
 Date: May 26, 2015
 Description: Behaves similar to a C# static class.
    Holds all the scores that have been obtained in the game.
 */
 
import java.util.*;
import java.io.*;
public final class ScoresList {
    //a constant and fields
    private static final String SCORES_FILE_NAME = "scores/Scores.txt";
    private static ArrayList<Score> scores = new ArrayList<Score>();
    
    //this class uses a private constructor to ensure that it cannot be instantiated
    private ScoresList() {
    }
    
    //accessor for the scores
    public static ArrayList<Score> getScores() {
        return scores;
    }
    
    /**
     * Loads the scores from the scores file
     * @return true if the scores are loaded properly
     */
    public static boolean loadScores() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(SCORES_FILE_NAME));
            //vars to help read in
            String line;
            String[] arr;
            
            //vars to help instantiate score instances
            String name;
            int score;
            long date;
            
            //keep reading while can read
            while ((line = br.readLine()) != null) {
                arr = line.split("\\|");
                name = arr[0];
                score = Integer.parseInt(arr[1].trim());
                //date = Long.parseLong(arr[2].trim());
                date = Score.DATE_FORMAT.parse(arr[2].trim()).getTime();
                addScore(new Score(name, score, date));    
            }
            return true;
        }
        catch (IOException e) {
            //exception checking time
            System.err.println("Error reading scores from " + SCORES_FILE_NAME);
            System.out.println(e);
        }
        catch (NumberFormatException e) {
            System.err.println("Error parsing scores file " + SCORES_FILE_NAME + ":");
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Index out of range error while reading scores file" + SCORES_FILE_NAME + ":");
            System.err.println(e);
        }
        finally {
            //if the read succeeded it would've returned true long ago
            return false;
        }
    }
    
    /**
     * Saves the scores to the file
     * @return true if the scores are saved properly
     */
    public static boolean saveScores() {
        try {
            //initiate the writer
            BufferedWriter bw = new BufferedWriter(new FileWriter(SCORES_FILE_NAME));
            
            //write each score into the file
            for (Score s: scores) {
                bw.write(String.valueOf(s));
                bw.newLine();
            }
            
            //close the writer
            bw.close();
            
            return true;
        }
        catch (IOException e) {
            //just in case for some reason the file cannot be saved, output error
            System.err.println("Error writing scores to " + SCORES_FILE_NAME);
            return false;
        }
    }
    
    //adds a score to the scores list
    public static void addScore(Score score) {
        scores.add(score);
    }
    
    //obtains the highest score
    //USES RECURSION
    public static int getHighest(int index) {
        //get the current score
        int currentScore = scores.get(index).getScore();
        
        //if at the end of the array, return this score
        //else return the maximum between current and the right subarray
        if (index == scores.size() - 1) {
            return currentScore;
        }
        else {
            return Math.max(currentScore, getHighest(index + 1));
        }
    }
    
    //sorting algorithms:
    //for all sorts, use insertion sort since it is theoretically the fastest
    
    /**
     * Sorts the list by name alphabetically ascending
     */
    public static void sortByName() {
        //go through each pass
        for (int top = 1; top < scores.size(); top++) {
            //save copy
            Score topScore = scores.get(top);
            int j = top;
            //check to see if element can shift downwards and if lower element has name which comes after
            while (j > 0 && topScore.getName().compareTo(scores.get(j - 1).getName()) < 0) {
                scores.set(j, scores.get(j - 1));
                j--;
            }
            //set the gap to the top score
            scores.set(j, topScore);
        }
    }
    
    /**
     * Sorts the list by scores highest-first
     */
    public static void sortByScore() {
        //go through each pass
        for (int top = 1; top < scores.size(); top++) {
            //save copy
            Score topScore = scores.get(top);
            int j = top;
            //check to see if element can shift downwards and if lower element has scores which is lower
            while (j > 0 && topScore.getScore() > scores.get(j - 1).getScore()) {
                scores.set(j, scores.get(j - 1));
                j--;
            }
            //set the gap to the top score
            scores.set(j, topScore);
        }
    }
    
    /**
     * Sorts by date newest-first (highest-first)
     */
    public static void sortByDate() {
        //go through each pass
        for (int top = 1; top < scores.size(); top++) {
            //save copy
            Score topScore = scores.get(top);
            int j = top;
            //check to see if element can shift downwards and if lower element has date which is older (lower numerically) than current one
            while (j > 0 && topScore.getDate() > scores.get(j - 1).getDate()) {
                scores.set(j, scores.get(j - 1));
                j--;
            }
            //set the gap to the top score
            scores.set(j, topScore);
        }
    }
}