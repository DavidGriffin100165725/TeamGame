import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //Bobux
    public static int money= 100;
    int basicTowerPrice = 50;
    
    int worldTime;
    
    int waveNumber = 1;

    int map [][] = {
            {1,1,1,1,1,2,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
        };
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 600, 1); 
        Menu menu = new Menu();
        addObject(menu,659,201);
        menu.setLocation(721,301);
        Level1();
        addInTowers();
        showText("Money: " + money, 700,30);
        showText("Tower = 50",700,70);
        showText("Mouse = Tower", 700,100);
        prepare();
    }

    public void act()
    {
        addInTowers();
        showText("Money: " + money, 660,30);
        worldTime++;
        spawnWave();
    }

    private void Level1()
    {
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 11; j++)
            {
                if (map[j][i] == 1)
                {
                    addObject(new Road(true), 30 + i * 60, 30 + j * 60);
                }
                if (map[j][i] == 2)
                {
                    addObject(new Road(90), 30 + i * 60, 30 + j * 60);
                }
                
            }

    }
    public void addInTowers()
    {
        if(Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo().getActor() ==null && money >= basicTowerPrice)
        {
            addObject(new Tower (), (Greenfoot.getMouseInfo().getX() /60) * 60 + 30, (Greenfoot.getMouseInfo().getY() /60) * 60 + 30);
            money -= basicTowerPrice;
        }
    }
    
    public void spawnWave()
    {
        if(worldTime % 20 == 0)
        {
            addObject(new Enemy(waveNumber),4, 27);
        }
        
        if(worldTime % 400 == 0)
        {
            waveNumber++;
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}

    
    