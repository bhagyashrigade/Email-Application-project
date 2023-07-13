package javaProgramming;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private int defaultPasswordLength=10;
	private String alternateEmail;
	private String companySuffix ="aeycompany.com";
	
	public Email(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		System.out.println("EMAIL CREATED: "+this.firstName +" "+ this.lastName);
		
		//below is for call a method asking for the department - return the department
		
		this.department=setDepartment();
		System.out.println("department: "+this.department);
		
		//call a method that returns a random password
		
		this.password =randomPassword(defaultPasswordLength);
		System.out.println("your password is:" +this.password);
		
		//combine elements to generate email
		
		email = firstName.toLowerCase() + ","+ lastName.toLowerCase() +"@"+department +"." + companySuffix;
	}
	
	//below for ask for the departments
	
	private String setDepartment() {
		System.out.println("New Worker: " + firstName + "department codes\n1 for sales\n2 for development]\n3 for accounting\n0 for none\n enter department code:");
		Scanner in =new Scanner(System.in);
		int depChoice=in.nextInt();
		if(depChoice==1)
			{
			return "sales";
			}else if(depChoice==2) {
				return "dev";
			}else if(depChoice==3) {
				return "acct";
			}else {
				return " "; 
			}
	}
	
	//below is for generate a random password
	
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMN1234@8976%";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
		int rand=	(int) (Math.random() * passwordSet.length());
		password[i] =passwordSet.charAt(rand);
		}
		return new String(password);
	}
	//set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}
	//set the alternate email
	public void setalternateEmail(String altEmail) {
		this.alternateEmail=altEmail;
		
	}
	//change the password
	public void changePassword(String password) {
		this.password=password;
	}
	
	public int getMailboxCapacity()
	{
		return mailboxCapacity;
			
	}
	public String getalternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {
		return password;
	}
	public String showInfo(){
		return "DISPLAY NAME: "+ firstName + " "+ lastName +"\nCOMPANY EMAIL: "+ email +"\nMAILBOX CAPACITY: "+mailboxCapacity +"mb";
		
	}
	
	

	public static void main(String[] args) {
		Email eml =new Email("John","smith");
		//eml.showInfo();
		
		eml.setalternateEmail("js@gmail.com");
		System.out.println(eml.showInfo());
		

	}

}
