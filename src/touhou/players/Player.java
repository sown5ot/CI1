package touhou.players;

import bases.Constraints;
import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;
import touhou.inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Created by Son Hoang on 8/2/2017.
 */
public class Player extends GameObject{
    private InputManager inputManager;
    private Constraints constraints;
    private FrameCounter frameCounter;
    private boolean lockSpell;
    private final int SPEED = 5;

    //constructor
    public Player(){
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        frameCounter = new FrameCounter(5);
        lockSpell = false;
    }

    public void run(){
        if (inputManager.upPressed)position.addUp(0, -SPEED);
        if (inputManager.downPressed)position.addUp(0, SPEED);
        if (inputManager.leftPressed)position.addUp(-SPEED, 0);
        if (inputManager.rightPressed)position.addUp(SPEED, 0);

        if (constraints != null)constraints.make(position);

            castSpell();
    }

    private void castSpell() {
        if (inputManager.xPressed && !lockSpell) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.getPosition().set(this.position);
            GameObject.add(newSpell);
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
}
