var Person = function(name) {
  this.self  = this;
  self.name  = name;
  // Say hi to person
  self.sayHiTo = function(person) {
    return 'Hi ' + person.name + ', my name is ' + self.name + '.';
  };
};

var ContactList = function(person) {
  this.self     = this;
  self.owner    = person;
  self.contacts = [];
  // Returns array with contacts who's name start with name
  self.getContactsByName = function(name) {
    return self.contacts.filter(function(person) {
      return person.name.startsWith(name);
    });
  };
  // Returns first match for name
  self.getContactByName = function(name) {
    return self.getContactsByName(name)[0];
  };
  // Returns true if person is in contact list
  self.inContactList = function(person) {
    return self.getContactByName(person.name) !== undefined;
  };
  // Add person to contact list, returns this
  self.addContact = function(person) {
    self.contacts.push(person);
    return self;
  };
};

// Data seeds
var wille  = new Person('Wille');
var becka  = new Person('Becka');
var philip = new Person('Philip');
var jacob  = new Person('Jacob');
var janush = new Person('Janush');
// Add contacts
contacts = new ContactList(wille);
contacts.addContact(becka);
contacts.addContact(philip);
contacts.addContact(jacob);
contacts.addContact(janush);

console.log(contacts.getContactsByName('Ja')[0].name); // Find contacts who's name start with 'Ja'
console.log(wille.sayHiTo(becka));                     // Wille say hi to Becka
