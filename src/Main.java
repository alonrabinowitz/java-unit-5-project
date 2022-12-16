import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends PApplet {
    public ArrayList<Rock> rocks;
    public ArrayList<Paper> papers;
    public ArrayList<Scissors> scissors;
    public ArrayList<PacManFood> pacmanFoods;
    public ArrayList<Ghost> ghosts;
    public PacMan pacman;
    PFont font;
    final int FIGHTSIM = 0;
    final int PACMAN = 1;
    final int CHOICE = 2;
    int gameMode = CHOICE;
    int lives = 5;

    public void settings(){
        size(600,600);
    }
    public void setup(){
        papers = new ArrayList<>();
        scissors = new ArrayList<>();
        rocks = new ArrayList<>();
        pacmanFoods = new ArrayList<>();
        ghosts = new ArrayList<>();
        pacman = new PacMan(0, 0,0,0,loadImage("pacman.png"));


        font = createFont("SF Pro", 12);

        for(int i = 0; i < 30; i++){
            addRock();
            addPaper();
            addScissors();
        }
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++) {
                pacmanFoods.add(new PacManFood(36*i+28, 36*j+28, 10,color(247, 241, 81)));
            }
        }
        // Create ghosts
        for(int i = 0; i < 3; i++){
            int x = (int)(Math.random()*450+75);
            int y = (int)(Math.random()*450+75);
            int xs, ys, temp;
            temp = (int)(Math.random()*4);
            if(temp == 0){
                xs = 5;
                ys = 0;
            }else if(temp == 1){
                xs = -5;
                ys = 0;
            }else if(temp == 2){
                xs = 0;
                ys = 5;
            }else{
                xs = 0;
                ys = -5;
            }
            PImage tempImage;
            temp = (int)(Math.random()*3);
            if(temp == 0){
                tempImage = loadImage("Ghost-B.png");
            }else if(temp == 1){
                tempImage = loadImage("Ghost-O.png");
            }else {
                tempImage = loadImage("Ghost-P.png");
            }
            ghosts.add(new Ghost(x, y, xs, ys, tempImage));
        }
    }
    public void draw(){
        background(204);
        if(gameMode == FIGHTSIM){
            rps();
        } else if(gameMode == PACMAN){
            pacMan();
        } else if(gameMode == CHOICE){
            String[] buttons = {"Fight Simulator", "PacMan"};
            gameMode = JOptionPane.showOptionDialog(null, "Which game do you want to play?",
                    "Games", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null,
                    buttons, null);
        }
    }

    public void rps(){
        for(Paper currPaper : papers){
            currPaper.act();
            currPaper.move();
            image(currPaper.p1, currPaper.x, currPaper.y);
        }
        for(Scissors currScissors : scissors){
            currScissors.act();
            currScissors.move();
            image(currScissors.p1, currScissors.x, currScissors.y);
        }
        for(Rock currRock : rocks){
            currRock.act();
            currRock.move();
            image(currRock.p1, currRock.x, currRock.y);
        }
        if(keyPressed){
            if(key == 'r'){
                addRockMouse();
            }
            if(key == 'p'){
                addPaperMouse();
            }
            if(key == 's'){
                addScissorsMouse();
            }
        }
        // Paper vs. Rock
        for(Paper currP : papers){
            for(int i = rocks.size()-1; i >= 0; i--){
                Rock currR = rocks.get(i);
                if(currP.x + currP.iW >= currR.x && currP.x <= currR.x + currR.iW && currP.y + currP.iH >= currR.y && currP.y <= currR.y + currR.iH) {
                    rocks.remove(currR);
                }
            }
        }
        //Rock vs. Scissors
        for(Rock currR : rocks){
            for(int i = scissors.size()-1; i >= 0; i--){
                Scissors currS = scissors.get(i);
                if(currS.x + currS.iW >= currR.x && currS.x <= currR.x + currR.iW && currS.y + currS.iH >= currR.y && currS.y <= currR.y + currR.iH) {
                    scissors.remove(currS);
                }
            }
        }
        // Scissors vs. Paper
        for(Scissors currS : scissors){
            for(int i = papers.size()-1; i >= 0; i--){
                Paper currP = papers.get(i);
                if(currP.x + currP.iW >= currS.x && currP.x <= currS.x + currS.iW && currP.y + currP.iH >= currS.y && currP.y <= currS.y + currS.iH) {
                    papers.remove(currP);
                }
            }
        }
        fill(204);
        stroke(0);
        rect(95, 10, 100, 50);
        fill(0);
//        textFont(font);
        text("Rocks: " + rocks.size(), 100, 25);
        text("Papers: " + papers.size(), 100, 40);
        text("Scissors: " + scissors.size(), 100, 55);
    }
    public void pacMan(){
        for (PacManFood currFood : pacmanFoods) {
            fill(currFood.color);
            ellipse(currFood.x, currFood.y, currFood.size, currFood.size);
        }
        image(pacman.p1, 36*(int)pacman.x+15, 36*(int)pacman.y+15);

        pacman.y+=pacman.ys;
        pacman.x+=pacman.xs;
        if(pacman.x < 0 || pacman.x >= 15){
            pacman.stopX();
        }
        if(pacman.y < 0 || pacman.y >= 15){
            pacman.stopY();
        }
        text("Food Eaten:",pacman.p1.width, pacman.p1.height);
    }
    public void keyReleased(){
        if(key == 'w'){
            pacman.ys = -0.05;
            pacman.xs = 0;
            pacman.p1 = loadImage("PacmanUP.png");
            pacman.p1.resize(32, 32);
        }
        if(key == 'a'){
            pacman.xs = -0.05;
            pacman.ys = 0;
            pacman.p1 = loadImage("PacmanLEFT.png");
            pacman.p1.resize(32, 32);
        }
        if(key == 's'){
            pacman.ys = 0.05;
            pacman.xs = 0;
            pacman.p1 = loadImage("PacmanDOWN.png");
            pacman.p1.resize(32, 32);
        }
        if(key == 'd'){
            pacman.xs = 0.05;
            pacman.ys = 0;
            pacman.p1 = loadImage("pacman.png");
            pacman.p1.resize(32, 32);
        }

    }
    public void addRock(){
        int x = (int)(Math.random()*600);
        int y = (int)(Math.random()*600);
        int xs = (int)(Math.random()*11-5);
        int ys = (int)(Math.random()*11-5);
        if(xs==0){
            xs+=1;
        }
        if(ys==0){
            ys+=1;
        }
        rocks.add(new Rock(x,y,xs,ys,loadImage("rock.png")));
    }
    public void addRockMouse(){
        int x = mouseX;
        int y = mouseY;
        int xs = (int)(Math.random()*11-5);
        int ys = (int)(Math.random()*11-5);
        if(xs==0){
            xs+=1;
        }
        if(ys==0){
            ys+=1;
        }
        rocks.add(new Rock(x,y,xs,ys,loadImage("rock.png")));
    }
    public void addPaper(){
        int x = (int)(Math.random()*600);
        int y = (int)(Math.random()*600);
        int xs = (int)(Math.random()*11-5);
        int ys = (int)(Math.random()*11-5);
        if(xs==0){
            xs+=1;
        }
        if(ys==0){
            ys+=1;
        }
        papers.add(new Paper(x,y,xs,ys,loadImage("paper.png")));
    }
    public void addPaperMouse(){
        int xs = (int)(Math.random()*11-5);
        int ys = (int)(Math.random()*11-5);
        if(xs==0){
            xs+=1;
        }
        if(ys==0){
            ys+=1;
        }
        papers.add(new Paper(mouseX,mouseY,xs,ys,loadImage("paper.png")));
    }
    public void addScissors(){
        int x = (int)(Math.random()*600);
        int y = (int)(Math.random()*600);
        int xs = (int)(Math.random()*11-5);
        int ys = (int)(Math.random()*11-5);
        if(xs==0){
            xs+=1;
        }
        if(ys==0){
            ys+=1;
        }
        scissors.add(new Scissors(x,y,xs,ys,loadImage("scissors.png")));
    }
    public void addScissorsMouse(){
        int xs = (int)(Math.random()*11-5);
        int ys = (int)(Math.random()*11-5);
        if(xs==0){
            xs+=1;
        }
        if(ys==0){
            ys+=1;
        }
        scissors.add(new Scissors(mouseX,mouseY,xs,ys,loadImage("scissors.png")));
    }
    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
