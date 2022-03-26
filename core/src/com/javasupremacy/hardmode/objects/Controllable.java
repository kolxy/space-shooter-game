package com.javasupremacy.hardmode.objects;

public interface Controllable {
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
    public void fire();
    public void slowMode(boolean slow);
}
