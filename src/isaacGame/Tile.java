package isaacGame;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

abstract public class Tile {
	static int WIDTH = 50;
	static int HEIGHT = 50;
	int x_coordinate;
	int y_coordinate;
	Player p1;
	
	public Tile (Player p1, int y_coordinate, int x_coordinate){
		this.p1 = p1;
		this.x_coordinate = 50*x_coordinate;
		this.y_coordinate = 450 - 50*y_coordinate;
	}
	
	
	public void drawTile(){
		glBegin(GL_QUADS);
		
		glTexCoord2f(0,1);
			glVertex2f(x_coordinate, y_coordinate);
			glTexCoord2f(1,1);
			glVertex2f(x_coordinate + WIDTH, y_coordinate);
			glTexCoord2f(1,0);
			glVertex2f(x_coordinate + WIDTH, y_coordinate + HEIGHT);
			glTexCoord2f(0,0);
			glVertex2f(x_coordinate, y_coordinate + HEIGHT);			
			
		glEnd();
	}
	
	public void reset(){
		if (p1.getCenterX() >= x_coordinate && p1.getCenterX() <= x_coordinate + WIDTH){
			if (p1.getCenterY() >= y_coordinate && p1.getCenterY() <= y_coordinate + HEIGHT){
				p1.deceleration = -0.5f;
			}
		}
	}
	
	public abstract void doEffects();
}
