package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class EnemySpawner extends GameObject{
    private FrameCounter frameCounter;
    private Random random;

    public EnemySpawner() {
        super();
        frameCounter = new FrameCounter(140);
        random = new Random();
    }

    public void run(){
        if (frameCounter.run()){
            frameCounter.reset();
            Enemy enemy = new Enemy();
            enemy.getPosition().set(random.nextInt(384), 40);
            GameObject.add(enemy);
        }
    }
}
