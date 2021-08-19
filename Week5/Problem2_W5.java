package Week5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2_W5 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week5/input2.txt"));
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
    
}