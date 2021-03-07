package model;

public class Patient extends Hospital{
    Patient(String hospitalName, String location, int available_beds, float rating, String contact, String doctor_name, int price) {
        super(hospitalName, location, available_beds, rating, contact, doctor_name, price);
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    String p_name;
    int p_id;
}
