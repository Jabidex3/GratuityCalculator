import java.util.Scanner;
import java.util.zip.CheckedInputStream;

public class TipCalculator {
	
	public static double tip(double billAmt, double percentage) {
		return billAmt * (percentage/100);

	}
	
	//checks if user input was a legitimate value
	public static boolean checkInput(String s) {
		try {
			double x = Double.valueOf(s);
			if(x<0) {
				System.out.println("Invaid input! Try again!");
				return false;
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Invaid input! Try again!");
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("+-------------------------------------+");
		System.out.println("| Welcome to the Gratuity Calculator! |");
		System.out.println("+-------------------------------------+");
		System.out.println("What was your bill total?");
		String amt = scan.nextLine();
		while(checkInput(amt)==false) {
			System.out.println("What was your bill total?");
			amt = scan.nextLine();
		}
		double amtConverted = Double.valueOf(amt);
		
		int choice;
		while(true) {
			System.out.println("How Much Would You Like to Tip?");
			System.out.println("1. 15%");
			System.out.println("2. 18%");
			System.out.println("3. 20%");
			System.out.println("4. Custom");
			String tipChoice = scan.nextLine();
			
			try {
				choice = Integer.valueOf(tipChoice) ;
				if(choice>0 && choice<5) {
					break;
				}
				else {
					System.out.println("Invalid choice! Choice out of range!");
				}
				
			}
			catch(Exception e) {
				System.out.println("Invalid choice! Try Again");
			}
		}
		
		if(choice ==1) {
			System.out.println("Gratuity Amount(15%): $"+tip(amtConverted,15) );
		}
		else if(choice ==2) {
			System.out.println("Gratuity Amount(18%): $"+tip(amtConverted,18) );
		}
		else if(choice ==3) {
			System.out.println("Gratuity Amount(20%): $"+tip(amtConverted,20) );
		}
		else {
			while(true){
				System.out.println("Please enter the percentage amount you wish to Tip:");
				//If you want to tip 30%, enter 30
				String 	percentage = scan.nextLine();
				double a;
				try {
					a = Double.valueOf(percentage);
					if(a>=0) {
						System.out.println("Gratuity Amount("+a+"): $"+tip(amtConverted,a) );
						break;
					}
					else {
						System.out.println("Invaid input! Try again!");
					}
				}
				catch(Exception e){
					System.out.println("Invaid input! Try again!");
				}
			}
		}
		
		scan.close();
	}

}
