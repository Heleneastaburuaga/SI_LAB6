package adapter2;

import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
      protected Covid19Pacient pacient;
      protected String[] columnNames = new String[] {"Symptom", "Weight" };
      protected Vector<Symptom> symptoms = new Vector<Symptom>();

      public Covid19PacientTableModelAdapter(Covid19Pacient p) {
        Set<Symptom> s=p.getSymptoms();
        Iterator<Symptom> i=s.iterator();
        while(i.hasNext()) {
            symptoms.add(i.next());
        }
        this.pacient=p;
      }

      public int getColumnCount() {
        // Challenge!
         return 2;
      }

      public String getColumnName(int i) {
        // Challenge!
          return columnNames[i];
      }

      public int getRowCount() {
        // Challenge!
          return pacient.getSymptoms().size();
      }

      public Object getValueAt(int row, int col) {
        // Challenge!
          Symptom s=symptoms.elementAt(row);
          if(col==0) {
              return s.getName();
          }
          if(col==1) {
              return pacient.getWeight(s);
          }
          return null;
      }
}