import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        ExpenseManager expenseManager=new ExpenseManager();
        expenseManager.addUser(new User("u1","user1","gaurav@workat.tech","9876543210"));
        expenseManager.addUser(new User("u2","user2","sagar@workat.tech","9876543210"));
        expenseManager.addUser(new User("u3","user3","hi@workat.tech","9876543210"));
        expenseManager.addUser(new User("u4","user4","mock-interviews@workat.tech","9876543210"));
        Scanner scanner=new Scanner(System.in);
        while (true){
            String command=scanner.nextLine();
            String[] commands=command.split("");
            String commandType=commands[0];
            switch (commandType){
                case "SHOW":
                    if(commands.length==1){
                        expenseManager.showBalances();
                    }
                    else{
                        expenseManager.showBalance(commands[1]);
                    }
                    break;
                case "EXPENSE":
                    String paidBy=commands[1];
                    Double amount=Double.parseDouble(commands[2]);
                    int noOFusers=Integer.parseInt(commands[3]);
                    String expenseType=commands[4+noOFusers];
                    List<Split> splits=new ArrayList<>();
                    switch (expenseType){
                        case "EQUAL":
                            for(int i=0;i<noOFusers;i++){
                                splits.add(new EqualSplit(expenseManager.userMap.get(commands[4+i])));
                            }
                            expenseManager.addExpense(ExpenseType.EQUAL,amount,paidBy,splits,null);
                            break;

                        case "EXACT":
                            for(int i=0;i<noOFusers;i++){
                                splits.add(new ExactSplit(expenseManager.userMap.get(commands[4+i]),Double.parseDouble(commands[5+noOFusers+i])));
                            }
                            expenseManager.addExpense(ExpenseType.EXACT,amount,paidBy,splits,null);
                            break;
                        case "PERCENT":
                            for(int i=0;i<noOFusers;i++){
                                splits.add(new PercentSPlit(expenseManager.userMap.get(commands[4+1]),Double.parseDouble(commands[5+noOFusers+i])));
                            }
                            expenseManager.addExpense(ExpenseType.PERCENT,amount,paidBy,splits,null);
                            break;
                     }
                     break;
             }
    }
}
}
