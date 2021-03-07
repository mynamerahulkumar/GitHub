package model;

import java.util.List;

public class EqualExpense  extends Expense{
    public EqualExpense( double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super( amount, paidBy, splits, expenseMetadata);
    }
    public boolean validate(){
            for(Split split:getSplits()){
                if(!(split instanceof EqualSplit)){ //check during creation of this list all have equal split
                    return false;
                }
            }
            return true;
    }
}
