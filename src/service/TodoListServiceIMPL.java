package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceIMPL implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceIMPL(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {

        TodoList[] model = todoListRepository.getAll();

        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++){
            var todo= model[i];

            int nomor = i+1;



            if (todo != null){
                System.out.println(nomor+". "+todo.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {

        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("Sukses menambha TODO: "+todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success){
            System.out.println("Sukses mengahapus todo: "+number);
        }else{
            System.out.println("Gagal menghapus Todo: "+number);
        }
    }
}
