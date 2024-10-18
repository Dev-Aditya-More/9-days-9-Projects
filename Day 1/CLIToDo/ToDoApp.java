import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {

    private final ArrayList<Task> tasks = new ArrayList<>();
    private int taskIdCounter = 1;

    public static void main(String[] args) {
        ToDoApp app = new ToDoApp();
        app.start();
    }

    private void start(){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            System.out.print("Please choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTask(scanner);

                case 2 -> viewTask();

                case 3 -> markTaskAsCompleted(scanner);

                case 4 -> deleteTask(scanner);

                case 5 -> {
                    System.out.println("Thanks for using!");
                    System.exit(0);
                }
            
                
            }
        }
    }

    private void showMenu() {
        System.out.println("\n======= To-Do Menu =======");
        System.out.println("1. Add a new task");
        System.out.println("2. View all tasks");
        System.out.println("3. Mark a task as completed");
        System.out.println("4. Delete a task");
        System.out.println("5. Exit the app");
        System.out.println("==========================");
    }

    private void addTask(Scanner scanner) {
        
        System.out.println("Enter Task: ");
        String taskName = scanner.nextLine();

        tasks.add(new Task(taskIdCounter++, taskName));
        System.out.println("Done.");
    }

    private void viewTask(){

        if(tasks.isEmpty()){

            System.out.println("No tasks to view!");
            return;
        }

        System.out.println("Your Tasks: ");

        for(Task task: tasks){
            System.out.println(task);
        }
    }

    private void markTaskAsCompleted(Scanner scanner){

        if(tasks.isEmpty()){

            System.out.println("No tasks was able to complete");
            return;
        }

        System.out.println("Enter the taskId to mark it as completed..");
        int taskId = scanner.nextInt();

        for(Task task : tasks){

            if(task.getTaskId() == taskId){
                task.markAsCompleted();
                System.out.println("Great that you've completed the task.");
                return;
            }
        }
        System.out.println("Task Not Found");
    }

    private void deleteTask(Scanner scanner){

        if(tasks.isEmpty()){

            System.out.println("No tasks was able to Delete");
            return;
        }

        System.out.println("Enter task Id to delete task: ");
        int taskId = scanner.nextInt();
        tasks.removeIf(task -> task.getTaskId() == taskId);
        System.out.println("Safely deleted");
        
    }    
}
