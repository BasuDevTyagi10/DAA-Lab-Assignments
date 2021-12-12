package Week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Problem2_W10 {
    static class Job{
        int timeTaken, deadLine, index;
        Job(int timeTaken, int deadLine, int index){
            this.timeTaken = timeTaken;
            this.deadLine = deadLine;
            this.index = index;
        }
    }
    static void jobSequencing(int n, int timeTaken[], int deadLine[]){
        Job jobs[] = new Job[n];
        for(int i=0;i<n;i++) jobs[i] = new Job(timeTaken[i], deadLine[i], i+1);
        
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.deadLine - o2.deadLine;
            }
        });

        ArrayList<Integer> selected = new ArrayList<>();
        int lastTime = 0;
        for(Job x: jobs){
            if(x.timeTaken + lastTime <= x.deadLine){
                lastTime += x.timeTaken;
                selected.add(x.index);
            }
        }
        Collections.sort(selected);
        int noa = selected.size();
        System.out.println("Max number of tasks = "+noa);
        System.out.print("Selected task numbers : ");
        for(int x=0;x<noa;x++)
            System.out.print(x == noa-1 ? selected.get(x)+"\n" : selected.get(x)+",");
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week10/input2.txt"));
            int n = sc.nextInt();
            int timeTaken[] = new int[n];
            int deadLine[] = new int[n];
            for(int i=0;i<n;i++) timeTaken[i] = sc.nextInt();
            for(int i=0;i<n;i++) deadLine[i] = sc.nextInt();
            jobSequencing(n, timeTaken, deadLine);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
