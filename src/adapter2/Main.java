package adapter2;

import domain.Covid19Pacient;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient pacient=new Covid19Pacient("aitor", 35);
		Covid19Pacient pacient1=new Covid19Pacient("paula", 35);
		
		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 3);
		
		pacient1.addSymptomByName("nauseas", 2);
		pacient1.addSymptomByName("fiebre", 1);
		pacient1.addSymptomByName("tos seca", 3);
		
		ShowPacientTableGUI gui=new ShowPacientTableGUI(pacient);
		ShowPacientTableGUI gui1=new ShowPacientTableGUI(pacient1);
		gui.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui.setBounds(100, 100, 300, 200);
		gui.setVisible(true);
		
		gui1.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui1.setBounds(400, 100, 300, 200);
		gui1.setVisible(true);

	}

}
