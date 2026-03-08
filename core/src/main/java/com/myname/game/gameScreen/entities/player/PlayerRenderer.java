package com.myname.game.gameScreen.entities.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayerRenderer {

    private Player player;

    public PlayerRenderer(Player player)
    {
        this.player = player;
    }

    public void render(float dt, SpriteBatch batch)
    {
        batch.draw(player.getTextureRegion(),player.getPosition().x,player.getPosition().y,player.getWidth(),player.getHeight());
    }

}
