package jframeAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;



public class Covid19PacientModelAdapter extends AbstractTableModel {

    private final List<Symptom> symptoms;
    private Covid19Pacient pacient;
    private String[] colNames = new String[] {"symptom", "severity"};
    
    
    public Covid19PacientModelAdapter(Covid19Pacient p) {
        //copy the HashMap data to a sequential data structure
    	symptoms=new ArrayList<Symptom>(p.getSymptoms());
    	this.pacient=p;
        
    } 

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return symptoms.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex) {
            case 0: return ((Object) symptoms.get(rowIndex));
            case 1: return ((Object) pacient.getWeight(symptoms.get(rowIndex)));
            	
            
    }
       return null;
   }
}
