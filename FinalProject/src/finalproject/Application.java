package finalproject;

import java.awt.*;
import java.awt.event.*;

public class Application extends Frame
{
    private final Dealer dealer;
    private final Player player;
    
    public Application(String title, int width, int height)
    {
        setLocation(100, 100);
        setSize(width, height);
        setBackground(new Color(0, 150, 0));
        
        dealer = new Dealer();
        player = new Player();
    }
    
    public void run()
    {
        Logger.info("Blackjack game started!");
        toFront();
        setVisible(true);
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                Logger.info("Blackjack game ended!");
                System.exit(0);
            }
            
            @Override
            public void windowActivated(WindowEvent e)
            {
                setEnabled(true);
            }
            
            @Override
            public void windowDeactivated(WindowEvent e)
            {
                setEnabled(false);
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
    {}
    
    public Dealer getDealer()
    {
        return this.dealer;
    }
    
    public Player getPlayer()
    {
        return this.player;
    }
}
