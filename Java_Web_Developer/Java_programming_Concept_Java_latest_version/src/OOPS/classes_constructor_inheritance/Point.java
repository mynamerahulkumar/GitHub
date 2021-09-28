package OOPS.classes_constructor_inheritance;

public class Point {
    private  int x;
    private int y;
    public Point(){
    }
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public double distance(){
        return this.distance(0,0);
    }
    public double distance(int x2,int y2){

        return Math.sqrt((this.x-x2)*(this.x-x2)+(this.y-y2)*(this.y-y2));
    }
    public double distance(Point point2){
       return this.distance(point2.x, point2.y);
    }

}
