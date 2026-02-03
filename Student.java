/**
 * Represents a Student entity with basic attributes.
 */
public class Student {
    private int id;       // Unique identifier for the student
    private String name;  // Student's full name
    private int age;      // Student's age

    /**
     * Constructor to initialize a Student object.
     * @param id   Unique student ID
     * @param name Student's name
     * @param age  Student's age
     */
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters
    public int getId() {
         return id;
         }
    public String getName()
     { 
        return name; 
     }
    public int getAge() 
    { return age; 

    }

    // String representation of Student object
    @Override
    public String toString() {
        return "ID:" + id + " | Name:" + name + "| Age:" + age;
    }
}
