package persistance;

import model.Bitmap;
import model.Image;

public class ProxyImage implements Image {

    private final ImageLoader loader;
    private Image nextImage;
    private Image prevImage;
    private Image realImage;

    public ProxyImage(ImageLoader loader) {
        this.loader = loader;
    }

    @Override
    public Bitmap getBitmap() {
        checkImageLoaded();
        return realImage.getBitmap();
    }

    @Override
    public Image getPrevImage() {
        return prevImage;
    }

    @Override
    public Image getNextImage() {
        return nextImage;
    }

    @Override
    public void setPrevImage(Image prevImage) {
        this.prevImage = prevImage;
    }

    @Override
    public void setNextImage(Image nextImage) {
        this.nextImage = nextImage;
    }

    private void checkImageLoaded() {
        if (realImage != null) {
            return;
        }
        realImage = loader.load();
    }

}
