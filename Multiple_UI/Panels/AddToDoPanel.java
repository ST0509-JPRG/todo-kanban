package Multiple_UI.Panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Multiple_UI.Events.OnAddToDoEvent;

public class AddToDoPanel extends TitledBorderPanel {

    private JTextField input;
    private JButton submit;

    public AddToDoPanel() {
        super("Add");

        JLabel label = new JLabel("New To Do");
        this.input = new JTextField(20);
        this.submit = new JButton("Submit");

        add(label);
        add(input);
        add(submit);
    }

    public void onAdd(OnAddToDoEvent event) {
        submit.addActionListener((e) -> event.run(this.input.getText()));
    }
}
