package authentication.example.Authentication_hashing.Hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SaltExample {
    public static void main(String[] args) {
        String passwordToHash="myPassword";
        byte[]salt =createSalt();
        String securePassword=getSecure_password(passwordToHash,salt);
        System.out.println(securePassword);
    }
    private static byte[] createSalt(){
        SecureRandom random=new SecureRandom();
        byte[]salt=new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    private static String getSecure_password(String passwordToHash,byte[]salt ){
        String generatedPassword=null;
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[]bytes=md.digest(passwordToHash.getBytes());
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<bytes.length;i++){
                sb.append(Integer.toString((bytes[i]&0xff)+0x100,16).substring(1));
            }
            generatedPassword=sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return  generatedPassword;
    }

}
