
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 *
 * @author Christophe
 */
public class Maps {
     char [][] mapy = new char [20][20];
   char d;
 
 public Maps(){
 
 }

     public char getMaps(int r, int t) throws IOException{
     InputStreamReader gg1 =null;
            BufferedReader gg = null;
            try {
                gg1 = new InputStreamReader(new FileInputStream("/Users/Christophe/Desktop/labylevel1.txt"), Charset.forName("UTF-8"));
                gg = new BufferedReader(gg1);
            } 
            catch (FileNotFoundException ex) {};
            int i =0;
            int kar;
            int j=0;
            
   
           while ((kar=gg.read())!=-1){
               char charac = (char) kar;
               
         switch (charac) {
             case 'x':
                 mapy[i][j]= charac;
                 break;
             case 'o':
                 mapy[i][j]= charac;
                 break;
             case 'a':
                 mapy[i][j]= charac;
                 break;
             case '\n':
                 i= -1;
                 j++;
                 break;
             default:
                 break;
         }
               i++;
               
           }
           gg.close();
           gg1.close();
         d = mapy[r][t];
         return d; 
     
     }
       
    }

