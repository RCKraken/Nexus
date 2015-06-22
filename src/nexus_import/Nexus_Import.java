package nexus_import;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Nexus_Import {
	
	public static BufferedImage frameIcon;
	
	public static BufferedImage grass;
	
	public static BufferedImage dirt;
	
	public static BufferedImage stone;
	
	public static void loadimage() throws IOException{
		
		frameIcon = ImageIO.read(Nexus_Import.class.getResource("Nexus_Star - Copy.png"));
		
		grass = ImageIO.read(Nexus_Import.class.getResource("Grass.png"));
		
		dirt = ImageIO.read(Nexus_Import.class.getResource("Dirt.png"));
		
		stone = ImageIO.read(Nexus_Import.class.getResource("Stone.png"));
		
	}
	
}
