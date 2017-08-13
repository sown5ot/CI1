package bases.physics;

import bases.GameObject;
import bases.Vector2D;

import javax.swing.*;

public class BoxCollider extends GameObject {
    private float width;
    private float height;

    public BoxCollider(float x, float y, float width, float height){
        super();
        this.position.set(x, y);
        this.width = width;
        this.height = height;
    }

    public BoxCollider(float width, float height){
        this(0, 0, width, height);
    }

    public float left(){
        return this.screenPosition.x - this.width / 2;
    }

    public float right(){
        return this.screenPosition.x + this.width / 2;
    }

    public float top(){
        return this.screenPosition.y - this.height / 2;
    }

    public float bottom(){
        return this.screenPosition.y + this.height / 2;
    }

    public boolean intersects(BoxCollider other){
        return this.left() <= other.right() &&
                this.right() >= other.left() &&
                this.top() <= other.bottom() &&
                this.bottom() >= other.top();
    }
}
