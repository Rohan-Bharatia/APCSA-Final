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
    
    public void draw(Graphics gfx, int x, int y)
    {
        gfx.setColor(Color.RED);
        gfx.fillRoundRect(x, y, 100, 250, 10, 10);
        gfx.setColor(Color.WHITE);
        gfx.fillRoundRect(x + 10, y + 10, 100 - 10, 250 - 10, 10, 10);
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
        public String toString()
    {
        return type + " OF " + suit + "S"; 
    }
}
