package finalproject;

import java.awt.*;
import java.awt.event.*;

public class Application extends Frame
{
    private final Dealer dealer;
    private final Player player;
    private GameState state;
    private final Chip[] chipOptions;
    private final Rectangle[] chipBounds;
    
    public Application(String title, int width, int height)
    {
        setTitle(title);
        setLocation(100, 100);
        setSize(width, height);
        setBackground(new Color(0, 150, 0));

        // Disable fullscreen
        setResizable(false);

        dealer = new Dealer();
        player = new Player();
        state  = GameState.WAITING;

        chipOptions = new Chip[4];
        chipOptions[0] = new WhiteChip();
        chipOptions[1] = new RedChip();
        chipOptions[2] = new BlueChip();
        chipOptions[3] = new BlackChip();
        
        chipBounds = new Rectangle[4];
        for (int i = 0; i < 4; ++i)
            chipBounds[i] = new Rectangle(100 + i * 100, 635, 60, 60);
        
        dealer.shuffle();
    }
    
    public void run()
    {
        dealer.GiveCard(player);
        dealer.GiveCard(player);
        state = GameState.PLAYER_TURN;
        repaint();

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

        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (state == GameState.PLAYER_TURN)
                {
                    switch (e.getKeyCode())
                    {
                        case KeyEvent.VK_H -> 
                        {
                            dealer.GiveCard(player);
                            if (player.getCardSum() > 21)
                                state = GameState.RESULT;
                            repaint();
                        }
                        case KeyEvent.VK_S ->
                        {
                            state = GameState.DEALER_TURN;

                            new Thread(() -> 
                            {
                                try
                                {
                                    dealer.GiveCard();
                                    dealer.GiveCard();
                                    repaint();
                                    Thread.sleep(850);

                                    while (dealer.getCardSum() < player.getCardSum())
                                    {
                                        dealer.GiveCard();
                                        repaint();
                                        Thread.sleep(850);
                                    }
                                }
                                catch (InterruptedException ex)
                                {
                                    Thread.currentThread().interrupt();
                                }

                                state = GameState.RESULT;
                                repaint();
                            }).start();
                        }
                    }
                }
            }
        });

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                if (state == GameState.WAITING)
                {
                    for (int i = 0; i < chipBounds.length; ++i)
                    {
                        if (chipBounds[i].contains(e.getPoint()))
                        {
                            player.addChip(chipOptions[i]);
                            repaint();
                        }
                    }
                }
            }
        });
    }
    
    @Override
    public void paint(Graphics gfx)
    {
        if (state == GameState.WAITING && player.getBet() > 0)
        {
            player.resetBet();
            dealer.GiveCard(player);
            dealer.GiveCard(player);
            state = GameState.PLAYER_TURN;
            repaint();
        }

        for (int i = dealer.getHand().size() - 1; i >= 0; --i)
            dealer.getHand().get(i).drawUp(gfx, 1100 - i * 110, 150);

        for (int i = 0; i < player.getHand().size(); ++i)
            player.getHand().get(i).drawUp(gfx, 100 + i * 110, 400);

        for (int i = 0; i < chipOptions.length; i++)
        {
            gfx.setColor(chipOptions[i].getColor());
            gfx.fillOval(chipBounds[i].x, chipBounds[i].y, chipBounds[i].width, chipBounds[i].height);

            gfx.setColor(chipOptions[i].getColor().equals(Color.BLACK) ? Color.WHITE : Color.BLACK);
            gfx.setFont(new Font("Arial", Font.BOLD, 16));
            gfx.drawString("$" + chipOptions[i].getValue(), chipBounds[i].x + (chipOptions[i].getValue() < 100 ? 15 : 10), chipBounds[i].y + 35);
        }

        int playerSum = player.getCardSum();
        int dealerSum = dealer.getCardSum();

        if (state == GameState.RESULT)
        {
            String result;
            if (playerSum > 21)
                result = "Player Busts!";
            else if (dealerSum > 21)
                result = "Dealer Busts!";
            else if (playerSum > dealerSum)
                result = "Player Wins!";
            else if (playerSum < dealerSum)
                result = "Dealer Wins!";
            else
                result = "Push (Tie)";

            gfx.setColor(Color.WHITE);
            gfx.setFont(new Font("Arial", Font.BOLD, 36));
            gfx.drawString(result, 500, 350);
        }

        gfx.setColor(Color.WHITE);
        gfx.setFont(new Font("Arial", Font.PLAIN, 36));
        gfx.drawString("Player: " + playerSum + " - $" + player.getBet(), 150, 615);
        gfx.drawString("Dealer: " + dealerSum, 1000, 100);
    }
    
    public Dealer getDealer()
    {
        return this.dealer;
    }
    
    public Player getPlayer()
    {
        return this.player;
    }
}
