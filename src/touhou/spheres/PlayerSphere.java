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

    public PlayerSphere() {
        super();
        this.renderer = new Animation(3,
                SpriteUtils.loadImage("assets/images/sphere/0.png"),
                SpriteUtils.loadImage("assets/images/sphere/1.png"),
                SpriteUtils.loadImage("assets/images/sphere/2.png"),
                SpriteUtils.loadImage("assets/images/sphere/3.png"));
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
    }

    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
