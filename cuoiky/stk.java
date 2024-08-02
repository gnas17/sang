public class stk extends Sach {
    private double thue;
    public stk(int ms, Date nn, double dg, int sl, String nxb, double thue){
        super(ms, nn, dg, sl, nxb);
        this.thue = thue;
    }

    public double getthue(){
        return thue;
    }

    public void setthue(){
        this.thue = getDonGia() / 10;
    }

    @Override
    public double getTotal(){
        return getSoLuong() * getDonGia() + thue;
    }
}
