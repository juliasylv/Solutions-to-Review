
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
        
        String s1 = charsInName("Brandon");
        
        String s2 = charsInName("Bob");
        
        System.out.println(s1);
        System.out.println(s2);
        
        
    }
    
    // Number 15
    public static String charsInName( String name )
    {
        String sentence;
        
        sentence = name + " has " + name.length() + " characters.";
        
        return sentence;
    }
    
    
    // Number 16
    public static void printInfo( String name, int age )
    {
        
        String sentence = name + " is " + age + " years old, another year older, another year wiser.";
        
        System.out.println( sentence );

    }
    
    
}
