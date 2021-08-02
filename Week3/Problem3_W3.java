package Week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3_W3 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("./Week3/input1.txt"));
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}