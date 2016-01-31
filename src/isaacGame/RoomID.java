package isaacGame;
/*
 File Name: RoomID.java
 Student Name: Raymond Zhao
 Class: ICS4U
 Date: May 26, 2015
 Description: An ID which stores room info.
    Specifically, its type and version.
 */
public class RoomID {
    //the two fields
    private char type;
    private int number;
    
    //a constructor which initializes the ID based on a String
    //an example string is O10
    public RoomID(String ID) throws NumberFormatException {
        type = ID.charAt(0);
        
        try {
            number = Integer.parseInt(ID.substring(1));
        }
        catch (NumberFormatException ex) {
            throw new NumberFormatException("Invalid room version number " + ID.substring(1));
        }
    }
    
    //accessors
    /**
     * returns the room's type
     */
    public char getType() {
        return type;
    }
    
    /**
     * returns the room's version number
     */
    public int getNumber() {
        return number;
    }
    
    /**
     * represents the ID as a String again
     */
    @Override
    public String toString() {
        return "" + type + number;
    }
}