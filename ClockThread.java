import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class ClockThread extends Thread
{
	private StillClock myClock = new StillClock();
	
	public void run()
	{
		JFrame myFrame = new JFrame("Clock");
		myFrame.setSize(300,300);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(myClock);
		myFrame.setVisible(true);
		try
		{
			while(true)
			{
				myClock.setCurrentTime();
				myFrame.repaint();
				this.sleep(100);
			}
		}
		catch(Exception ex)
		{
			System.out.println("ERROR!");
		}
	}
}