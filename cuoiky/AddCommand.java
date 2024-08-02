public class AddCommand extends Command {
    private Sach sach;

    public AddCommand(SachService sachService, Sach sach) {
        super(sachService);
        this.sach = sach;
    }

    @Override
    public void execute() {
        sachService.add(sach);
    }
}
