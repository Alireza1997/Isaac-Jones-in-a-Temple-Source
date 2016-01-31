package isaacGame;
import static org.lwjgl.opengl.GL11.*;

public class Sand extends Tile {
	public Sand(Player p1, int y_coordinate, int x_coordinate) {
		super(p1, y_coordinate, x_coordinate );
	}

	public void doEffects(){		
		glColor3f(.9f, .94f, .69f);		
		//draw quad
		drawTile();
		reset();
	}
}
