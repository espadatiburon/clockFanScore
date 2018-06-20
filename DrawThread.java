import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class DrawThread extends Thread
{
	private DrawArcs myDraw = new DrawArcs();
	
	public void run()
	{
		String[] args = {};
		myDraw.main(args);
		try
		{
			myDraw.repaint();
			this.sleep(100);
		}
		catch(Exception ex)
		{
			System.out.println("ERROR");
		}
	}
}