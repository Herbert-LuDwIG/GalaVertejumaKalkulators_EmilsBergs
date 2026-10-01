package pakotne;

import java.util.Scanner;

public class Metodes {

	public static int Audzekni(int studSk) {
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
			while(!scan.hasNextInt()) {
				System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
				scan.next();
			}
			studSk = scan.nextInt();
		}while(studSk<1);
		

		return studSk;
	}
	
	public static String[] AudzekniVardi(String[] studenti, int studSk){
		Scanner scan = new Scanner(System.in);
		// Ievada audzēkņu vārdus, uzvārdus
				for(int i=0; i<studSk; i++) {
					do {
						System.out.println("Ievadi "+(i+1)+". studentu");
						studenti[i] = scan.nextLine().trim();
					} while(!studenti[i].matches("^[\\p{L} ]+$"));
				}
				return studenti;
	}
	
	public static int kriterijs(int kritSk) {
		Scanner scan = new Scanner(System.in);
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
		return kritSk;
	}
	
	public static String[] Kritnosaukumi(String[] kriteriji) {
		Scanner scan = new Scanner(System.in);
		// Definē kritērijus
		int maxSvars = 100, sk = 1;
		double atlSvars;
		for(int i=0; i<kriteriji.length; i++) {
			do {
				System.out.println("Ievadi "+(i+1)+". kritēriju");
				kriteriji[i] = scan.nextLine().trim();
			} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
				
	}
		return kriteriji;
	
	}
	
	
	public static int[] ievadiKriterijus(String[] kriteriji,int[] kriterijaSvars) {
		Scanner scan = new Scanner(System.in);
        int maxSvars = 100;
        int sk = 1;

        double atlSvars;

        for (int i = 0; i < kriteriji.length; i++) {
            // Kritērija nosaukums
            do {
                System.out.println("Ievadi " + (i + 1) + ". kritēriju");

                kriteriji[i] = scan.nextLine().trim();

            } while (!kriteriji[i].matches("^[\\p{L} ]+$"));
            // Kritērija svars
            do {

                System.out.println("Ievadi " + (i + 1) + ". kritērija svaru (max: " + maxSvars + ")");

                while (!scan.hasNextInt()) {

                    System.out.println("Ievadi " + (i + 1)+ ". kritērija svaru");
                    scan.next();
                }
                kriterijaSvars[i] = scan.nextInt();

                /*
                 * Minimālais KATRA ATLIKUŠĀ kritērija svars ir 5.
                 * Kopējai svaru vērtībai jābūt 100.
                 */

                atlSvars = (maxSvars - kriterijaSvars[i]) / (double) (kriteriji.length - sk);

            } while (
                    kriterijaSvars[i] > maxSvars|| kriterijaSvars[i] < 5 || (i != kriteriji.length - 1 && kriterijaSvars[i] == maxSvars)
                    || (i == kriteriji.length - 1 && (maxSvars - kriterijaSvars[i]) > 0) || atlSvars < 5);
            maxSvars -= kriterijaSvars[i];
            sk++;
            scan.nextLine();
        }
        return kriterijaSvars;
    }



	
	
	
}

