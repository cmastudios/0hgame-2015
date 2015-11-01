package me.cmastudios.zerohour;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created by Connor on 11/1/2015.
 */
public class FieldScreen implements Screen {
    private final RadicalHarvestPimps game;
    private final Texture bg;
    private final SpriteBatch batch;
    private final Sprite player;
    private final Sprite robber;
    private final Sprite pumpkin;
    private final Texture death;
    private Circle pCircle;

    public FieldScreen(RadicalHarvestPimps game) {
        this.game = game;
        this.bg = new Texture("field.jpg");
        this.player = new Sprite(new Texture("farmer.png"));
        this.robber = new Sprite(new Texture("robber.png"));
        this.pumpkin = new Sprite(new Texture("pumpkin.png"));
        this.death = new Texture("death.png");
        this.batch = new SpriteBatch();

        player.setCenterX(41);
        player.setCenterY(600 - 145);
        player.setScale(0.5f);
        robber.setCenterX(743);
        robber.setCenterY(600 - 463);
        robber.setScale(0.5f);
        pumpkin.setScale(0.75f);
        this.spawnPumpkin();
    }

    @Override
    public void show() {

    }

    private final float scale = 75;
    private double score = 5;
    private final float robberRatchet = 1.20f;

    private void spawnPumpkin() {
        int x = (int) (game.rand.nextInt(800));
        int y = (int) (game.rand.nextInt(600));
        pumpkin.setCenterX(x);
        pumpkin.setCenterY(y);
        pCircle = new Circle(x, y, 60f);
    }

    @Override
    public void render(float delta) {
        if (score > 0 && Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.translateY(delta*scale);
        }
        if (score > 0 && Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.translateY(-delta*scale);
        }
        if (score > 0 && Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.translateX(-delta * scale);
        }
        if (score > 0 && Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.translateX(delta*scale);
        }
        if ((pumpkin.getX() + pumpkin.getWidth() / 2.0f) < (robber.getX() + robber.getWidth() / 2.0f)) {
            robber.translateX(-delta*scale*robberRatchet);
        } else {
            robber.translateX(delta*scale*robberRatchet);
        }
        if ((pumpkin.getY() + pumpkin.getHeight() / 2.0f) < (robber.getY() + robber.getHeight() / 2.0f)) {
            robber.translateY(-delta * scale * robberRatchet);
        } else {
            robber.translateY(delta * scale * robberRatchet);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.X)) {
            this.spawnPumpkin();
        }
        if (score > 0 && pCircle.contains(player.getX() + player.getWidth()/2.0f, player.getY() + player.getHeight() / 2.0f)) {
            score++;
            this.spawnPumpkin();
        }
        if (pCircle.contains(robber.getX() + robber.getWidth()/2.0f, robber.getY() + robber.getHeight()/2.0f)) {
            score--;
            this.spawnPumpkin();
        }
        batch.begin();
        batch.draw(bg, 0, 0);
        player.draw(batch);
        robber.draw(batch);
        pumpkin.draw(batch);
        batch.end();
        if (score <= 0) {
            batch.begin();
            batch.draw(death, 0, 0);
            batch.end();
            if (Gdx.input.isTouched()) {
                game.setScreen(new SplashScreen(game));
            }
        }
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
