package collection;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PriorityQueueTest {

    @Test
    public void whenPut() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("middle", 4));
        priorityQueue.put(new Task("low", 6));
        priorityQueue.put(new Task("urgent", 2));
        Task result = priorityQueue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}