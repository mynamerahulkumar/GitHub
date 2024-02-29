package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.reflection;

import com.google.gson.Gson;

import java.lang.reflect.Field;

public class ReflectionMain1 {
    static Gson g=new Gson();
    public static void main(String[] args) throws IllegalAccessException {
        Person p1=new Person("Rahul",29);
      // serlization-convert object to data transportable to network
       String data=g.toJson(p1);
        System.out.println(data);
        // deserilization-convert data to object
        Person p2=g.fromJson("{\"name\":\"Rahul1\",\"age\":29}",Person.class);
        System.out.println(p2.age);
        System.out.println(p2.name);
        printObject(p2);
        Vehicle2 vehicle2=new Vehicle2(4,"red");
        printObject(vehicle2);
    }

    /**
     *  here we have used reflection to print unknown object
     * @param o
     * @throws IllegalAccessException
     */
    static void printObject(Object o) throws IllegalAccessException {
        Class objectClass=o.getClass();
        System.out.println("class-"+objectClass.getSimpleName());
        for(Field field:objectClass.getDeclaredFields()){
            String value="";
            if(field.getType().equals(int.class)){
                value=String.valueOf(field.getInt(o));
            }
            if(field.getType().equals(String.class)){
                value= (String) field.get(o);
            }
            System.out.println("Field:"+field.getName()+" value:"+value);
        }
    }
}
