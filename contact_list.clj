(ns contactlist)

(defrecord Person [name])
(defn sayHiTo [person otherPerson]
  (str "Hi " (:name person) ", my name is " (:name otherPerson) "."))

(defrecord ContactList [owner contacts])
(defn getContactsByName [contactList name]
  (filter #(.startsWith (.name %) name) (:contacts contactList)))
(defn getContactByName [contactList name]
  (first (getContactsByName contactList name)))
(defn addContact [contactList person]
  (conj (:contacts contactList) person))

; Data seeds
(def wille (Person. "Wille"))
(def becka (Person. "Becka"))
(def jacob (Person. "Jacob"))
(def vigge (Person. "Vigge"))
(def sigge (Person. "Sigge"))
; Add contacts
(def contactList (ContactList. wille [becka jacob vigge]))
(def contactList (ContactList. wille (addContact contactList sigge)))

; Prints
(println (sayHiTo wille becka))
(println (:name (getContactByName contactList (:name becka))))
(println (:name (getContactByName contactList "Ja")))
