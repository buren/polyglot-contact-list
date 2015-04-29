class Person < Struct.new(:name)
  # Say hi to person
  def say_hi_to(person)
    "Hi #{person.name}, my name is #{name}."
  end
end

class ContactList
  attr_reader :contacts, :owner

  def initialize(person)
    @owner    = person
    @contacts = []
  end
  # Returns array with contacts who's name start with name
  def contacts_by_name(name)
    contacts.select { |p| p.name.start_with?(name) }
  end
  # Returns first match for name
  def contact_by_name(name)
    contacts_by_name(name).first
  end
  # Returns true if person is in contact list
  def in_contact_list?(person)
    contact_by_name(person.name) != nil
  end
  # Add person to contact list, returns this
  def add_contact(person)
    @contacts << person
    self
  end
end
# Data seeds
wille = Person.new('Wille')
becka = Person.new('Becka')
jacob = Person.new('Jacob')
vigge = Person.new('Vigge')
sigge = Person.new('Sigge')
# Add contacts
list = ContactList.new(wille)
list.add_contact(becka)
list.add_contact(jacob)
list.add_contact(vigge)
list.add_contact(sigge)

puts list.contacts_by_name('Ja')[0].name # Find contacts who's name start with 'Ja'
puts wille.say_hi_to(becka)              # Wille say hi to Becka
