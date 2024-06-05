import java.util.List;
import java.util.TreeSet;


public static void main(String[] args) {
    Book phoneBook = new Book();
    //внесение данных
    phoneBook.addContact("Роман", "321");
    phoneBook.addContact("Роман", "124");
    phoneBook.addContact("Роман", "123");
    phoneBook.addContact("Роман", "231");
    phoneBook.addContact("Sasha", "987");
    phoneBook.addContact("Oleg", "567");
    phoneBook.addContact("Oleg", "456");

    phoneBook.printBook(); // Вывод всех записей книги
    phoneBook.removeContact("Роман", "124"); // удаление телефона Романа

    TreeSet<String> johnPhones = phoneBook.getPhones("Роман");
    System.out.println("Телефоны Романа: " + johnPhones); //Выводтелефонов для Романа
    johnPhones = phoneBook.getPhones("Oleg");
    System.out.println("Телефоны Oleg: " + johnPhones);

    List<String> sortedContacts = phoneBook.sortContactsByPhones();
    System.out.println("Отсортированные номера:");
    for (String contact : sortedContacts) { // Вывод отсортированных телефонов
        System.out.println(contact);
    }

}