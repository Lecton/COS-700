
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Test {

    public static BufferedImage original;
    public static BufferedImage copy;
    public static String source = "./image1.BMP";
    
    public static void main(String[] args) throws IOException {
        original = ImageIO.read(new File(source));
        int count = 0;
        int depth=0;
        
        for(int i = 0; i < original.getWidth();i++){
            for(int j = 0; j < original.getHeight();j++){
                depth = original.getRGB(i, j);
                ++count;
            }
        }
        System.out.println("pixels: " + count);
    }
    
    public static String intToByte(int px){
        return String.format("%8s", Integer.toString(px,2)).replace(' ', '0');
    }
}
