package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
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
        frameCounter = new FrameCounter(140);
        random = new Random();
        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png");
        renderer = new ImageRenderer(image);
        BufferedImage image;
    }

    public void run(){
        super.run();
        setTransparent(image);
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

    public void setTransparent(BufferedImage image){
        int height = image.getHeight();
        int width = image.getWidth();
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                image.setRGB(x ,y , 0);
            }
        }
    }
}
