import processing.core.PImage;

public class Ghost {
    int iW, iH;
    double  x, y, xs, ys;
    PImage p1;
    public Ghost(double x, double y, double xs, double ys, PImage p1){
        this.x = x;
        this.y = y;
        this.xs = xs;
        this.ys = ys;
        this.p1 = p1;
        p1.resize(32, 32);
        this.iW = p1.width;
        this.iH = p1.height;
    }
    public void reverseX(){
        xs = -xs;
    }
    public void reverseY(){
        ys = -ys;
    }
    public void move(){
        x += xs;
        y += ys;
    }
    public void act(){
        move();
    }
}
