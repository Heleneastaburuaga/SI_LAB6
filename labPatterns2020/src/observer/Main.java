package observer;

import java.util.Observable;

import domain.Covid19Pacient;
import domain.Medicament;
import factory.MedicalGUI;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Medicament m=new Medicament("Ibuprofeno");
		MedicalGUI mgui=new MedicalGUI(m);
	}


}
