package Utility;

import model.Hospital;
import model.Patient;

import java.util.Arrays;
import java.util.Vector;

public class Hospital_Utility {
    public void printHospitalData(Vector<Hospital> hospitalData){
        int n=hospitalData.size();
        for(int i=0;i<n;i++){
            System.out.println(hospitalData.get(i).getHospitalName());
            System.out.println(hospitalData.get(i).getLocation());
            System.out.println(hospitalData.get(i).getAvailable_beds());
            System.out.println(hospitalData.get(i).getRating());
            System.out.println(hospitalData.get(i).getContact());
            System.out.println(hospitalData.get(i).getDoctor_name());
            System.out.println(hospitalData.get(i).getPrice());
        }
    }
    public void printPatientDate(Vector<Patient> patientData){
        int n=patientData.size();
        for(int i=0;i<n;i++){
            System.out.println(patientData.get(i).getP_name());
            System.out.println(patientData.get(i).getP_id());
            System.out.println(patientData.get(i).getHospitalName());
            System.out.println(patientData.get(i).getAvailable_beds());
            System.out.println(patientData.get(i).getRating());
            System.out.println(patientData.get(i).getContact());
            System.out.println(patientData.get(i).getDoctor_name());
            System.out.println(patientData.get(i).getPrice());


        }
    }
//    boolean name(Hospital A,Hospital B){
//        boolean b = A.getHospitalName() > B.getHospitalName();
//        return b;
//    }
//    public void SortHospitalByName(Vector<Hospital> hospitals){
//        Arrays.sort(hospitals.be);
//    }

    
}
