package Control;

import userinterface.ImageViewer;

public interface ImageCommand {

    public ImageViewer getViewer();

    public abstract void execute();

}
