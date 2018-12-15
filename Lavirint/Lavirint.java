package Lavirint;

import java.util.Comparator;

import org.svetovid.Svetovid;

public class Lavirint {
	private static Put najPut;
	
	private static int sirina, visina;
	
	private static int[][] matrica;
	private static boolean[][] bio;
	
	private static final int ZID = -11;
	private static final int CILJ = -99;
	
	public static void main(String[] args) {
		String imeFajla = "Lavirint.txt";
		if(Svetovid.testIn(imeFajla)) {
			ucitaj(imeFajla);
			stampaj();
			System.out.println((postojiPut(0, 0)? "Posoji" : "Ne postoji") + " izlaz iz lavirinta!\n");
//			System.out.println("Najkraci put je: \n" + najkraciPut(0, 0).stampajPut());
			najkraciPut(0, 0).uputstvo();
//			System.out.println("Put sa najvise blaga je: \n" + putSaNajviseBlaga(0, 0).stampajPut());
			putSaNajviseBlaga(0, 0).uputstvo();
		} else {
			System.out.println("Fajl ne postoji...");
		}
	}
	
	public static void ucitaj(String imeFajla){
		sirina = Svetovid.in(imeFajla).readInt();
		visina = Svetovid.in(imeFajla).readInt();
		matrica = new int [visina][sirina];
		bio = new boolean [visina][sirina];
		for(int i = 0; i < visina; i++) {
			for(int j = 0; j < sirina; j++) {
				matrica[i][j] = Svetovid.in(imeFajla).readInt();
			}
		}
	}
	public static void stampaj() {
		System.out.println(sirina + " " + visina);
		for(int i = 0; i < visina; i++) {
			for(int j = 0; j < sirina; j++) {
				System.out.printf("%1$5d", matrica[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean postojiPut(int x, int y) {
		if(x < 0 || x >= visina || y < 0 || y >= sirina) return false;
		if(matrica[x][y] == ZID) return false;
		if(bio[x][y]) return false;
		if(matrica[x][y] == CILJ) {
			bio = new boolean[visina][sirina];
			return true;
		}
		
		bio[x][y] = true;
		
		if(postojiPut(x+1, y)) return true;
		if(postojiPut(x-1, y)) return true;
		if(postojiPut(x, y+1)) return true;
		if(postojiPut(x, y-1)) return true;
		
		bio[x][y] = false;
		return false;
	}

	private static Put najkraciPut(int x, int y) {
		Put r = new Put();
		najPut = null;
		trazeniPut(x, y, new KomparatorPoDuzini(), r);
		return najPut;
	}
	private static Put putSaNajviseBlaga(int x, int y) {
		Put r = new Put();
		najPut = null;
		trazeniPut(x, y, new KomparatorPoVrednosti(), r);
		return najPut;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void trazeniPut(int x, int y, Comparator c, Put r) {
		if(x < 0 || x >= visina || y < 0 || y >= sirina) return;
		if(matrica[x][y] == ZID) return;
		if(bio[x][y]) return;
		if(matrica[x][y] == CILJ) {
			r.dodajPolje(new Polje(x, y));
			if(najPut == null || c.compare(najPut, r) > 0) najPut = r.copy();
			r.obrisiPolje();
			return;
		}
		
		bio[x][y] = true;
		r.dodajPolje(new Polje(x, y, matrica[x][y]));
		
		trazeniPut(x+1, y, c, r);
		trazeniPut(x-1, y, c, r);
		trazeniPut(x, y+1, c, r);
		trazeniPut(x, y-1, c, r);
		
		bio[x][y] = false;
		r.obrisiPolje();
	}
	//stampa bulovu matricu kao 0 i 1... jedinice predstavljaju put do izlaza..
	public static void stampajBio() {
		for(int i = 0; i < visina; i++) {
			for(int j = 0; j < sirina; j++) {
				System.out.printf("%1$3d", (bio[i][j]? 1 : 0));
			}
			System.out.println();
		}
	}
}

class KomparatorPoDuzini implements Comparator<Put> {
	public int compare(Put p1, Put p2) {
		return p1.size() - p2.size();
	}
}
class KomparatorPoVrednosti implements Comparator<Put> {
	public int compare(Put p1, Put p2) {
		return p2.vrednost() - p1.vrednost();
	}
}

