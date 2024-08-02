public class sgkDTO extends SachDTO{
    private String tt;  // Special attribute for sgk

    public sgkDTO(int ms, Date nn, double dg, int sl, String nxb, String tt) {
        super(ms, nn, dg, sl, nxb);
        this.tt = tt;
    }

    // Getters and Setters
    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }
}
