package Week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1_W6 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week6/input1.txt"));
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
