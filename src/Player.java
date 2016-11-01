


import java.awt.Image;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;

/**
 *
 * @author Christophe
 */
public class Player {

    Maps q = new Maps();
    private String nom;
    private int x;
    private int y;
    private Image picture;

    //création de l'objet joueur avec nom, position aléatoire et l'image de celui-ci
    
    
public Player(String Name,int x, int y) {
this.nom = Name;
   
     int xplay1 = ThreadLocalRandom.current().nextInt(1, 19);
     int yplay1= ThreadLocalRandom.current().nextInt(1, 19);
    
        try {
            while ((q.getMaps(xplay1,yplay1)=='x')||(q.getMaps(xplay1,yplay1)=='a')){
                
                int xxplay1= ThreadLocalRandom.current().nextInt(1, 19);
                int yyplay1 = ThreadLocalRandom.current().nextInt(1, 19);
            
                xplay1= xxplay1;
                yplay1= yyplay1;
            }

             } catch (IOException ex) {
                 System.out.println("oups, IOexception");
        }
            this.x=xplay1;
            this.y=yplay1;


ImageIcon img3 = new ImageIcon ("/Users/Christophe/Desktop/player1.png");
picture = img3.getImage();
             
}    

//diverses méthodes pour obtenir l'image, le nom et les coordonnées du joueur

public Image getImage() {
return picture;
}

public String getName() {
return nom;
}

public void setX(int z) {
x=z;
}

public void setY(int a) {
y=a;
}

public int getX() {
return x;
}

public int getY() {
return y;
}

//Vérification de la nouvelle position du joueur lors d'un déplacement 

public char check() throws IOException {
  char u = q.getMaps(x,y-1);
                return u;    
}
public char check1() throws IOException {
  char u = q.getMaps(x,y+1);
                return u;    
}    
 public char check2() throws IOException {
  char u = q.getMaps(x+1,y);
                return u;    
}
 public char check3() throws IOException {
  char u = q.getMaps(x-1,y);
                return u;    
}


 //méthodes pour le changer la position du joueur lorsqu'il appuie sur le bouton correspondant
 
public void  moveUp() throws IOException{

    x=x+0;
    y=y-1;
}
public void moveDown(){

    x+=0;
    y+=1;
}
public void moveEast(){

    x+=1;
    y+=0;
}
 public void moveWest(){

    x-=1;
    y+=0;
}
 
}
