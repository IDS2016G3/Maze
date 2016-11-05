

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author Christophe
 */
public class board extends JFrame implements ActionListener{
    
private int t,z;  
Player p1 =new Player("John",t,z); 
JFrame f = new JFrame();
Maps m = new Maps(); 


public static JButton bouton = new JButton("Up");
public static JButton bouton2 = new JButton("Down");
public static JButton bouton3 = new JButton("Left");
public static JButton bouton4 = new JButton("Right");
public static JButton bouton5 = new JButton("Exit");
public static JPanel b1 = new JPanel();   


   public static void main(String[] args){
   //new board();
   
   } 
  
   //Creation de la fenetre qui va contenir le labyrinthe et les commandes des mouvements du joueur
   
    public board(){
    
    f.setTitle("Nouveau Labyrinthe");
    f.setSize(640,700);
    f.setLocationRelativeTo(null);  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    b1.add(bouton);
    b1.add(bouton2);
    b1.add(bouton3);
    b1.add(bouton4);
    b1.add(bouton5);

   f.getContentPane().add(b1, BorderLayout.SOUTH);
   
    bouton.addActionListener(this);
    bouton2.addActionListener(this);
    bouton3.addActionListener(this);
    bouton4.addActionListener(this);
    bouton5.addActionListener(this);
    
    f.getContentPane().add(new grafic());

    f.setVisible(true);
  
    }
   
   //Fenêtre du message de la victoire du joueur

public class finMessage extends JPanel {
    
    public finMessage(){
    JFrame Fin = new JFrame();
    Fin.setTitle(p1.getName() +", vous avez gagné!!");
    Fin.setSize(400,400);
    Fin.setLocationRelativeTo(null);  
    Fin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Fin.setContentPane(new graficimage());
    Fin.setVisible(true);
    }
  }

    public class graficimage extends JPanel{
public void paintComponent(Graphics g){
      super.paintComponent(g);
ImageIcon img = new ImageIcon ("/Users/Christophe/Desktop/victoire.jpg");
                 Image path = img.getImage();
                 g.drawImage(path,0,0, this.getWidth(),this.getHeight(),this);
}}
    

    /*Diverses actions implémentées lorsque le joueur clique sur les boutons d'un mouvement
    *Une fois que le joueur arrive à l'arrivée, une nouvelle fenêtre s'ouvre pour dire qu'il a gagné
    */
@Override
public void actionPerformed(ActionEvent arg0){  

      if (arg0.getSource()== bouton){
          try {
              if ((p1.check()=='o')){
                  p1.moveUp();
                  f.repaint();
              }
              else if (p1.check()=='a'){
                 p1.moveUp();
                 f.repaint();
                 new finMessage();
                 f.setVisible(false);
              }
          } catch (IOException ex) {
              Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
      
      if (arg0.getSource()== bouton2){
      try {
              if (p1.check1()=='o'){
              p1.moveDown(); 
              f.repaint();
            
              }
              else if (p1.check1()=='a'){
                 p1.moveDown(); 
                 f.repaint();
                 new finMessage();
                 f.setVisible(false);
              }
              
          } catch (IOException ex) {
              Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
          }}
      
      if (arg0.getSource()== bouton4){
          try{
             if (p1.check2()=='o'){
              p1.moveEast();
              f.repaint();
           
              }
             else if (p1.check2()=='a'){
                 p1.moveEast();
                 f.repaint();
                 new finMessage();
                 f.setVisible(false);
             }
             
      } catch (IOException ex) {
              Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
          }}
      
      if (arg0.getSource()== bouton3){
      try{
             if (p1.check3()=='o'){
                 p1.moveWest();
                 f.repaint();
           
             }
             else if (p1.check3()=='a'){
                 p1.moveWest();
                 f.repaint();
                 new finMessage();
                 f.setVisible(false);
             }
             
      } catch (IOException ex) {
              Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
      } }
      
      if (arg0.getSource()== bouton5)
      { 
          System.exit(0);
      }
  
}

// Partie graphique pour le joueur et le labyrinthe

public class grafic extends JPanel {


@Override
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      char u = 0;  
      
      try {
     for (int x=0;x<20;x++){
         
     for (int y=0; y<20; y++){
         
             u = m.getMaps(x,y);
         
         switch (u) {
             case 'x':
                 ImageIcon img1 = new ImageIcon ("/Users/Christophe/Desktop/wall.png");
                 Image wall = img1.getImage();
                 g.drawImage(wall,x*32,y*32, this);
                 break;
             case 'o':
                 ImageIcon img = new ImageIcon ("/Users/Christophe/Desktop/path.png");
                 Image path = img.getImage();
                 g.drawImage(path,x*32,y*32, this);
                 break;         
             case 'a':
                 ImageIcon img2 = new ImageIcon ("/Users/Christophe/Desktop/end.png");
                 Image end = img2.getImage();
                 g.drawImage(end,x*32,y*32, this);
                 break;
             default:
                 break;
         }
}}
        } catch (Exception e) {System.out.println("oups");
         }
      g.drawImage(p1.getImage(),p1.getX()*32,p1.getY()*32,null);
  
}
}}