package touhou.bosses;

import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.renderers.Animation;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

public class BossBullets extends GameObject implements PhysicsBody {
    private BoxCollider boxCollider;
    private int typeBullet;
    private float drX;
    private float drY;

//    public BossBullets(int typeBullet, float dirX, float dirY){
//        super();
//        switch (typeBullet){
//            case 1: renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png"));
//                break;
//            case 2: renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/green.png"));
//                break;
//            case 3: renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/pink.png"));
//                break;
//            case 4: renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/red.png"));
//                break;
//            case 5: renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
//                break;
//            case 6: renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/white.png"));
//                break;
//            default: renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
//                break;
//        }
//        boxCollider = new BoxCollider(5, 5);
//        this.drX = dirX;
//        this.drY = dirY;
//    }

    public BossBullets(){
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png"));
        boxCollider = new BoxCollider(5, 5);
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        fly();
        hitPlayer();
        setDeactivate();
    }

    private void fly() {
        position.addUp(drX, drY);
    }

    private void hitPlayer(){

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    public float getDrX() {
        return drX;
    }

    public void setDrX(float drX) {
        this.drX = drX;
    }

    public float getDrY() {
        return drY;
    }

    public void setDrY(float drY) {
        this.drY = drY;
    }
}
