package Lavirint;

import java.util.ArrayList;

public class Put {

	private ArrayList<Polje> put;

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

	public int size() {
		return put.size();
	}

	public int vrednost() {
		int suma = 0;
		for(Polje p : put) {
			suma += (p.getV()>0? p.getV() : 0);
		}
		return suma;
	}
	
	public Polje get(int index) {
		return put.get(index);
	}
	
	public Put copy() {
		Put novi = new Put();
		for(Polje p : put) {
			novi.dodajPolje(p);
		}
		return novi;
	}

	@Override
	public String toString() {
		String s = "";
		for(Polje polje : put) {
			s += polje;
		}
		return "Put ["+s+"]";
	}
	
	//moja metoda ^_^ (izlaz u formatu: <<goTo><->>) ---> npr (dole----- ) znaci idi dole 5 puta
	public void uputstvo() {
		String curr = "";
		for(int i = 0; i < put.size(); i++) {
			if(i == 0) {
				if(0 != put.get(i).getX()) {
					System.out.print("dole");
					curr = "dole";
				}
				if(0 != put.get(i).getY()) {
					System.out.print("desno");
					curr = "desno";
				}
			} else {
				if(put.get(i-1).getX() != put.get(i).getX()) {
					if(put.get(i-1).getX() < put.get(i).getX()) {
						if(!curr.equals("dole")) {
							System.out.print(" dole-"); 
							curr = "dole";
						} else System.out.print("-");
					} else 
						if(!curr.equals("gore")) {
							System.out.print(" gore-"); 
							curr = "gore";
						} else System.out.print("-");
				}
				if(put.get(i-1).getY() != put.get(i).getY()) {
					if(put.get(i-1).getY() < put.get(i).getY()) {
						if(!curr.equals("desno")) {
							System.out.print(" desno-"); 
							curr = "desno";
						} else System.out.print("-");
					}else 
						if(!curr.equals("levo")) {
							System.out.print(" levo-"); 
							curr = "levo";
						} else System.out.print("-");
				}
			}
		}
		System.out.println();
	}
}

/***
*       if(r.size()>=2) {
*			if(r.get(r.size()-2).getX() != r.get(r.size()-1).getX()) {
*				if(r.get(r.size()-2).getX() < r.get(r.size()-1).getX()) System.out.println("dole");
*				else System.out.println("gore");
*			}
*			if(r.get(r.size()-2).getY() != r.get(r.size()-1).getY()) {
*				if(r.get(r.size()-2).getY() < r.get(r.size()-1).getY()) System.out.println("desno");
*				else System.out.println("levo");
*			}
*		}
*/
