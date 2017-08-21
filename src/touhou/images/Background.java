package touhou.images;

import bases.GameObject;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;
import touhou.settings.Settings;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Background extends GameObject {
    private final int SPEED = 1;
    private final int imageHeight;
    private ImageRenderer imageRenderer;

    public Background() {
        super();
        imageRenderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/background/0.png"));
        imageHeight = imageRenderer.image.getHeight();
        imageRenderer.getAnchor().set(0, 1);
        position.set(0, Settings.instance.getGameWindowHeight());
        this.renderer = imageRenderer;
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        move();
    }

    private void move() {
        position.addUp(0, SPEED);
        if (position.y >= imageHeight) position.y = imageHeight;
    }

}
