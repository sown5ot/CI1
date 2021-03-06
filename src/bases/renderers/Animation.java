package bases.renderers;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public class Animation implements Renderer{
    private List<BufferedImage> images;
    private FrameCounter frameCounter;
    private int currentImageIndex;
    private boolean reverseAnimation;
    private boolean oneTime;
    private boolean end;

    public Animation(int frameDelay, boolean oneTime, BufferedImage... images){
        this.images = Arrays.asList(images);
        this.frameCounter = new FrameCounter(frameDelay);
        this.currentImageIndex = 0;
        this.reverseAnimation = false;
        this.oneTime = oneTime;
    }

    public void render(Graphics2D g2d, Vector2D position){
        if (!end) {
            BufferedImage image = images.get(currentImageIndex);
            Vector2D renderPosition = position.substract(image.getWidth() / 2, image.getHeight() / 2);

            g2d.drawImage(image, (int) renderPosition.x, (int) renderPosition.y, null);
        }
        update();
    }

    private void update() {
        if (frameCounter.run()){
            frameCounter.reset();
            if (!reverseAnimation){
                currentImageIndex++;
                if (currentImageIndex >= images.size()){
                    if (!oneTime) {
                        currentImageIndex = 0;
                    }
                    else {
                        end = true;
                    }
                }
            }
            else {
                currentImageIndex--;
                if (currentImageIndex <= 0){
                    if (!oneTime) {
                        currentImageIndex = images.size() - 1;
                    }
                    else {
                        end = true;
                    }
                }
            }
        }
    }

    public void reset(){
        end = false;
        currentImageIndex = 0;
    }

    public void setReverseAnimation(boolean reverseAnimation) {
        this.reverseAnimation = reverseAnimation;
    }

    public boolean isEnd() {
        return end;
    }
}
