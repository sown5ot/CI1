package touhou.bases;

/**
 * Created by Son Hoang on 8/2/2017.
 */
public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void set(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D other){ set(other.x, other.y); }

    public void addUp(float dx, float dy){
        this.x += dx;
        this.y += dy;
    }

    public void addUp(Vector2D other){ addUp(other.x, other.y); }

    public void substractBy(float dx, float dy){
        this.x += dx;
        this.y += dy;
    }

    public void substractBy(Vector2D other){ substractBy(other.x, other.y); }

    public Vector2D add(float dx, float dy){ return new Vector2D(this.x + dx, this.y + dy); }

    public Vector2D add(Vector2D other){ return add(other.x, other.y); }

    public Vector2D substract(float dx, float dy){ return new Vector2D(this.x - dx, this.y - dy); }

    public Vector2D substract(Vector2D other){ return new Vector2D(this.x + other.x, this.y + other.y); }

    public Vector2D multiply(float f){ return new Vector2D(this.x * f, this.y * f); }

    public float magnitude(){ return (float) Math.sqrt(this.x * this.x + this.y * this.y); }

    public Vector2D normalize(){
        float mag = magnitude();
        return new Vector2D(this.x / mag, this.y / mag);
    }

   // public Vector2D rotate(float angle){

    //}
}
