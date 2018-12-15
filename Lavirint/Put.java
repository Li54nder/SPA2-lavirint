package Lavirint;

import java.util.ArrayList;

public class Put {

	ArrayList<Polje> put;

	public Put() {
		super();
		this.put = new ArrayList<Polje>();
	}
	
	public void dodajPolje(Polje polje) {
		put.add(polje);
	}
	
	public void obrisiPolje() {
		if(put.size() > 0) {
			put.remove(put.size()-1);
		}
	}
	public String stampajPut() {
		String s = "___Put:___\n";
		for(Polje polje : put) {
			s += ("\t" + polje + "\n");
		}
		return s;
	}

	@Override
	public String toString() {
		String s = "";
		for(Polje polje : put) {
			s += polje;
		}
		return "Put ["+s+"]";
	}
	
}
