package bases;

import bases.renderers.ImageRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    protected Vector2D position;
    protected ImageRenderer renderer;

    private static Vector<GameObject> gameObjects = new Vector<>();
    private static Vector<GameObject> newGameObjects = new Vector<>();

    public static void runAll(){
        for (GameObject gameObject : gameObjects){
            gameObject.run();
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics2D g2d){
        for (GameObject gameObject : gameObjects){
            gameObject.render(g2d);
        }
    }

    public static void add(GameObject gameObject){
        newGameObjects.add(gameObject);
    }


    public void setTransparent(BufferedImage image){
        int height = image.getHeight();
        int width = image.getWidth();
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                image.setRGB(x ,y , 0);
            }
        }
    }

    public GameObject() {
        position = new Vector2D();
    }

    public void run(){

    }

    public void render(Graphics2D g2d){
        renderer.render(g2d, position);
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


}
