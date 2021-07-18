package Week1;

/**
 * JumpSearch
 */
import java.util.*;
public class JumpSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            int key=sc.nextInt();
            int comparisions=0; boolean isPresent=false;
            int step = 2,prev=0;
            while(arr[step]<key){
                comparisions++;
                prev = step;
                step += 2;
                if(step>=n){
                    step = n-1;
                    break;
                }
            }
            for(int i=prev;i<=step;i++){
                comparisions++;
                if(arr[i]==key){
                    isPresent = true;
                    break;
                }
            }
            if(isPresent) System.out.println("Present "+comparisions);
            else System.out.println("Not Present "+comparisions);
        }
        sc.close();
    }
}