/*
 * Comparator to compare name fields of two Student Classes
   This comparator is used by the TreeMap data structure
   to determine the order in which Student objects are stored.
   
*/


import java.util.Comparator;

public class ComparatorStudentName implements Comparator<Student> 
{
  @Override
  public int compare( Student s1, Student s2)
  {
    return s1.getName().compareTo(s2.getName());
  }
}
