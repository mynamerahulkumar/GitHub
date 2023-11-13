package javatutorial.intro.files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFiles {
    public static void main(String[] args) throws IOException {
        FileReader in=null;
        FileWriter out=null;
        try {
            in =new FileReader("C:\\Users\\LENOVO\\Documents\\GitHub\\Azure_devops_springboot\\Algorithms\\src\\main\\java\\javatutorial\\intro\\" +
                    "files\\input.txt");
            out= new FileWriter("C:\\Users\\LENOVO\\Documents\\GitHub\\Azure_devops_springboot\\Algorithms\\src\\main\\java\\javatutorial\\intro" +
                    "\\files\\output.txt");
            int c = 0;
            while((c=in.read())!=-1){
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(in!=null){
                in.close();
            }
            if(out!=null){
                out.close();
            }
            System.out.println("File copy");
        }

    }
}
