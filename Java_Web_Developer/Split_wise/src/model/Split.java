package model;

public class Split {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private User user;
    double amount;
    public Split(User user){
        this.user=user;
    }

}
