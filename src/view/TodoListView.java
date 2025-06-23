package view;

import service.TodoListService;
import util.InputUtil;

import static util.InputUtil.input;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){

        while (true){
            todoListService.showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var input = input("Pilih");
            if (input.equals("1")){
                addTodoList();
            }
            else if (input.equals("2")){
                removeTodoList();
            } else if (input.equals("3")) {
                break;

            } else{
                System.out.println("Pilihan tidak dimengerti");
            }
        }

    }


    public void addTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x jika batal)");


        if (todo.equals("x")){
            //batal
        } else{
            todoListService.addTodoList(todo);
        }
    }

    public  void removeTodoList(){
        System.out.println("Menghapus TODOLIST");
        var todo = input("Nomor yang dihapus (x jika batal)");


        if (todo.equals("x")){
            //batal
        } else{
           todoListService.removeTodoList(Integer.valueOf(todo));
        }

    }
}


