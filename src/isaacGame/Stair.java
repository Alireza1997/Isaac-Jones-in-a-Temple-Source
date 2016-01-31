package isaacGame;
import static org.lwjgl.opengl.GL11.glColor3f;


public class Stair extends Tile{
	public Stair(Player p1, int y_coordinate, int x_coordinate) {
		super(p1, y_coordinate, x_coordinate );
	}

	public void doEffects(){		
		glColor3f(.5f, .5f, .5f);		
		drawTile();
		if (p1.getCenterX() >= x_coordinate && p1.getCenterX() <= x_coordinate + WIDTH){
			if (p1.getCenterY() >= y_coordinate && p1.getCenterY() <= y_coordinate + HEIGHT){
				BuildingManager.advanceFloor();
			}
		}
	}
}
