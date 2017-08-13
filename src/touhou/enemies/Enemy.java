package touhou.enemies;

import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import tklibs.SpriteUtils;
import bases.Constraints;
import bases.FrameCounter;
import bases.renderers.ImageRenderer;

public class Enemy extends GameObject implements PhysicsBody{
    private Constraints constraints;
    private FrameCounter frameCounter;
    private final int SPEED = 1;
    private BoxCollider boxCollider;

    public Enemy() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
        frameCounter = new FrameCounter(70);
        boxCollider =  new BoxCollider(15, 30);
        this.nextGameObjects.add(boxCollider);
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
//        if (constraints != null) {
//            constraints.make(position);
//        }
        fly();
        castSpell();
    }

    private void fly(){
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

    public BoxCollider getBoxCollider(){
        return this.boxCollider;
    }
}
