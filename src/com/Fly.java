package com;

import java.awt.*;

class Fly implements Bug{
    private final double k = 0.01;
    private double x, y; // fly position
    private double vx, vy; // fly velocity
    private State currentState;


    private int time=0;

    public Fly()	{
        x = Math.random();
        y = Math.random();
        vx = k*(Math.random() - Math.random());
        vy = k*(Math.random() - Math.random());
        currentState = new NormalState();
    }

    public void draw(Graphics g) {
        g.setColor(currentState.getColor());
        Rectangle rc = g.getClipBounds();
        int a = (int)(x*rc.getWidth()),
                b = (int)(y*rc.getHeight());
        g.fillOval(a, b, 5, 5);
    }

    public void move() {
        if (time > 0) {
            if(currentState instanceof NormalState){
                currentState = new DizzyState();
            }
            -- time;
        } else {
            if(currentState instanceof DizzyState){
                currentState = new FrozenState();
                time+=currentState.getTime();
            } else {
                currentState = new NormalState();
            }
        }

        currentState.calcMove(this);

        if(x<0) { x = -x; vx = -vx; time+=DizzyState.TIME; }
        if(x>1) { x = 2-x;vx = -vx; time+=DizzyState.TIME;}
        if(y<0) { y = -y; vy = -vy; time+=DizzyState.TIME;}
        if(y>1) { y = 2-y;vy = -vy; time+=DizzyState.TIME;}
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    public double getVX() {
        return vx;
    }

    public void setVX(double vx) {
        this.vx = vx;
    }

    public double getVY() {
        return vy;
    }

    public void setVY(double vy) {
        this.vy = vy;
    }
}

