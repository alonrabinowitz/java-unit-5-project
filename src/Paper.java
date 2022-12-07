import processing.core.PImage;

public class Paper {
    int x,y,xs,ys, iW, iH;
    PImage p1;
    public Paper(PImage p1){
        this.p1 = p1;
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
        x = (int)(Math.random()*(600-iW));
        y = (int)(Math.random()*(600-iH));
    }
    public void act(){
        if(x < 0 || x>=600){
            reverseX();
        }
        if(y < 0 || y >= 600){
            reverseY();
        }
    }
}
