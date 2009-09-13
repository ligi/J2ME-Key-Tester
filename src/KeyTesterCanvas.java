/***************************************************************
 *
 * Canvas  of DUBwise Installer
 *                                                           
 * Author:        Marcus -LiGi- Bueschleb
 * Mailto:        LiGi @at@ LiGi DOTT de                    
 * 
 * 
 * this class detects some propertys of the Phone
 *
 ***************************************************************/

import javax.microedition.lcdui.*;
import java.io.*;
import javax.microedition.io.*;
import javax.microedition.rms.*;

public class KeyTesterCanvas
    extends Canvas
    implements Runnable
{

    String key_action_name="none";
    int key_code=-1;
    int game_action=-1;

    public int key_repeat=0;

    public KeyTesterCanvas()
    {
	new Thread(this).start();
    }


    public void run()
    {
	while (true)
	    {
		repaint();
		serviceRepaints();

		try
		    {
			Thread.sleep(50);
		    }
		catch (Exception e)
		    {}
	    }
    }
    
    public void keyPressed(int keyCode)
    {
	if (keyCode==key_code)
	    key_repeat++;
	else
	    {
		key_code=keyCode;
		key_repeat=0;
	    }

	game_action=getGameAction(keyCode);

	key_action_name="unknown";

	switch(game_action)
	    {
	    case Canvas.UP:
		key_action_name="UP";
		break;

	    case Canvas.DOWN:
		key_action_name="DOWN";
		break;

	    case Canvas.LEFT:
		key_action_name="LEFT";
		break;

	    case Canvas.RIGHT:
		key_action_name="RIGHT";
		break;

	    case Canvas.FIRE:
		key_action_name="FIRE";
		break;
	    }

	switch(keyCode)
	    {
	    case Canvas.KEY_STAR:
		key_action_name="STAR";
		break;
		
	    case Canvas.KEY_POUND:
		key_action_name="POUND";
		break;

	    case Canvas.KEY_NUM0:
		key_action_name="NUM0";
		break;


	    case Canvas.KEY_NUM1:
		key_action_name="NUM1";
		break;

	    case Canvas.KEY_NUM2:
		key_action_name="NUM2";
		break;

	    case Canvas.KEY_NUM3:
		key_action_name="NUM3";
		break;

	    case Canvas.KEY_NUM4:
		key_action_name="NUM4";
		break;

	    case Canvas.KEY_NUM5:
		key_action_name="NUM5";
		break;

	    case Canvas.KEY_NUM6:
		key_action_name="NUM6";
		break;

	    case Canvas.KEY_NUM7:
		key_action_name="NUM7";
		break;

	    case Canvas.KEY_NUM8:
		key_action_name="NUM8";
		break;

	    case Canvas.KEY_NUM9:
		key_action_name="NUM9";
		break;

	    }
    }

    public void paint(Graphics g)
    {
	Font my_font=Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);
	g.setFont(my_font);

	g.setColor(0);
	g.fillRect(0,0,this.getWidth(),this.getHeight());
	g.setColor(0x00BB00);
	g.drawString("Action Name: " + key_action_name ,0,0,Graphics.LEFT  | Graphics.TOP);
	g.drawString("KeyAction: " + game_action ,0,my_font.getHeight()*2,Graphics.LEFT  | Graphics.TOP);
	g.drawString("KeyCode: " + key_code ,0,my_font.getHeight()*4,Graphics.LEFT  | Graphics.TOP);
	g.drawString("Press any key 3 times to exit" ,0,my_font.getHeight()*6,Graphics.LEFT  | Graphics.TOP);

    }
}
