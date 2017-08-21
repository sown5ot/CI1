package touhou.settings;

import java.awt.*;

public class Settings {
    private int windowWidth;
    private int windowHeight;
    private int gameWindowWidth;
    private int gameWindowHeight;
    private Insets windowInsets;

    public static final Settings instance = new Settings();

    private Settings(int windowWidth, int windowHeight, int gameWindowWidth, int gameWindowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.gameWindowWidth = gameWindowWidth;
        this.gameWindowHeight = gameWindowHeight;
        this.windowInsets = windowInsets;
    }

    private Settings(){
        this(1024, 768, 384, 768);
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getGameWindowWidth() {
        return gameWindowWidth;
    }

    public void setGameWindowWidth(int gameWindowWidth) {
        this.gameWindowWidth = gameWindowWidth;
    }

    public int getGameWindowHeight() {
        return gameWindowHeight;
    }

    public void setGameWindowHeight(int gameWindowHeight) {
        this.gameWindowHeight = gameWindowHeight;
    }

    public Insets getWindowInsets() {
        return windowInsets;
    }

    public void setWindowInsets(Insets windowInsets) {
        this.windowInsets = windowInsets;
    }
}
