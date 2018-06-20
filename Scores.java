import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Scores
{
	public static void main(String [] args)
	{
		JFrame myFrame = new JFrame("Scores");
		JPanel myPanel = new JPanel();
		ClockThread clock = new ClockThread();
		DrawThread myDraw = new DrawThread();
		JLabel totalLabel;
		JLabel avgLabel;
		int total = 0;
		double average = 0;
		
		myFrame.setSize(250,250);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel.setBackground(Color.YELLOW);
		total = myTotal("Scores.txt");
		average = myAvg("Scores.txt");
		totalLabel = new JLabel("Total: " + total);
		avgLabel = new JLabel("Average: " + average);
		
		myPanel.add(totalLabel);
		myPanel.add(avgLabel);
		
		myFrame.add(myPanel);
		clock.start();
		myDraw.start();
		myFrame.setVisible(true);
	}
	
	public static int myTotal(String scoreFile)
	{
		int total = 0;
		try
		{
			Scanner sc = new Scanner(new File(scoreFile));
		
			while(sc.hasNextInt())
			{
				total += sc.nextInt();
			}
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("NO FILE FOUND!");
		}
		
		return total;
	}
	
	public static double myAvg(String scoreFile)
	{
		double avg = 0;
		int count = 0;
		int total = 0;
		
		try
		{
			Scanner sc = new Scanner(new File(scoreFile));
			
			while(sc.hasNextInt())
			{
				total += sc.nextInt();
				count++;
			}
			
			avg = ((double)total)/count;
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("NO FILE FOUND!");
		}
		
		return avg;
	}
	
}