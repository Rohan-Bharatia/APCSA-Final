package finalproject;

import java.awt.*;
import java.awt.event.*;

public class Application
{
    private final Frame frame;
    
    public Application(String title, int with, int height)
    {
        frame = new Frame(title);
        frame.setSize(with, height);
        frame.setBackground(Color.WHITE);
    }
    
    public void run()
    {
        frame.toFront();
        frame.setVisible(true);
        
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}
