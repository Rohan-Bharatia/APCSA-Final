package finalproject;

import java.awt.*;

public class Card
{
    private final CardSuit suit;
    private final CardColor col;
    private final CardType type;
    
    public Card(CardSuit suit, CardColor col, CardType type)
    {
        this.suit = suit;
        this.col  = col;
        this.type = type;
    }
    
    public void drawUp(Graphics gfx, int x, int y)
    {
        gfx.setColor(Color.WHITE);
        gfx.fillRoundRect(x, y, 100, 150, 10, 10);
        gfx.setColor(getColor());
        gfx.setFont(new Font("Arial", Font.PLAIN, 36));
        gfx.drawString(getData()[1], x + 50 - (36 / 4), y + 75 + (36 / 4));
        gfx.setFont(new Font("Arial", Font.PLAIN, 24));
        gfx.drawString(getData()[0], x + 12, y + 24 + 6);
        if (getValue() != 10)
            gfx.drawString(getData()[0], x + 100 - 24, y + 150 - 12);
        else
            gfx.drawString(getData()[0], x + 100 - 36, y + 150 - 12);
    }
    
    public void drawDown(Graphics gfx, int x, int y)
    {
        int t = 3;
        gfx.setColor(Color.WHITE);
        gfx.fillRoundRect(x, y, 100, 150, 10, 10);
        gfx.setColor(Color.BLUE);
        gfx.fillRoundRect(x + t, y + t, 100 - (t * 2), 150 - (t * 2), t, t);
    }
    
    public CardSuit getSuit()
    {
        return this.suit;
    }
    
    public static CardSuit setSuitInLoop(int s)
    {
        switch (s)
        {
            case 0  -> { return CardSuit.HEART; }
            case 1  -> { return CardSuit.DIAMOND; }
            case 2  -> { return CardSuit.SPADE; }
            case 3  -> { return CardSuit.CLUB; }
            default -> { throw new IndexOutOfBoundsException("This card suit does not exist (" + s + ")"); }
        }
    }
    
    public Color getColor()
    {
        return switch (col)
        {
            case RED   -> Color.RED;
            case BLACK -> Color.BLACK;
            default    -> Color.BLUE;
        };
    }
    
    public static CardColor setColorInLoop(int c)
    {
        switch (c)
        {
            case 0  -> { return CardColor.RED; }
            case 1  -> { return CardColor.BLACK; }
            default -> { throw new IndexOutOfBoundsException("This card color does not exist (" + c + ")"); }
        }
    }
    
    public CardType getType()
    {
        return this.type;
    }
    
    public static CardType setTypeInLoop(int t)
    {
        switch (t)
        {
            case 0  -> { return CardType.TWO; }
            case 1  -> { return CardType.THREE; }
            case 2  -> { return CardType.FOUR; }
            case 3  -> { return CardType.FIVE; }
            case 4  -> { return CardType.SIX; }
            case 5  -> { return CardType.SEVEN; }
            case 6  -> { return CardType.EIGHT; }
            case 7  -> { return CardType.NINE; }
            case 8  -> { return CardType.TEN; }
            case 9  -> { return CardType.JACK; }
            case 10 -> { return CardType.QUEEN; }
            case 11 -> { return CardType.KING; }
            case 12 -> { return CardType.ACE; }
            default -> { throw new IndexOutOfBoundsException("This card type does not exist (" + t + ")"); }
        }
    }
    
    private String[] getData() // type, suit
    {
        String st;
        switch (suit)
        {
            case HEART   -> { st = "♥"; }
            case DIAMOND -> { st = "♦"; }
            case SPADE   -> { st = "♠"; }
            case CLUB    -> { st = "♣"; }
            default      -> { st = ""; }
        }
        
        switch (type)
        {
            case TWO   -> { return new String[]{ "2",  st }; }
            case THREE -> { return new String[]{ "3",  st }; }
            case FOUR  -> { return new String[]{ "4",  st }; }
            case FIVE  -> { return new String[]{ "5",  st }; }
            case SIX   -> { return new String[]{ "6",  st }; }
            case SEVEN -> { return new String[]{ "7",  st }; }
            case EIGHT -> { return new String[]{ "8",  st }; }
            case NINE  -> { return new String[]{ "9",  st }; }
            case TEN   -> { return new String[]{ "10", st }; }
            case JACK  -> { return new String[]{ "J",  st }; }
            case QUEEN -> { return new String[]{ "Q",  st }; }
            case KING  -> { return new String[]{ "K",  st }; }
            case ACE   -> { return new String[]{ "A",  st }; }
            default    -> { return new String[]{ "",   st }; }
        }
    }
    
    public int getValue()
    {
        switch (type)
        {
            case TWO   -> { return 2; }
            case THREE -> { return 3; }
            case FOUR  -> { return 4; }
            case FIVE  -> { return 5; }
            case SIX   -> { return 6; }
            case SEVEN -> { return 7; }
            case EIGHT -> { return 8; }
            case NINE  -> { return 9; }
            case TEN   -> { return 10; }
            case JACK  -> { return 10; }
            case QUEEN -> { return 10; }
            case KING  -> { return 10; }
            case ACE   -> { return 11; }
            default    -> { return 0; }
        }

    }
}
