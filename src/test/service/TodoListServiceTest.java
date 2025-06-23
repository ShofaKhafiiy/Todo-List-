package test.service;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceIMPL;

public class TodoListServiceTest {

    public static void main(String[] args) {
        testRemoveTodoList();
    }


    public static void testShowTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceIMPL(todoListRepository);

        todoListService.showTodoList();
    }


    public  static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

        TodoListService todoListService = new TodoListServiceIMPL(todoListRepository);

        todoListService.addTodoList("Belajar java dasar");
        todoListService.addTodoList("Belajar java oop");
        todoListService.addTodoList("Belajar java classes");

        todoListService.showTodoList();
    }


    public static  void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

        TodoListService todoListService = new TodoListServiceIMPL(todoListRepository);


        todoListService.addTodoList("Belajar java dasar");
        todoListService.addTodoList("Belajar java oop");
        todoListService.addTodoList("Belajar java classes");

        todoListService.showTodoList();

        todoListService.removeTodoList(2);
        todoListService.showTodoList();
    }

}
