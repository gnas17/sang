
public class TbcCommand extends Command {
    public TbcCommand(SachService sachService) {
        super(sachService);
    }

    @Override
    public void execute() {
        sachService.tbc();
    }
}
