public class Sachimp extends publisher implements SachService {
    private SachDAO sachDao;

    public Sachimp(SachDAO sachDao) {
        this.sachDao = sachDao;
        this.notifysubcribers();
    }

    @Override
    public void add(Sach sach) {
        sachDao.add(sach);
        this.notifysubcribers();
    }

    @Override
    public void edit(Sach sach) {
        sachDao.edit(sach);
        this.notifysubcribers();
    }

    @Override
    public void remove(int ms) {
        sachDao.remove(ms);
        this.notifysubcribers();
    }

    @Override
    public List<SachDTO> search(String searchms) {
        return sachDao.search(searchms);
        this.notifysubcribers();
    }

    @Override
    public List<SachDTO> getbynxb(String nxb) {
        return sachDao.getbynxb(nxb);
        this.notifysubcribers();
    }

    @Override
    public double total() {
        return sachDao.total();
        this.notifysubcribers();
    }

    @Override
    public double tbc() {
        return sachDao.tbc();
        this.notifysubcribers();
    }
}
