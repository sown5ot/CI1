package touhou.spheres;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.renderers.Animation;
import tklibs.SpriteUtils;

public class PlayerSphere extends GameObject implements PhysicsBody{
    private BoxCollider boxCollider;
    private FrameCounter frameCounter;
    private Animation animation;

    public PlayerSphere() {
        super();
        animation = new Animation(15,
                SpriteUtils.loadImage("assets/images/sphere/0.png"),
                SpriteUtils.loadImage("assets/images/sphere/1.png"),
                SpriteUtils.loadImage("assets/images/sphere/2.png"),
                SpriteUtils.loadImage("assets/images/sphere/3.png"));
        this.renderer = animation;
        frameCounter = new FrameCounter(10);
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        shoot();
    }

    private void shoot() {
        if (frameCounter.run()) {
            frameCounter.reset();
            SphereBullet sphereBullet = new SphereBullet();
            sphereBullet.getPosition().set(this.position);
            nextGameObjects.add(sphereBullet);
        }
    }

    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    public void setReverse(boolean reverse){
        this.animation.setReverseAnimation(reverse);
    }
}
