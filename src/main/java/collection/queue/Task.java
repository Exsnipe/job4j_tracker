package collection.queue;

public record Task(Position position,
                   String description,
                   int urgency) {
}
