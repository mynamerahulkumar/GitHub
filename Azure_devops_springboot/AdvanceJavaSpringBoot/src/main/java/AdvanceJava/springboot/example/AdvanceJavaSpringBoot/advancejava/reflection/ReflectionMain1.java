package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.reflection;

import com.google.gson.Gson;

public class ReflectionMain1 {
    static Gson g=new Gson();
    public static void main(String[] args) {
        Person p1=new Person("Rahul",29);
       String data=g.toJson(p1);
        System.out.println(data);

        Person p2=g.fromJson("{\"name\":\"Rahul1\",\"age\":29}",Person.class);
        System.out.println(p2.age);
        System.out.println(p2.name);
    }
}
