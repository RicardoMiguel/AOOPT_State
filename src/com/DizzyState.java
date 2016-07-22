package com;

import java.awt.*;

/**
 * Created by Ricardo on 14/06/2016.
 */
public class DizzyState implements State{
    public static final int TIME = 100;
    @Override
    public Color getColor() {
        return Color.red;
    }

    @Override
    public int getTime() {
        return TIME;
    }

    @Override
    public void calcMove(Bug bug) {
        double x = bug.getX();
        double y = bug.getY();
        double vx = bug.getVX();
        double vy = bug.getVY();
        x += vx/2;
        y += vy/2;

        bug.setX(x);
        bug.setY(y);
    }
}
