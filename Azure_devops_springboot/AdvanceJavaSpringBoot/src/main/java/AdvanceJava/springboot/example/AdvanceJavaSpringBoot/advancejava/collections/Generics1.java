package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Generics1 {
    /**
     * covariance,contravariance and invariance
     * y=f(x)
     * A,B;where A extend B
     * covariance
     * then f(A) extends f(B)
     *
     * contraverses
     * then f(B) extends f(A)
     *
     * invariant
     * --no relationship
     */
    public static void main(String[] args) {

        Truck t=new Truck();
        t.insert(new Cement());
        List<Sand> sands=new ArrayList<>(2);
        sands.add(new Sand());
        sands.add(new Sand());
       // t.insertAll( sands);// java does not understand if list of sand has relation with list of good-invariant
        t.insertAll((List) sands);
        t.prinstatus();


    }
  static   class  Person{

    }
   static class Goods{

    }
   static class  Cement extends Goods{

    }
    static class Sand extends Goods{}

    static class  Student extends Person{

    }
  static   class Vehicle<T>{
        Stack<T> items=new Stack<>();
        int capacity=10;
        private int filled=0;
        void  prinstatus(){
            items.forEach(item-> System.out.println(item));
        }
        void insertAll(List<T> itemlist){
            items.addAll(itemlist);
        }
        void insert(T item){
            filled++;
            items.add(item);
        }
        T unload(){
            T item=items.pop();
            filled--;
            return item;
        }

    }
  static   class SchoolBus extends Vehicle<Person>{

    }
   static class Truck extends Vehicle<Goods>{

   }
}
