import java.util.ArrayList;
import java.util.Scanner;


/**
 *     2. Create a new program that implements a simple mobile phone with the following capabilities.
 *         ◦ Able to store, modify, remove and query contact names.
 *         ◦ You will want to create a separate class for contacts (name and phone number)
 *         ◦ Create a master class (mobilePhone) that holds the ArrayList of the contacts The MobilePhone class has the functionality listed above
 * Add a menu of options that are available
 * Options: Quit, print a list of contacts, add a new contact, update an existing contact, remove a contact, and search/find a contact
 * When adding or updating be sure to check if the contact already exists (for that use
 * ‘name’)
 * Be sure not to expose the inner workings of the ArrayList to MobilePhone e.g no ints, no
 * .get(i), etc
 * MobilePhone should do everything with contact object only
 */
public class AssignmentTwo {
    ArrayList<Contact> contacts;
    Contact contact;

    public AssignmentTwo() {
        contacts = new ArrayList();

        contact = new Contact();
    }

    public void startApp(){
        this.printMenu();
    }

    private void printMenu() {
        System.out.print("Welcome to my Mobile phone \n\t" +
                "1.Print Contacts\n\t2.Add Contact\n\t3. Update Contact\n" +
                "\t4.Remove Contact\n\t5.Search Contact\n\t6.Quit\n");
        receiveUserChoice();
    }

    private void receiveUserChoice() {
        Scanner keyboard = new Scanner(System.in);
        // get the user choice
        int choice = keyboard.nextInt();

        String contactName, phoneNumber, name;
        boolean hasRemoved, hasAdded;

        switch (choice) {
            case 1:
                contact.printContacts(contacts);

                System.out.print("\n\n");
                printMenu();
                break;
            case 2:
                // for clearing existing newline in keyboard buffer
                keyboard.nextLine();

                System.out.println("Provide the details of the contact below");
                System.out.print("Name: ");
                contactName = keyboard.nextLine();
                System.out.print("Phone Number: ");
                phoneNumber = keyboard.nextLine();

                hasAdded = contact.addContact(new Contact(contactName, phoneNumber), contacts);
                if (hasAdded) {
                    System.out.println("Contact added successfully");
                } else {
                    System.out.println("Failed to add contact");
                }

                System.out.print("\n\n");
                printMenu();
                break;
            case 3:
                // for clearing existing newline in keyboard buffer
                keyboard.nextLine();

                System.out.print("Enter the name of the contact you want to update: ");
                name = keyboard.nextLine();

                System.out.println("Provide the details of the contact below");
                System.out.print("Name: ");
                contactName = keyboard.nextLine();
                System.out.print("Phone Number: ");
                phoneNumber = keyboard.nextLine();

                Contact c = contact.updateContact(name, new Contact(contactName, phoneNumber), contacts);
                if (c.name == null) {
                    System.out.println("Contact failed to update");
                } else {
                    System.out.println("Contact updated successfully  " + c);
                }

                System.out.print("\n\n");
                printMenu();
                break;
            case 4:
                // for clearing existing newline in keyboard buffer
                keyboard.nextLine();

                System.out.print("Enter the name of the contact you want to remove: ");
                name = keyboard.nextLine();

                hasRemoved = contact.removeContact(name, contacts);
                if (hasRemoved) {
                    System.out.println("Contact removed successfully");
                } else {
                    System.out.println("Failed to remove contact");
                }

                System.out.print("\n\n");
                printMenu();
                break;
            case 5:
                // for clearing existing newline in keyboard buffer
                keyboard.nextLine();

                System.out.print("Enter the name of the contact you're looking for ");
                name = keyboard.nextLine();

                Contact cn = contact.getContact(name, contacts);
                if (cn.name == null) {
                    System.out.println("Contact does not exist");
                } else {
                    System.out.println("Contact found" + contact);
                }

                System.out.print("\n\n");
                printMenu();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("\n\tAction could not be interpreted. \n\tKindly Try again!");
                printMenu();
        }
    }
}

