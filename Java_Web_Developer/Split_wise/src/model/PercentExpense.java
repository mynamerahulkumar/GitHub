package model;

import java.util.List;

public class PercentExpense extends Expense{

    public PercentExpense( double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for(Split split:getSplits()){
            if(!(split instanceof PercentSPlit)){
                return false;
            }
        }
        double sumPercent=0;
        double totalPercent=100;
        for(Split split:getSplits()){
            PercentSPlit percentSPlit= (PercentSPlit) split;
            sumPercent+=percentSPlit.getPercent();
            }
        if(sumPercent!=totalPercent){
            return false;
        }
        return true;
    }
}
