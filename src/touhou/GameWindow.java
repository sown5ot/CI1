package touhou;

import tklibs.SpriteUtils;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpawner;
import touhou.enemies.EnemySpell;
import touhou.bases.Constraints;
import touhou.bases.FrameCounter;
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

    private Graphics2D windowGraphics;
    private BufferedImage backbufferImage;
    private Graphics2D backbufferGraphics;
    private BufferedImage background;
    private int backgroundY = 2400;
    private FrameCounter enemySpawnCounter;

    Player player = new Player();
    ArrayList<PlayerSpell> playerSpells = new ArrayList<>();
    InputManager inputManager = new InputManager();

    EnemySpawner enemySpawner = new EnemySpawner();
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<EnemySpell> enemySpells = new ArrayList<>();

    public GameWindow() {
        pack(); //ép vào inset (phần người dùng nhìn được)
        background = SpriteUtils.loadImage("assets/images/background/0.png");
        //backgroundY = background.getHeight() / 2;
        player.setInputManager(inputManager);
        player.setConstraints(new Constraints(getInsets().top, 768, getInsets().left, 384));
        player.playerSpells = this.playerSpells;

        setupGameLoop();
        setupWindow();
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
        this.windowGraphics = (Graphics2D) this.getGraphics();

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
                lastTimeUpdate = System.currentTimeMillis();
            }
            currentTime = System.currentTimeMillis();
            if (currentTime - lastTimeUpdate > 17) {
                run();
                render();
                lastTimeUpdate = currentTime;
            }
        }
    }

    private void run() {
        player.run();
        for (PlayerSpell playerSpell : playerSpells) { playerSpell.run(); } /*foreach*/

        for (Enemy enemy: enemies) {
            enemy.run();
        }

        enemySpawner.spawn(enemies);
        //for (EnemySpell enemySpell : enemySpells){ enemySpell.run(); }

    }

    private void render() {
        backbufferGraphics.setColor(Color.black);
        backbufferGraphics.fillRect(0, 0, 1024, 768);
//        if (backgroundY >= 0){
//            backgroundY = background.getHeight() / 2;
//            backbufferGraphics.drawImage(background, 0, -backgroundY, null);
//        }
        backbufferGraphics.drawImage(background, 0, -backgroundY, null);
        backgroundY -= 3;

        player.render(backbufferGraphics);
        for (PlayerSpell playerSpell: playerSpells) playerSpell.render(backbufferGraphics);

        for (Enemy enemy: enemies) {
            enemy.render(backbufferGraphics);
        }
        for (EnemySpell enemySpell : enemySpells) enemySpell.render(backbufferGraphics);


        windowGraphics.drawImage(backbufferImage, 0, 0, null);
    }
}
