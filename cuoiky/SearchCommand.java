

public class SearchCommand extends Command{
    private String searchms;

    public SearchCommand(SachService sachService, String searchms) {
        super(sachService);
        this.searchms = searchms;
    }

    @Override
    public void execute() {
        sachService.search(searchms);
    }
}
