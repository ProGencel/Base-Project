package com.myname.game.gameScreen.entities.player;

import static com.myname.game.gameScreen.utils.Constants.*;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.myname.game.gameScreen.entities.GameEntity;
import common.Box2DCreator;

public class Player extends GameEntity {

    private float width;
    private float height;
    private TextureRegion textureRegion;
    private Fixture mainFixture;
    private PlayerRenderer playerRenderer;

    public Player(TiledMap map, World world)
    {
        playerRenderer = new PlayerRenderer(this);
        position = new Vector2();
        setBody(map,world);
    }

    public void setBody(TiledMap map, World world)
    {
        TiledMapTileMapObject mapObject = Box2DCreator.findWantedTileMapObjectButLookingTileSetProps(map,"Objects","Player","type");

        textureRegion = mapObject.getTextureRegion();
        position.x = mapObject.getX() * UNIT_SCALE;
        position.y = mapObject.getY() * UNIT_SCALE;
        width = mapObject.getTextureRegion().getRegionWidth() * UNIT_SCALE;
        height = mapObject.getTextureRegion().getRegionHeight() * UNIT_SCALE;

        body = Box2DCreator.createBody(BodyDef.BodyType.DynamicBody,world,position,new Vector2(width,height));
        FixtureDef fdef = new FixtureDef();

        mainFixture = Box2DCreator.createFixture(body,fdef, Box2DCreator.ShapeType.Ellipse,new Vector2(width,height));
    }

    public void render(float dt, SpriteBatch batch)
    {
        playerRenderer.render(dt,batch);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Vector2 getPosition()
    {
        return position;
    }

    public TextureRegion getTextureRegion() {
        return textureRegion;
    }
}
