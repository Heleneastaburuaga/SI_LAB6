package observer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;


import javax.swing.JLabel;

import domain.Covid19Pacient;

@SuppressWarnings("deprecation")
public class PacientThermometerGUI extends Frame implements Observer{	
	private TemperatureCanvas gauges;
	/**
	 * @wbp.nonvisual location=119,71
	 */
	private final JLabel label = new JLabel("New label");
	
	public PacientThermometerGUI(Observable obs){ 
		super("Temperature Gauge");
		Panel Top = new Panel();
		add("North", Top);
		gauges = new TemperatureCanvas(0,15);
		gauges.setSize(500,280);
		add("Center", gauges);		
		setSize(200, 380);
		setLocation(0, 100);
		setVisible(true);
		obs.addObserver(this);
	}

	
	class TemperatureCanvas extends Canvas {	
		
		public void set(int level) { current = level; }	
		public int get(){return current;}
		public int getMax(){return Max;}
		public int getMin(){return Min;}
		
		private int Max, Min, current;
		
		public TemperatureCanvas(int min, int max){ Min = min; Max = max; }
		
		public void paint(Graphics g)
		{	Color c;
		    if (current<5) c=Color.green;
		     else if (current<10) c=Color.yellow;
		      else c=Color.red;
			g.setColor(Color.black);
			g.drawRect(left,top, width, height);
			g.setColor(c);
			g.fillOval(left-width/2, top+height-width/3,width*2, width*2);
			g.setColor(Color.black);
			g.drawOval(left-width/2, top+height-width/3,width*2, width*2);
			g.setColor(Color.white);
			g.fillRect(left+1,top+1, width-1, height-1);
			g.setColor(c);
			long redtop = height*(get()-getMax())/(getMin()-getMax());
			g.fillRect(left+1, top + (int)redtop, width-1, height-(int)redtop);
		}
		
		private static final int width = 20;
		private static final int top = 20;
		private static final int left = 100;
		private static final int right = 250;
		private static final int height = 200;
	}
	
	public void update(Observable o, Object args) {
		Covid19Pacient p=(Covid19Pacient) o;
		// Obtain the current covidImpact to paint
		int farenheit = (int) p.covidImpact(); 
		// temperature gauge update
		gauges.set(farenheit);
		gauges.repaint();
		}

}
