package collection;

import java.util.Collections;
import java.util.Comparator;

public class JobAscByName implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }
}
