package Multiple_UI;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Multiple_UI.Controller.ToDoController;
import Multiple_UI.Events.OnAddToDoEvent;
import Multiple_UI.Panels.AddToDoPanel;
import Multiple_UI.Panels.DisplayToDoPanel;

import java.awt.*;

public class ToDoFrame extends JFrame {
    public ToDoFrame(ToDoController controller) {
        super();

        setTitle("To Do App");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        AddToDoPanel addToDoPanel = new AddToDoPanel();
        DisplayToDoPanel displayToDoPanel = new DisplayToDoPanel(controller);

        panel.add(addToDoPanel);
        panel.add(displayToDoPanel);

        add(panel);

        addToDoPanel.onAdd((newToDo) -> {
            controller.addTodo(newToDo);
            displayToDoPanel.refresh();
        });
    }
}
