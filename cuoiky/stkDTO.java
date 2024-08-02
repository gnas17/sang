public class stkDTO extends SachDTO{
    private double thue;  // Special attribute for stk

    public stkDTO() {
        // Default constructor
    }

    public stkDTO(int ms, Date nn, double dg, int sl, String nxb, double thue) {
        super(ms, nn, dg, sl, nxb);
        this.thue = thue;
    }

    // Getters and Setters
    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }
}
