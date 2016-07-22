package com;

import java.awt.*;

/**
 * Created by Ricardo on 14/06/2016.
 */
public interface State {

    public Color getColor();
    public int getTime();
    public void calcMove(Bug bug);

}
