package com.myname.game.gameScreen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    private MapAndCamManager manager;
    private SpriteBatch batch;

    public GameScreen(AssetManager assetManager)
    {
        batch = new SpriteBatch();
        manager = new MapAndCamManager(assetManager.get("World/World.tmx"),batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(Color.BLACK);

        manager.camRender(delta);
        manager.mapRender(delta);
    }

    @Override
    public void resize(int width, int height) {
        manager.resize(width, height);
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
        manager.dispose();
    }
}
