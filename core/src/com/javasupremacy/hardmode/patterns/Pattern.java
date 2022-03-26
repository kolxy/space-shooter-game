package com.javasupremacy.hardmode.patterns;

import com.badlogic.gdx.math.Rectangle;
import com.javasupremacy.hardmode.objects.EnemyLaser;

import java.util.List;

public interface Pattern {
    /**
     * Add lasers to the list.
     * @param list
     * @param hitbox
     */
    public void fire(float deltaTime, List<EnemyLaser> list, Rectangle hitbox);
}
