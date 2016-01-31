package isaacGame;
import java.io.*;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import static org.lwjgl.opengl.GL11.*;


public class Player extends Mover {
	
	Player() {
		super(new Vector2f(375,225), new Vector2f(50,50), "SmallJones", 3);
		velocity = new Vector2f(0,0);
		maxSpeed = 13;
		acceleration = 1f;
		deceleration = -0.5f;
	}	
	
	
	public void accelerate (){		
		if (Math.abs(velocity.getY())< maxSpeed){
			if (Keyboard.isKeyDown(Keyboard.KEY_W))
				velocity.addY(acceleration);
			if (Keyboard.isKeyDown(Keyboard.KEY_S))
				velocity.addY(-acceleration);
		}		
		
		if (Math.abs(velocity.getX())< maxSpeed){
			if (Keyboard.isKeyDown(Keyboard.KEY_A))
				velocity.addX(-acceleration);
			if (Keyboard.isKeyDown(Keyboard.KEY_D))
				velocity.addX(acceleration);	
		}				
	}
	
	public void decelerate(){
		if (velocity.getX() > 0){			
			velocity.addX(deceleration);
			if (velocity.getX() < 0)
				velocity.setX(0);
		}
		if (velocity.getX() < 0){			
			velocity.addX(-deceleration);
			if (velocity.getX() > 0)
				velocity.setX(0);
		}		
		if (velocity.getY() > 0){			
			velocity.addY(deceleration);
			if (velocity.getY() < 0)
				velocity.setY(0);
		}
		if (velocity.getY() < 0){
			velocity.addY(-deceleration);
			if (velocity.getY() > 0)
				velocity.setY(0);
		}
	}	
	
	
	//accessors
	public int getCenterX(){
		return (int) (location.getX()+size.getX()/2);
	}
	public int getCenterY(){
		return (int) (location.getX()+size.getY()/2);
	}
}
