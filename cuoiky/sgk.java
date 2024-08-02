import java.util.Date;

public class sgk extends Sach{
    private String tt;
    public sgk(int ms, Date nn, double dg, int sl, String nxb, String tt) {
        super(ms, nn, dg, sl, nxb);
        this.tt = tt;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    @Override
    public double getTotal() {
       if(tt = "mới"){ return getDonGia() * getSoLuong(); }
       else{ return getDonGia() * getSoLuong()  / 2; }
    }

}
