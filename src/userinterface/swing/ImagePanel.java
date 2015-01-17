package userinterface.swing;

import java.awt.Graphics;
import javax.swing.JPanel;
import model.Image;
import userinterface.ImageViewer;

public class ImagePanel extends JPanel implements ImageViewer {

    private Image image;
    private int initialPoint;
    private int offset;

    public ImagePanel() {
        this.offset = 0;
        this.hookEvents();
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public void showNextImage() {
        image = image.getNextImage();
        repaint();
    }

    @Override
    public void showPrevImage() {
        image = image.getPrevImage();
        repaint();
    }

    //Incomplete
    @Override
    public void paint(Graphics g) {
        if (image == null) {
            return;
        }
        super.paint(g);
    }

    //Incomplete
    private void hookEvents() {
    }

}
