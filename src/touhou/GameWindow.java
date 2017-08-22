package touhou;

import bases.GameObject;
import tklibs.SpriteUtils;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpawner;
import touhou.enemies.EnemySpell;
import bases.Constraints;
import bases.FrameCounter;
import touhou.images.Background;
import touhou.images.Scene1;
import touhou.inputs.InputManager;
import touhou.players.Player;
import touhou.players.PlayerSpell;
import touhou.settings.Settings;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by huynq on 7/29/17.
 */
public class GameWindow extends Frame {
    private long lastTimeUpdate;
    private long currentTime;

    private BufferedImage blackBackground;
    private BufferedImage backbufferImage;
    private Graphics2D backbufferGraphics;

    private Scene1 level1;
    InputManager inputManager = InputManager.instance;

    public GameWindow() {
        pack();
        setupGameLoop();
        setupWindow();
        setupLevel1();
    }

    private void setupLevel1() {
        level1 = new Scene1();
        level1.init();
    }

    private void setupGameLoop() {
        lastTimeUpdate = -1;
    }

    private void setupWindow() {
        this.setSize(Settings.instance.getWindowWidth(), Settings.instance.getWindowHeight());
        this.setTitle("Touhou - Remade by Sown5ot");
        this.setVisible(true);

        this.backbufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.backbufferGraphics = (Graphics2D) this.backbufferImage.getGraphics();
        this.blackBackground = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D backgroundGraphics = (Graphics2D) this.blackBackground.getGraphics();
        backgroundGraphics.setColor(Color.black);
        backgroundGraphics.fillRect(0, 0, getWidth(), getHeight());

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

        Settings.instance.setWindowInsets(this.getInsets());
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

    private void render() {
        backbufferGraphics.drawImage(blackBackground, 0, 0, null);
        GameObject.renderAll(backbufferGraphics);
        getGraphics().drawImage(backbufferImage, 0, 0, null);
    }
}
