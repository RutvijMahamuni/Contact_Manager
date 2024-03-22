package apps;

import java.util.Scanner;


public class Contacts_Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Operations o=new Operations();
		int ch;
		boolean flag=true;
		while(flag) {
			System.out.println("******Contacts******");
			System.out.println("1. View Contacts");
			System.out.println("2. Add new contact");
			System.out.println("3. Update contact");
			System.out.println("4. Delete contact");
			System.out.println("0. Exit");
			System.out.println("Enter your choice:");
			ch=sc.nextInt();
			switch(ch) {
			case 0:
				flag=false;
				break;
			case 1:
				o.viewAll();
				break;
			case 2:
				System.out.println("Enter the name: ");
				String name=sc.next();
				System.out.println("Enter the phone number: ");
				String ph=sc.next();
				System.out.println("Enter the email: ");
				String email=sc.next();
				o.addContact(name, ph, email);
				break;
			case 3: 
				System.out.println("Enter the name of contact to update: ");
				String nm1=sc.next();
				System.out.println("Enter new name: ");
				String nm2=sc.next();
				System.out.println("Enter new phone number: ");
				ph=sc.next();
				System.out.println("Enter new mail id: ");
				email=sc.next();
				o.updateContact(nm1, nm2, ph, email);
				break;
			case 4:
				System.out.println("Enter the name of contact to delete: ");
				name=sc.next();
				o.deleteContacts(name);
				break;
			default:
				System.out.println("Please enter a valid input");
					
				
				
			}
		}
		sc.close();

	}

}
