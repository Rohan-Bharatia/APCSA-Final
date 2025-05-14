package finalproject;

import java.awt.Color;

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
    
    public CardSuit getSuit()
    {
        return this.suit;
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
    
    public CardType getType()
    {
        return type;
    }
}
