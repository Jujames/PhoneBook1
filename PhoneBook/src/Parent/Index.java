package Parent;

import java.util.Scanner;

import Directory.Address;
import Directory.Contacts;

public class Index {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String[] users = {};
		{

			for (;;) {
				System.out.println(
						"\n Please select from the following option: \n1) Create new contact: \n2) Search contact: \n3) Update contact:\n4) exit :");
				int select = input.nextInt();

				if (select == 1) {
					String[] newArray = new String[users.length + 1];
					for (int i = 0; i < users.length; i++) {
						newArray[i] = users[i];
					}
					String user = createContacts();
					System.out.println(" New user created: " + user);
					newArray[newArray.length - 1] = user;
					users = newArray;

				}
				if (select == 2) {
					System.out.println(" Enter First/Last name or phone number: ");
					String search = input.next();
					for (int i = 0; i < users.length; i++) {
						if (users[i].contains(search)) {
							System.out.println(users[i]);

						}
					}

				}
				if (select == 3) {
					System.out.println(" Enter phone number: ");
					String search = input.next();
					for (int i = 0; i < users.length; i++) {
						if (users[i].contains(search)) {
							System.out.println(users[i]);
							System.out.println(
									" What would you like to do; \n1 Return to main menu \n2 Update contact info \n3 Delete contact ");
							int select3 = input.nextInt();

							if (select3 == 1) {
								break;
							}

							if (select3 == 2) {
								String user = createContacts();
								System.out.println("User has been updated:" + user);
								users[i] = user;
							}

							if (select3 == 3) {
								users[i] = null;
							}
						}
					}
				}
				if (select == 4) {
					System.out.println("\n End Program ");
					System.exit(0);
				}

			}
		}
	}

	public static String createContacts() {

		Scanner input = new Scanner(System.in);

		System.out.println(" first name");
		String firstName = input.nextLine();
		System.out.println(" Enter last name");
		String lastName = input.nextLine();
		System.out.println(" Enter Phone Number");
		String phoneNumber = input.nextLine();

		System.out.println(" Enter house number and street");
		String street = input.nextLine();
		System.out.println(" Enter city");
		String city = input.nextLine();
		System.out.println(" Enter state");
		String state = input.nextLine();
		System.out.println("Enter zip");
		String zip = input.nextLine();

		Contacts contact = new Contacts(firstName, lastName, phoneNumber);
		String users = contact.getFirst() + contact.getLast() + contact.getPhone();

		Address address = new Address(street, city, state, zip);
		String residence = address.getStreet() + address.getCity() + address.getState() + address.getZip();

		System.out.println("\n New Contact added to phone book : \n" + users + residence);
		return users + residence;

	}

}
