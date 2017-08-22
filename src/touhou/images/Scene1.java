package touhou.images;

import bases.Constraints;
import bases.GameObject;
import touhou.enemies.EnemySpawner;
import touhou.inputs.InputManager;
import touhou.players.Player;
import touhou.settings.Settings;

public class Scene1 {
    private Background background;
    private Player player;
    private EnemySpawner enemySpawner;
    private Settings settings = Settings.instance;

    public Scene1() {
        addBackground();
        addPlayer();
        enemySpawn();
    }

    private void addBackground() {
        GameObject.add(new Background());
    }

    private void addPlayer() {
        player = new Player();
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
        enemySpawner = new EnemySpawner();
        GameObject.add(enemySpawner);
    }
}
