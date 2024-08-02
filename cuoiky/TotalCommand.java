

public class TotalCommand extends Command {
    public TotalCommand(SachService sachService) {
        super(sachService);
    }

    @Override
    public void execute() {
        sachService.total();
    }
}
