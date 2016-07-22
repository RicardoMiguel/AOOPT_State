package com;

import java.awt.*;

/**
 * Created by Ricardo on 14/06/2016.
 */
public class NormalState implements State{

    @Override
    public Color getColor() {
        return Color.black;
    }

    @Override
    public int getTime() {
        return 0;
    }

    @Override
    public void calcMove(Bug bug) {
        double x = bug.getX();
        double y = bug.getY();
        double vx = bug.getVX();
        double vy = bug.getVY();
        x += vx;
        y += vy;
        bug.setX(x);
        bug.setY(y);

    }
}
