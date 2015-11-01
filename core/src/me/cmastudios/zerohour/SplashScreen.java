package me.cmastudios.zerohour;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Connor on 11/1/2015.
 */
public class SplashScreen implements Screen {
    private final RadicalHarvestPimps game;
    Texture splash, hoe;
    SpriteBatch batch;
    long startTime;

    public SplashScreen(RadicalHarvestPimps game) {
        this.game = game;
        this.splash = new Texture("splash.jpg");
        this.hoe = new Texture("hoe.png");
        this.batch = new SpriteBatch();
        startTime = System.currentTimeMillis();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(splash, 0, 0);
        if (System.currentTimeMillis() - startTime > 1000) {
            batch.draw(hoe, 0, 0);
            if (Gdx.input.isTouched()) {
                this.game.setScreen(new FieldScreen(this.game));
            }
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
