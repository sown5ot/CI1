package touhou.players;

import bases.Vector2D;
import bases.renderers.Animation;
import bases.renderers.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;

public class PlayerMovement implements Renderer {
    private Animation leftMove = new Animation(7,
            false,
            SpriteUtils.loadImage("assets/images/players/left/0.png"),
            SpriteUtils.loadImage("assets/images/players/left/1.png"),
            SpriteUtils.loadImage("assets/images/players/left/2.png"),
            SpriteUtils.loadImage("assets/images/players/left/3.png"),
            SpriteUtils.loadImage("assets/images/players/left/4.png"),
            SpriteUtils.loadImage("assets/images/players/left/5.png")
    );

    private Animation rightMove = new Animation(7,
            false,
            SpriteUtils.loadImage("assets/images/players/right/0.png"),
            SpriteUtils.loadImage("assets/images/players/right/1.png"),
            SpriteUtils.loadImage("assets/images/players/right/2.png"),
            SpriteUtils.loadImage("assets/images/players/right/3.png"),
            SpriteUtils.loadImage("assets/images/players/right/4.png"),
            SpriteUtils.loadImage("assets/images/players/right/5.png")
    );

    private Animation straightMove = new Animation(7,
            false,
            SpriteUtils.loadImage("assets/images/players/straight/0.png"),
            SpriteUtils.loadImage("assets/images/players/straight/1.png"),
            SpriteUtils.loadImage("assets/images/players/straight/2.png"),
            SpriteUtils.loadImage("assets/images/players/straight/3.png"),
            SpriteUtils.loadImage("assets/images/players/straight/4.png"),
            SpriteUtils.loadImage("assets/images/players/straight/5.png"),
            SpriteUtils.loadImage("assets/images/players/straight/6.png")
    );

    private Animation currentMove = straightMove;

    public void update(Player player){
        Vector2D velocity = player.getVelocity();
        if (velocity.x < 0){
            currentMove = leftMove;
        }
        else if (velocity.x > 0){
            currentMove = rightMove;
        }
        else {
            currentMove = straightMove;
        }

    }

    @Override
    public void render(Graphics2D g2d, Vector2D position) {
        currentMove.render(g2d, position);

    }
}
