package collection;

public class Job implements Comparable<Job> {
    private String name;
    private int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Job{"
                + "name='" + name + '\''
                + ", priority=" + priority
                + '}';
    }

    @Override
    public int compareTo(Job anotherJob) {
        return Integer.compare(priority, anotherJob.priority);
    }
}




/*  SortByNameJob класс компаратор по имени джоб */