package Multiple_UI.Panels;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Multiple_UI.Controller.ToDoController;
import Multiple_UI.Model.Status;
import Multiple_UI.Model.ToDo;

public class DisplayToDoPanel extends JPanel {
    DisplayToDoSubPanel[] subPanels;
    ToDoController controller;

    public DisplayToDoPanel(ToDoController controller) {
        super();
        this.controller = controller;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        subPanels = new DisplayToDoSubPanel[Status.values().length];
        int i = 0;
        for (Status status : Status.values()) {
            subPanels[i] = new DisplayToDoSubPanel(status, new ToDo[0], () -> refresh());
            JScrollPane scrollPane = new JScrollPane(subPanels[i]);
            add(scrollPane);
            i++;
        }

        refresh();
    }

    public void refresh() {
        ToDo[] todos = controller.getAllTodos();
        Status[] allValues = Status.values();
        HashMap<Status, ArrayList<ToDo>> todosByStatus = new HashMap<>();
        for (ToDo todo : todos) {
            Status status = todo.getStatus();
            if (!todosByStatus.containsKey(status)) {
                todosByStatus.put(status, new ArrayList<>());
            }
            todosByStatus.get(status).add(todo);
        }

        int i = 0;
        for (Status status : allValues) {
            ArrayList<ToDo> todosOfStatus = todosByStatus.getOrDefault(status, new ArrayList<>());
            subPanels[i++].refresh(todosOfStatus.toArray(new ToDo[0]));
        }
    }

}

class DisplayToDoSubPanel extends TitledBorderPanel {
    OnRefresh refreshParent;
    Status status;

    public DisplayToDoSubPanel(Status status, ToDo[] todos, OnRefresh refreshParent) {
        super(status.name());
        this.status = status;
        this.refreshParent = refreshParent;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 300));
        setAlignmentX(LEFT_ALIGNMENT);

        refresh(todos);
    }

    public void refresh(ToDo[] todos) {
        removeAll();
        revalidate();
        repaint();

        if (todos.length == 0) {
            JLabel emptyLabel = new JLabel("No todos");
            add(emptyLabel);
            return;
        }

        for (ToDo todo : todos) {
            ToDoPanel toDoPanel = new ToDoPanel(todo);
            toDoPanel.addOnNext((e) -> {
                todo.next();
                refreshParent.refresh();
            });
            toDoPanel.addOnCancel((e) -> {
                todo.cancel();
                refreshParent.refresh();
            });
            add(toDoPanel);
        }

        this.setTitle(String.format("%s (%d)", status.name(), todos.length));
    }
}

interface OnRefresh {
    public void refresh();
}