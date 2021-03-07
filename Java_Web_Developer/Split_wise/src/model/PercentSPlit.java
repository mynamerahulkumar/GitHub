package model;

public class PercentSPlit extends Split{
    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    double percent;
    public PercentSPlit(User user,double percent) {
        super(user);
        this.percent=percent;
    }
}
