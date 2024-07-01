package Multiple_UI.Panels;

import javax.swing.JTextArea;

public class DisplayArrayPanel extends TitledBorderPanel {
    private JTextArea textArea;

    public DisplayArrayPanel(String title) {
        super(title);

        textArea = new JTextArea(20, 20);
        textArea.setEditable(false);

        add(textArea);
    }

    public void refresh(String[] texts) {
        textArea.setText(String.join("\n", texts));
    }
}
