import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String [] model = new String[10];

    public static Scanner inputUser = new Scanner(System.in);

    public static void main(String[] args) {
     testViewShowTodoList();
    }






    /*MENAMPILKAN TODOLIST*/
    public static void showToDoList(){
       for (var i = 0; i < model.length; i++){
        String todo= model[i];

        int nomor = i+1;



        if (todo != null){
            System.out.println(nomor+". "+todo);
        }
       }
    }

    /*test showTodoList*/

    public static void testShowTodoList(){
        model[0] ="Belajar java";
        model[1] = "Makan";
        model[2] = "Minum";
        showToDoList();
    }

    /*Menambahkan todo ke list*/
    public static void addToDoList(String todo){

        //cek model apakah penuh
        var isFull = true;
        for (var i =0;i<model.length;i++){
            if (model[i] == null){
                isFull = false;
                break;
            }
        }

        //jika penuh resize ukurannya
       if (isFull){
           var temp =model;
           model = new String[model.length*2];

           for (int i = 0;i< temp.length ;i++){
               model[i] = temp[i];
           }
       }


        //tambahkan keposisi data array yang null
        for (var i = 0; i< model.length; i++){
            if (model[i] ==null){
                model[i] = todo;
                break;
            }
        }
    }

    /*unit test untuk addtodolist*/
    public  static void testAddTodoList(){
        for (var i =0;i< 25 ; i++){
            addToDoList("Contoh todo ke-"+(i+1));
        }
        showToDoList();
    }


    /*Mengahpus toDoList*/
    public static boolean removeToDoList(Integer number){
        if ((number-1) >= model.length){
            return false;
        } else if (model[number-1] == null) {
            return false;
        } else{
           for (var i = (number-1) ; i<model.length; i++){
               if (i ==(model.length -1)){
                   model[i] = null;
               }else{
                   model[i] = model[i+1];
               }
           }
           return true;
        }

    }

    public static void testRemoveTodoList(){
        addToDoList("Haloo");
        addToDoList("Makan ");
        addToDoList("Minummm");

     var result =   removeToDoList(20);
        System.out.println(result);

        result = removeToDoList(4);
        System.out.println(result);

        result = removeToDoList(2);
        System.out.println(result);

        showToDoList();
    }


    public static String input(String info){

        System.out.print(info +" : ");
            String data = inputUser.nextLine();
            return data;
    }

    public  static void testInput(){
        var name = input("Nama");
        System.out.println("HI "+ name);

    }


    public static void viewShowTodoList(){
        while (true){
            showToDoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var input = input("Pilih");
            if (input.equals("1")){
                viewAddTodoList();
            }
            else if (input.equals("2")){
                viewRemoveTodolist();
            } else if (input.equals("3")) {
                break;

            } else{
                System.out.println("Pilihan tidak dimengerti");
            }
        }

    }

    public static void testViewShowTodoList(){
        addToDoList("asuhd");
        addToDoList("asuhd");
        addToDoList("asuhd");
        addToDoList("asuhd");
        addToDoList("asuhd");
        addToDoList("asuhd");

        viewShowTodoList();
    }

    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x jika batal)");


        if (todo.equals("x")){
            //batal
        } else{
            addToDoList(todo);
        }

    }

    public static void viewRemoveTodolist(){
        System.out.println("Menghapus TODOLIST");
        var todo = input("Nomor yang dihapus (x jika batal)");


        if (todo.equals("x")){
            //batal
        } else{
           boolean success = removeToDoList(Integer.valueOf(todo));
           if (!success){
               System.err.println("Gagal menghapus todolist ini: "+todo);
           }
        }

    }
}