package userinterface.swing;

import java.awt.image.BufferedImage;
import model.Bitmap;

public class SwingBitmap implements Bitmap {

    private BufferedImage bufferedImage;

    public SwingBitmap(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
    
    public BufferedImage getBufferedImage(){
        return bufferedImage;
    }

    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public int getHeigth() {
        return bufferedImage.getHeight();
    }

}
