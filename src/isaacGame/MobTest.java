package isaacGame;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

public class MobTest {
	int HEIGHT = 50;
	int WIDTH = 50;
	
	int x_coordinate = 375;
	int y_coordinate = 225;
	
	float x_velocity = 0;
	float y_velocity = 0;
	int max_speed = 5;
	float acceleration = 0.5f;
	
	Texture mobTexture;
	
	Player p1;
	public MobTest(Player p1, int x, int y){
		this.p1 = p1;
		x_coordinate = x;
		y_coordinate = y;
	}
	
	public void drawMob (){

		glColor3f(1f, 1f, 1f);
		
		//get texture
		mobTexture = TextureApplier.loadTexture("SmallJones");
		mobTexture.bind();
		
		//draw quad
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
		
		this.move();
		this.quadAcceleration();
	}
	
	private void move(){		
		x_coordinate += x_velocity;	
		y_coordinate += y_velocity;	
	}
	
	public void quadAcceleration (){
			
		if (p1.location.getY() > y_coordinate && y_velocity < max_speed)
			y_velocity += acceleration;
		if (p1.location.getY() < y_coordinate && y_velocity > -max_speed)
			y_velocity -= acceleration;			
		if (p1.location.getX() > x_coordinate && x_velocity < max_speed)
			x_velocity += acceleration;
		if (p1.location.getX() < x_coordinate && x_velocity > -max_speed)
			x_velocity -= acceleration;							
	}
}
