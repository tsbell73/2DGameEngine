package tb.game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SpriteSheet {
    
    public String path;
    public int width;
    public int height;
    
    public int[] pixels;
    
    public SpriteSheet(String path){
        BufferedImage image = null;
        
        
        try {
            image = ImageIO.read(SpriteSheet.class.getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(SpriteSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(image == null){
            return;
        }
        
        this.path = path;
        this.width = image.getWidth();
        this.height = image.getHeight();
        
        pixels = image.getRGB(0,0,width,height,null,0,width);
        
        for(int i = 0; i < pixels.length;i++){
            pixels[i]=(pixels[i] & 0xff)/64;
        }
    }
}
