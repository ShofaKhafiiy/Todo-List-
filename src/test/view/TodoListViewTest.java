package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceIMPL;
import view.TodoListView;

public class TodoListViewTest {
    public static void main(String[] args) {
testShowTodolist();
    }

    public static void testShowTodolist(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceIMPL(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);


        todoListService.addTodoList("sjds");
        todoListService.addTodoList("sjds");
        todoListService.addTodoList("sjds");

        todoListView.showTodoList();
    }
}
