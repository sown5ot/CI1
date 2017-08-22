package touhou.bosses;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.pool.GameObjectPool;
import bases.renderers.Animation;
import tklibs.SpriteUtils;
import touhou.enemies.EnemyExplosion;


public class EnemyBoss extends GameObject implements PhysicsBody {
    private BoxCollider boxCollider;
    private Animation animation;
    private int HP = 5000;
    private FrameCounter shootCounter;
    private boolean shootLock;

    public EnemyBoss(){
        super();
        animation = new Animation(10,
                false,
                SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/2.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/4.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/5.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/6.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/7.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/8.png")
                );
        shootCounter = new FrameCounter(15);
        this.renderer = animation;
        boxCollider = new BoxCollider(20, 20);
        this.nextGameObjects.add(boxCollider);
        shootLock = false;
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        //TODO: làm boss bay xuống ở cuối map
        move();
        shoot();
    }

    private void shoot() {
        if (shootCounter.run()){
            shootType1();
            shootCounter.reset();
        }
    }

    private void shootType1() {
        if (!shootLock) {
            createBulletType1();
//            shootLock = true;
        }
    }

    private void createBulletType1() {
        BossBullets bossBullet = GameObjectPool.reuse(BossBullets.class);
        bossBullet.getPosition().set(this.position);
        float speedX;
        float speedY;
        double slice = 2 * Math.PI / 360;
        for (int i = 0; i <= 360; i++) {
            double angle = slice * i;
            speedX = (float) (Math.cos(angle));
            speedY = (float) (Math.sin(angle));
            bossBullet.setDrY(speedY);
            bossBullet.setDrX(speedX);
        }
    }

    private void move() {
        if (screenPosition.y < 100){
            position.addUp(0, 3);
        }
    }

    public void getDamage(int damage) {
        HP -= damage;
        if (HP == 0) {
        this.setActive(false);
        EnemyExplosion enemyExplosion = GameObjectPool.reuse(EnemyExplosion.class);
        enemyExplosion.getPosition().set(this.screenPosition);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
