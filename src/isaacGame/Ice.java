package isaacGame;
import java.io.*;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import static org.lwjgl.opengl.GL11.*;

public class Ice extends Tile {
	
	Texture iceTexture;
	
	public Ice(Player p1, int y_coordinate, int x_coordinate) {
		super(p1, y_coordinate, x_coordinate );
		
	}

	public void doEffects(){	

		glColor3f(1f, 1f, 1f);
		glEnable(GL_TEXTURE_2D);
		
		iceTexture =TextureApplier.loadTexture("IceTile");
		iceTexture.bind();
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
		glDisable(GL_TEXTURE_2D);
			
		if (p1.getCenterX() >= x_coordinate && p1.getCenterX() <= x_coordinate + WIDTH){
			if (p1.getCenterY() >= y_coordinate && p1.getCenterY() <= y_coordinate + HEIGHT){
				p1.deceleration = -0.09f;
			}
		}
		
	}
}
