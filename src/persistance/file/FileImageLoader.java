package persistance.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.Image;
import model.RealImage;
import persistance.ImageLoader;
import userinterface.swing.SwingBitmap;

public class FileImageLoader implements ImageLoader{

    private final String fileName;

    public FileImageLoader(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public Image load() {
        return new RealImage(new SwingBitmap(loadBufferedImage()));
    }

    private BufferedImage loadBufferedImage() {
        try{
            return ImageIO.read(new File(fileName));
        } catch (IOException exception){
            return null;
        }
    }
    
}
