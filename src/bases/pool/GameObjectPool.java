package bases.pool;

import bases.GameObject;
import bases.Vector2D;

import java.util.ArrayList;
import java.util.Vector;

public class GameObjectPool {
    private static Vector<GameObject> objectPool = new Vector<>();

    public static <T extends GameObject> T reuse(Class<T> tClass){
        System.out.println(objectPool.size());
        for (GameObject gameObject : objectPool){
            if (gameObject.getClass().equals(tClass)){
                if (!gameObject.isActive()){
                    gameObject.reset();
                    return (T) gameObject;
                }
            }
        }
        try {
            T gameObject = tClass.newInstance();
            GameObject.add(gameObject);
            objectPool.add(gameObject);
            return gameObject;
        } catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
