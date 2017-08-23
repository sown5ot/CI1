package touhou.bosses;

import bases.GameObject;
import bases.renderers.Animation;
import tklibs.SpriteUtils;

import java.awt.*;

public class BossExplosion extends GameObject{
    private Animation animation;

    public BossExplosion(){
        animation = new Animation(7,
                true,
                SpriteUtils.loadImage("assets/images/enemies/explosion-big/0.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion-big/2.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion-big/4.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion-big/6.png")
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