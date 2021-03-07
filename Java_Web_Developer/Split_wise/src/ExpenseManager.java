import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    List<Expense> expenses;
    Map<String , User> userMap;
    Map<String,Map<String,Double>> balanceSheet;
    public ExpenseManager(){
        expenses=new ArrayList<Expense>();
        userMap=new HashMap<String,User>();
        balanceSheet=new HashMap<String,Map<String,Double>>();
    }
    public void addUser(User user){
        userMap.put(user.getId(),user);
        balanceSheet.put(user.getId(),new HashMap<String,Double>());
    }
    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split>splits, ExpenseMetadata expenseMetadata){
        Expense expense=ExpenseService.createExpense(expenseType,amount,userMap.get(paidBy),splits,expenseMetadata);
        expenses.add(expense);
        for (Split split:splits){
            String paidTo=split.getUser().getId();
            Map<String,Double> balance=balanceSheet.get(paidBy);
            if(!balance.containsKey(paidTo)){
                balance.put(paidTo,0.0);
            }
            balance.put(paidTo,balance.get(paidTo)+split.getAmount());
            balance=balanceSheet.get(paidTo);
            if(!balance.containsKey(paidBy)){
                balance.put(paidBy,0.0);
            }
            balance.put(paidBy,balance.get(paidBy)-split.getAmount());
        }

    }
    public void showBalance(String userId){
        boolean isEmpty=true;
        for(Map.Entry<String ,Double> userBalance:balanceSheet.get(userId).entrySet()){
            if(userBalance.getValue()!=0){
                isEmpty=false;
                printBalance(userId,userBalance.getKey(),userBalance.getValue());
            }
        }
        if(isEmpty){
            System.out.println("No balance");
        }
    }
    public void showBalances(){
        boolean isEmpty=true;
        for(Map.Entry<String,Map<String,Double>> allBalance:balanceSheet.entrySet()){
            for(Map.Entry<String,Double> userBalance:allBalance.getValue().entrySet()){
                if(userBalance.getValue()!=0){
                    isEmpty=false;
                    printBalance(allBalance.getKey(),userBalance.getKey(),userBalance.getValue());
                }
            }
        }
    }
    private void printBalance(String user1,String user2,double amount){
        String username1=userMap.get(user1).getName();
        String username2=userMap.get(user2).getName();
        if(amount<0){
            System.out.println(username1+" owes "+username2+":"+Math.abs(amount));
        }
        else if(amount>0){
            System.out.println(username2+ " owes "+username1+":"+Math.abs(amount));
        }
    }

}
