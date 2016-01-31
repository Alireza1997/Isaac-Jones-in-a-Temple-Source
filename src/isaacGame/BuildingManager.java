package isaacGame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuildingManager {

	Floor [] floors = new Floor [3];
	public static int currentFloorLevel = 0;
	private Player p1;
	FloorID tempFloorID;
	
	//constructor
	public BuildingManager (Player p1){
		this.p1 = p1;
		loadAllFloorTemplates();
	}
	
	//methods
	public void loadAllFloorTemplates(){
		//Temporary variable
		int start = 0;
		int numTemplates = 0;
		
		for (int i = 0; i < 3; i++){
			
			String line;			
			try {//read rooms from .txt
				
				char [][] floorLayout = new char[10][10];
						
				BufferedReader readFile = new BufferedReader (new FileReader("Floor_" + (i+1) +".txt"));
				
				//count templates
				numTemplates = Integer.parseInt(readFile.readLine().substring(0,1));
				
				//rng pick a random floor layout to load
				start = (int)(Math.random()*numTemplates) * 11;	
				
				//read in the ID and save it
				for(int k = 0; k < start; k++)
					readFile.readLine();				
				tempFloorID = new FloorID(readFile.readLine());
				
				//make the char array
				for(int j = 0; j < 10; j++){
					line = readFile.readLine();
					for (int n = 0; n < 10; n++){
						floorLayout [j][n] = line.charAt(n);
					}
				}
				
				floors[i] = new Floor (tempFloorID, p1, floorLayout);
				
				readFile.close();
			}catch (IOException e){
				System.out.println("Error");
			}
		}
	}
	
	public void changeRoom(){
		floors[currentFloorLevel].changeRoom();
	}
	
	public static void advanceFloor(){		
		
		if (currentFloorLevel == 2)
			System.out.println("gameOver");
		else
			currentFloorLevel ++;
	}
	
	public void render(){
		floors[currentFloorLevel].renderCurrentRoom();
	}
}
