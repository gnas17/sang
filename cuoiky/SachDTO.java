import java.sql.Date;

public class SachDTO {
    private int ms;         // Book ID
    private Date nn;        // Date
    private double dg;      // Price
    private int sl;         // Quantity
    private String nxb;     // Publisher

    public SachDTO(int ms, Date nn, double dg, int sl, String nxb) {
        this.ms = ms;
        this.nn = nn;
        this.dg = dg;
        this.sl = sl;
        this.nxb = nxb;
    }

    // Getters and Setters
    public int getMaSach() {
        return ms;
    }

    public void setMaSach(int ms) {
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
}
