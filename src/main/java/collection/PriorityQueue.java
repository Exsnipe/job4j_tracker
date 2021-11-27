package collection;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task currentTask : tasks) {
            if (task.getPriority() < currentTask.getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }

}
