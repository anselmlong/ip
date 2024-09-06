package sigma.command;

import sigma.exception.SigmaException;
import sigma.utils.Storage;
import sigma.utils.TaskList;
import sigma.utils.Ui;

/**
 * Represents the command to find tasks with a keyword.
 */
public class FindCommand extends Command {

    public FindCommand(String[] split) {
        super(split);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws SigmaException {
        if (split.length < 2) {
            throw new SigmaException("What the sigma? You're missing the search parameters! "
                    + "Write \"find <query>\"!");
        }
        String keyword = split[1];
        TaskList matchingTasks = new TaskList(tasks.findTasks(keyword));
        if (matchingTasks.isEmpty()) {
            return String.format("What the sigma, I couldn't find any tasks with \"%s\" in them.", keyword);
        } else {
            return String.format("You're looking for \"%s\"? Here you go sis!\n%s", keyword,
                    Ui.buildList(matchingTasks).toString());
        }
    }

}
