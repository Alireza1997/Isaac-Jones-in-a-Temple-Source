package isaacGame;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.opengl.Texture;

//i like to mover mover
public abstract class Mover {
	
	//fields
	protected Vector2f location;
	protected Vector2f velocity;
	protected Vector2f size;
	
	protected String textureFile;
	protected Texture texture;
	
	protected int health;
	protected int maxHealth;
	
	protected float acceleration;
	protected float deceleration;
	protected float maxSpeed;
	
	//constructor
	Mover(Vector2f location, Vector2f size, String textureFile, int health){
		this.location = location;
		this.size = size;
		this.textureFile = textureFile;
		this.health = health;
	}
	
	//instance methods
	//renders the mover
	protected void render(){

		glColor3f(1f, 1f, 1f);
		
		//get texture
		texture = TextureApplier.loadTexture(textureFile);
		texture.bind();
		
		//draw quad
		glBegin(GL_QUADS);
		
			glTexCoord2f(0,1);
			glVertex2f(location.getX(), location.getY());
			glTexCoord2f(1,1);
			glVertex2f(location.getX() + size.getX(), location.getY());
			glTexCoord2f(1,0);
			glVertex2f(location.getX() + size.getX(), location.getY() + size.getY());
			glTexCoord2f(0,0);
			glVertex2f(location.getX(), location.getY() + size.getY());			
			
		glEnd();
		
		this.move();
		this.accelerate();		
		this.decelerate();
	}
	
	//applies the velocity of the mover to its location
	protected void move(){
		location.addX(velocity.getX());
		location.addY(velocity.getY());
	}
	
	//subtract the health of mover by set ammount
	public void takeDamage(int damage){
		health -= damage;
	}
	
	//subtract health of mover by 1
	public void takeDamage(){
		health--;
	}
	
	protected abstract void accelerate();
	
	protected abstract void decelerate();
	
	
	
}
