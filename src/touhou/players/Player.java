package touhou.players;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
import touhou.bases.Vector2D;
import touhou.inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Created by Son Hoang on 8/2/2017.
 */
public class Player {
    public Vector2D position;
    public BufferedImage image;
    public final int SPEED = 5;
    public InputManager inputManager;
    public Constraints constraints;
    public ArrayList<PlayerSpell> playerSpells;

    //constructor
    public Player(){
        position = new Vector2D(384/2, 600);
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
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
        if (inputManager.xPressed) {
            PlayerSpell newSpell = new PlayerSpell(position.add(0,10));
            playerSpells.add(newSpell);
        }
    }

    public void render(Graphics2D g2d){
        g2d.drawImage(image, (int) position.x, (int) position.y, null);
    }
}
