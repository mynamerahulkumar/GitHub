package com.online.ecommercespringboot.controller;

import com.online.ecommercespringboot.dto.Customer;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/ecom")
public class EcommerceController {
    HashMap<Integer,String> hashMap=new HashMap<>();
    @GetMapping("/customerdetails")
    public String getCustomerDetails(@RequestParam int id){
        System.out.println("Welcome to Emcommerce website");
        if(hashMap.containsKey(id)){
            String name=hashMap.get(id);
            return "Customer Name-"+name;
        }
        else{
            return "Customer does not exist";
        }
    }
    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        System.out.println("Welcome to Emcommerce website-Customer added");
        if(hashMap.containsKey(customer.getId())){
            return "Customer already exist";
        }
        hashMap.put(customer.getId(),customer.name);
        return "Customer added";
    }


    @PostMapping("/addCustomerFile")
    public String addCustomerFile(@RequestBody Customer customer)  {
        try {
            FileWriter fileWriter=new FileWriter("MyFile.txt",true);
            String details=customer.toString();
            fileWriter.write(details);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Welcome to Emcommerce website-Customer added");
        return "Customer added";
    }

    @GetMapping("/readCustomerFile")
    public String getCustomerFile()  {
        String details="";
        try {
            FileReader fileReader=new FileReader("MyFile.txt");
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line="";
            while ((line =bufferedReader.readLine())!=null){
                details=details+line +" ";
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Welcome to Emcommerce website-Customer added");
        return details;
    }






}
