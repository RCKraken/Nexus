package nexus_main;


import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import nexus_import.Nexus_Import;


public class Nexus_Main {
	
	public static final byte GRASS = 1;
	public static final byte STONE = 2;
	public static final byte DIRT = 3;
	public static final int MAPX = 120;
	public static final int MAPY = 70;
	
	public static char[][] blocks = new char [MAPX][MAPY];
	
	public static Nexus_Graphics nexusCanvas = new Nexus_Graphics();
	
	public static void main(String[] args) throws InterruptedException, IOException {

		Nexus_Import.loadimage();
		
		Frame frame01 = new Frame("Nexus");
		
		frame01.setIconImage(Nexus_Import.frameIcon);
		
		frame01.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent we)
			      {
			      System.exit(0);
			      }
			   });
			   
		frame01.setSize(1200, 700);
			   
		frame01.setVisible(true);
		nexusCanvas.setSize(1200, 700);
		frame01.add(nexusCanvas);
		
		mapGen();
		gameloop();
	}
	
	static void mapGen(){
		
		for(int i = 0; i < MAPX; i++){
				
				blocks[i][6] = GRASS;
				blocks[i][5] = DIRT;
				blocks[i][4] = DIRT;
				blocks[i][3] = DIRT;
				blocks[i][2] = STONE;
				blocks[i][1] = STONE;
				blocks[i][0] = STONE;
		}
	
	}
	
	public static void gameloop() throws InterruptedException{
		
		while(true){
			
			Thread.sleep(33);
			nexusCanvas.render();
		}
	}
}

