package finalproject;

import java.util.ArrayList;

public class Dealer
{
    private final ArrayList<Card> cards;
    
    public Dealer()
    {
        cards = new ArrayList<>();
    }
    
    public void shuffle()
    {
        ArrayList<Card> list = new ArrayList<>();
        
        for (Card card : cards)
        {
            int r = (int)(Math.random() * 52);
            if (list.get(r) == (null))
                list.set(r, card);
        }
    }
    
    public ArrayList<Card> getCards()
    {
        return this.cards;
    }
}
