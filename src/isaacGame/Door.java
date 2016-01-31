package isaacGame;
import static org.lwjgl.opengl.GL11.*;


public class Door extends Tile{
	public Door(Player p1, int y_coordinate, int x_coordinate) {
		super(p1, y_coordinate, x_coordinate );
	}
	
	public void doEffects(){		
		glColor3f(1f, 0.5f, .5f);		
		//draw quad
		drawTile();
		reset();
	}
}
