package sigma.task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task.
 */
public class DeadlineTask extends Task {
    private LocalDateTime date;

    public DeadlineTask(String desc, LocalDateTime date) {
        super(desc);
        this.date = date;
    }

    /**
     * Returns the date of the deadline task.
     * @return Date of the deadline task.
     */
    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy, HH:mm");
        return date.format(formatter);
    }

    /**
     * Returns the type of the task.
     * @return String representation of type of the task.
     */
    public String getTaskType() {
        return "D";
    }

    /**
     * Returns the string representation of the task.
     * @return String representation of the task.
     */
    @Override
    public String toString() {
        return String.format("[D][%s] %s (by: %s)", getStatusString(), getDesc(), getDate());
    }
}
