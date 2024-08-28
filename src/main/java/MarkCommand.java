public class MarkCommand extends Commands {

    public MarkCommand(String[] split) {
        super(split);
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws SigmaException {
        if (split.length > 1) {
            int index = Integer.parseInt(split[1]);
            if (index > 0 && index <= tasks.size()) {
                Task item = tasks.get(index - 1);
                if (item.getStatusString() == "X") {
                    throw new SigmaException("What the sigma? Task already marked!");
                }
                item.setStatus(true);
                ui.print(String.format("SLAYYY! I'm going to mark this done for you:\n [%s] %s", item.getStatusString()
                        , item.getDesc()));
            } else {
                throw new SigmaException("Invalid task number!");
            }
        } else {
            throw new SigmaException("Bro's dreaming. Add a number bozo!");
        }
    }

}
