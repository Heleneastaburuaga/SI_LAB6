package iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import adapter.InvertedIterator;
import domain.Symptom;

public class pacientAdaptadorea implements InvertedIterator {
	 private Set<Symptom> symptoms;
	    private int position;

	    public pacientAdaptadorea(Set<Symptom> symptoms) {
	        this.symptoms = new HashSet<>(symptoms);
	        this.position = this.symptoms.size() - 1;
	    }

	    @Override
	    public Object previous() {
	        if (hasPrevious()) {
	            Iterator<Symptom> iterator = symptoms.iterator();
	            Symptom result = null;
	            for (int i = 0; i <= position; i++) {
	                result = iterator.next();
	            }
	            position--;
	            return result;
	        } else {
	            return null;
	        }
	    }

	    @Override
	    public boolean hasPrevious() {
	        return position >= 0;
	    }

	    @Override
	    public void goLast() {
	        position = symptoms.size() - 1;
	    }
	}