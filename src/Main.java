import processing.core.PApplet;
import processing.core.PFont;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends PApplet {
    public ArrayList<Rock> rocks;
    public ArrayList<Paper> papers;
    public ArrayList<Scissors> scissors;
    PFont font;
    final int FIGHTSIM = 0;
    final int PACMAN = 1;
    final int CHOICE = 2;
    int gameMode;

    public void settings(){
        size(600,600);
    }
    public void setup(){
        papers = new ArrayList<>();
        scissors = new ArrayList<>();
        rocks = new ArrayList<>();

        font = createFont("SF Pro", 12);

        for(int i = 0; i < 30; i++){
            addRock();
            addPaper();
            addScissors();
        }
    }
    public void draw(){
        // We mostly worked on the plan for extending our project with an additional game
        background(204);
        if(gameMode == FIGHTSIM){
            rps();
        } else if(gameMode == PACMAN){
            pacMan();
        } else if(gameMode == CHOICE){
            String[] buttons = {"Fight Simulator", "PacMan"};
            gameMode = JOptionPane.showOptionDialog(null, "Which game do you want to play?",
                    "Games", JOptionPane.DEFAULT_OPTION, 0, null,
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
