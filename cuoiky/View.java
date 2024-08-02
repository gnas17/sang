
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame implements Subscriber {
    private SachService sachService;
    private Controller controller;

    // Components
    private JLabel msLabel, nnLabel, dgLabel, slLabel, nxbLabel, ttLabel, searchLabel;
    private JComboBox<String> nnComboBox;
    private JTextField msField, dgField, slField, nxbField, ttField, searchField;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton, removeButton, editButton, getbynxbButton, totalButton, tbcButton, searchButton, sgkButton, stkButton;

    public View(SachService sachService) {
        sachService = sachService;
        this.controller = new Controller(sachService);
        buildPanel();
        buildMenu();
    }
 
    private void buildPanel() {
        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create north panel
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new LayoutManager());

        // Create labels and fields
        msLabel = new JLabel("Mã sách:");
        msField = new JTextField(10);
        nnLabel = new JLabel("Ngày nhập:");
        nnComboBox = new JComboBox<>();
        dgLabel = new JLabel("Đơn giá:");
        dgField = new JTextField(10);
        slLabel = new JLabel("Số lượng:");
        slField = new JTextField(10);
        nxbLabel = new JLabel("Nhà xuất bản:");
        nxbField = new JTextField(10);
        ttLabel = new JLabel("Tác giả:");
        ttField = new JTextField(10);
        searchLabel = new JLabel("Tìm kiếm:");
        searchField = new JTextField(10);

        // Add components to north panel
        northPanel.add(msLabel);
        northPanel.add(msField);
        northPanel.add(nnLabel);
        northPanel.add(nnComboBox);
        northPanel.add(dgLabel);
        northPanel.add(dgField);
        northPanel.add(slLabel);
        northPanel.add(slField);
        northPanel.add(nxbLabel);
        northPanel.add(nxbField);
        northPanel.add(ttLabel);
        northPanel.add(ttField);
        northPanel.add(searchLabel);
        northPanel.add(searchField);

        // Create center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        // Create table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã sách");
        tableModel.addColumn("Ngày Nhập");
        tableModel.addColumn("Đơn giá");
        tableModel.addColumn("Số lượng");
        tableModel.addColumn("Nhà xuất bản");
        tableModel.addColumn("Tác giả");
        table = new JTable(tableModel);

        // Add table to center panel
        centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Create south panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        // Create buttons
        addButton = new JButton("Thêm");
        removeButton = new JButton("Xóa");
        editButton = new JButton("Sửa");
        getbynxbButton = new JButton("Lấy theo nhà xuất bản");
        totalButton = new JButton("Tổng");
        tbcButton = new JButton("Trung bình");
        searchButton = new JButton("Tìm kiếm");
        sgkButton = new JButton("Sách giáo khoa");
        stkButton = new JButton("Sách tham khảo");

        // Add buttons to south panel
        southPanel.add(addButton);
        southPanel.add(removeButton);
        southPanel.add(editButton);
        southPanel.add(getbynxbButton);
        southPanel.add(totalButton);
        southPanel.add(tbcButton);
        southPanel.add(searchButton);
        southPanel.add(sgkButton);
        southPanel.add(stkButton);

        // Add panels to main panel
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);

        // Add panel to frame
        JFrame frame = new JFrame("Quản lý sách");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void buildMenu() {
        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");

        // Create menu items
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem addItem = new JMenuItem("Add");
        JMenuItem removeItem = new JMenuItem("Remove");
        JMenuItem editItem = new JMenuItem("Edit");
        JMenuItem getbynxbItem = new JMenuItem("Lấy theo nhà xuất bản");
        JMenuItem totalItem = new JMenuItem("Tổng");
        JMenuItem tbcItem = new JMenuItem("Trung bình");
        JMenuItem searchItem = new JMenuItem("Tìm kiếm");
        JMenuItem sgkItem = new JMenuItem("Sách giáo khoa");
        JMenuItem stkItem = new JMenuItem("Sách tham khảo");

        // Add menu items to menus
        fileMenu.add(exitItem);
        editMenu.add(addItem);
        editMenu.add(removeItem);
        editMenu.add(editItem);
        viewMenu.add(getbynxbItem);
        viewMenu.add(totalItem);
        viewMenu.add(tbcItem);
        viewMenu.add(searchItem);
        viewMenu.add(sgkItem);
        viewMenu.add(stkItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        // Set menu bar for frame
        JFrame frame = new JFrame("Quản lý sách");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    // Phương thức update table
    private void updateTable() {
        List<Sach> sachList = controller.getSachList();
        updateTable(sachList);
    }

    // Phương thức update table with list
    
    private void updateTable(List<Sach> sachList) {
        tableModel.setRowCount(0);
        for (Sach sach : sachList) {
            tableModel.addRow(new Object[] {
                sach.getMasach(),
                sach.getNgayNhap(),
                sach.getDonGia(),
                sach.getSoLuong(),
                sach.setTrangThai(),
                sach.getNhaXuatBan()
            });
        }
    }

    // Phương thức load sách
    public void loadSach() {
        List<Sach> sachList = controller.getSachList();
        updateTable(sachList);
    }

    // Phương thức get data from text field
    public Sach getDatafromTextField() {
        Sach sach = new Sach();
        sach.setMaSach(msField.getText());
        sach.setNgayNhap(nnComboBox.getSelectedItem().toString());
        sach.setDonGia(Double.parseDouble(dgField.getText()));
        sach.setSoLuong(Integer.parseInt(slField.getText()));
        sach.setTrangThai(ttField.getText());
        sach.setNhaXuatBan(nxbField.getText());
        return sach;
    }

    // Phương thức reset
    public void reset() {
        msField.setText("");
        nnComboBox.setSelectedIndex(0);
        dgField.setText("");
        slField.setText("");
        ttField.setText("");
        nxbField.setText("");
    }

    // Phương thức clear field
    public void clearField() {
        msField.setText("");
        dgField.setText("");
        slField.setText("");
        ttField.setText("");
        nxbField.setText("");
    }

    // Phương thức show stk field
    public void showstkField() {
        stkButton.setVisible(true);
    }

    // Phương thức show sgk field
    public void showsgkField() {
        sgkButton.setVisible(true);
    }
   
        public static <SachGateway> void main(String[] args) {
            // Initialize the components
            SachGateway sachGateway = new SachGateway(); // Replace with actual constructor if necessary
            SachDAO sachDAO = new SachDAOimp(sachGateway);
            SachService sachService = new SachService(sachDAO);
            View view = new View();
            Controller controller = new Controller(view, sachService);
    
            // Set up the commands
            Command addCommand = new AddCommand(sachService);
            Command editCommand = new EditCommand(sachService);
            Command removeCommand = new RemoveCommand(sachService);
            Command searchCommand = new SearchCommand(sachService);
            Command getbynxbCommand = new GetByNxbCommand(sachService);
            Command totalCommand = new TotalCommand(sachService);
            Command tbcCommand = new TbcCommand(sachService);
    
            // Bind commands to controller
            controller.setAddCommand(addCommand);
            controller.setEditCommand(editCommand);
            controller.setRemoveCommand(removeCommand);
            controller.setSearchCommand(searchCommand);
            controller.setGetbynxbCommand(getbynxbCommand);
            controller.setTotalCommand(totalCommand);
            controller.setTbcCommand(tbcCommand);
    
        }

        @Override
        public void update(List<SachDTO> sachDTO) {
            tableModel.setRowCount(0);
        // Populate with new data
        for (SachDTO sach : sachDTO) {
            tableModel.addRow(new Object[]{
                sach.getMaSach(), 
                sach.getNgayNhap(), 
                sach.getDonGia(), 
                sach.getNhaXuatBan(), 
                sach.getSoLuong(),
                sach.getTrangThai()
            });
        }
        }
}

