import java.util.Scanner;
/**
 * Processes a Social Security number and determines its validity
 * @author Paul Dacey
 *
 */
public class SocSecProcessor 
{

	public static void main(String[] args) 
	{
		int continu = 1;
		while(continu == 1)
		{
			System.out.print("Name? ");
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();
			System.out.print("SSN? ");
			String ssn = scan.nextLine();
			try {
				if(isValid(ssn))
				{
					System.out.println(name + " " + ssn + " is valid");
				}
			} 
			catch (SocSecException e) 
			{
				System.out.println(e);
			}
			System.out.println("Continue? ");
			String yesOrNo = scan.nextLine();
			
			if(yesOrNo.equalsIgnoreCase("n") || yesOrNo.equalsIgnoreCase("no"))
			{
				continu = 0;
				scan.close();
			}
			if(yesOrNo.equalsIgnoreCase("y") || yesOrNo.equalsIgnoreCase("yes")) 
			{
				continu = 1;
			}
			else
			{
				continu = -1;
				while(continu == -1)
				{
					System.out.println("Please enter either y/yes or n/no");
					System.out.println("Continue? ");
					yesOrNo = scan.nextLine();
					if(yesOrNo.equalsIgnoreCase("n") || yesOrNo.equalsIgnoreCase("no"))
					{
						continu = 0;
						scan.close();
					}
					if(yesOrNo.equalsIgnoreCase("y") || yesOrNo.equalsIgnoreCase("yes")) 
					{
						continu = 1;
					}
				}

			}
		}
	
	}
	/**
	 * Checks a ssn number
	 * @param ssn SSN to be checked
	 * @return Boolean value of true if valid, false if not
	 * @throws SocSecException Custom exception thrown if SSN number is not valid
	 */
	public static boolean isValid(String ssn) throws SocSecException
	{
		boolean check = true;
		
		if(ssn.length() != 11)
		{
			check = false;
			throw new SocSecException(", wrong number of characters");
		}
		if(ssn.charAt(3) != '-' || ssn.charAt(6) != '-')
		{
			check = false;
			throw new SocSecException(", dashes in wrong spots");
		}
		
		for(int i = 0; i < ssn.length(); i++)
		{
			if(i != 3 && i != 6)
			{
				if(!Character.isDigit(ssn.charAt(i)))
				{
					check = false;
					throw new SocSecException(", contains a character that is not a digit");
				}
			}
			
		}
		
		
		return check;
	}

}
