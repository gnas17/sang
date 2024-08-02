

public class GetByNxbCommand extends Command {
    private String nxb;

    public GetByNxbCommand(SachService sachService) {
        super(sachService);
        this.nxb = nxb;
    }

    @Override
    public void execute() {
        sachService.getbynxb(nxb);
    }
}
