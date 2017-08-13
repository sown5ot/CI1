package bases.physics;

import touhou.enemies.Enemy;
import touhou.players.Player;

import java.util.Vector;

public class PhysicsPool {
    private static Vector<PhysicsBody> physicsObjects = new Vector<>();

    public static Enemy collideWithEnemy(BoxCollider otherBox){
        for (PhysicsBody physicsObject : physicsObjects){
            if (physicsObject.isActive()){
                if (physicsObject instanceof Enemy && physicsObject.getBoxCollider().intersects(otherBox)){
                    return (Enemy) physicsObject;
                }
            }
        }
        return null;
    }

    public static Player collideWithPlayer(BoxCollider otherBox){
        for (PhysicsBody physicsObject : physicsObjects){
            if (physicsObject.isActive()){
                if (physicsObject instanceof Player && physicsObject.getBoxCollider().intersects(otherBox)){
                    return (Player) physicsObject;
                }
            }
        }
        return null;
    }

    public static void add(PhysicsBody physicsObject){
        physicsObjects.add(physicsObject);
    }
}
