package isaacGame;
/*

 File Name: Score.java
 Student Name: Raymond Zhao
 Class: ICS4U
 Date: May 26, 2015
 Description: A class which holds a score
    Each score has a name, an amount, and a date
 */
 
import java.util.*;
import java.text.*;
public class Score {
    //the fields
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("MMM dd, yyyy");
    private String name;
    private int score;
    private long date;
    
    //constructor which initializes all the fields
    public Score(String name, int score, long date) {
        this.name = name;
        this.score = score;
        this.date = date;
    }
    
    //copy constructor
    public Score(Score other) {
        this.name = other.name;
        this.score = other.score;
        this.date = other.date;
    }
    
    //accessors for each of the fields
    //the name
    public String getName() {
        return name;
    }
    //the score
    public int getScore() {
        return score;
    }
    //the date
    public long getDate() {
        return date;
    }
    
    /**
     * An accessor which returns the date in a human-readable format
     */
    public String getDateString() {
        return DATE_FORMAT.format(new Date(date));
    }
    
    //returns the date in a readable format
    @Override
    public String toString() {
        return name + "|" + score + "|" + getDateString();
    }
}