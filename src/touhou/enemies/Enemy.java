package touhou.enemies;

import bases.GameObject;
import tklibs.SpriteUtils;
import bases.Constraints;
import bases.FrameCounter;
import bases.renderers.ImageRenderer;

public class Enemy extends GameObject{
    private Constraints constraints;
    private FrameCounter frameCounter;
    private final int SPEED = 1;
    private EnemySpawner enemySpawner;

    public Enemy() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
        frameCounter = new FrameCounter(70);
        enemySpawner = new EnemySpawner();
    }

    public void run(){
        super.run();
//        if (constraints != null) {
//            constraints.make(position);
//        }

        fly();
        castSpell();
    }

    public void fly(){
        position.addUp(0, SPEED);
    }

    private void castSpell() {
        if (frameCounter.run()) {
            EnemySpell enemySpell = new EnemySpell();
            enemySpell.getPosition().set(this.position);
            GameObject.add(enemySpell);
            frameCounter.reset();
        }
    }
}
