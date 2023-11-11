package iterator;

import java.util.Comparator;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import adapter.InvertedIterator;
import adapter.Sorting;
import domain.Covid19Pacient;
import domain.Symptom;

	public class Main {

		public static void main(String[] args) {
			Covid19Pacient p=new Covid19Pacient("Ane", 29);
			p.addSymptom(new Symptom("nauseas", 10, 3), 1);
			p.addSymptom(new Symptom("fiebre", 10, 1), 2);
			p.addSymptom(new Symptom("mareos", 10, 4), 3);
			p.addSymptom(new Symptom("tos seca", 10, 10), 4);
			p.addSymptom(new Symptom("cefalea", 10, 7), 5);
			
			Sorting s = new Sorting();
			pacientAdaptadorea invertedIterator = new pacientAdaptadorea(p.getSymptoms());

			SintomaOrdenatu izena = new SintomaOrdenatu();
			SeverityOrdenatu severity = new SeverityOrdenatu();

			Iterator<Object> nameIterator = s.sortedIterator(invertedIterator, izena);

	
	        System.out.println("Izenarekin ordenatua:");
	        while (nameIterator.hasNext()) {
	            Symptom symptom = (Symptom) nameIterator.next();
	            System.out.println(symptom.getName());
	        }

	        invertedIterator.goLast();


	        Iterator<Object> indexIterator = s.sortedIterator(invertedIterator, severity);


	        System.out.println("\n Severityrekin ordenatua:");
	        while (indexIterator.hasNext()) {
	            Symptom symptom = (Symptom) indexIterator.next();
	            System.out.println(symptom.getSeverityIndex());
	        }
	    }

	}

	

