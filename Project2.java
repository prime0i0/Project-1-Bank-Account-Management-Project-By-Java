import java.util.Scanner;
import java.io.*;
class  InSufficientFundException extends Exception
{
	private String message;
	public InSufficientFundException (String message)
	{
		this.message = message;
	}
	public String getMessage()
	{
		return message;
	}
}
class BankAccount
{
	private double balance;
	public BankAccount()
	{
		balance = 0.0;
	}
	public void deposit (double amount)
	{
		balance = balance + amount;
	}
	public void withdraw (double amount) throws InSufficientFundException
	{
		if(amount > balance)
		{
			throw new InSufficientFundException("Insufficient Balance . withdraw process couldn't be completed.");
		}
		balance = balance - amount ;
	}
	public double getBalance()
	{
		return balance;
	}
}
class Project
{
	public static void main(String ...t) throws IOException
	{
		//Project2 p2 = new Project2();
		BankAccount account = new BankAccount();
		Scanner sc = new Scanner (System.in);
		System.out.println("------WELCOME TO JAVA BANK------");
		System.out.println("1. New User\n2. Existing User");
		System.out.print("Select : ");
		int choice1 = sc.nextInt();
		switch(choice1)
		{
			case 1:
					System.out.println("-----CREATE ACCOUNT-----");
					System.out.println("FILL THE FORM");
		
					new Database().database();
				
					break;
			case 2:
					System.out.println("LOGIN");
					System.out.print("USERNAME : ");
					String user = sc.nextLine();
					user = sc.nextLine();
								
					Console  r = System.console();
					System.out.print("PASSWORD : ");
					char k[] = r.readPassword();
					String pas ="";
					for(char ch : k)
					{
						pas+=(ch);
					}
										
					File f3=new File("A5.txt");
					String[] words=null;
					FileReader fr = new FileReader(f3);
					BufferedReader br = new BufferedReader(fr);
					String s;
					String input=user+pas;
					int count=0;
					while((s=br.readLine())!=null)
					{
						words=s.split(" ");
						for (String word : words) 
							{
								if (word.equals(input))
									{
									   count++;
									   break;
									}
							}
					}
					fr.close();
						
					if(count!=0)
					  {
						
							int choice;
							do
							{	
								System.out.println("----BANK ACCOUNT MENU----");
								System.out.println("1-Deposit");
								System.out.println("2-Withdraw");
								System.out.println("3-show Current Balance");
								System.out.println("4-Quit");
								System.out.print("Select an option : ");
								choice = sc.nextInt();
					
							  switch (choice)
						   	  {
								case 1:
									System.out.print("Deposit Amount : ");
									account.deposit(sc.nextInt());
									break;
								case 2:
									System.out.println("Current Balance : "+account.getBalance());
									System.out.print("Withdraw Amount : ");
									try
									{
										account.withdraw(sc.nextInt());
									}
									catch (InSufficientFundException e)
									{
										System.out.println(e.toString());
									}
										break;
									case 3:
									System.out.println("Current Balance : "+account.getBalance());
									break;
							  }
							}while(choice != 4);
					  }
					else
					  {
						 System.out.println("Try again (Mismach Username or Password)");
					  }		
					break;
		}
		System.out.println("Bye... , thanks for using our bank service , have a nive day");
	}
}