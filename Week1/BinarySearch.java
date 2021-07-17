package Week1;

/**
 * BinarySearch
 */
import java.util.*;
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            int key=sc.nextInt();
            int comparisions=0; boolean isPresent=false;
            int l=0,u=n-1,mid;
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