package isaacGame;
import java.io.*;

import org.lwjgl.opengl.GL11;

public class Room {
	
	//fields
	Tile [][] tiles = new Tile[10][16];
	Player p1;
	RoomID id;
	
	//constructor
	public Room(RoomID id, Player p1, char[][] charTiles, boolean [] doors, boolean [] locked){
		this.p1 = p1;
		this.id = id;
		setupTiles(charTiles, p1);
		makeDoors(doors, locked);					
	}
	
	//instance methods
	private void makeDoors(boolean[]doors, boolean[] locked){
		if (doors[0] == true){
			tiles[0][7] = new Sand(p1, 0, 7);
			tiles[0][8] = new Sand(p1, 0, 8);			
		}		
		if (doors[1] == true){
			tiles[4][15] = new Sand(p1, 4, 15);
			tiles[5][15] = new Sand(p1, 5, 15);
		}
		if (doors[2] == true){
			tiles[9][7] = new Sand(p1, 9, 7);
			tiles[9][8] = new Sand(p1, 9, 8);
		}	
		if (doors[3] == true){
			tiles[4][0] = new Sand(p1, 4, 0);
			tiles[5][0] = new Sand(p1, 5, 0);
		}
		
		if (locked[0] == true){
			tiles[0][7] = new Door(p1, 0, 7);
			tiles[0][8] = new Door(p1, 0, 8);			
		}		
		if (locked[1] == true){
			tiles[4][15] = new Door(p1, 4, 15);
			tiles[5][15] = new Door(p1, 5, 15);
		}
		if (locked[2] == true){
			tiles[9][7] = new Door(p1, 9, 7);
			tiles[9][8] = new Door(p1, 9, 8);
		}	
		if (locked[3] == true){
			tiles[4][0] = new Door(p1, 4, 0);
			tiles[5][0] = new Door(p1, 5, 0);
		}
	}
	
	private void setupTiles(char[][] charTiles, Player p1){
		
		for(int i = 0; i < 10; i++){
			for (int n = 0; n < 16; n++){
				if (charTiles[i][n] == 'I')
					tiles [i][n] = new Ice(p1, i, n);				
				if (charTiles[i][n] == 'W')
					tiles [i][n] = new Wall(p1, i, n);
				if (charTiles[i][n] == '.')
					tiles [i][n] = new Sand(p1, i , n);				
				if (charTiles[i][n] == 'H')
					tiles [i][n] = new Hole(p1, i ,n);	
				if (charTiles[i][n] == 'S')
					tiles [i][n] = new Stair(p1, i, n);
			}
		}
	}
	
	
	public void renderRoom(){	
		for (int i = 0; i < 10; i++){			
			for (int n = 0; n < 16; n++){
				tiles[i][n].doEffects();
			}
		}			
	}

	//accessors and mutators
	public void setTile(int yCoordinate, int xCoordinate, Tile tile){
		tiles[yCoordinate][xCoordinate] = tile;
	}
	
	public Tile getTile(int yCoordinate, int xCoordinate){
		return tiles[yCoordinate][xCoordinate];
	}
	
	
}
