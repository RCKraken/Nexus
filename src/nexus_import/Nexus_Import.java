package nexus_import;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Nexus_Import {
	
	public static BufferedImage frameIcon;
	
	public static BufferedImage grass;
	
	public static BufferedImage dirt;
	
	public static BufferedImage stone;
	
	public static BufferedImage sky;
	
	public static BufferedImage sanic;
	
	public static void loadimage() throws IOException{
		
		frameIcon = ImageIO.read(Nexus_Import.class.getResource("Nexus_Star - Copy.png"));
		
		grass = ImageIO.read(Nexus_Import.class.getResource("nexus_grass.png"));
		
		dirt = ImageIO.read(Nexus_Import.class.getResource("nexus_dirt.png"));
		
		stone = ImageIO.read(Nexus_Import.class.getResource("nexus_stone.png"));
		
		sky = ImageIO.read(Nexus_Import.class.getResource("nexus_sky.png"));
		
		sanic = ImageIO.read(Nexus_Import.class.getResource("Sanic.png"));
		
	}
	
}
