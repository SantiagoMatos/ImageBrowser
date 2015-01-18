package app;

import Control.ImageCommand;
import Control.NextImageCommand;
import Control.PrevImageCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Image;
import persistance.ImageListLoader;
import persistance.file.FileImageListLoader;
import userinterface.swing.ActionListenerFactory;
import userinterface.swing.ApplicationFrame;

public class ImageBrowser {

    private ApplicationFrame frame;
    private static String path;
    private Map<String, ImageCommand> commandMap;

    public static void main(String[] args) {
        path = "C:\\Users\\usuario\\Desktop\\carpeta";
        new ImageBrowser().execute();
    }

    private void execute() {
        ImageListLoader loader = createImageListLoader(path);
        List<Image> list = loader.load();
        frame = new ApplicationFrame(createActionListenerFactory());
        frame.getImageViewer().setImage(list.get(0));
        createCommands();
        frame.setVisible(true);
    }

    private ImageListLoader createImageListLoader(String path) {
        return new FileImageListLoader(path);
    }

    private ActionListenerFactory createActionListenerFactory() {
        return new ActionListenerFactory() {
            @Override
            public ActionListener create(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ImageCommand command = commandMap.get(action);
                        if (command == null) {
                            return;
                        }
                        command.execute();
                    }
                };
            }
        };

    }

    private void createCommands() {
        commandMap = new HashMap<>();
        commandMap.put("Next", new NextImageCommand(frame.getImageViewer()));
        commandMap.put("Prev", new PrevImageCommand(frame.getImageViewer()));
    }

}
