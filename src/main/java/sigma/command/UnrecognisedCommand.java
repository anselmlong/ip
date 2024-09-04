package sigma.command;

import sigma.utils.Storage;
import sigma.utils.TaskList;
import sigma.utils.Ui;
import sigma.exception.SigmaException;

/**
 * Represents the command to execute the user's input.
 */
public class UnrecognisedCommand extends Command {

        public UnrecognisedCommand(String[] split) {
            super(split);
        }

        /**
         * Throws an unrecognised error.
         * @param tasks
         * @param ui
         * @param storage
         * @throws SigmaException
         */
        @Override
        public String execute(TaskList tasks, Ui ui, Storage storage) throws SigmaException {
            ui.throwUnrecognisedError();
            return "???";
        }

}
