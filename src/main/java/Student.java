/** Student class used as Key object in Map samples.
 * 
 * This Student class MUST implement the hashCode() and equals() methods
 * because Student objects are being used as Keys in a HashMap, and a 
 * HashMap requires that its key objects implement hashCode() & equals()
 * in order to perform the hashing function.
 * The hashCode() and equals() methods must be consistent in their
 * implementation.
 * 
 */

import java.util.Objects;

public class Student {
    
    int id;
    String name;

    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    // Use IDE Menu options:  "Code > Generate > equals() and hashcode()"
    //
    @Override
    public int hashCode() {
        return Objects.hash(id, name);  // both fields are included in the hash function
    }

    @Override
    public boolean equals(Object obj)  // must be consistent with the hashCode()
    {                                   // i.e. use the same fields as in hashcode()
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Student{" + "id=" + id + ", name=" + name + '}';
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }   
}
