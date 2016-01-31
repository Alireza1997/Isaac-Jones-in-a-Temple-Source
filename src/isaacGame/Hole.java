package isaacGame;
import static org.lwjgl.opengl.GL11.*;

public class Hole extends Tile{
	public Hole(Player p1, int y_coordinate, int x_coordinate) {
		super(p1, y_coordinate, x_coordinate );
	}

	public void doEffects(){		
		glColor3f(.1f, .1f, .1f);		
		drawTile();
		if (p1.getCenterX() >= x_coordinate && p1.getCenterX() <= x_coordinate + WIDTH){
			if (p1.getCenterY() >= y_coordinate && p1.getCenterY() <= y_coordinate + HEIGHT){
				System.out.println("dead");
			}
		}
	}
}
