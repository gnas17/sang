public class SachimpDAO implements SachDAO {
    private SachGateway sachGateway;

    public SachDAOimp(SachGateway sachGateway) {
        this.sachGateway = sachGateway;
    }

    @Override
    public void add(SachDTO sach) {
        sachGateway.add(sach);
    }

    @Override
    public void edit(SachDTO sach) {
        sachGateway.edit(sach);
    }

    @Override
    public void remove(int ms) {
        sachGateway.remove(ms);
    }

    @Override
    public List<SachDTO> search(String searchms) {
        return sachGateway.search(searchms);
    }

    @Override
    public List<SachDTO> getbynxb(String nxb) {
        return sachGateway.getbynxb(nxb);
    }

    @Override
    public double total() {
        return sachGateway.total();
    }

    @Override
    public double tbc() {
        return sachGateway.tbc();
    }
}
