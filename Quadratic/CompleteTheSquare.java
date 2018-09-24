import java.util.Scanner;

/**
 * Write a description of class CompleteTheSquare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CompleteTheSquare
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        double a = 0, b = 0, c = 0;
        String answer = "";
        
        do
        {
            System.out.println("Please enter the constants A, B, and C for the following");
            System.out.println("quadratic expression Ax^2 + Bx + C: ");
            
            System.out.print("A = ");
            a = kb.nextDouble();
            
            System.out.print("B = ");
            b = kb.nextDouble();
            
            System.out.print("C = ");
            c = kb.nextDouble();
            
            System.out.println();
            
            System.out.println( a + "x^2 + " + b + "x + " + c );
            
            System.out.print("Is this the correct quadratic? Y or N ");
            
            
            
            answer = kb.next();
            
            System.out.println();
            
        }while( !answer.equalsIgnoreCase("Y") );
        
        // Step 0
        System.out.println();
        System.out.println();
        System.out.println("Step 0: Group the terms that have x^2 and x.");
        System.out.println();
        System.out.println( "(" + a + "x^2 + " + b + "x) + " + c );
        
        System.out.println();
        System.out.print("Type in C to continue: ");
        answer = kb.next();
        
        
        // Step 1
        System.out.println();{ }
        System.out.println();
        System.out.println("Step 1: Factor out the number being multiplied by");
        System.out.println("the x^2 term from the x^2 and x terms.");
        System.out.println();
        System.out.println( a + "(x^2 + " + (b/a) + "x) + " + c );
        
        System.out.println();
        System.out.print("Type in C to continue: ");
        answer = kb.next();
        
        
        // Step 2
        System.out.println();
        System.out.println();
        System.out.println("Step 2: Compute side work: Take the number being");
        System.out.println("multiplied by the x term, divide by 2 and square the");
        System.out.println("result.");
        System.out.println();
        double num = (b*b/(4*a*a));
        System.out.println( "((" + (b/a) + ")/2)^2 = (" + (b/(2*a)) + ")^2 = " + num );
        
        System.out.println();
        System.out.print("Type in C to continue: ");
        answer = kb.next();
        
        
        // Step 3
        System.out.println();
        System.out.println();
        System.out.println("Step 3: Add and subtract a 'Well Chosen Zero', that is,");
        System.out.println("add and subtract the number computed in Step 2 inside");
        System.out.println("the parentheses.");
        System.out.println();
        System.out.println( a + "(x^2 + " + (b/a) + "x + " + num + " - " + num + ") + " + c );
        
        System.out.println();
        System.out.print("Type in C to continue: ");
        answer = kb.next();
        
        
        // Step 4
        System.out.println();
        System.out.println();
        System.out.println("Step 4: Move the term that we subtracted in Step 3 to the");
        System.out.println("outside of the parentheses by distributing the factored");
        System.out.println("number from Step 1.");
        System.out.println();
        System.out.println( a + "(x^2 + " + (b/a) + "x + " + num + ") - " + (a*num) + " + " + c );
        
        System.out.println();
        System.out.print("Type in C to continue: ");
        answer = kb.next();
        
        
        // Step 5
        System.out.println();
        System.out.println();
        System.out.println("Step 5: Factor what is left in the parentheses into a ");
        System.out.println("perfect square.  Use the work in step 2 to help figure out");
        System.out.println("what the factors will be.  Also, combine constants on the ");
        System.out.println("outside of the parentheses.");
        System.out.println();
        System.out.println( a + "(x + " + (b/(2*a)) + ")^2 + " + (c-a*num) );
        
        System.out.println();
        System.out.print("Type in C to continue: ");
        answer = kb.next();
        
        
    }
}
