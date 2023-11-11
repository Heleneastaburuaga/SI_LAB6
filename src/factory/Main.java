package factory;

import domain.Covid19Pacient;
import domain.Medicament;
import domain.Symptom;
import observer.PacientObserverGUI;
import observer.PacientThermometerGUI;
import observer.SemaphorGUI;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient p1=new Covid19Pacient("aitor", 35);
		new PacientSymptomGUI(p1);

		new PacientObserverGUI (p1);
		new PacientThermometerGUI (p1);
		new SemaphorGUI (p1);
	}

}
