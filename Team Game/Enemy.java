import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld world;
    public int health = 5;
    
    public Enemy(int level)
    {
        if(level == 1)
        {
            setImage("Enemy.png");
        }
        if(level == 2)
        {
            setImage("Enemy2.png");
        }
    }
    public void act()
    {
       moveAlongPath(); 
       hitByProjectile();
    }
    public void moveAlongPath()
    {
        getImage().scale(60,60);
        move(1);
        List <Road> road90 = getObjectsAtOffset(-30, 0, Road.class);
        for (Road roads: road90)
        {
          if(roads.straight == false && getRotation() == 0)
            {
                setRotation(roads.turn);
            }
        }
    }
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null)
        {
            health--;
            
            getWorld().removeObject(projectile);
        }
        if(health < 1)
        {
            world.money += 50;
            getWorld().removeObject(this);
        }
        else if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    

}
