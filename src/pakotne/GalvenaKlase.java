package pakotne;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GalvenaKlase {
	static public Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int studSk = 0, kritSk = 0;
		
		DecimalFormat df = new DecimalFormat("0.#");
		
		int choice;
		String[] studenti = null;
		
		String[] kriteriji = null; //kritSk
		int[] kriterijaSvars = null; //kritSk
		int[][] kriterijaVertejums = new int[studSk][kritSk];
		double[] semestraVertejums = new double[studSk];
		
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
				int n = Metodes.Audzekni(studSk);
				studenti = new String[n];
				studenti = Metodes.AudzekniVardi(studenti, n);
					System.out.println("Studenti un viņi vārdi ir ievadīti!");
			break;
			case 2:
				int n2 = Metodes.kriterijs(kritSk);
				kriteriji = new String[n2];
				kriterijaSvars = new int[n2];
				kriteriji = Metodes.Kritnosaukumi(kriteriji);
				kriterijaSvars = Metodes.ievadiKriterijus(kriteriji, kriterijaSvars);
				break;
			case 3:break;
			case 4:break;
			case 5:break;
			case 6:break;
			case 7:break;
			case 8:break;
			case 9:break;
			case 10:break;
			case 0:System.out.println("Programma apturēta!"); break;
				default: System.out.println("Darbība nepastāv!");
			}
			
			
		}while(choice != 0);
		
	
		
		// Vērtēšanas kritēriju skaita ievade
		do {
			System.out.println("Kāds būs kritēriju skaits?");
			while(!scan.hasNextInt()) {
				System.out.println("Kāds būs kritēriju skaits?");
				scan.next();
			}
			kritSk = scan.nextInt();
		}while(kritSk<1);
		
		
		scan.nextLine();
		
		
		
		// Definē kritērijus
		int maxSvars = 100, sk = 1;
		double atlSvars;
		for(int i=0; i<kriteriji.length; i++) {
			do {
				System.out.println("Ievadi "+(i+1)+". kritēriju");
				kriteriji[i] = scan.nextLine().trim();
			} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
			
			// Norāda katra kritērija svaru
			do {
				System.out.println("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")");
				while(!scan.hasNextInt()) {
					System.out.println("Ievadi "+(i+1)+". kritērija svaru");
					scan.next();
				}
				kriterijaSvars[i] = scan.nextInt();
				/* Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
				 * kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
				*/
				atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
			} while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
				  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
				  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
				  || atlSvars < 5);
			maxSvars -= kriterijaSvars[i];
			sk++;
			scan.nextLine();
		}
		
		
		
		// Norāda vērtējumu kādu ieguvis katrs audzēknis par katru kritēriju
		for(int i=0; i<kriterijaVertejums.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				do {
					System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
					while(!scan.hasNextInt()) {
						System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
						scan.next();
					}
					kriterijaVertejums[i][j] = scan.nextInt();
				}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
			}
		}
		
		// Gala vērtējuma aprēķināšana
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
		}
		
		// Gala vērtējumu izvadīšana
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				System.out.println("Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j]);
			}
			System.out.println("Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		}
		
	}
}