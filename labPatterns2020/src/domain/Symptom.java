package domain;

import java.util.Arrays;
import java.util.List;

public class Symptom {
	private String name;
	private int covidImpact;
	private int severityIndex;

	public Symptom(String name, int covidImpact, int severityIndex) {
		this.name = name;
		this.covidImpact = covidImpact;
		this.severityIndex = severityIndex;
	}
	
	public Symptom() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCovidImpact() {
		return covidImpact;
	}
	public void setCovidImpact(int covidImpact) {
		this.covidImpact = covidImpact;
	}
	public int getSeverityIndex() {
		return severityIndex;
	}
	public void setSeverityIndex(int severityIndex) {
		this.severityIndex = severityIndex;
	}
	@Override
	public String toString() {
		return name;
	}
	
	public Symptom createSymptom(String symptomName) {
	    List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia","expectoracion");
	    List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);
	    List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea","mialgia","escalofrios");
	    List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);
	    List<String> impact1 = Arrays.asList("nauseas", "vómitos", "congestión nasal","diarrea","hemoptisis","congestion conjuntival", "mareos");
	    List<Double> index1 = Arrays.asList(5.0, 4.8, 3.7, 0.9, 0.8, 2.1, 4.5);
	    
	    List<String> digestiveSymptom=Arrays.asList("nauseas", "vómitos","diarrea");
	    List<String> neuroMuscularSymptom=Arrays.asList("fiebre", "astenia", "cefalea", "mialgia","escalofrios");
	    List<String> respiratorySymptom=Arrays.asList("tos seca","expectoracion","disnea","dolor de garganta", "congestión nasal","hemoptisis","congestion conjuntival");
	    List<String> movilitySymptom=Arrays.asList("mareos");

	    int impact=0;
	    double index=0;
	    if (impact5.contains(symptomName)) {impact=5; index= index5.get(impact5.indexOf(symptomName));}
	      else if (impact3.contains(symptomName)) {impact=3;index= index3.get(impact3.indexOf(symptomName));}
	        else if (impact1.contains(symptomName)) {impact=1; index= index1.get(impact1.indexOf(symptomName));}
	 
	    if (impact!=0)  {
	    	if (digestiveSymptom.contains(symptomName)) return new DigestiveSymptom(symptomName,(int)index, impact);
	    	if (neuroMuscularSymptom.contains(symptomName)) return new NeuroMuscularSymptom(symptomName,(int)index, impact);
	    	if (respiratorySymptom.contains(symptomName)) return new RespiratorySymptom(symptomName,(int)index, impact);
	    	if (movilitySymptom.contains(symptomName)) return new MovilitySymptom(symptomName,(int)index, impact);
	    }
	    return null;		
		
	}
	
}
