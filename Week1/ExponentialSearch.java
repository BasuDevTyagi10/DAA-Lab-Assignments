package Week1;

/**
 * ExponentialSearch
 */
import java.util.*;
public class ExponentialSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            int key=sc.nextInt();
            int comparisions=0; boolean isPresent=false;
            if(arr[0] == key){
                comparisions = 1;
                System.out.println("Present "+comparisions);
                System.exit(0);
            }
            int j = 1;
            while(j<n && arr[j]<=key){
                comparisions++;
                j = j*2;
            }
            // binary Search to find key
            int l=j/2,u=Math.min(j, n-1),mid;
            while(u>=l){
                comparisions++;
                mid=(u+l)/2;
                if(arr[mid]==key){
                    isPresent=true;
                    break;
                } else if(arr[mid]>key) {
                    u = mid-1;
                } else if(arr[mid]<key) {
                    l = mid+1;
                }
            }
            if(isPresent) System.out.println("Present "+comparisions);
            else System.out.println("Not Present "+comparisions);
        }
        sc.close();
    }
}