import java.util.*;
import java.io.*;
/**
 * This program will complete the square on a quadratic expression with
 * constants given by the user.  Each step will be shown clearly so that
 * an Algebra 2 student can check their handwritten work.
 * 
 * @author Brandon Bettes
 * @version 1.0
 */
public class CompleteTheSquare
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);

        String answer = "";
        double a = 0, b = 0, c = 0;

        do
        {
            System.out.println("Please enter the constants A, B, and C for the following");
            System.out.println("quadratic equation A*x^2 + B*x + C:");

            // get the value of A from the user
            System.out.print("A = ");
            a = kb.nextDouble();

            // get the value of B from the user
            System.out.print("B = ");
            b = kb.nextDouble();

            // get the value of C from the user
            System.out.print("C = ");
            c = kb.nextDouble();

            // Display the current quadratic
            System.out.println( a + "*x^2 + " + b + "*x + " + c );

            // Prompt user if this is correct
            System.out.print("Is this the correct quadratic? (Y or N) ");
            answer = kb.next();

        } while( !answer.equalsIgnoreCase("Y") );

        // Step 0
        System.out.println();
        System.out.println();
        System.out.println("Step 0: Group the terms that have x^2 and x.");
        System.out.println();
        System.out.println( "(" + a + "*x^2 + " + b + "*x) + " + c );

        System.out.print("Type in C and hit enter to continue: ");
        answer = kb.next();

        // Step 1
        System.out.println();
        System.out.println();
        System.out.println("Step 1: Factor out the number being multiplied by");
        System.out.println("        the x^2 term from the x^2 and x terms.");
        System.out.println();
        System.out.println( a + "(x^2 + " + (b/a) + "*x) + " + c );

        System.out.print("Type in C and hit enter to continue: ");
        answer = kb.next();

        // Step 2
        System.out.println();
        System.out.println();
        System.out.println("Step 2: Compute side work: Take the number being multiplied");
        System.out.println("        by the x term, divide by 2 and square the result.");
        System.out.println();
        double num = Math.pow( (b/a)/2, 2 );
        System.out.println( " ((" + (b/a) + ")/2)^2 = " + num );

        System.out.print("Type in C and hit enter to continue: ");
        answer = kb.next();

        // Step 3
        System.out.println();
        System.out.println();
        System.out.println("Step 3: Add and subtract a 'Well Chosen Zero', that is,");
        System.out.println("        add and subtract the number computed in Step 2");
        System.out.println("        inside the parentheses with the x^2 and x terms.");
        System.out.println();
        System.out.println( a + "(x^2 + " + (b/a) + "*x + " + num + " - " + num + ") + " + c );

        System.out.print("Type in C and hit enter to continue: ");
        answer = kb.next();

        // Step 4
        System.out.println();
        System.out.println();
        System.out.println("Step 4: Move the term that we subtracted in step 3 to the");
        System.out.println("        outside of the parentheses by distributing the");
        System.out.println("        factored number from step 1.");
        System.out.println();
        System.out.println( a + "(x^2 + " + (b/a) + "*x + " + num + ") - " + (a*num) + " + " + c );

        System.out.print("Type in C and hit enter to continue: ");
        answer = kb.next();

        // Step 5
        System.out.println();
        System.out.println();
        System.out.println("Step 5: Factor what is left in the parentheses into a ");
        System.out.println("        perfect square.  Use the work in step 2 to help");
        System.out.println("        figure out what the factors will be.");
        System.out.println();
        System.out.println( a + "(x + " + (b/(2*a)) + ")^2 + " + (c - a*num) );

        System.out.print("Type in C and hit enter to continue: ");
        answer = kb.next();
        
        // Fractional answers:
        
        System.out.println();
        System.out.println( a + "(x + " + convertDecimalToFraction(b/(2*a)) + ")^2 + " + convertDecimalToFraction(c - a*num) );

        System.out.print("Type in C and hit enter to continue: ");
        answer = kb.next();
    }

    public static String convertDecimalToFraction(double x)
    {
        if (x < 0)
        {
            return "-" + convertDecimalToFraction(-x);
        }
        
        double tolerance = 1.0E-13;
        double h1=1;
        double h2=0;
        double k1=0;
        double k2=1;
        double b = x;
        
        do
        {
            double a = Math.floor(b);
            double aux = h1;
            h1 = a*h1+h2;
            h2 = aux;
            aux = k1;
            k1 = a*k1+k2;
            k2 = aux;
            b = 1/(b-a);
        } while (Math.abs(x-h1/k1) > x*tolerance);

        return (int)h1+"/"+(int)k1;
    }

}
