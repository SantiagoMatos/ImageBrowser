package model;

public class RealImage implements Image {

    private final Bitmap bitmap;
    private Image prevImage;
    private Image nextImage;

    public RealImage(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
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

}
