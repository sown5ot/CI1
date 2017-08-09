package touhou.images;

import bases.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {
    private BufferedImage image;
    private Graphics2D backbufferGraphics;
    private int backgroundY = -2400;

    public Background() {
        super();
        image = SpriteUtils.loadImage("assets/images/background/0.png");
    }

    public void run(){
        super.run();
        backbufferGraphics.drawImage(image, 0 ,backgroundY , null);
        backgroundY += 3;
    }
}
