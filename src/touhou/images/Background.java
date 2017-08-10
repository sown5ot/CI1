package touhou.images;

import bases.GameObject;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Background extends GameObject {
    public Background() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/background/0.png"));
    }

//    public void paint(Graphics2D g2d){
//        g2d.drawImage(image, 0, (int) position.y, null);
//        position.y += 3;
//    }

    public void run(){
        super.run();
        position.y += 3;
    }

}
