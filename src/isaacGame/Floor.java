package isaacGame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Floor {
	Room [][] rooms = new Room [10][10];
	char [][] charRooms = new char [10][10];
	Player p1;
	int currentX;
	int currentY;
	FloorID id;

	RoomID tempRoomID;// Temporary id used to make rooms
	
	
	//constructor reads rooms
	public Floor(FloorID ID, Player p1, char[][] charRooms){
		this.p1 = p1;
		this.charRooms = charRooms;
		setupRooms();
		
			
	}// end constructor
	
	public void renderCurrentRoom(){		
		rooms[currentY][currentX].renderRoom();
	}
	
	public void changeRoom(){
		if (p1.location.getX() >= 750){
			currentX ++;
			p1.location.setX(1) ;
		}
			
		if (p1.location.getX() <= 0){
			currentX --;
			p1.location.setX(749) ;
		}
		
		if (p1.location.getY() >= 450){
			currentY --;
			p1.location.setY(1);
		}
		
		if (p1.location.getY() <= 0){
			currentY ++;
			p1.location.setY(449);		
		}		
	}
	
	private void setupRooms(){		
		boolean [] doors;
		boolean [] locked;
		
		for (int i = 0; i < 10; i++){
			for (int n = 0; n < 10; n++){
				//make new door array for every room
				doors = new boolean [4];
				locked = new boolean [4];
				//if that location isn't a dot, it makes a room object
				if (charRooms[i][n] != '.'){	
					
					if (i!=0 && charRooms[i-1][n] != '.')
						if (charRooms[i-1][n] == 'F')
							locked[0] = true;
						else
							doors[0] = true;
					
					if (i!=9 && charRooms[i+1][n] != '.')
						if (charRooms[i+1][n] == 'F')
							locked[2] = true;
						else
							doors[2] = true;
					
					if (n!=9 && charRooms[i][n+1] != '.')
						if (charRooms[i][n+1] == 'F')
							locked[1] = true;
						else
							doors[1] = true;
					
					if (n!=0 && charRooms[i][n-1] != '.')
						if (charRooms[i][n-1] == 'F')
							locked[3] = true;
						else
							doors[3] = true;
					//create the room and send doors as constructor
					
					if (charRooms[i][n] == 'O'){
						currentX = n;
						currentY = i;
						rooms[i][n] = new Room (tempRoomID, p1, loadRoomTemplate(charRooms[i][n]), doors, locked);
					}
					else{						
						rooms[i][n] = new Room (tempRoomID, p1, loadRoomTemplate(charRooms[i][n]), doors, locked);
					}
				}
			}
		}
	}
	
	private char[][] loadRoomTemplate(char type){
		//make the char array
		//temprorary fields
		String line;		
		char [][] tiles = new char [10][16];
		int start = 0;
		int numTemplates;			
		
		try {//read rooms from .txt
			BufferedReader readFile = new BufferedReader (new FileReader("Room_" + type + ".txt"));
			
			//count templates
			numTemplates = Integer.parseInt(readFile.readLine().substring(0,1));
			
			//rng to find starting line
			start = (int)(Math.random()*numTemplates) * 11;	
			
			//skip to start
			for(int i = 0; i < start; i++)
				readFile.readLine();
			
			//read in ID
			tempRoomID = new RoomID(readFile.readLine());
			
			//start reading actual layout and save
			for(int i = 0; i < 10; i++){
				line = readFile.readLine();
				for (int n = 0; n < 16; n++){
					tiles [i][n] = line.charAt(n);
				}
			}
			readFile.close();
		}catch (IOException e){
			System.out.println("Error reading Room_" + type + ".txt");
		}
		
		//return room layout
		return tiles;
	}
}//end class
