import java.util.List;
import java.util.stream.Collectors;

public class Contact {

    // initialization
    public String name, phoneNumber;

    public Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(){}


    public void printContacts(List<Contact> contacts) {
        if(contacts.size() < 1) {
            System.out.println("No contacts in ur phone book");
        }else {
            contacts.forEach(System.out::println);
        }
    }

    public Contact updateContact(String name, Contact contact, List<Contact> contacts) {
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

    public boolean removeContact(String name, List<Contact> contacts) {
        boolean removeStatus = contacts.removeIf(contact -> contact.name.equals(name));
        return removeStatus;
    }

    public boolean addContact(Contact contact, List<Contact> contacts){
        contacts.add(contact);
        return true;
    }

    public Contact getContact(String name, List<Contact> contacts){
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
