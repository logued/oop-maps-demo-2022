

public class Book 
{
    int code; // unique identifier for each book instance
    String title;

    public Book(int code, String title){
        this.code = code;
        this.title = title;
    }

    public int getCode(){
        return code;
    }

    public String getTitle(){
        return title;
    }

  @Override
  public String toString() {
    return "Book{" + "code=" + code + ", title=" + title + '}';
  }
    
    
}
