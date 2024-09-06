package sigma.command;

import java.time.LocalDateTime;

import sigma.exception.SigmaException;
import sigma.task.EventTask;
import sigma.utils.Parser;
import sigma.utils.Storage;
import sigma.utils.TaskList;
import sigma.utils.Ui;

/**
 * Represents the command to add an event task.
 */
public class EventCommand extends Command {

    public EventCommand(String[] split) {
        super(split);
    }

    /**
     * Adds an event task to the task list.
     *
     * @param tasks
     * @param ui
     * @param storage
     * @return String response.
     * @throws SigmaException
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws SigmaException {
        Parser parser = new Parser();
        final String eventMessage = "Write \"event <task> /from <start time> /to <end time>\"!";
        if (split.length < 2) {
            throw new SigmaException("What the sigma? You're missing the task! " + eventMessage);
        }
        String[] eventSplit = split[1].split(" /from ");
        if (eventSplit.length < 2) {
            throw new SigmaException("What the sigma? You're missing the timing! " + eventMessage);
        }
        String[] timing = eventSplit[1].split(" /to ");
        if (timing.length < 2) {
            throw new SigmaException("What the sigma? You're missing the end timing! " + eventMessage);
        }
        LocalDateTime from = Parser.parseLocalDateTime(timing[0]);
        LocalDateTime to = Parser.parseLocalDateTime(timing[1]);
        EventTask eventTask = new EventTask(eventSplit[0], from, to);
        tasks.add(eventTask);
        return "You're a busy bee! Added: \n" + eventTask
                + "\nNow you have " + tasks.size() + " tasks in the list!";
    }

}
