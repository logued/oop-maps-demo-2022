/** Student class used as Key object in Map samples.
 * 
 * This Student class MUST implement the hashCode() and equals() methods
 * because Student objects are being used as Keys in a HashMap, and a 
 * HashMap requires that its key objects implement hashCode() in order
 * to perform the hashing function.
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

    @Override
    public int hashCode()   // has function that used both id and name
    {
        int hash = 5;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj)  // compliments the hashCode()
    {
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
