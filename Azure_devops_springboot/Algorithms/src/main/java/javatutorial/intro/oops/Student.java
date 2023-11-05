package javatutorial.intro.oops;

public class Student {
    String name;
    public Student(){
    }
    public Student(String name){
        this.name=name;
    }
    public static void main(String[] args) {
        Student student=new Student();
        Student student2=new Student("John");
        System.out.println("Student Name-"+student2.name);//John
    }
}
