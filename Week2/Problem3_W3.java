package Week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Problem3_W3 {
    public static void main(String[] args) throws IOException{
        try {
            Scanner sc = new Scanner(new File("./Week2/input2.txt"));
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
