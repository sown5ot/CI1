package touhou.spheres;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.PhysicsPool;
import bases.renderers.Animation;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;
import touhou.bosses.EnemyBoss;
import touhou.enemies.Enemy;

public class SphereBullet extends GameObject implements PhysicsBody {
    private BoxCollider boxCollider;
    private final int SPEED = 10;
    private int damage = 2;

    public SphereBullet(){
        super();
        renderer = new Animation(7,
                false,
                SpriteUtils.loadImage("assets/images/sphere-bullets/0.png"),
                SpriteUtils.loadImage("assets/images/sphere-bullets/1.png"),
                SpriteUtils.loadImage("assets/images/sphere-bullets/2.png"),
                SpriteUtils.loadImage("assets/images/sphere-bullets/3.png")
        );

        boxCollider = new BoxCollider(12, 12);
        this.nextGameObjects.add(boxCollider);
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        position.addUp(0, -SPEED);
        hitEnemy();
        hitBoss();
        setDeactivate();
    }

    private void hitEnemy() {
        Enemy hitEnemy = PhysicsPool.collideWith(this.boxCollider, Enemy.class);
        if (hitEnemy != null){
            hitEnemy.getDamage(damage);
            this.isActive = false;
        }
    }

    private void hitBoss(){
        EnemyBoss hitBoss = PhysicsPool.collideWith(this.boxCollider, EnemyBoss.class);
        if (hitBoss != null){
            hitBoss.getDamage(damage);
            this.isActive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
