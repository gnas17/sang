

public class EditCommand extends Command {
    private Sach sach;

    public EditCommand(SachService sachService, Sach sach) {
        super(sachService);
        this.sach = sach;
    }

    @Override
    public void execute() {
        sachService.edit(sach);
    }
}
