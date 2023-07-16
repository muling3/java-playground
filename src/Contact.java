import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Contact {

    // initialization
    public String name, phoneNumber;

    ArrayList<Contact> contacts;

    public Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(){
        contacts = new ArrayList<>();
    }

    public void printContacts() {
        if(contacts.size() < 1) {
            System.out.println("\nNo contacts in ur phone book");
        }else {
//            contacts.forEach(System.out::println);
                       // or
            for(int i = 0; i < contacts.size(); i++) {
                System.out.println("1. " + contacts.get(i));
            }
        }
    }

    public Contact updateContact(String name, Contact contact) {
        List<Contact> matchedContacts = contacts.stream().filter(c -> c.name.equals(name)).collect(Collectors.toList());
        if(matchedContacts.size() < 1){
            return new Contact();
        };

        Contact matchedContact = matchedContacts.get(0);
        int matchedContactIndex = contacts.indexOf(contact);

        matchedContact.name = contact.name;
        matchedContact.phoneNumber = contact.phoneNumber;

        contacts.set(matchedContactIndex, matchedContact);

        return matchedContact;
    }

    // removing contact
    public boolean removeContact(String name) {
        boolean removeStatus = contacts.removeIf(contact -> contact.name.equals(name));
        return removeStatus;
    }

    // for adding contact
    public boolean addContact(Contact contact){
        contacts.add(contact);
        return true;
    }

    public Contact getContact(String name){
        List<Contact> matchedContacts = contacts.stream().filter(c -> c.name.equals(name)).collect(Collectors.toList());
        return matchedContacts.size() > 0 ? matchedContacts.get(0) : new Contact();
    }

    @Override

    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
