package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemySpawner extends GameObject{
    private FrameCounter frameCounter;
    private Random random;
    private BufferedImage image;

    public EnemySpawner() {
        super();
        frameCounter = new FrameCounter(100);
        random = new Random();
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        spawnEnemy();
    }

    private void spawnEnemy() {
        if (frameCounter.run()){
            frameCounter.reset();
            Enemy enemy = new Enemy();
            enemy.getPosition().set(random.nextInt(384), 40);
            GameObject.add(enemy);
        }
    }

}
