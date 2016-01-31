package isaacGame;
import static org.lwjgl.opengl.GL11.*;

public class Wall extends Tile {	
	public Wall(Player p1, int y_coordinate, int x_coordinate) {
		super(p1, y_coordinate, x_coordinate );
	}

	public void doEffects(){	
		//color & render
		glColor3f(.87f, .84f, .59f);
		drawTile();
				
		if(p1.velocity.getX() < 0){
			if (p1.location.getY() + p1.velocity.getY() < y_coordinate + p1.size.getY() && p1.location.getY() + p1.velocity.getY() > y_coordinate - p1.size.getY())
				if (p1.location.getX() + p1.velocity.getX() < x_coordinate + p1.size.getX() && p1.location.getX() + p1.velocity.getX() > x_coordinate ){
					if(p1.velocity.getX() < 0)
						p1.velocity.setX(0);
					System.out.println("hi");
			}
		}
		if(p1.velocity.getX() > 0){
			if (p1.location.getY()  + p1.velocity.getY() < y_coordinate + p1.size.getY() && p1.location.getY()  + p1.velocity.getY() > y_coordinate - p1.size.getY())
				if (p1.location.getX() + p1.velocity.getX() < x_coordinate + p1.size.getX() && p1.location.getX() + p1.velocity.getX() > x_coordinate - p1.size.getX()){
					if(p1.velocity.getX() > 0)
						p1.velocity.setX(0);
					System.out.println("hi2");
				}
		}
		
		if(p1.velocity.getY() < 0){
			if (p1.location.getX() + p1.velocity.getX() < x_coordinate + p1.size.getX() && p1.location.getX() + p1.velocity.getX() > x_coordinate - p1.size.getX())
				if (p1.location.getY() + p1.velocity.getY() < y_coordinate + p1.size.getY() && p1.location.getY()  + p1.velocity.getY() > y_coordinate){
					if(p1.velocity.getY() < 0)
						p1.velocity.setY(0);
					System.out.println("hi3");
				}
		}
		if(p1.velocity.getY() > 0){
			if (p1.location.getX() + p1.velocity.getX() < x_coordinate + p1.size.getX() && p1.location.getX() + p1.velocity.getX() > x_coordinate - p1.size.getX())
				if (p1.location.getY()  + p1.velocity.getY() < y_coordinate + p1.size.getY() && p1.location.getY()  + p1.velocity.getY() > y_coordinate - p1.size.getY()){
					if(p1.velocity.getY() > 0)
						p1.velocity.setY(0);
					System.out.println("hi4");
				}
		}
	}
}
