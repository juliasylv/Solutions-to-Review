import java.util.Scanner;
/**
 * Text Game Template
 * @author   Brandon Bettes
 * @version  1.0
 * 
 * 
 * Write the title and description of your game here.
 * 
 * 
 * @authors (your names) 
 * @version (a version number or a date)
 */
public class NameOfGame
{
    /** 
     * 
     * Field variables Go Up Here
     * 
     */
    // Declare any field, aka world variables that you need here.
    // For example, you could assign a number to each room so that we know where the player
    // is currently located. Uses key word static in declaration.
    // Example:
    static int currentRoom;

    // If you want the player to have character stats, declare them here as a static variable.
    // Examples:
    static String playerName;
    static int playerHealth;
    static int playerStamina;

    // If you want to have items that the player can find in game and add to their 'inventory',
    // declare item variables here. We can use booleans to represent if the player has the item
    // in their inventory or not.
    // Examples:
    
    /** Elven sword
     * 
     *  taken name: sword, elvensword
     */
    static boolean sword;
    static int swordLocation; // Keep track of item location.
    
    /** Oil lamp
     * 
     *  starts in pack
     *  taken name: lamp, oillamp
     *  useable: lamp
     */
    static boolean oilLamp;
    static boolean oilLampOn; // Is the lamp on or off?
    
    // Keep track of the turns taken by player:
    static int turnsTaken;

    // End of field variables

    /** Prompts the user to play game or quit.
     */
    public static void main(String[] args)
    {
        boolean run = true;
        do
        {
            Scanner sc = new Scanner(System.in);

            System.out.print("Prompt the user here to begin game or quit: ");
            String response = sc.next().toLowerCase();

            if( response.equals("begin") )
            {
                startGame();
                run = false; // after our game is over, exit the loop
            }
            else if( response.equals("quit") )
            {
                run = false;
            }
            else
            {
                System.out.println("Display error message.");
            }

        }while(run);
    }

    /** Displays the introduction to the game.  Includes any instructions you may want to give
     *  the user when beginning the game.
     */
    public static void displayIntro()
    {
        System.out.println("Display the full introduction of your game to the user here.");
        System.out.println("For now, all commands are limited to one word at a time.");

        System.out.println();
        System.out.println();
    }

    /** Displays a description of the room where the character is currently located.
     */
    public static void displayCurrentRoom()
    {
        switch( currentRoom )
        {
            case 1: // starting room
            {
                System.out.println("You are in a cave with very little light.");
                System.out.println("To the north you can see faint sunlight.");
                break;
            }
            case 2: // north of starting room
            {
                System.out.println("There is an entrance to a dark cave south of you.");
                System.out.println("It seems vaguely familiar.");
                if( !sword )
                {
                    System.out.println("You see an elven sword on the ground in front of you.");
                }
                break;
            }
            default:
            {
                break;
            }
        }
    }
    
        /** @param direction - the direction the player wants to go.
     * 
     *  @return true if the player's chosen direction is allowed from their current location,
     *          false otherwise.
     */
    public static boolean canMove( String direction )
    {
        switch( currentRoom )
        {
            case 1: // Can only move north from this room
            {
                if(direction.equals("n") || direction.equals("north") )
                    return true;
                else
                    return false;
            }
            case 2: // Can only move south from this room
            {
                if(direction.equals("s") || direction.equals("south"))
                    return true;
                else
                    return false;
            }
            default:
            {
                return false;
            }
        }
    }
    
        /** 'Move' command
     * 
     * Moves the player in a given direction.
     * 
     * @param direction - the direction the player wants to go.
     */
    public static void move(String direction)
    {
        if( canMove(direction) )
        {
            switch(currentRoom)
            {
                case 1: // starting room
                {
                    if( direction.equals("n") || direction.equals("north") )
                    {
                        currentRoom = 2;
                    }
                    break;
                }
                case 2: // cave entrance
                {
                    if( direction.equals("s") || direction.equals("south") )
                    {
                        currentRoom = 1;
                    }
                    break;
                }
                default:
                {
                    break;
                }
            }
        }
        else
        {
            System.out.println("You cannot move in that direction.");
        }
        
        displayCurrentRoom();
    }

    /** Displays all items in player's inventory.
     */
    public static void displayInventory()
    {
        if( sword )
            System.out.println("An elven sword");

        if( oilLamp )
        {
            System.out.print("A simple oil lamp.  It is currently turned ");
            if( oilLampOn )
                System.out.println("on.");
            else
                System.out.println("off.");
        }
    }

    /** Initializes static variabdisplayCurrentRoomles
     */
    public static void init()
    {
        /** 
         * Player creation
         */
        // Prompt user for character name.
        System.out.print("What is your name? ");
        Scanner kb = new Scanner(System.in);
        playerName = kb.next();
        // Player stats
        playerHealth = 5;
        playerStamina = 5;
        
        
        /** 
         * Starting room number:
         */
        currentRoom = 1;

        /** 
         * Items:
         * Set all items that we don't want the user to start with to false,
         * and if we want them to start with an item set to true.
         */
        sword = false;
        swordLocation = 2;  // Elven sword will be located in room 2

        oilLamp = true; // starting with oil lamp in inventory
        oilLampOn = false;

    }

    /** Starts a new game
     */
    public static void startGame()
    {
        displayIntro();  // Display the game's intro!

        init(); // Initialize game variables

        displayCurrentRoom();  // Display the starting room description

        boolean menu = true;
        do
        {
            Scanner kb = new Scanner(System.in);

            String getAction = kb.next().toLowerCase();

            switch( getAction )
            {
                case "inventory":
                {
                    displayInventory();
                    break;
                }
                case "look":
                {
                    displayCurrentRoom();
                    break;
                }
                case "take":
                case "get":
                {
                    takeItem();
                    break;
                }
                case "n":
                case "north":
                case "s":
                case "south":
                case "e":
                case "east":
                case "w":
                case "west":
                {
                    move( getAction );
                    break;
                }
                
                case "go":
                case "walk":
                case "run":
                case "jog":
                {
                    System.out.println("Which direction do you want to " + getAction + "?");
                    break;
                }
                
                case "use":
                {
                    useItem();
                    break;
                }
                
                case "quit":
                {
                    menu = false;
                    break;
                }
                
                default:
                {
                    System.out.println("Error message here, action not defined");
                    break;
                }

            }
            
            System.out.println(); // print a space between attempted actions

        }while( menu );
    }

    /** 'Take' command
     * 
     * Takes an item from the ground
     * 
     * @Preconditions: Player must be in the same room as item
     * 
     * @Postconditions: If item is found, item placed in player's pack
     */
    public static void takeItem()
    {
        System.out.print("What item would you like to take? ");
        Scanner kb = new Scanner(System.in);
        String itemToGet = kb.next().toLowerCase();

        switch( itemToGet )
        {
            case "sword":
            case "elvensword":
            {
                if( currentRoom == 2 && !sword )
                {
                    System.out.println("You grab the elven sword and put it in your pack.");
                    sword = true;
                }
                else
                {
                    System.out.println("I don't see that here.");
                }
                break;
            }
            
            case "oillamp":
            case "lamp":
            {
                System.out.println("That is already in your pack.");
                break;
            }
            
            default:
            {
                System.out.println("I don't see that here.");
                break;
            }
        }
    }
    
    /** 'Use' command
     * 
     * Use an item.
     * 
     * @Preconditions: Item must be in player pack.
     */
    public static void useItem()
    {
        System.out.print("What item would you like to use from inventory? ");
        Scanner kb = new Scanner(System.in);
        String itemToUse = kb.next().toLowerCase();

        switch( itemToUse )
        {
            case "oillamp":
            case "lamp":
            {
                String onOff = "off";
                if( !oilLampOn )
                {
                    onOff = "on";
                }
                
                System.out.println("You turn " + onOff + " the oil lamp.");
                oilLampOn = !oilLampOn;
                break;
            }
            
            default:
            {
                System.out.println("I don't see how to use that.");
                break;
            }
        }
    }
}
