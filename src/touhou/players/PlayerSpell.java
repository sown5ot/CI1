package touhou.players;

import bases.GameObject;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Son Hoang on 8/2/2017.
 */
public class PlayerSpell extends GameObject{
    private final int SPEED = 15;

    public PlayerSpell() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/player-spells/a/0.png"));
    }

    public void run(){
        super.run();
        position.addUp(0, -SPEED);
    }

}
