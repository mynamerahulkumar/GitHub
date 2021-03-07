package model;

public class Hospital {
    String hospitalName;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAvailable_beds() {
        return available_beds;
    }

    public void setAvailable_beds(int available_beds) {
        this.available_beds = available_beds;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    String location;
    int available_beds;
    float rating;
    String contact;
    String doctor_name;
    int price;
     Hospital(String hospitalName,String location,int available_beds,float rating,String contact,String doctor_name,int price){
         this.hospitalName=hospitalName;
         this.location=location;
         this.available_beds=available_beds;
         this.rating=rating;
         this.contact=contact;
         this.doctor_name=doctor_name;
         this.price=price;
    }
}
