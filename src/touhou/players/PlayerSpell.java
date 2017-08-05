package touhou.players;

import tklibs.SpriteUtils;
import touhou.bases.Vector2D;
import touhou.bases.renderers.ImageRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Son Hoang on 8/2/2017.
 */
public class PlayerSpell {
    public Vector2D position;
    public ImageRenderer renderer;
    public final int SPEED = 20;

    public PlayerSpell() {
        position = new Vector2D();
        BufferedImage image = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
        renderer = new ImageRenderer(image);
    }


    public void run(){
        position.addUp(0, -SPEED);
    }

    public void render(Graphics2D g2d){renderer.render(g2d, position); }

}
