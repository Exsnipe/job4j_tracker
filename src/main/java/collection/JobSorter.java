package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class JobSorter {
    public static void main(String[] args) {
       List<Job> listJob = new ArrayList<>(Arrays.asList(
               new Job("Fix bugs", 4),
               new Job("Reboot server", 2),
               new Job("Impl task", 1)
       ));
        System.out.println(listJob);
        Collections.sort(listJob);
        System.out.println(listJob);
        Collections.sort(listJob, new SortByNameJob());
        System.out.println(listJob);
    }
}
