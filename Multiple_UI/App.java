package Multiple_UI;

import Multiple_UI.Controller.ToDoController;

public class App {

    public static void main(String[] args) {
        ToDoController controller = new ToDoController();
        new ToDoFrame(controller).setVisible(true);
    }
}
