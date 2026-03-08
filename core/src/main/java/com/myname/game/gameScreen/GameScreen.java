package com.myname.game.gameScreen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.ScreenUtils;
import com.myname.game.gameScreen.entities.HolderStatics;

public class GameScreen implements Screen {

    private MapAndCamManager manager;
    private TiledMap map;
    private SpriteBatch batch;
    private PhysicWorld world;

    private HolderStatics holderStatics;

    public GameScreen(AssetManager assetManager)
    {
        map = assetManager.get("World/World.tmx");
        batch = new SpriteBatch();
        manager = new MapAndCamManager(map,batch);
        world = new PhysicWorld(manager);
        holderStatics = new HolderStatics(map,world.getWorld());

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        world.updatePhysic(delta);
        world.render();
        ScreenUtils.clear(Color.BLACK);

        manager.camRender(delta);
        manager.mapRender(delta);

        batch.setProjectionMatrix(manager.getCamera().combined);
        batch.begin();

        holderStatics.draw(batch);

        batch.end();
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
        world.dispose();
    }
}
