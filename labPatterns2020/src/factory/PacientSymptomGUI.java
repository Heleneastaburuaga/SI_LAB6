package factory;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Covid19Pacient;
import domain.Symptom;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PacientSymptomGUI extends JFrame {

	
	private Covid19Pacient p;
	

	private JPanel contentPane;
	private JTextField weightField;
	private JButton btnRemoveSymptom;
	private JLabel errorLabel;
	private JLabel lblPacient;
	private JLabel labelPacient;
	private JTextField symptonNameField;
	private JLabel reportLabel;

	
	/**
	 * Create the frame.
	 */
	public PacientSymptomGUI(Covid19Pacient p) {
		this.p=p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectSymptom = new JLabel("Symptom Name");
		lblSelectSymptom.setBounds(32, 68, 100, 16);
		contentPane.add(lblSelectSymptom);
		
		JLabel lblSymptomWeight = new JLabel("Symptom weight");
		lblSymptomWeight.setBounds(32, 96, 125, 16);
		contentPane.add(lblSymptomWeight);
		
		weightField = new JTextField();
		weightField.setBounds(195, 91, 130, 26);
		contentPane.add(weightField);
		weightField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Symptom");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					String symptomName=symptonNameField.getText();
					addSymptom(p,symptomName);
			}
		});
		btnNewButton.setBounds(88, 202, 117, 29);
		contentPane.add(btnNewButton);
		
		btnRemoveSymptom = new JButton("Remove Symptom");
		btnRemoveSymptom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText(" ");

				String symptomName=symptonNameField.getText();
				removeSymptom(symptomName);

				
			} 
		});
		btnRemoveSymptom.setBounds(255, 202, 147, 29);
		contentPane.add(btnRemoveSymptom);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(117, 146, 238, 16);
		contentPane.add(errorLabel);
		
		lblPacient = new JLabel("Pacient:");
		lblPacient.setBounds(210, 17, 61, 16);
		contentPane.add(lblPacient);
		
	    labelPacient = new JLabel("New label");
		labelPacient.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		labelPacient.setBounds(271, 17, 131, 16);
		labelPacient.setText(p.getName());

		contentPane.add(labelPacient);
		
		symptonNameField = new JTextField();
		symptonNameField.setBounds(195, 63, 130, 26);
		contentPane.add(symptonNameField);
		symptonNameField.setColumns(10);
		
		 reportLabel = new JLabel("");
		reportLabel.setBounds(42, 263, 360, 114);
		contentPane.add(reportLabel);
		this.setVisible(true);
		
	}
	
	public void addSymptom(Covid19Pacient p, String symptomName) {
		Symptom s;
		if (isNumeric(weightField.getText())) {
		  if (p.getSymptomByName(symptomName)==null) {
			if (Integer.parseInt(weightField.getText())<=3) {
				s=p.addSymptomByName(symptomName, Integer.parseInt(weightField.getText()));
				if (s!=null) {
					errorLabel.setText("Symptom added :"+symptomName);
					reportLabel.setText(createReport());
				} else errorLabel.setText("ERROR, Symptom "+symptomName+ " does not exist ");
			} else errorLabel.setText("ERROR, Weight between [1..3]");
		  } 
		  else errorLabel.setText("ERROR, Symptom "+symptomName+" already assigned ");
		} else errorLabel.setText("ERROR, weight must be an integer");
		  
	}
	
	public void removeSymptom(String symptomName) {
		if (p.getSymptomByName(symptomName)!=null) {
			p.removeSymptomByName(symptomName);
			errorLabel.setText("Symptom removed :"+symptomName);
			reportLabel.setText(createReport());

		
	     } else errorLabel.setText("ERROR, Symptom does not exist");
	}
	
	public String createReport() {
		Iterator<Symptom> i=p.getSymptoms().iterator();
	    Symptom p2;
	    String s="<html> Covid impact: <b>"+p.covidImpact()+"</b><br>";
	    s=s+"Symptoms: <br>";
	    while (i.hasNext()) {
	    	 p2=i.next();
	    	if (p2!=null) 
	        	s=s+p2.toString()+", "+p.getWeight(p2)+"<br>";	
	    }
	    s=s+"</html>";
        return s;	}
	
	public boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}
