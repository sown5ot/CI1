package touhou.images;

import bases.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Background extends GameObject {
    private BufferedImage image;
    private int backgroundY;

    public Background() {
        super();
        image = SpriteUtils.loadImage("assets/images/background/0.png");
        backgroundY = -2400;
    }

    public void paint(Graphics2D g2d){
        g2d.drawImage(image, 0, backgroundY, null);
    }

    public void run(){
        super.run();
        backgroundY += 3;
    }

}
