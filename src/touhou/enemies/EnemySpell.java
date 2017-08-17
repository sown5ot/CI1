package touhou.enemies;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.PhysicsPool;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemySpell extends GameObject implements PhysicsBody{
    private final int SPEED = 13;
    private BoxCollider boxCollider;
    private final int DAMAGE = 1;

    public EnemySpell() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        boxCollider = new BoxCollider(10, 10);
        this.nextGameObjects.add(boxCollider);
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        position.addUp(0, SPEED);
        hitPlayer();
    }

    public void hitPlayer(){
        Player hitPlayer = PhysicsPool.collideWith(boxCollider, Player.class);
        if (hitPlayer != null){
            this.isActive = false;
            hitPlayer.getDamage(DAMAGE);
            if (hitPlayer.getHealthPoint() == 0) {
                hitPlayer.setActive(false);
            }
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
