import java.util.*;
class Course{ //stores all the course information like course code, title, credits, how many students are enrolled, and the max capacity
    private String code;
    private String title;
    private int credits;
    private int enrolled;
    private int capacity;

    public Course(String code, String title, int credits, int capacity){ //sets up the course
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.capacity = capacity;

        enrolled = 0; //starts with 0 students
    }
    //returns data
    public String getCode() {
        return code;
    }
    public String getTitle(){
        return title;
    }
    public int getCredits(){
        return credits;
    }
    public int getEnrolled(){
        return enrolled;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity; //updates the course size
    }
    public boolean isAvailable(){
        return enrolled < capacity;  // if the course still has openings then the student can still enroll
    }
    public void incrementEnrolled(){
        enrolled++; //increases count after each enrollment
    }
    public void decrementEnrolled(){ //when course is dropped
        enrolled--;
    }
    @Override
    public String toString(){ //text
        return code + " - " + title + " (" + credits + " cr) [" + enrolled + "/" + capacity + " enrolled]"; //returns the course info
    }
}

class Student { //Stores student info
    private String name;
    private String studentId;
    private double gpa;
    private List<Course> courses;

    public Student(String name, String studentId, double gpa) { //Sets up student information
        this.name = name;
        this.studentId = studentId;
        this.gpa = gpa;

        courses = new ArrayList<>();
    }

    public void enroll(Course course) { //enrolls the student in the course
        if (courses.contains(course)) {
            throw new IllegalStateException("Already enrolled in " + course.getCode()); //checks if already enrolled

        }
        if (!course.isAvailable()) {
            throw new IllegalArgumentException(course.getCode() + " is full."); //checks if there is space
        }
        courses.add(course);
    }

    public void drop(String courseCode) { //drops the course
        Iterator<Course> it = courses.iterator();
        while (it.hasNext()) {
            Course c = it.next();
            if (c.getCode().equalsIgnoreCase(courseCode)) {
                it.remove();
                c.decrementEnrolled();
                return;
            }
        }
        throw new NoSuchElementException("Course not found: " + courseCode);
    }

    public int getTotalCredits() { //adds the credits of all the classes being taken
        int total = 0;
        for (Course c : courses) {
            total += c.getCredits();
        }
        return total;
    }

    public String getName() { //getters that return the students info when class needs it
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public List<Course> getCourses() {
        return courses;
    } //for the course roster
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //for multiple lines of string

        sb.append("Student: ")
                .append(name)
                .append(" (ID: ")
                .append(studentId)
                .append(") | GPA: ")
                .append(gpa)
                .append(" | Credits: ")
                .append(getTotalCredits())
                .append("\n");

        for (Course c : courses) {
            sb.append("   - ")
                    .append(c.getCode())
                    .append(": ")
                    .append(c.getTitle())
                    .append(" (")
                    .append(c.getCredits())
                    .append(" cr)")
                    .append("\n");
        }
        return sb.toString();
    }
}

class Registrar { //stores all students and courses
    private List<Course> catalog;
    private List<Student> students;

    public Registrar(){ //empty list
        catalog = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourse(Course c){
        catalog.add(c);
    } //add the course to the list
    public void addStudent(Student s){
        students.add(s);
    } //adds student to the list
    public Course findCourse(String code){
        for (Course c : catalog){
            if (c.getCode().equalsIgnoreCase(code)){ //works even with capitalization differences
                return c;
            }
        }
        return null;
    }
    public void register(Student s, Course c){ //registers student and updates the count
        s.enroll(c);
        c.incrementEnrolled();
    }

    public void printRoster(String code){ //prints the course roster and every student that has that course
        Course c = findCourse(code);
        if (c == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println(c);
        for (Student s : students) {

            if (s.getCourses().contains(c)){

                System.out.println(" - " + s.getName() + " (" + s.getStudentId() + ")");
            }
        }
    }
}
public class LabTen { //main method
    public static void main(String[] args){

        Registrar reg = new Registrar();

        Course cs101 = new Course("CS10", "Intro to Programming", 3, 2);
        Course math201 = new Course("MATH201", "Calculus 1", 4, 3);
        Course eng102 = new Course("eng102", "Technical Writing", 3, 5);

        reg.addCourse(cs101);
        reg.addCourse(math201);
        reg.addCourse(eng102);

        Student alice = new Student("Alice", "5001", 3.7);
        Student bob = new Student("Bob", "5002", 3.2);
        Student carol = new Student("Carol", "5003", 3.9);
        Student david = new Student("David", "5004", 3.5);

        reg.addStudent(alice);
        reg.addStudent(bob);
        reg.addStudent(carol);
        reg.addStudent(david);

        reg.register(alice, cs101);
        reg.register(alice, math201);
        reg.register(alice, eng102);

        reg.register(bob, cs101);

        try{
            reg.register(carol, cs101);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        alice.drop("ENG102");

        System.out.println("\n// After enrollment:");
        System.out.println(alice);

        System.out.println("// Roster for CS101:");
        reg.printRoster("CS101");
    }
}
