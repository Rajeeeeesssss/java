import java.util.Scanner;


class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private Student next; 

    // Constructor
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
       
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public Student getNext() { return next; }
    public void setNext(Student next) { this.next = next; }

    public void updateDetails(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }


    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}


class StudentManagementSystem {
    private Student head; 

    public StudentManagementSystem() {
        this.head = null;
    }

    // Add student
    public void addStudent(int id, String name, int age, String course) {
        Student newStudent = new Student(id, name, age, course);
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newStudent);
        }
        System.out.println("Student added successfully!");
    }

    // View students
    public void viewStudents() {
        if (head == null) {
            System.out.println("No students found.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    // Update details
    public void updateStudent(int id, String name, int age, String course) {
        Student temp = head;
        while (temp != null) {
            if (temp.getId() == id) {
                temp.updateDetails(name, age, course);
                System.out.println("Student updated successfully!");
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Delete details
    public void deleteStudent(int id) {
        if (head == null) {
            System.out.println("No students found.");
            return;
        }
        if (head.getId() == id) {
            head = head.getNext();
            System.out.println("Student deleted successfully!");
            return;
        }
        Student temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getId() == id) {
                temp.setNext(temp.getNext().getNext());
                System.out.println("Student deleted successfully!");
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}

public class StudentManagementS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    sms.addStudent(id, name, age, course);
                    break;
                case 2:
                    sms.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter ID of student to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int updateAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Course: ");
                    String updateCourse = scanner.nextLine();
                    sms.updateStudent(updateId, updateName, updateAge, updateCourse);
                    break;
                case 4:
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = scanner.nextInt();
                    sms.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
