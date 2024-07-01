package Multiple_UI.Controller;

import java.util.ArrayList;

import Multiple_UI.Model.ToDo;

public class ToDoController {
    private ArrayList<ToDo> todos;

    public ToDoController() {
        todos = new ArrayList<>();

        init();
    }

    private void init() {
        ToDo doneToDo = new ToDo("JPRG CA1");
        doneToDo.next().next();
        todos.add(doneToDo);

        ToDo anotherDoneToDo = new ToDo("JPRG MST");
        anotherDoneToDo.next().next();
        todos.add(anotherDoneToDo);

        ToDo cancelledToDo = new ToDo("Combined Buffet");
        cancelledToDo.cancel();
        todos.add(cancelledToDo);

        ToDo onGoingToDo = new ToDo("DBS CA2");
        onGoingToDo.next();
        todos.add(onGoingToDo);

        ToDo pendingToDo = new ToDo("JPRG CA2");
        todos.add(pendingToDo);
    }

    public void addTodo(String todo) {
        todos.add(new ToDo(todo));
    }

    public ToDo[] getAllTodos() {
        return todos.toArray(new ToDo[0]);
    }

}
