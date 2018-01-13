package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener ,KeyListener {
   JButton startButton , stopButton , quitButton;
   static final int Left = 0,Down = 1, Right =2 ,Up =3;
   static final int GameLocX = 50 , GameLocY = 50 , GameWidth =700 , GameHeigh = 500 ;
   int score = 0, speed = 0;
   boolean startFlag = false;
   Snake snake;
   Food food;
   public GamePanel(){
       snake = new Snake();
       food = new Food(snake);
       startButton = new JButton("start");
       stopButton = new JButton("stop");
       setLayout(new FlowLayout(FlowLayout.LEFT));
       this.add(startButton);
       this.add(stopButton);
       startButton.addActionListener(this);
       stopButton.addActionListener(this);
       stopButton.setEnabled(false);
       this.addKeyListener(this);
       new Thread(new snakeThread()).start();

    }
    public void paint(Graphics g){
       super.paint(g);
       g.setColor(Color.WHITE);
       g.fillRect(GameLocX,GameLocY,GameWidth,GameHeigh);
       g.setColor(Color.BLACK);
       g.drawRect(GameLocX,GameLocY,GameWidth,GameHeigh);
       g.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
       g.drawString("Score : "+score+" Speed : "+speed,250,25);
       food.draw(g);
       snake.draw(g);

    }
    class snakeThread implements Runnable {

        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(500-speed >=0 ? 500-speed : 0);
//                    repaint();
//                    snake.move();
//                    if(snake.isEat(food)){
//                            snake.evolve();
//                            food = new Food(snake);
//                            speed+=10;
//                            score+=100;
//                        }

                    if (startFlag){
                        repaint();
                        snake.move();
                        if(snake.isEat(food)){
                            snake.evolve(food);
                            food = new Food(snake);
                            speed+=10;
                            score+=100;
                        }
                    }

                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == startButton){
           startFlag = true;
           startButton.setEnabled(false);
           stopButton.setEnabled(true);
           this.requestFocus();
       }
       if(e.getSource() == stopButton){
           startFlag =false;
           startButton.setEnabled(true);
           stopButton.setEnabled(false);
       }

    }
    @Override
    public void keyPressed(KeyEvent e) {
       switch (e.getKeyCode()){
           case KeyEvent.VK_UP :
               if(snake.getDir()!=Down)
                   snake.changDir(Up);
               System.out.print("up");
               break;
           case KeyEvent.VK_DOWN :
               if(snake.getDir()!=Up)
                   snake.changDir(Down);
               System.out.print("down");
               break;
           case KeyEvent.VK_LEFT :
               if(snake.getDir()!=Right)
                   snake.changDir(Left);
               break;
           case KeyEvent.VK_RIGHT :
               if(snake.getDir()!=Left)
                   snake.changDir(Right);
               break;
       }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
