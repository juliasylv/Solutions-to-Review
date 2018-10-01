import java.util.Scanner;

/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please input your first name: ");
        String name = sc.next();
        
        System.out.print("Please input the amount that your bank account will start with: ");
        double amount = sc.nextDouble();
        
        BankAccount account = new BankAccount( amount, name );
        int choice = 0;
        
        do
        {
            System.out.println("Please choose from the following:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Current Balance");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            System.out.println();
            
            switch( choice )
            {
                case 1:
                {
                    
                    break;
                }
                case 2:
                {
                    
                    break;
                }
                case 3:
                {
                    
                    break;
                }
                case 4:
                {
                    
                    break;
                }
                default:
                {
                    System.out.println("Invalid choice, please try again.");
                    break;
                }
            }
            
        } while( choice != 4 );
        
        
    }
}
