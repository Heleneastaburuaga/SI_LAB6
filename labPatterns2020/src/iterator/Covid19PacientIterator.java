package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import adapter.InvertedIterator;
import domain.Symptom;

public class Covid19PacientIterator implements Iterator  {
	List<Symptom> symptoms=new Vector<Symptom>();
	int position=0;

	public Covid19PacientIterator(Set<Symptom> s) {
		Iterator<Symptom> i=s.iterator();
		while (i.hasNext())
			symptoms.add(i.next());
		this.position = symptoms.size();
	}

	@Override
	public boolean hasNext() {
		return position<symptoms.size();
	}

	@Override
	public Object next() {
		Symptom symptom=symptoms.get(position);
		position++;
		return symptom;
	}


}
