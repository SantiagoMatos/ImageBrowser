package userinterface.swing;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
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

    @Override
    public void paint(Graphics g) {
        if (image == null) {
            return;
        }
        super.paint(g);
        g.drawImage(getBufferedImage(image), offset, 0, null);
        if (offset == 0) {
            return;
        }
        if (offset < 0) {
            g.drawImage(getBufferedImage(image.getNextImage()), image.getBitmap().getWidth() + offset, 0, null);
        }
        if (offset > 0) {
            g.drawImage(getBufferedImage(image.getPrevImage()), offset - image.getBitmap().getWidth(), 0, null);
        }

    }

    private BufferedImage getBufferedImage(Image image) {
        SwingBitmap bitmap = (SwingBitmap) image.getBitmap();
        return bitmap.getBufferedImage();
    }

    private void hookEvents() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                initialPoint = e.getX();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (offset > image.getBitmap().getWidth() / 2) {
                    showPrevImage();
                } else if (offset < -image.getBitmap().getWidth() / 2) {
                    showNextImage();
                }
                offset = 0;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                offset = e.getX() - initialPoint;
                repaint();

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

}
