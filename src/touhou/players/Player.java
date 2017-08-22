package touhou.players;

import bases.Constraints;
import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.PhysicsPool;
import bases.pool.GameObjectPool;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;
import touhou.enemies.Enemy;
import touhou.inputs.InputManager;
import touhou.spheres.PlayerSphere;
import touhou.spheres.SphereBullet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Created by Son Hoang on 8/2/2017.
 */
public class Player extends GameObject implements PhysicsBody{
    private InputManager inputManager;
    private Constraints constraints;
    private FrameCounter frameCounter;
    private boolean lockSpell;
    private final int SPEED = 3;
    private final int SPHERERANGE = 30;
    private BoxCollider boxCollider;
    public boolean isActive;
    private int healthPoint;
    private Vector2D velocity;
    private PlayerMovement playerMovement;

    //constructor
    public Player(){
        super();
        playerMovement = new PlayerMovement();
        this.renderer = playerMovement;
        frameCounter = new FrameCounter(5);
        lockSpell = false;
        isActive = true;
        boxCollider = new BoxCollider(20, 20);
        this.nextGameObjects.add(boxCollider);
        healthPoint = 15;
        velocity = new Vector2D();
        addSpheres();
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);

        velocity.set(0, 0);
        if (inputManager.upPressed) velocity.y -= SPEED;
        if (inputManager.downPressed) velocity.y += SPEED;
        if (inputManager.leftPressed) velocity.x -= SPEED;
        if (inputManager.rightPressed) velocity.x += SPEED;
        position.addUp(velocity);

        if (constraints != null)constraints.make(position);
        castSpell();
        playerMovement.update(this);
    }

    private void addSpheres() {
        PlayerSphere leftSphere = new PlayerSphere();
        leftSphere.getPosition().set(-SPHERERANGE, 0);
        nextGameObjects.add(leftSphere);

        PlayerSphere rightSphere = new PlayerSphere();
        rightSphere.getPosition().set(SPHERERANGE, 0);
        rightSphere.setReverse(true);
        nextGameObjects.add(rightSphere);
    }

    private void castSpell() {
        if (inputManager.xPressed && !lockSpell) {
            PlayerSpell newSpell = GameObjectPool.reuse(PlayerSpell.class);
            newSpell.getPosition().set(this.position);

            SphereBullet leftSphereBullet = GameObjectPool.reuse(SphereBullet.class);
            leftSphereBullet.getPosition().set(this.position.add(-SPHERERANGE, 0));

            SphereBullet rightSphereBullet = GameObjectPool.reuse(SphereBullet.class);
            rightSphereBullet.getPosition().set(this.position.add(SPHERERANGE, 0));

            lockSpell = true;
        }

        unlockSpell();
    }


    private void unlockSpell() {
        if (lockSpell){
            if (frameCounter.run()){
                frameCounter.reset();
                lockSpell = false;
            }
        }
    }

    public void setInputManager(InputManager inputManager) {
        if (inputManager == null){
            throw new IllegalArgumentException();
        } else {
            this.inputManager = inputManager;
        }
    }

    public void setConstraints(Constraints constraints) {
        if (constraints == null){
            throw new IllegalArgumentException();
        } else {
            this.constraints = constraints;
        }
    }

    public void getDamage(int damage){
        healthPoint -= damage;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    public Vector2D getVelocity() {
        return velocity;
    }
}
