package touhou.players;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.PhysicsPool;
import bases.renderers.Animation;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import touhou.bosses.EnemyBoss;
import touhou.enemies.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Son Hoang on 8/2/2017.
 */
public class PlayerSpell extends GameObject implements PhysicsBody{
    private final int SPEED = 10;
    private BoxCollider boxCollider;
    private int damage = 4;

    public PlayerSpell() {
        super();
        renderer = new Animation(5,
                false,
                SpriteUtils.loadImage("assets/images/player-spells/a/0.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/1.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/2.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/3.png"));
        boxCollider = new BoxCollider(20, 20);
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

    public BoxCollider getBoxCollider(){
        return this.boxCollider;
    }

}
