import java.sql.Connection;
import java.util.List;

public class SachGateway  {
    private Connection connect;

    public SachGateway() {
        connect = new Connection();
    }

    public void add(SachDTO sach) {
        // Add sach to database using connect
    }

    public void edit(SachDTO sach) {
        // Update sach in database using connect
    }

    public void remove(int ms) {
        // Delete sach from database using connect
    }

    public List<SachDTO> search(String searchms) {
        // Search for sach in database using connect
        return null;
    }

    public List<SachDTO> getbynxb(String nxb) {
        // Search for sach by nxb in database using connect
        return null;
    }

    public double total() {
        // Calculate total price of all sach in database using connect
        return 0.0;
    }

    public double tbc() {
        // Calculate average price of all sach in database using connect
        return 0.0;
    }
}
