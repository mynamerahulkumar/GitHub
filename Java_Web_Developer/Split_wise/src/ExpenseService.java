import model.*;

import java.util.List;

public class ExpenseService {
    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata){
        switch (expenseType){
            case EXACT:
                return new ExactExpense(amount,paidBy,splits,expenseMetadata);
            case PERCENT:
                for (Split split:splits){
                    PercentSPlit percentSPlit= (PercentSPlit) split;
                    split.setAmount((percentSPlit.getPercent()*amount)/100);
                }
                return new PercentExpense(amount,paidBy,splits,expenseMetadata);
            case EQUAL:
                int totalSplit=splits.size();
                double splitAmount=((double) Math.round((amount*100)/totalSplit)/100);
                for (Split split:splits){
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount+(amount-splitAmount*totalSplit));
                return new EqualExpense(amount,paidBy,splits,expenseMetadata);
            default:
                return null;
        }
    }
}
