package touhou.images;

import bases.Constraints;
import bases.GameObject;
import touhou.bosses.EnemyBoss;
import touhou.enemies.EnemySpawner;
import touhou.inputs.InputManager;
import touhou.players.Player;
import touhou.settings.Settings;

public class Scene1 {
    private Settings settings = Settings.instance;
    private Background background = new Background();

    public void init() {
        addBackground();
        addPlayer();
//        enemySpawn();
        addBoss();
    }

    private void addBackground() {
        GameObject.add(background);
    }

    private void addPlayer() {
        Player player = new Player();
        player.setInputManager(InputManager.instance);
        player.setConstraints(new Constraints(
                settings.getWindowInsets().top,
                settings.getGameWindowHeight(),
                settings.getWindowInsets().left,
                settings.getGameWindowWidth())
        );
        player.getPosition().set(384 / 2, 600);
        GameObject.add(player);
    }

    private void enemySpawn() {
        EnemySpawner enemySpawner = new EnemySpawner();
        GameObject.add(enemySpawner);
    }

    private void addBoss() {
        EnemyBoss boss = new EnemyBoss();
        boss.getPosition().set(settings.getGameWindowWidth() / 2, 0);
        GameObject.add(boss);
    }
}
