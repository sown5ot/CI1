package touhou.spheres;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.renderers.Animation;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

public class SphereBullet extends GameObject implements PhysicsBody {
    private BoxCollider boxCollider;
    private FrameCounter frameCounter;
    private final int SPEED = 5;

    public SphereBullet(){
        super();
        renderer = new Animation(7,
                SpriteUtils.loadImage("assets/images/sphere-bullets/0.png"),
                SpriteUtils.loadImage("assets/images/sphere-bullets/1.png"),
                SpriteUtils.loadImage("assets/images/sphere-bullets/2.png"),
                SpriteUtils.loadImage("assets/images/sphere-bullets/3.png")
        );

        boxCollider = new BoxCollider(12, 12);
        this.nextGameObjects.add(boxCollider);
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        position.addUp(0, -SPEED);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
