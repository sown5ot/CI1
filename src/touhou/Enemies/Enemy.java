package touhou.Enemies;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
import touhou.bases.FrameCounter;
import touhou.bases.Vector2D;
import touhou.bases.renderers.ImageRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    private Vector2D position;
    private Constraints constraints;
    private FrameCounter frameCounter;
    private ImageRenderer renderer;
    public ArrayList<EnemySpell> enemySpells;

    private final int SPEED = 5;

    public Enemy() {
        position = new Vector2D(384/2, 0);
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        renderer = new ImageRenderer(image);
        frameCounter = new FrameCounter(10);
    }

    public void run(){
        if (constraints != null) {
            constraints.make(position);
        }

        position.addUp(0, SPEED);
        castSpell();

    }

    private void castSpell() {
        if (frameCounter.run()) {
            EnemySpell enemySpell = new EnemySpell();
            enemySpell.position.set(this.position);
            enemySpells.add(enemySpell);
            frameCounter.reset();
        }

    }

    public void render(Graphics2D g2d){
        renderer.render(g2d, position);
    }

    public void setConstraints(Constraints constraints){
        if (constraints == null){
            throw new IllegalArgumentException();
        } else {
            this.constraints = constraints;
        }
    }
}
