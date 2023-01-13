import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 600, 1); 

        Titleletters titleletters = new Titleletters();
        addObject(titleletters,419,300);
        
        QuitText quittext = new QuitText();
        addObject(quittext,422,500);

        prepare();
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("Enter"))
            Greenfoot.setWorld(new MyWorld());
            
        if (Greenfoot.isKeyDown("Q"))
            Greenfoot.setWorld(new ThankYou());
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
