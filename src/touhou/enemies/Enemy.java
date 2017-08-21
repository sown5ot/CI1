package touhou.enemies;

import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.PhysicsPool;
import bases.pool.GameObjectPool;
import bases.renderers.Animation;
import bases.renderers.Renderer;
import tklibs.SpriteUtils;
import bases.Constraints;
import bases.FrameCounter;
import bases.renderers.ImageRenderer;
import touhou.players.Player;

public class Enemy extends GameObject implements PhysicsBody{
    private Constraints constraints;
    private FrameCounter frameCounter;
    private final int SPEED = 2;
    private BoxCollider boxCollider;

    public Enemy() {
        super();
        renderer = new Animation(7,
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/1.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/2.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/3.png"));
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
        hitPlayer();
        setDeactivate();
    }

    private void hitPlayer(){
        Player hitPlayer = PhysicsPool.collideWith(boxCollider, Player.class);
        if (hitPlayer != null){
            hitPlayer.setActive(false);
            this.isActive = false;
        }
    }

    private void fly(){
        position.addUp(0, SPEED);
    }

    private void castSpell() {
        if (frameCounter.run()) {
            EnemySpell enemySpell = GameObjectPool.reuse(EnemySpell.class);
            enemySpell.getPosition().set(this.position);
            frameCounter.reset();
        }
    }

    public BoxCollider getBoxCollider(){
        return this.boxCollider;
    }
}
