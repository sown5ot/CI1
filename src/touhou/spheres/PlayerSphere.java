package touhou.spheres;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.pool.GameObjectPool;
import bases.renderers.Animation;
import tklibs.SpriteUtils;
import touhou.players.Player;

public class PlayerSphere extends GameObject implements PhysicsBody{
    private BoxCollider boxCollider;
    private FrameCounter frameCounter;
    private Animation animation;

    public PlayerSphere() {
        super();
        animation = new Animation(15,
                false,
                SpriteUtils.loadImage("assets/images/sphere/0.png"),
                SpriteUtils.loadImage("assets/images/sphere/1.png"),
                SpriteUtils.loadImage("assets/images/sphere/2.png"),
                SpriteUtils.loadImage("assets/images/sphere/3.png"));
        this.renderer = animation;
        frameCounter = new FrameCounter(10);
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
    }

    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    public void setReverse(boolean reverse){
        this.animation.setReverseAnimation(reverse);
    }
}
