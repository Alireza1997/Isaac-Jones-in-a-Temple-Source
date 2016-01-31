package isaacGame;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class GameScreen {
	static int X_RESOLUTION = 800;
	static int Y_RESOLUTION = 600;	
	
	Player p1 = new Player();
	BuildingManager b1 = new BuildingManager (p1);
	MobTest m1 = new MobTest(p1, 100, 100);
	MobTest m2 = new MobTest(p1, 400, 400);
	
	public void gameWindow ()
	{		
		try{
			Display.setDisplayMode(new DisplayMode(X_RESOLUTION,Y_RESOLUTION));
			Display.create();
		} catch(LWJGLException e) {
			System.out.println("Error");
		}

		//initialize openGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, X_RESOLUTION, 0, Y_RESOLUTION, 1, -1);	
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		
		
		while (!Display.isCloseRequested()){
			Display.update();
			Display.sync(60);
			b1.render();
			b1.changeRoom();
			glEnable(GL_TEXTURE_2D);
			m1.drawMob();
			m2.drawMob();
			p1.render();
			glDisable(GL_TEXTURE_2D);
			renderTopBar();
		}
		Display.destroy();
	}
	
	public void renderTopBar(){
		glColor3f(.5f, .5f, .5f);	
		glBegin(GL_QUADS);
			glVertex2f(0,500 );
			glVertex2f(800, 500);
			glVertex2f(800, 600);
			glVertex2f(0, 600);
		glEnd();		
	}
}
