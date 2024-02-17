package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class CollectionMain {
    public static void main(String[] args) {
        System.out.println("Hello world");
        ArrayList<Integer> intarr=new ArrayList<>();
        for(Integer i:intarr){
            System.out.println(i);
        }
        Iterable iterable;//
        intarr.iterator();
        HashMap<String,Integer> intMap=new HashMap<>();// hashmap is not iterable so we can't use directly
        for(String key:intMap.keySet()){
            Integer i=intMap.get(key);
        }
    }
}
