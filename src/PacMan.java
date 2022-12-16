import processing.core.PImage;

public class PacMan {
    int x,y,xs,ys,iW,iH;
    boolean up,down,left,right;
    PImage p1;
    public PacMan(int x, int y, int xs, int ys, PImage p1){
        this.x = x;
        this.y = y;
        this.xs = xs;
        this.ys = ys;
        this.p1 = p1;
        p1.resize(32, 32);
        this.iW = p1.width;
        this.iH = p1.height;
    }
    public void move(){
        if(up){
            y-=ys;
        }
        if(down){
            y+=ys;
        }
        if(left){
            x-=xs;
        }
        if(right){
            x+=xs;
        }
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
