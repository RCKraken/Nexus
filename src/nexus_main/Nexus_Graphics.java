package nexus_main;

import nexus_import.Nexus_Import;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;

public class Nexus_Graphics extends Canvas implements ImageObserver{
	
	public BufferStrategy nexusBufferStrategy;
	
	public void render(){
		if(this.getBufferStrategy() == null){
			this.createBufferStrategy(2);
			nexusBufferStrategy = this.getBufferStrategy();
			
		}
		
		Graphics2D nexusG = (Graphics2D) nexusBufferStrategy.getDrawGraphics();
	
		//background
		nexusG.setColor(Color.black);
		nexusG.fillRect(0, 0, 1200, 730);
		
		//sky
		nexusG.drawImage(Nexus_Import.sky, 0, 0, 6674, 450, null);
		
		//mudMan
		nexusG.drawImage(Nexus_Import.mudMan.getImage(), 300, 340, this);
		
		//MapGen
		for(int i = 0; i < Nexus_Main.MAPX; i++){
			
			for(int j = 0; j < Nexus_Main.MAPY; j++){
				
				if(Nexus_Main.blocks[i][j] == Nexus_Main.GRASS){
					nexusG.drawImage(Nexus_Import.grass, i*50+Nexus_Main.MapPosX-10000, (Nexus_Main.MAPY - j) * 50-2760, 50, 50, null);
				}
				
				if(Nexus_Main.blocks[i][j] == Nexus_Main.DIRT){
					nexusG.drawImage(Nexus_Import.dirt, i*50+Nexus_Main.MapPosX-10000, (Nexus_Main.MAPY - j) * 50-2760, 50, 50, null);
				}
				
				
				if(Nexus_Main.blocks[i][j] == Nexus_Main.STONE){
					nexusG.drawImage(Nexus_Import.stone, i*50+Nexus_Main.MapPosX-10000, (Nexus_Main.MAPY - j) * 50-2760, 50, 50, null);
				}
				
				if(Nexus_Main.blocks[i][j] == Nexus_Main.TREE){
					nexusG.drawImage(Nexus_Import.tree, i*300+Nexus_Main.MapPosX-10000, (Nexus_Main.MAPY - j) * 50-2750, 200, 400, null);
				}
			}
			
		}
		
			
		
				
		nexusG.dispose();
		nexusBufferStrategy.show();
		Toolkit.getDefaultToolkit().sync();
	}
}
