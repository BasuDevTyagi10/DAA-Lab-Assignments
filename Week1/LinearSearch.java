package Week1;

/**
 * LinearSearch
 */
import java.util.*;
public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            int key=sc.nextInt();
            int comparisions=0; boolean isPresent=false;
            for(int i=0;i<n;i++){
                comparisions++;
                if(arr[i]==key){
                    isPresent=true;
                    break;
                }
            }
            if(isPresent) System.out.println("Present "+comparisions);
            else System.out.println("Not Present "+comparisions);
        }
        sc.close();
    }
}