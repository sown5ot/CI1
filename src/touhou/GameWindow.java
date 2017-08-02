package touhou;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
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

<<<<<<< HEAD

    private BufferedImage background;
    private BufferedImage player;
    private int playerX = 384 / 2;
    private int playerY = 600;
    private int moveX;
    private int moveY;
    private int backgroundY = 0;

    public GameWindow() {
        background = SpriteUtils.loadImage("assets/images/background/0.png");
        player = SpriteUtils.loadImage("assets/images/players/straight/3.png");
=======
    private BufferedImage spells;
    private BufferedImage background;

    Player player = new Player();
    ArrayList<PlayerSpell> playerSpells = new ArrayList<>();
    InputManager inputManager = new InputManager();

    public GameWindow() {
        background = SpriteUtils.loadImage("assets/images/background/0.png");
        player.inputManager = this.inputManager;
        player.constraints = new Constraints(0, 768, 0, 384);
        player.playerSpells = this.playerSpells;
>>>>>>> shooting
        setupGameLoop();
        setupWindow();
    }

    private void setupGameLoop() {
        lastTimeUpdate = -1;
    }

    private void setupWindow() {
        this.setSize(1024, 768);
<<<<<<< HEAD
        this.setTitle("Tohou - Remade by Sown5ot");
=======
        this.setTitle("Touhou - Remade by QHuyDTVT");
>>>>>>> shooting
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
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
<<<<<<< HEAD
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    moveX = 5;
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    moveX = -5;
                }

                if (e.getKeyCode() == KeyEvent.VK_UP){
                    moveY = -5;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    moveY = 5;
                }
=======
                inputManager.keyPressed(e);
>>>>>>> shooting
            }

            @Override
            public void keyReleased(KeyEvent e) {
<<<<<<< HEAD
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    moveX = 0;
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    moveX = 0;
                }

                if (e.getKeyCode() == KeyEvent.VK_UP){
                    moveY = 0;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    moveY = 0;
                }
=======
                inputManager.keyReleased(e);
>>>>>>> shooting
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
            }
        }
    }

    private void run() {
<<<<<<< HEAD
        playerX += moveX;
        playerY += moveY;
        if (playerX < 0 || playerX > 384){
            playerX = -playerX;
        }

        if (playerY < 0 || playerY > 768){
            playerY = -playerY;
=======
        player.run();
        for (PlayerSpell playerSpell : playerSpells){
            playerSpell.run();
>>>>>>> shooting
        }
    }

    private void render() {
        backbufferGraphics.setColor(Color.black);
<<<<<<< HEAD
        backbufferGraphics.fillRect(0,0,1024,768);
        backbufferGraphics.drawImage(background, 0, backgroundY-3109+768, null);
        backgroundY +=1;
        backbufferGraphics.drawImage(player, playerX, playerY, null);
=======
        backbufferGraphics.fillRect(0, 0, 1024, 768);
        backbufferGraphics.drawImage(background, 0, 0, null);
        player.render(backbufferGraphics);

        for (PlayerSpell playerSpell : playerSpells){
            playerSpell.render(backbufferGraphics);
        }
>>>>>>> shooting

        windowGraphics.drawImage(backbufferImage, 0, 0, null);
    }
}
