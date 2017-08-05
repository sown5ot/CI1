package touhou.players;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
import touhou.bases.FrameCounter;
import touhou.bases.Vector2D;
import touhou.bases.renderers.ImageRenderer;
import touhou.inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Created by Son Hoang on 8/2/2017.
 */
public class Player {
    private Vector2D position;
    private ImageRenderer renderer;
    private InputManager inputManager;
    private Constraints constraints;
    private FrameCounter frameCounter;
    public ArrayList<PlayerSpell> playerSpells;

    private final int SPEED = 5;

    //constructor
    public Player(){
        position = new Vector2D(384/2, 600);
        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        renderer = new ImageRenderer(image);
        frameCounter = new FrameCounter(3);
    }

    public void run(){
        if (inputManager.upPressed)position.addUp(0, -SPEED);
        if (inputManager.downPressed)position.addUp(0, SPEED);
        if (inputManager.leftPressed)position.addUp(-SPEED, 0);
        if (inputManager.rightPressed)position.addUp(SPEED, 0);

        if (constraints != null)constraints.make(position);

        if (frameCounter.run()) {
            frameCounter.reset();
            castSpell();
        }
    }

    private void castSpell() {
        if (inputManager.xPressed) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.position.set(this.position);
            playerSpells.add(newSpell);
        }
    }

    public void render(Graphics2D g2d){ renderer.render(g2d, position); }

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
