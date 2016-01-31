package isaacGame;
import java.io.*;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


public class TextureApplier {
	public static Texture loadTexture(String key){
		
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/"+key+".PNG")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
