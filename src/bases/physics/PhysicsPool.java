package bases.physics;

import touhou.enemies.Enemy;
import touhou.players.Player;

import java.util.Vector;

public class PhysicsPool {
    private static Vector<PhysicsBody> physicsObjects = new Vector<>();

    public static <T extends PhysicsBody> T collideWith(BoxCollider otherBox, Class tClass){
        for (PhysicsBody physicsObject : physicsObjects){
            if (physicsObject.isActive()){
                if (physicsObject.getClass().equals(tClass) && physicsObject.getBoxCollider().intersects(otherBox)){
                    return (T) physicsObject;
                }
            }
        }
        return null;
    }

    public static void add(PhysicsBody physicsObject){
        physicsObjects.add(physicsObject);
    }
}
