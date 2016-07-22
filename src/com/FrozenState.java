package com;

import java.awt.*;

/**
 * Created by Ricardo on 14/06/2016.
 */
public class FrozenState implements State {

    @Override
    public Color getColor() {
        return Color.yellow;
    }

    @Override
    public int getTime() {
        return 75;
    }

    @Override
    public void calcMove(Bug bug) {

    }
}
