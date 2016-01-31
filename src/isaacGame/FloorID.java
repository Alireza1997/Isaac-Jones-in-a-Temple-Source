package isaacGame;
/*
 File Name: FloorID.java
 Student Name: Raymond Zhao
 Class: ICS4U
 Date: May 26, 2015
 Description: 
 */
public class FloorID {
    //the two fields
    private int floorNumber;
    private int layoutNumber;
    
    //a constructor which initializes the ID based on a String
    //an example string is 0_10
    public FloorID(String ID) throws NumberFormatException {
        String[] temp = ID.split("_");
        //try parsing the floor number
        try {
            floorNumber = Integer.parseInt(temp[0]);
        }
        catch (NumberFormatException ex) {
            throw new NumberFormatException("Invalid floor number " + temp[0]);
        }
        
        //try parsing the layout number
        try {
            layoutNumber = Integer.parseInt(temp[1]);
        }
        catch (NumberFormatException ex) {
            throw new NumberFormatException("Invalid layout number " + temp[1]);
        }
    }
    
    //accessors
    /**
     * returns the floor's type
     */
    public int getFloorNumber() {
        return floorNumber;
    }
    
    /**
     * returns the room's version number
     */
     public int getLayoutNumber() {
         return layoutNumber;
    }
    
    /**
     * represents the ID as a String again
     */
    @Override
    public String toString() {
        return floorNumber + "_" + layoutNumber;
    }
}