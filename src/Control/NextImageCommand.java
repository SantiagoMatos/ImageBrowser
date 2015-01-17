package Control;

import userinterface.ImageViewer;

public class NextImageCommand implements ImageCommand {

    private final ImageViewer imageViewer;

    public NextImageCommand(ImageViewer imageViewer) {
        this.imageViewer = imageViewer;
    }

    @Override
    public ImageViewer getViewer() {
        return imageViewer;
    }

    @Override
    public void execute() {
        this.getViewer().showNextImage();
    }

}
