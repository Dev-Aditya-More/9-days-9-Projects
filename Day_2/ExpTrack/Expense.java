package Day_2.ExpTrack;

import java.util.ArrayList;
import java.util.Scanner;

public class Expense{
    
    private final String date;
    private final String category;
    private final double amount;
    private final String description;

    public Expense(String date, String category, double amount, String description){

        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public double getAmount(){
        return amount;
    }

    @Override
    public String toString(){

        return "Date: " + date + "Category: " + category + "Amount: $" + amount + "Description: " + description;
    }


    public static final ArrayList<Expense> expenses = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
        
    public static void main(String[] args) {

            
        while(true){

            System.out.println("\n<--------------Expenses Tracker------------>");
            System.out.println("1. Add an expense");
            System.out.println("2. View all expenses");
            System.out.println("3. Calculate total expense");
            System.out.println("4. Exit");

            System.out.println("\nEnter your choices (1-4)");
            int choice = sc.nextInt();
            sc.nextLine();

                switch (choice) {
                    case 1:
                        AddExpense();
                        break;
                        
                    case 2:
                        viewExpenses();
                        break;

                    case 3:
                        calculateTotal();
                        break;

                    case 4:
                        System.out.println("Exiting..");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! choose valid option!");
                
                }
        }
    }



    private static void AddExpense(){

        System.out.println("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.println("Enter category (e.g., Food, Transport): ");
        String category = sc.nextLine();

        System.out.println("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();  // consume the newline

        System.out.println("Enter description: ");
        String description = sc.nextLine();

        Expense newExpense = new Expense(date, category, amount, description);
        expenses.add(newExpense);

        System.out.println("Expense added successfully!");
    }

    public static void viewExpenses(){

        if(expenses.isEmpty()){
            System.out.println("No expense recorded..");
        }
        else{
            System.out.println("All expenses: ");
            for (Expense expense : expenses){
                System.out.println(expense);

            }
        }
    }

    protected static void calculateTotal(){

        double sum = 0;

        for(Expense expense : expenses){
            sum += expense.getAmount();
        }
        System.out.println("Total amount: " + sum);
    }

};
