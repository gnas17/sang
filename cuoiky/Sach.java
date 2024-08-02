import java.io.Serializable;

public class Sach implements Serializable {
    private int ms;
    private Date nn;
    private double dg;
    private int sl;
    private String nxb;

    public Sach(int ms, Date nn, double dg, int sl, String nxb){
        this.ms = ms;
        this.nn = nn;
        this.dg = dg;
        this.sl = sl;
        this.nxb = nxb;
    }
    public int getMasach() {
        return ms;
    }

    public void setMasach(int ms) {
        this.ms = ms;
    }

    public Date getNgayNhap() {
        return nn;
    }

    public void setNgayNhap(Date nn) {
        this.nn = nn;
    }

    public double getDonGia() {
        return dg;
    }

    public void setDonGia(double dg) {
        this.dg = dg;
    }

    public int getSoLuong() {
        return sl;
    }

    public void setSoLuong(int sl) {
        this.sl = sl;
    }

    public String getNhaXuatBan() {
        return nxb;
    }

    public void setNhaXuatBan(String nxb) {
        this.nxb = nxb;
    }

    public double total(){}

}
