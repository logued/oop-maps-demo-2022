
/**
 * Nov 2024
 * Map Interface - Implemented by HashMap and TreeMap classes
 * <p>
 * A Map is a Data Structure that allows us to associate a Key with a Value.
 * e.g. A person's name with their favorite film "John" -> "StarWars"
 * or a class group with a list of students: "SD2A" -> {"Anne", "John",..}.
 * <p>
 * When we add an entry to a Map we must provide both the Key and the Value.
 * These pairs are often called a "Key-Value" pairs.
 * <p>
 * A Map stores both the Key and the Value for each key|value pair. Key and
 * Value must be class types (not primitive types, so Integer rather than int)
 * The Key class MUST implement the methods hashCode() and equals() [or inherit
 * them]
 * <p>
 * String and Integer are the most effective and preferred Key types.
 * Keys must be unique (no duplicate keys are allowed)
 * A Map can be implemented as a HashMap or a TreeMap.
 * - HashMap is fastest for put() and get() (but order is not maintained)
 * HashMap time complexity for get and put is O(1)
 * - TreeMap maintains a sorted order based on the "Natural Ordering"
 * of the Key elements ( defined by compareTo() ) or based on a
 * Comparator supplied in the Map constructor.
 * TreeMap time complexity for put and get is O(log n)
 * <p>
 * Maps are commonly used to pass data around within a program, so it is
 * important to understand how to use them.
 */

import java.util.*;
import java.util.Map.Entry;

public class AppMainMapsDemo {

    public static void main(String[] args) {
        System.out.println("Maps Demo");
        System.out.println("- remember to uncomment method calls in main() to see outputs.");

        map1();     // HashMap: String=>String
//         map2();     // HashMap: String=>Integer
//         map3();     // HashMap: Integer=>Book
//         map4();     // HashMap: String=>ArrayList
//         map5();     // Passing Map as argument into a method
//         map6();     // TreeMap: Integer=>Book - hashCode() & equals()
//         map7();     // HashMap: (Student=>Book) - hashCode() & equals()
//         map8();     // HashMap: (String=>HashMap<String,String>
//         map9();     // TreeMap: (Student=>Book) - Comparator required
    }

    public static void map1() // HashMap: String=>String,  key=>value
    {
        Map<String, String> map = new HashMap<>();
        // Creates a new HashMap object, but stores the reference to the HashMap
        // in a reference of type Map.  "Map" is an Interface, and we use it to create
        // references to various types of map.  HashMap is very fast for retrieval.

        // Add or put() entries into map (Peoples favourite films)
        map.put("John", "Alien");
        map.put("Anne", "LaLa Land");
        map.put("Zoe", "Alien");
        map.put("Zoe", "Trainspotting");  // replaces previous entry

        // retrieve or get() entries from the map
        String key = "Zoe";
        String favouriteFilm = map.get(key);  // use Key to get Value
        System.out.println(key + " favourite film is: " + favouriteFilm);

        // delete or remove() entries from the map
        key = "John";
        map.remove(key);  // deletes the map Entry for John

        //TODO: add your own name and favourite film to the map
        // and then retrieve and display it. Finally remove it.
        // get() returns null if the key is not found, so we should always check for null
        // (this check may be omitted from some sample code below, but you should always use it)


        key = "Elvis";
        favouriteFilm = map.get(key);  // use Key to get Value
        if (favouriteFilm != null) {
            System.out.println(key + " favourite film is : " + favouriteFilm);
        } else {
            System.out.println(key + " NOT found");
        }

        // to check if a key is in the map
        if (map.containsKey(key)) {
            System.out.println("The key: " + key + " is in the map.");
        } else {
            System.out.println("The key: " + key + " is NOT in the map.");
        }

        /**
         * Retrieve all the Keys and their Values from the Map
         */
        System.out.println("Retrieve all entries from a Map (no order)");
        // note that a map Entry contains both the Key and the Value
        // Entry is a class that is used by Map as the structure to store map entries.

        // get all entries (Entry objects) in the map, and return as a Set of Entries.
        Set<Entry<String, String>> entrySet = map.entrySet();

        System.out.println("\n\nMap<Key:Value> pairs (Entry objects)");
        // iterate over each Entry in the set of entries
        for (Map.Entry<String, String> entry : entrySet) {  // for each entry in the set...
            key = entry.getKey();             // get key object from the Entry
            String value = entry.getValue();  // get the value from the Entry
            System.out.println("Name: " + key + ", Favourite film: " + value);
        }

        // Print the values in the map
        System.out.println("All values from the Map:");
        Collection<String> values = map.values(); // get all the values
        for (String value : values) {
            System.out.print(value + ", ");
        }

        // Get all keys from the Map (Set used because keys are unique)
        Set<String> keySet = map.keySet();  // get all keys
        System.out.println("All keys from the Map:");
        for (String name : keySet) {
            System.out.print(name + ", ");
        }

        // Use keys from keySet to get each value from the Map
        System.out.println("\n\nMap<Key:Value> pairs");
        for (String k : keySet) {
            String film = map.get(k);   // get value associated with key
            System.out.println(k + " : " + film);
        }
    }

    public static void map2() {
        // Keys and Values must be Class types.
        // Primitive type values such as 'int' values will be converted
        // automatically to their corresponding Class types (e.g. Integer).
        // (This is called Autoboxing).

        Map<String, Integer> ageMap = new HashMap<>();

        ageMap.put("John", 18); // int values automatically converted to Integer
        ageMap.put("Anne", 19);
        ageMap.put("Adam", 17);
        ageMap.put("Adam", 99);   // repeated key, value 99 replaces 17

        Set<String> keySet = ageMap.keySet();  // get all keys
        // All keys are unique (no two can be the same) so it is natural
        // that they are returned as a Set. (A Set has no duplicate elements)

        // Retrieve each value using a key
        for (String key : keySet) {
            int value = ageMap.get(key);
            System.out.println(key + " : " + value);
        }

        String key = "Anne";
        if (ageMap.containsKey(key)) {
            System.out.println("ageMap contains the key" + key + " with value " + ageMap.get(key));
        } else {
            System.out.println("ageMap does NOT contain the key " + key);
        }
    }

    public static void map3() {
        // Map a Book Code to a Book object
        Map<Integer, Book> bookMap = new HashMap<>();

        bookMap.put(30004, new Book(30004, "Fight Club")); // long int values automatically converted to Integer
        bookMap.put(40023, new Book(40023, "Jaws"));
        bookMap.put(55523, new Book(55523, "White Teeth"));
        bookMap.put(66623, new Book(66623, "Ted Bundy"));  // repeated key, Book entry is updated with new value

        Set<Integer> keySet = bookMap.keySet();

        for (Integer key : keySet) {  // for each key in the map
            Book book = bookMap.get(key); // get the value using the key (here, value is a reference to a Book object)
            System.out.println(key + " Title: "
                    + book.getTitle() + ", Code:" + book.getCode());
        }
    }

    /**
     * Demonstrates mapping of a single item to a collection type E.g mapping a
     * persons name to a List of their friends. In this example we use an
     * ArrayList object to store the list of friends.
     */
    public static void map4() {
        // Map: Name (String) => ArrayList object (containing list of names)
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();

        // A new ArrayList is required for each map entry
        // John has two friends => Kylie and Donald
        ArrayList<String> friendsList = new ArrayList<>();
        friendsList.add("Kylie");
        friendsList.add("Donald");
        friendsMap.put("John", friendsList);  // put entry (String->ArrayList)

        friendsList = new ArrayList<>();  // new arraylist for Julie's friends
        friendsList.add("Barak");
        friendsList.add("James");
        friendsList.add("Megan");
        friendsMap.put("Julie", friendsList);

        // Retrieve John's list of friends.  The value returned is
        // (a reference to) an ArrayList, so we must assign it to
        // an ArrayList type
        String key = "John";
        friendsList = friendsMap.get(key);  // returns a reference to an ArrayList

        System.out.print(key + "'s friends: ");
        for (String s : friendsList) {
            System.out.print(s + ", ");
        }

        // Output all map entries
        for (Map.Entry<String, ArrayList<String>> entry : friendsMap.entrySet()) {
            key = entry.getKey();
            ArrayList<String> list = entry.getValue();
            System.out.println("Name: " + key + ", Friend: " + list);
        }
    }

    public static void map5() // demonstrates passing a Map as an argument to a method
    {
        // Map a book code to a Book class/object
        //
        Map<Integer, Book> bookMap = new HashMap<>();

        bookMap.put(30004, new Book(30004, "Fight Club")); // long int values automatically converted to Integer
        bookMap.put(40023, new Book(40023, "Jaws"));
        bookMap.put(55523, new Book(55523, "White Teeth"));
        bookMap.put(55523, new Book(55523, "Ted"));  // duplicate key, overwrites existing one

        // call a method that takes a Map and int as arguments, and returns a List
        List<Book> shortTitledBookList = getShortTitledBooks(bookMap, 4);

        System.out.println("Books with short titles (<=4 characters)");
        for (Book book : shortTitledBookList) {
            System.out.println(" Code:" + book.getCode() + ", Title: " + book.getTitle());
        }
    }

    public static List<Book> getShortTitledBooks(Map<Integer, Book> bookMap, int maxLengthOfTitle) {
        // parameter bookMap is a reference to the original map

        List<Book> bookList = new ArrayList<>(); // list to store the result

        Set<Integer> keySet = bookMap.keySet();

        for (Integer key : keySet) {
            Book book = bookMap.get(key);
            if (book.getTitle().length() <= maxLengthOfTitle) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    /**
     * TREE MAP maintains sorted order based on Natural Ordering [compareTo()] of Integer class.
     *
     */
    public static void map6() {
        TreeMap<Integer, Book> bookMap = new TreeMap<>();

        bookMap.put(30004, new Book(30004, "Fight Club")); // long int values automatically converted to Long
        bookMap.put(40023, new Book(40023, "Jaws"));
        bookMap.put(55523, new Book(55523, "White Teeth"));
        bookMap.put(66623, new Book(66623, "Ted"));  // duplicate

        System.out.println("TreeMap");
        System.out.println("Note that output should be in order of Key");

        Set<Integer> keySet = bookMap.keySet();

        for (Integer key : keySet) {
            Book book = bookMap.get(key);
            System.out.println("Key: " + key
                    + book.getTitle() + ", Code:" + book.getCode());
        }
    }

    /**
     * *********************************************************************
     */
    /**
     * Intermediate Level material. Using our own classes as Key values =>
     * implementing hashCode() and equals() in Key class
     *
     */
    public static void map7() // Map (Student => Book )   HashMap
    {
        // Student class is used as the Key in this case,
        // so, Student class MUST implement both hashCode() and equals()
        // so that the fields to be included in the hashing process are available
        // to the HashMap.

        Map<Student, Book> favouriteBook = new HashMap<>();

        Student student = new Student(1001, "Tom Malone");
        Book book = new Book(30004, "Lazy Days");

        favouriteBook.put(student, book);   //

        student = new Student(2002, "Zoe Salanda");
        book = new Book(40023, "Columbiana");
        favouriteBook.put(student, book);

        System.out.println("Map: [ Student -> Book ]");
        // for each Entry in the set of all entries
        for (Map.Entry<Student, Book> entry : favouriteBook.entrySet()) {
            student = entry.getKey();
            book = entry.getValue();
            System.out.println("Student: " + student + ", favourite Book: " + book);
        }
    }

    /**
     * This sample maps a person's name (String) to a HashMap of their attributes.
     * The KEY is the persons name (String), and the VALUE is itself a HashMap that
     * maps attribute names to attribute values (e.g. "height" to "1.76")
     * So, the VALUE is of type "HashMap<String,String>"
     * This is a one-to-many  [ 1 : Many ] association.
     * */
    public static void map8() // map: Name (String) => Attributes (Map)
    {
        Map<String, HashMap<String, String>> usersMap = new HashMap<>();

        HashMap<String, String> attributesMap = new HashMap<>();
        // HashMap for John's attributes
        attributesMap.put("Hair", "Red");
        attributesMap.put("Height", "1.76");
        usersMap.put("John", attributesMap);  // map name to attributes

        // Note that we must instantiate (create) a new HashMap for each person.
        // If we don't then we will have only one HashMap shared between all people.
        attributesMap = new HashMap<>();    // new hashmap for Alice's attributes
        attributesMap.put("Hair", "Black");
        attributesMap.put("Height", "1.76");
        attributesMap.put("Age", "21");     // extra attribute
        usersMap.put("Alice", attributesMap);

// Note: if you use Map interface type for attributes, then you will have to cast the 
// reference to a HashMap<String,String> type.
//  i.e.  userMap.put("Alice", (HashMap<String,String>)attributesMap);

        System.out.println("Map: [ String (name) => Map (attributes map) ]");
        // for each Entry in the set of all entries
        for (Map.Entry<String, HashMap<String, String>> entry : usersMap.entrySet()) {
            String userName = entry.getKey();
            attributesMap = entry.getValue(); // get attributes Map for this username

            System.out.println("User Name: " + userName);
            // iterate over the attributes in the attributes map
            for (Map.Entry<String, String> attributeEntry : attributesMap.entrySet()) {
                System.out.print(" Attribute name: ");
                System.out.print(attributeEntry.getKey());
                String value = attributeEntry.getValue();
                System.out.print(" Value: ");
                System.out.println(value);
            }
        }

  /*
        // Print all keys and values in the map
        Set<String> keySet = usersMap.keySet(); // get all keys

        for (String userName : keySet) {            // for each Entry user name
            attributesMap = usersMap.get(userName);
            System.out.println("User: " + userName);
            
            Set<String> attributeSet = attributesMap.keySet();
            
            for(String attributeName: attributeSet){    // output attributes for a user
                System.out.println( attributeName + 
                            " : " + attributesMap.get(attributeName) );                
            }
            
        }
   */
    }

    /**
     TREEMAP
     In this sample we map a Student object to their favourite Book.
     Student class is used as the Key in this TreeMap, and Book as the value.

     If we wish to maintain an ordering of Students, then we use a TreeMap.
     However, the Students will have to have a "Natural Ordering", which is achieved
     by ensuring that either:
     1. The Student class (Key) implements the Comparable interface, or
     2. A comparator is supplied as an argument to the constructor when creating the TreeMap.
     The comparator will dictate the ordering of the elements in the map.
     */
    public static void map9()  // TREE Map (Student => Book )
    {
        //Map<Student, Book> favouriteBook = new TreeMap<>(new ComparatorStudentName());

        // Alternatively, use Comparator.comparing in constructor for TreeMap order
        // Map<Student, Book> favouriteBook = new TreeMap<>(Comparator.comparing(Student::getName));

        // Or. using Lambda style:
        Map<Student, Book> favouriteBook = new TreeMap<>( (s1,s2) -> s1.getName().compareTo(s2.getName()));

        Student student = new Student(1001, "Tom Malone");
        Book book = new Book(30004, "Lazy Days");

        favouriteBook.put(student, book);

        // or, instantiate objects and add to map in one statement
        favouriteBook.put(new Student(2002, "Zoe Salanda"),
                new Book(40023, "Columbiana"));

        student = new Student(2002, "Adam Ant");
        book = new Book(30053, "Mountains");
        favouriteBook.put(student, book);

        System.out.println("Map: [ Student -> Book ]");
        // for each Entry in the set of all entries
        for (Map.Entry<Student, Book> entry : favouriteBook.entrySet()) {
            student = entry.getKey();
            book = entry.getValue();
            System.out.println("Student: " + student + ", favourite Book: " + book);
        }
    }

}
