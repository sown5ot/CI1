package touhou.players;

import tklibs.SpriteUtils;
import touhou.bases.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Son Hoang on 8/2/2017.
 */
public class PlayerSpell {
    public Vector2D position;
    public BufferedImage image;
    public Player player;
    public final int SPEED = 5;

    public PlayerSpell() {
        position = new Vector2D();
        image = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
    }

    public PlayerSpell(Vector2D position) {
        this.position = position;
        image = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
    }

    //run()
    public void run(){
        position.addUp(0, -SPEED);
    }

    //render
    public void render(Graphics2D g2d){
        g2d.drawImage(image, (int) (position.x + 5), (int) (position.y + 5), null);
    }

}
