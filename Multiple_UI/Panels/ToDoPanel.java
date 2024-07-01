package Multiple_UI.Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Multiple_UI.Model.Status;
import Multiple_UI.Model.ToDo;

public class ToDoPanel extends JPanel {

    private JButton nextStateButton;
    private JButton cancelButton;

    public ToDoPanel(ToDo todo) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);

        JLabel text = new JLabel(todo.getText());
        nextStateButton = new JButton("Next");
        cancelButton = new JButton("Cancel");

        add(text);
        if (!Status.isTerminal(todo.getStatus())) {
            add(nextStateButton);
            add(cancelButton);
        }

        if (todo.getStatus() == Status.Done) {
            text.setForeground(new Color(0, 102, 0));
        } else if (todo.getStatus() == Status.Cancelled) {
            text.setForeground(Color.RED);
        }
    }

    public void addOnNext(ActionListener event) {
        nextStateButton.addActionListener(event);
    }

    public void addOnCancel(ActionListener event) {
        cancelButton.addActionListener(event);
    }
}
