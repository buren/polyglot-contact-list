import java.util.ArrayList;

class Person {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public String sayHiTo(Person person) {
    return "Hi " + person.getName() + ", my name is " + this.getName() + ".";
  }
}

class ContactList {
  private Person owner;
  private ArrayList<Person> contacts;

  public ContactList(Person person) {
    this.owner = person;
    this.contacts = new ArrayList<Person>();
  }

  public ArrayList<Person> getContactsByName(String name) {
    ArrayList<Person> found = new ArrayList<Person>();
    for (Person person : this.contacts) {
      if (person.getName().indexOf(name) != -1) {
        found.add(person);
      }
    }
    return found;
  }

  public Person getContactByName(String name) {
    ArrayList<Person> found = this.getContactsByName(name);
    if (found.size() != 0) return found.get(0);
    return null;
  }

  public boolean inContactList(Person person) {
    return this.getContactByName(person.getName()) != null;
  }

  public void addContact(Person person) {
    contacts.add(person);
  }

  public Person getOwner() {
    return this.owner;
  }
}

class Main {
  public static void main(String[] args) {
    Person wille = new Person("Wille");
    Person becka = new Person("Becka");
    Person jacob = new Person("Jacob");
    Person vigge = new Person("Vigge");
    Person sigge = new Person("Sigge");
    // Add contacts
    ContactList contacts = new ContactList(wille);
    contacts.addContact(becka);
    contacts.addContact(jacob);
    contacts.addContact(vigge);
    contacts.addContact(sigge);
    // Find contacts who's name start with 'Ja'
    System.out.println(contacts.getContactsByName("Ja").get(0).getName());
    System.out.println(wille.sayHiTo(becka)); // Wille say hi to Becka
  }
}
