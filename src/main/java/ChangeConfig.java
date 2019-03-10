import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeConfig {
    private JPanel panel1;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;

    public ChangeConfig() {
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeConfig();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addConfig();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateConfig();
            }
        });
    }

    private void updateConfig() {

    }

    private void addConfig() {

    }

    private void changeConfig() {

    }
}
