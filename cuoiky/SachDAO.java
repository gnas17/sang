import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private List<SachDTO> sachList;

    public SachDAO() {
        sachList = new ArrayList<>();
    }

    // Adds a new SachDTO object to the list
    public void add(SachDTO sach) {
        sachList.add(sach);
    }

    // Edits an existing SachDTO object in the list
    public void edit(SachDTO sach) {
        for (int i = 0; i < sachList.size(); i++) {
            if (sachList.get(i).getMaSach() == sach.getMaSach()) {
                sachList.set(i, sach);
                return;
            }
        }
    }

    // Removes a SachDTO object from the list by its ms
    public void remove(int ms) {
        sachList.removeIf(sach -> sach.getMaSach() == ms);
    }

    // Searches for SachDTO objects by ms (searchms) and returns a list of matching objects
    public List<SachDTO> search(String searchms) {
        List<SachDTO> result = new ArrayList<>();
        for (SachDTO sach : sachList) {
            if (String.valueOf(sach.getMaSach()).contains(searchms)) {
                result.add(sach);
            }
        }
        return result;
    }

    // Retrieves a list of SachDTO objects by their nxb
    public List<SachDTO> getByNxb(String nxb) {
        List<SachDTO> result = new ArrayList<>();
        for (SachDTO sach : sachList) {
            if (sach.getNhaXuatBan().equalsIgnoreCase(nxb)) {
                result.add(sach);
            }
        }
        return result;
    }

    // Calculates the total price of all books in the list
    public double total() {
        return sachList.stream()
                .flatMapToDouble(SachDTO::getTotal)
                .sum();
    }

    // Calculates the average price (đơn giá) of all books in the list
    public double tbc() {
        return sachList.stream()
                .mapMultiToDouble(SachDTO::getDg)
                .average()
                .orElse(0.0);
    }
}
