import processing.core.PImage;

public class PacMan {
    int iW,iH, lives;
    double x,y,xs,ys;
    boolean up,down,left,right;
    PImage p1;
    public PacMan(double x, double y, double xs, double ys, PImage p1, int lives){
        this.x = x;
        this.y = y;
        this.xs = xs;
        this.ys = ys;
        this.p1 = p1;
        p1.resize(32, 32);
        this.iW = p1.width;
        this.iH = p1.height;
        this.lives = lives;
    }
    public void move(){

    }
    public void stopX(){
        xs = 0;
    }
    public void stopY(){
        ys = 0;
    }
    public void act(){

    }
}
