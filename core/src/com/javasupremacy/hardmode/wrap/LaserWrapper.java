package com.javasupremacy.hardmode.wrap;

import com.badlogic.gdx.math.Rectangle;
import com.javasupremacy.hardmode.objects.EnemyLaser;
import com.javasupremacy.hardmode.strategy.LaserStrategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LaserWrapper {
    private float timestamp;
    private LaserStrategy currentStrategy;
    private Queue<Float> releaseTime;
    private Queue<LaserStrategy> strategyList;

    public LaserWrapper() {
        timestamp = 0;
        releaseTime = new LinkedList<>();
        strategyList = new LinkedList<>();
    }

    public void fire(float deltaTime, Rectangle hitbox, List<EnemyLaser> list, List<EnemyLaser> heavyList) {
        timestamp += deltaTime;
        if (currentStrategy == null || (!releaseTime.isEmpty() && timestamp >= releaseTime.peek())) {
            releaseTime.poll();
            currentStrategy = strategyList.poll();
        }
        currentStrategy.fire(deltaTime, hitbox, list, heavyList);
    }

    public void addLaser(float timestamp, String stratStr, String moveStr, String texture) {

        try {
            Class cls = Class.forName("com.javasupremacy.hardmode.strategy." + stratStr);
            LaserStrategy strategy = (LaserStrategy) cls.getConstructor().newInstance();
            strategy.setTexture(texture);
            strategy.setLaserMovement(moveStr);
            releaseTime.offer(timestamp);
            strategyList.offer(strategy);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
