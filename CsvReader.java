package ku.cs.controllers.admin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class CsvReader {
    public static  void main(String[] args) throws  IOException{
        File purchase = new File("D:/OKOK/filecsv/purchase.csv");
        BufferedReader br = new BufferedReader(new FileReader(purchase));
        String line ="";
        try{
            while ((line=br.readLine())!=null){
                String[] count = line.split(",");
                System.out.println(count[0]+" "+count[1]);

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
