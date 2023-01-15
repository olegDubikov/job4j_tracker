package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PriorityQueueTest {

    @Test
    public void whenHigherPrioritySecond() {
        var priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("low", 5));
        priorityQueue.put(new Task("urgent", 1));
        priorityQueue.put(new Task("middle", 3));
        Task result = priorityQueue.take();
        assertThat(result.getDesc()).isEqualTo("urgent");
    }

    @Test
    public void whenHigherPriorityEquals() {
        var priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("low", 5));
        priorityQueue.put(new Task("urgent", 5));
        priorityQueue.put(new Task("middle", 5));
        Task result = priorityQueue.take();
        assertThat(result.getDesc()).isEqualTo("low");
    }
}