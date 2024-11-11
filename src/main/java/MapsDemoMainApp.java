
/**                                    Nov 2024
 * Map Interface - Implemented by HashMap and TreeMap classes
 *
 * A Map is a Data Structure that allows us to associate a Key with a Value.
 * e.g. A person's name with their favorite film "John" -> "StarWars"
 * or a class group with a list of students: "SD2A" -> {"Anne", "John",..}.
 *
 * When we add an entry to a Map we must provide both the Key and the Value.
 * These pairs are often called a "Key-Value" pairs.
 *
 * A Map stores both the Key and the Value for each key|value pair. Key and
 * Value must be class types (not primitive types, so Integer rather than int)
 * The Key class must implement the methods hashCode() and equals() [or inherit
 * them]
 *
 * String and Integer are the most effective and preferred Key types.
 * Keys must be unique (no duplicate keys are allowed)
 * A Map can be implemented as a HashMap or a TreeMap.
 *  - HashMap is fastest for put() and get() (but order is not maintained)
 *    HashMap time complexity is O(1)
 *  - TreeMap maintains a sorted order based on the "natural ordering"
 *    of the Key elements ( defined by compareTo() ) or based on a
 *    Comparator supplied in the Map constructor.
 *    TreeMap time complexity is O(log n)
 *
 * Maps are commonly used to pass data around within a program, so it is
 * important to understand how to use them.
 */
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class MapsDemoMainApp {

  public static void main(String[] args) {
    System.out.println("Maps Demo");
    System.out.println("- remember to uncomment method calls in main() to see outputs.");

      map1();     // HashMap: String=>String
     // map2();     // HashMap: String=>Integer
     // map3();     // HashMap: Integer=>Book
     // map4();     // HashMap: String=>ArrayList
     // map5();     // Passing Map as argument into a method
     // map6();     // TreeMap: Integer=>Book - hashCode() & equals()
     // map7();     // HashMap: (Student=>Book) - hashCode() & equals()
     // map8();     // HashMap: (String=>HashMap<String,String>
     // map9();     // TreeMap: (Student=>Book) - Comparator required
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
    String favourite = map.get(key);  // use Key to get Value
    System.out.println(key + " favourite film is: " + favourite);

    // delete or remove() entries from the map
    key = "John";
    map.remove(key);  // deletes the Entry for John

    //TODO: add your own name and favourite film to the map
    // and then retrieve and display it. Finally remove it.
    // get() returns null if the key is not found, so we should always check for null
    // (this check may be omitted from the sample code below, but you should always use it)
    key = "Elvis";
    favourite = map.get(key);  // use Key to get Value
    if (favourite != null) {
      System.out.println(key + " favourite film is: " + favourite);
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

    Set<Entry<String, String>> entrySet = map.entrySet();  // get all entries (Entry objects)
    System.out.println("\n\nMap<Key:Value> pairs (Entry objects)");
    // iterate over each Entry in the set of etries
    for (Map.Entry<String, String> entry : entrySet) {
      key = entry.getKey(); // get key object from the Entry
      String value = entry.getValue();
      System.out.println("Name: " + key + ", Favourite film: " + value);
    }

    //Print the values in the map
    System.out.println("All values from the Map:");
    Collection<String> values = map.values(); // get all the values
    for (String s : values) {
      System.out.print(s + ", ");
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

    // Retrieve all values using key values
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

    for (Integer key : keySet) {
      Book book = bookMap.get(key);
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
    Map< String, ArrayList<String> > friendsMap = new HashMap<>();

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

    List<Book> shortTitledBookList;

    shortTitledBookList = getShortTitledBooks(bookMap, 4); // pass a Map as an argument

    System.out.println("Books with short titles (<=4 characters)");
    for (Book book : shortTitledBookList) {
      System.out.println(" Code:" + book.getCode() + ", Title: " + book.getTitle() );
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
   * TREE MAP maintains sorted order based on compareTo() of Long class
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
  public static void map7() // Map (Student => Book )
  {
    // Student class is used as the Key in this case,
    // so, it MUST implement hashCode() and equals()
    // so that the map can compare elements.


    Map<Student, Book> favouriteBook = new HashMap<>();

    Student student = new Student(1001, "Tom Malone");
    Book book = new Book(30004, "Lazy Days");

    favouriteBook.put(student, book);

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
   * This sample maps "String" to "HashMap<String,String>"
   * representing a mapping of a String (name) to a Map of attributes [ 1 : Many ]
   */
  public static void map8() // map: Name (String) => Attributes (Map)
  {
    Map< String, HashMap<String, String> > usersMap = new HashMap<>();

    HashMap< String, String > attributesMap = new HashMap<>();
    // HashMap for John's attributes
    attributesMap.put("Hair", "Red");
    attributesMap.put("Height", "1.76");
    usersMap.put("John", attributesMap);  // map name to attributes

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
      attributesMap = entry.getValue(); // get attributes Map for a username

      System.out.println("User Name: " + userName);
      // loop over the attributes in the attributes map
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

public static void map9()  // TREE Map (Student => Book )
    {
        // Student class is used as the Key in this TreeMap,
        // so, Student must implement Comparable or
        // a Comparator must be supplied to the TreeMap on construction
        // The comparator will dictate the ordering of the elements in the map.

        Map<Student, Book> favouriteBook = new TreeMap<>(new ComparatorStudentName());
        
        Student student = new Student(1001, "Tom Malone");
        Book book = new Book(30004, "Lazy Days");
        
        favouriteBook.put(student, book);

        // or, instantiate objects and add to map in one statement
        favouriteBook.put(new Student(2002, "Zoe Salanda"),
                          new Book(40023, "Columbiana")   );
        
        student = new Student(2002, "Adam Ant");
        book = new Book(30053, "Mountains");
        favouriteBook.put(student, book);
             
        System.out.println("Map: [ Student -> Book ]");
        // for each Entry in the set of all entries
        for (Map.Entry<Student, Book> entry : favouriteBook.entrySet()) {
            student = entry.getKey();
            book = entry.getValue();
            System.out.println("Student: " + student + ", favourite Book: "+book); 
        }
    }
    
}
