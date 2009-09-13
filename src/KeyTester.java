/***********************************************************************
 *                                                           
 * test J2ME Keys
 * main MIDLet Source file
 *                                                           
 * Author:        Marcus -LiGi- Bueschleb
 * Mailto:        LiGi @at@ LiGi DOTT de                    
 *
 ************************************************************************/


import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class KeyTester
    extends MIDlet
    implements Runnable
{

    boolean app_running=false;
    KeyTesterCanvas canvas;
    Display display;

    protected void startApp()
        throws MIDletStateChangeException
    {

       if (app_running)return;
       display  = Display.getDisplay(this);

       canvas=new KeyTesterCanvas();

       // fire up canvas
       display.setCurrent(canvas);
	new Thread(this).start();
    }


    public void run()
    {
	while (canvas.key_repeat<2)
	    {
		try
		    {
			Thread.sleep(50);
		    }
		catch (Exception e)
		    {}
	    }
	notifyDestroyed();
    }
    
    protected void pauseApp()     {}   // not needed right now
    protected void destroyApp(boolean arg0)  {    }
    
}
