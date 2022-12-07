public class Paper {
    int x,y,xs,ys, iW, iH;
    public Paper(){
        this.x = x;
        this.y = y;
        this.xs = xs;
        this.ys = ys;
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
