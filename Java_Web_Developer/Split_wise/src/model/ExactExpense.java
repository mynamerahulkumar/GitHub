package model;

import java.util.List;

public class ExactExpense  extends Expense{
    public ExactExpense( double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate(){
        for(Split split:getSplits()){
            if(!(split instanceof  EqualSplit)){
                return false;
            }
        }
        double totalAmount=getAmount();
        double sumofTotalAmount=0;
        for(Split split:getSplits()){
            double amount=split.getAmount();
            sumofTotalAmount+=amount;
        }
        if(sumofTotalAmount!=totalAmount){
            return false;
        }
        return true;
    }


}
