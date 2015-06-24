package nexus_main;


import java.awt.Frame;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import nexus_import.Nexus_Import;


public class Nexus_Main {
	
	public static int MapPosX = 0;
	
	public static boolean aPressed = false;
	public static boolean wPressed = false;
	public static boolean sPressed = false;
	public static boolean dPressed = false;
	public static boolean shiftPressed = false;
	
	public static final byte GRASS = 1;
	public static final byte STONE = 2;
	public static final byte DIRT = 3;
	public static final byte TREE = 4;
	public static final int MAPX = 500;
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
			   
		frame01.setSize(1200, 730);
			   
		frame01.setVisible(true);
		nexusCanvas.setSize(1200, 730);
		frame01.add(nexusCanvas);
		
		mapGen();
		
		keyboardInitialize();
		
		gameloop();
	}
	
	static void mapGen(){
		
		for(int i = 0; i < MAPX; i++){
				
				blocks[i][14] = TREE;
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
			if(shiftPressed){
				if(aPressed == true){
					MapPosX += 10;
				}
				if(dPressed == true){
					MapPosX -= 10;
				}
			}
			
				if(aPressed == true){
					MapPosX += 7;
				}
				if(dPressed == true){
					MapPosX -= 7;
				}
			nexusCanvas.render();
		}
	}
	
	public static void keyboardInitialize()
	{
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (Nexus_Main.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_A) {
                            aPressed = true;
                        }
                        else if (ke.getKeyCode() == KeyEvent.VK_W) {
                            wPressed = true;
                        }
                        else if (ke.getKeyCode() == KeyEvent.VK_S) {
                            sPressed = true;
                        }
                        else if (ke.getKeyCode() == KeyEvent.VK_D) {
                            dPressed = true;
                        }
                        else if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
                            shiftPressed = true;
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                    	if (ke.getKeyCode() == KeyEvent.VK_A) {
                            aPressed = false;
                        }
                        else if (ke.getKeyCode() == KeyEvent.VK_W) {
                            wPressed = false;
                        }
                        else if (ke.getKeyCode() == KeyEvent.VK_S) {
                            sPressed = false;
                        }
                        else if (ke.getKeyCode() == KeyEvent.VK_D) {
                            dPressed = false;
                        }
                        else if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
                            shiftPressed = false;
                        }
                        break;
                    }
                    return false;
                }
            }
        });
	}
}

