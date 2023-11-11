package observer;

import java.awt.Color;
import java.awt.Frame;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import domain.Covid19Pacient;


@SuppressWarnings("deprecation")
public class SemaphorGUI extends JFrame implements Observer {
	/** stores the associated ConcreteSubject */
	public SemaphorGUI (Observable obs) {
		setSize(100, 100);
		setLocation(350,10);
		Color c=Color.green;
		getContentPane().setBackground(c);
		repaint();
		setVisible(true);
		obs.addObserver(this);
	}
	
	public void update(Observable	o,	Object	arg)	{
		Covid19Pacient	p=(Covid19Pacient)o;
		Color	c;
		double current=p.covidImpact();
		if (current<5)	c=Color.green;
		else if (current<=10)	c=Color.yellow;
		else c=Color.red;
		getContentPane().setBackground(c);
		repaint();
	}

}     

