package pakotne;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GalvenaKlase {
	static public int  n, n2;
	static public Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int studSk = 0, kritSk = 0;
		
	int choice;
		
		
		String[] studenti = null;
		
		String[] kriteriji = null; //kritSk
		int[] kriterijaSvars = null; //kritSk
		int[][] kriterijaVertejums = null;
		
		
		do {
			
			System.out.println("1 - Ievadīt audzēkņus un viņu vārdus\n"
					+ "2 - Ievadīt kritērijus un to svaru\n"
					+ "3 - Ievadīt vērtējumus\n"
					+ "4 - Labot kritēriju\n"
					+ "5 - Labot Kritērija svaru\n"
					+ "6 - Labot iegūto atzīmi\n"
					+ "7 - Aprēķināt gala vērtējumu\n"
					+ "8 - Saglabāt rezultātus failā\n"
					+ "9 - Nolasīt rezultātu no faila\n"
					+ "0 - Apturēt programmu");
			
			choice = scan.nextInt();
			
			
				
			
			
			switch(choice) {
			
			case 1:
				n = Metodes.Audzekni(studSk);
				studenti = new String[n];
			
				studenti = Metodes.AudzekniVardi(studenti, n);
					System.out.println("Studenti un viņi vārdi ir ievadīti!");
			break;
			case 2:
			n2 = Metodes.kriterijs(kritSk);
				kriteriji = new String[n2];
				kriterijaSvars = new int[n2];
				kriteriji = Metodes.Kritnosaukumi(kriteriji);
				kriterijaSvars = Metodes.ievadiKriterijus(kriteriji, kriterijaSvars);
				break;
			case 3:
				kriterijaVertejums = new int[studSk][kritSk];
				System.out.println("....!");
				kriterijaVertejums = Metodes.VertIevade(n, n2, studenti, kriteriji, kriterijaVertejums);
				break;
			case 4:
				kriteriji = Metodes.LabotKriteriju(kriteriji);
				break;
			case 5:break;
			case 6:
				double[] semestraVertejums = new double[studSk];
				semestraVertejums = Metodes.GalaVertejums(studenti, kriteriji, kriterijaSvars, kriterijaVertejums, semestraVertejums);
				break;
			case 7:break;
			case 8:break;
			case 9:break;
			case 0:System.out.println("Programma apturēta!"); break;
				default: System.out.println("Darbība nepastāv!");
			}
			
			
		}while(choice != 0);
		
		
	}
}