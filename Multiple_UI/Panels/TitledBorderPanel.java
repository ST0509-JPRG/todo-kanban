package Multiple_UI.Panels;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class TitledBorderPanel extends JPanel {
    private TitledBorder border;

    public TitledBorderPanel(String title) {
        super();

        this.border = BorderFactory.createTitledBorder(title);
        setBorder(border);
    }

    public void setTitle(String title) {
        this.border.setTitle(title);
    }
}
