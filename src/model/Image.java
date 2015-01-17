package model;

public interface Image {

    public Bitmap getBitmap();

    public Image getPrevImage();

    public Image getNextImage();

    public void setPrevImage(Image prevImage);

    public void setNextImage(Image nextImage);

}
