import java.time.LocalDateTime;

public class EventCommand extends Commands {

    public EventCommand(String[] split) {
        super(split);
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws SigmaException {
        Parser parser = new Parser();
        String syntax = "Write \"event <task> /from <start time> /to <end time>\"!";
        if (split.length < 2) {
            throw new SigmaException("What the sigma? You're missing the task! " + syntax);
        }
        String[] eventSplit = split[1].split(" /from ");
        if (eventSplit.length < 2) {
            throw new SigmaException("What the sigma? You're missing the timing!" + syntax);
        }
        String[] timing = eventSplit[1].split(" /to ");
        if (timing.length < 2) {
            throw new SigmaException("What the sigma? You're missing the end timing!" + syntax);
        }
        LocalDateTime from = parser.dateTimeParse(timing[0]);
        LocalDateTime to = parser.dateTimeParse(timing[1]);
        EventTask eventTask = new EventTask(eventSplit[0], from, to);
        tasks.add(eventTask);
        ui.print("You're a busy bee! Added: \n" + eventTask.toString()
                + "\nNow you have " + tasks.size() + " tasks in the list!");
    }
}
