package nexus_main;

import nexus_import.Nexus_Import;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class Nexus_Graphics extends Canvas{
	
	public BufferStrategy nexusBufferStrategy;
	
	public void render(){
		if(this.getBufferStrategy() == null){
			this.createBufferStrategy(2);
			nexusBufferStrategy = this.getBufferStrategy();
			
		}
		
		Graphics2D nexusG = (Graphics2D) nexusBufferStrategy.getDrawGraphics();
	
		//background
		nexusG.setColor(Color.black);
		nexusG.fillRect(0, 0, 1200, 700);
			
		//MapGen
		for(int i = 0; i < Nexus_Main.MAPX; i++){
			
			for(int j = 0; j < Nexus_Main.MAPY; j++){
				
				if(Nexus_Main.blocks[i][j] == Nexus_Main.GRASS){
					nexusG.drawImage( Nexus_Import.grass, i*10, (Nexus_Main.MAPY - j) * 10, null);
				}
				
				else if(Nexus_Main.blocks[i][j] == Nexus_Main.DIRT){
					nexusG.drawImage( Nexus_Import.dirt, i*10, (Nexus_Main.MAPY - j) * 10, null);
				}
				
				else if(Nexus_Main.blocks[i][j] == Nexus_Main.STONE){
					nexusG.drawImage( Nexus_Import.stone, i*10, (Nexus_Main.MAPY - j) * 10, null);
				}
			}
			
		}
				
			
		
				
		nexusG.dispose();
		nexusBufferStrategy.show();
		Toolkit.getDefaultToolkit().sync();
	}
}
