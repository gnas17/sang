


import javax.swing.event.ListSelectionListener;
import javax.swing.text.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;

public class Controller implements ActionListener {
    private View view;
    private static Controller instance;

    private Controller(View view) {
        this.view = view;
    }

    public static Controller getInstance(View view) {
        if (instance == null) {
            instance = new Controller(view);
        }
        return instance;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getAddButton()) {
            Command addCommand = new AddCommand(sachService, view.getSach());
            execute(addCommand);
        } else if (e.getSource() == view.getEdiButton()) {
            Command editCommand = new EditCommand(sachService, view.getSach());
            execute(editCommand);
        } else if (e.getSource() == view.getRemoveButton()) {
            Command removeCommand = new RemoveCommand(sachService, view.getSelectedRow());
            execute(removeCommand);
        } else if (e.getSource() == view.getSearchButton()) {
            Command searchCommand = new SearchCommand(sachService, view.getSearchField().getText());
            execute(searchCommand);
        } else if (e.getSource() == view.getTotalButton()) {
            Command totalCommand = new TotalCommand(sachService);
            execute(totalCommand);
        } else if (e.getSource() == view.getTbcButton()) {
            Command tbcCommand = new TbcCommand(sachService);
            execute(tbcCommand);
        } else if (e.getSource() == view.getGetbynxbButton()) {
            Command getbynxbCommand = new GetbynxbCommand(sachService, view.getNxbField().getText());
            execute(getbynxbCommand);
        }
        view.clearField();
        view.loadSach();
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == view.getNnComboBox()) {
            view.showsgkField();
        } else if (e.getSource() == view.getSlComboBox()) {
            view.showstkField();
        }
        view.loadSach();
    }
    
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            view.showstkField();
            view.showsgkField();
        }
        view.getDatafromTextField();
    }

    public void execute(Command command) {
        command.execute();
    }
}
