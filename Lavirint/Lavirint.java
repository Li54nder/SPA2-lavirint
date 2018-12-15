package Lavirint;


import org.svetovid.Svetovid;

public class Lavirint {
	private Put putanja;
	
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
		if(matrica[x][y] == CILJ) return true;
		
		bio[x][y] = true;
		
		if(postojiPut(x+1, y)) return true;
		if(postojiPut(x-1, y)) return true;
		if(postojiPut(x, y+1)) return true;
		if(postojiPut(x, y-1)) return true;
		
		bio[x][y] = false;
		return false;
	}

	
}
