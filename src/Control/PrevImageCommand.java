package Control;

import userinterface.ImageViewer;

public class PrevImageCommand implements ImageCommand {

    private final ImageViewer imageViewer;

    public PrevImageCommand(ImageViewer imageViewer) {
        this.imageViewer = imageViewer;
    }

    @Override
    public ImageViewer getViewer() {
        return imageViewer;
    }

    @Override
    public void execute() {
        this.getViewer().showPrevImage();
    }

}
