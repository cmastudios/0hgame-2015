package me.cmastudios.zerohour;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class RadicalHarvestPimps extends Game {

    final Random rand;

    public RadicalHarvestPimps() {
        this.rand = new Random();
    }
	@Override
	public void create () {
        this.setScreen(new SplashScreen(this));
	}

}
