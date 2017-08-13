package touhou;

import bases.GameObject;
import tklibs.SpriteUtils;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpawner;
import touhou.enemies.EnemySpell;
import bases.Constraints;
import bases.FrameCounter;
import touhou.images.Background;
import touhou.inputs.InputManager;
import touhou.players.Player;
import touhou.players.PlayerSpell;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by huynq on 7/29/17.
 */
public class GameWindow extends Frame {
    private long lastTimeUpdate;
    private long currentTime;

    private BufferedImage backbufferImage;
    private Graphics2D backbufferGraphics;
    private Background background = new Background();

    Player player = new Player();
    InputManager inputManager = new InputManager();
    private EnemySpawner enemySpawner = new EnemySpawner();


    public GameWindow() {
        pack(); //ép vào inset (phần người dùng nhìn được)
        addBackground();
        addPlayer();
        enemySpawn();
        setupGameLoop();
        setupWindow();
    }

    private void enemySpawn() {
        GameObject.add(enemySpawner);
    }

    private void addBackground() {
        background.getPosition().set(384 / 2, -2342 / 2);
        GameObject.add(background);
    }

    private void addPlayer() {
        player.getPosition().set(384 / 2, 600);
        player.setInputManager(inputManager);
        player.setConstraints(new Constraints(getInsets().top, 768, getInsets().left, 384));

        GameObject.add(player);
    }

    private void setupGameLoop() {
        lastTimeUpdate = -1;
    }

    private void setupWindow() {
        this.setSize(1024, 768);

        this.setTitle("Touhou - Remade by Sown5ot");
        this.setVisible(true);

        this.backbufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.backbufferGraphics = (Graphics2D) this.backbufferImage.getGraphics();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputManager.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputManager.keyReleased(e);
            }
        });
    }

    public void loop() {
        while(true) {
            if (lastTimeUpdate == -1) {
                lastTimeUpdate = System.nanoTime();
            }
            currentTime = System.nanoTime();
            if (currentTime - lastTimeUpdate > 17000000) {
                run();
                render();
                lastTimeUpdate = currentTime;
            }
        }
    }

    private void run() {
        GameObject.runAll();
    }

    public void update(Graphics g){
        g.drawImage(backbufferImage, 0, 0, null);
    }

    private void render() {
        backbufferGraphics.setColor(Color.black);
        backbufferGraphics.fillRect(0, 0, 1024, 768);
        GameObject.renderAll(backbufferGraphics);

        repaint();
    }
}
