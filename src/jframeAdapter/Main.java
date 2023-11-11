package jframeAdapter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.Covid19Pacient;
import domain.Symptom;

	public class Main {

		public static void main(String[] args) {
			Covid19Pacient p=new Covid19Pacient("Ane", 29);
			p.addSymptom(new Symptom("s1", 10, 10), 1);
			p.addSymptom(new Symptom("s2", 10, 10), 2);
			p.addSymptom(new Symptom("s3", 10, 10), 3);
			p.addSymptom(new Symptom("s4", 10, 10), 4);
			p.addSymptom(new Symptom("s5", 10, 10), 5);
			
			
			Covid19PacientModelAdapter pacientModelAdapter=new Covid19PacientModelAdapter(p);        
			
			JFrame j=new JFrame();
			JTable table = new JTable(pacientModelAdapter);
			 j.add(new JScrollPane(table));
	         
		     j.setTitle(p.getName()+"'s symptoms");
		     j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
		     j.pack();
		     j.setVisible(true);

		}

	}

