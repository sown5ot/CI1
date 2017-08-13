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
    private final int SPEED = 10;
    private BoxCollider boxCollider;

    public EnemySpell() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        boxCollider = new BoxCollider(10, 10);
        this.nextGameObjects.add(boxCollider);
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        position.addUp(0, SPEED);
    }

    public void hitPlayer(){
        Player hitPlayer = PhysicsPool.collideWithPlayer(boxCollider);
        if (hitPlayer != null){
            hitPlayer.isActive = false;
            this.isActive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
