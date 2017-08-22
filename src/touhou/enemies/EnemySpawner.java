package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.pool.GameObjectPool;
import touhou.bosses.EnemyBoss;
import touhou.settings.Settings;

import java.util.Random;

public class EnemySpawner extends GameObject{
    private FrameCounter frameCounter;
    private Random random;
    Settings settings = Settings.instance;
    private EnemyBoss boss;

    public EnemySpawner() {
        super();
        frameCounter = new FrameCounter(100);
        random = new Random();
        boss = new EnemyBoss();
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        spawnEnemy();
    }

    private void spawnEnemy() {
        if (frameCounter.run()){
            frameCounter.reset();
            Enemy enemy = GameObjectPool.reuse(Enemy.class);
            enemy.getPosition().set(random.nextInt(settings.getGameWindowWidth()), 40);
        }
    }
}
