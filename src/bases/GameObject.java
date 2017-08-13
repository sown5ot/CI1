package bases;

import bases.physics.PhysicsBody;
import bases.physics.PhysicsPool;
import bases.renderers.ImageRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class GameObject {
    protected Vector2D position;
    protected ImageRenderer renderer;
    protected Vector2D screenPosition;
    protected ArrayList<GameObject> nextGameObjects;
    protected boolean isActive;

    private static Vector<GameObject> gameObjects = new Vector<>();
    private static Vector<GameObject> newGameObjects = new Vector<>();

    public GameObject() {
        nextGameObjects = new ArrayList<>();
        screenPosition = new Vector2D();
        position = new Vector2D();
        isActive = true;
    }

    public static void runAll(){
        for (GameObject gameObject : gameObjects){
            if (gameObject.isActive) {
                gameObject.run(new Vector2D(0, 0));
            }
        }

        for (GameObject newGameObject : newGameObjects){
            if (newGameObject instanceof PhysicsBody){
                PhysicsPool.add((PhysicsBody) newGameObject);
            }
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics2D g2d){
        for (GameObject gameObject : gameObjects){
            if (gameObject.isActive) {
                gameObject.render(g2d);
            }
        }
    }

    public static void add(GameObject gameObject){
        newGameObjects.add(gameObject);
    }

//
//    public void setTransparent(BufferedImage image){
//        int height = image.getHeight();
//        int width = image.getWidth();
//        for (int y = 0; y < height; y++){
//            for (int x = 0; x < width; x++){
//                image.setRGB(x ,y , 0);
//            }
//        }
//    }

    public void run(Vector2D parentPosition){
        screenPosition = parentPosition.add(position);
        for (GameObject nextObject : nextGameObjects) nextObject.run(screenPosition);
    }

    public void render(Graphics2D g2d){
        if (renderer != null) {
            renderer.render(g2d, screenPosition);
        }

        for (GameObject nextGameObject : nextGameObjects){
            if (nextGameObject.isActive) nextGameObject.render(g2d);
            }
        }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public ImageRenderer getRenderer() {
        return renderer;
    }

    public void setRenderer(ImageRenderer renderer) {
        this.renderer = renderer;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
