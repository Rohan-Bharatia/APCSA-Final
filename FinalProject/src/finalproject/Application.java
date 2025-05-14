package finalproject;

import java.awt.*;
import java.awt.event.*;

public class Application extends Frame
{
    public Application(String title, int width, int height)
    {
        setLocation(100, 100);
        setSize(width, height);
        setBackground(new Color(0, 150, 0));
    }
    
    public void run()
    {
        toFront();
        setVisible(true);
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
            
            @Override
            public void windowGainedFocus(WindowEvent e)
            {
                setEnabled(true);
            }
            
            @Override
            public void windowLostFocus(WindowEvent e)
            {
                setEnabled(false);
            }
        });
    }
    
    @Override
    public void paint(Graphics g)
    {
    }
}
