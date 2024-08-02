

public class RemoveCommand extends Command  {
    private int ms;

    public RemoveCommand(SachService sachService, int ms) {
        super(sachService);
        this.ms = ms;
    }

    @Override
    public void execute() {
        sachService.remove(ms);
    }
}
