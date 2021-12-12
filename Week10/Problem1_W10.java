package Week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem1_W10 {
    static class Activity{
        int startTime,endTime,index;
        Activity(int startTime, int endTime, int index){
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
    }
    static void activitySelection(int n, int startTimes[], int endTimes[]){
        Activity activities[] = new Activity[n];
        for(int i=0;i<n;i++) activities[i] = new Activity(startTimes[i], endTimes[i], i+1);
        Arrays.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2){
                if(a1.endTime > a2.endTime) return 1;
                else if(a1.endTime < a2.endTime) return -1;
                else{
                    if(a1.startTime >= a2.startTime) return 1;
                    else return 1;
                }
            }
        });
        ArrayList<Integer> selected = new ArrayList<>();
        int i,j;
        i = 0;
        selected.add(activities[i].index);
        
        for (j = 1; j < n; j++){
            if (activities[j].startTime >= activities[i].endTime){
                selected.add(activities[j].index);
                i = j;
            }
        }
        int noa = selected.size();
        System.out.println("No. of non-conflicting activities: "+noa);
        System.out.print("List of selected activities: ");
        for(int x=0;x<noa;x++)
            System.out.print(x == noa-1 ? selected.get(x)+"\n" : selected.get(x)+",");
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week10/input1.txt"));
            int n = sc.nextInt();
            int startTimes[] = new int[n];
            int endTimes[] = new int[n];
            for(int i=0;i<n;i++) startTimes[i] = sc.nextInt();
            for(int i=0;i<n;i++) endTimes[i] = sc.nextInt();
            activitySelection(n, startTimes, endTimes);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
