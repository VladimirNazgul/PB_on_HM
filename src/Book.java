import java.util.*;

public class Book {
    private static HashMap<String, TreeSet<String>> phoneBook;
    public Book() {
        phoneBook = new HashMap<>();
    }
    public void addContact(String name, String phoneNumber) {
        TreeSet<String> phones = phoneBook.getOrDefault(name, new TreeSet<>());
        phones.add(phoneNumber);
        phoneBook.put(name, phones);
    }
    public void removeContact(String name, String phoneNumber) {
        TreeSet<String> phones = phoneBook.getOrDefault(name, new TreeSet<>());
        phones.remove(phoneNumber);
        if (phones.isEmpty()) {
            phoneBook.remove(name);
        } else {
            phoneBook.put(name, phones);
        }
    }
    public TreeSet<String> getPhones(String name) {
        return phoneBook.get(name);
    }
    public HashMap<String, TreeSet<String>> getAllContacts() {
        return phoneBook;
    }
    public void printBook() {
        for (String name : phoneBook.keySet()) {
            TreeSet<String> phones = phoneBook.get(name);
            System.out.println(name + ": " + phones);
        }
    }
    public List<String> sortContactsByPhones() {
        List<Map.Entry<String, TreeSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().size() - e1.getValue().size());
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, TreeSet<String>> entry : sortedEntries){
            result.add(entry.getKey() + ": " + entry.getValue());
        }
        return result;
    }
}

