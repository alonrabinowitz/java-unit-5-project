import processing.core.PImage;

public class Ghost {
    int x, y, xs, ys, iW, iH;
    PImage p1;
    public Ghost(int x, int y, int xs, int ys, PImage p1){
        this.x = x;
        this.y = y;
        this.xs = xs;
        this.ys = ys;
        this.p1 = p1;
        p1.resize(64, 64);
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
