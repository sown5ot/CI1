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
    private int HP = 100;
    private FrameCounter shootCounter;
    private boolean shootLock;
    private FrameCounter frameCounter;

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
        shootCounter = new FrameCounter(150);
        this.renderer = animation;
        boxCollider = new BoxCollider(20, 20);
        this.nextGameObjects.add(boxCollider);
        shootLock = false;
        frameCounter = new FrameCounter(100);
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
            createBulletType1(0, 0, 0, 1);
            createBulletType1(0, 10, 0, 1);
            createBulletType1(0, 20, 0, 1);
            createBulletType1(0, 30, 0, 1);
            createBulletType1(0, 40, 0, 1);

            createBulletType1(0, 0, 0.5f, 1);
            createBulletType1(10, 0, 0.5f, 1);
            createBulletType1(20, 0, 0.5f, 1);
            createBulletType1(30, 0, 0.5f, 1);
            createBulletType1(40, 0, 0.5f, 1);
//
            createBulletType1(5, 0, 0.25f, 1);
            createBulletType1(15, 0, 0.25f, 1);
            createBulletType1(25, 0, 0.25f, 1);
            createBulletType1(35, 0, 0.25f, 1);
            createBulletType1(45, 0, 0.25f, 1);

            createBulletType1(0, 0, -0.5f, 1);
            createBulletType1(-10, 0, -0.5f, 1);
            createBulletType1(-20, 0, -0.5f, 1);
            createBulletType1(-30, 0, -0.5f, 1);
            createBulletType1(-40, 0, -0.5f, 1);

            createBulletType1(-5, 0, -0.25f, 1);
            createBulletType1(-15, 0, -0.25f, 1);
            createBulletType1(-25, 0, -0.25f, 1);
            createBulletType1(-35, 0, -0.25f, 1);
            createBulletType1(-45, 0, -0.25f, 1);
//            shootLock = true;
        }
    }

    private void createBulletType1(float posX, float posY, float speedX, float speedY) {
        BossBullets bossBullet = GameObjectPool.reuse(BossBullets.class);
        bossBullet.getPosition().set(this.position.add(posX, posY));
        bossBullet.setDrY(speedY);
        bossBullet.setDrX(speedX);
    }

    private void move() {
        if (screenPosition.y < 150) {
            position.addUp(0, 3);
            }
    }

    public void getDamage(int damage) {
        HP -= damage;
        EnemyExplosion enemyExplosion = GameObjectPool.reuse(EnemyExplosion.class);
        enemyExplosion.getPosition().set(this.screenPosition);
        if (HP <= 0) {
            this.setActive(false);
            BossExplosion bossExplosion = GameObjectPool.reuse(BossExplosion.class);
            bossExplosion.getPosition().set(this.screenPosition);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
