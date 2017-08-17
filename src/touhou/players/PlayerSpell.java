package touhou.players;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.PhysicsPool;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import touhou.enemies.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Son Hoang on 8/2/2017.
 */
public class PlayerSpell extends GameObject implements PhysicsBody{
    private final int SPEED = 15;
    private BoxCollider boxCollider;

    public PlayerSpell() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/player-spells/a/0.png"));
        boxCollider = new BoxCollider(20, 20);
        this.nextGameObjects.add(boxCollider);
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        position.addUp(0, -SPEED);
        hitEnemy();
    }

    private void hitEnemy() {
        Enemy hitEnemy = PhysicsPool.collideWith(this.boxCollider, Enemy.class);
        if (hitEnemy != null){
            hitEnemy.setActive(false);
            this.isActive = false;
        }
    }

    public BoxCollider getBoxCollider(){
        return this.boxCollider;
    }

}
