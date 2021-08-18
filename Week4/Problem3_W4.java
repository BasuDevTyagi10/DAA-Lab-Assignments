package Week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3_W4 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("./Week4/input3.txt"));
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}