package touhou.enemies;

import bases.GameObject;
import bases.renderers.Animation;
import tklibs.SpriteUtils;

import java.awt.*;

public class EnemyExplosion extends GameObject{
    private Animation animation;

    public EnemyExplosion(){
        animation = new Animation(7,
                true,
                SpriteUtils.loadImage("assets/images/enemies/explosion/1.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/3.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/5.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/7.png")
        );

        this.renderer = animation;
    }

    @Override
    public void render(Graphics2D g2d) {
        super.render(g2d);
        if (animation.isEnd()) this.isActive = false;
    }

    @Override
    public void reset() {
        super.reset();
        animation.reset();
    }
}
