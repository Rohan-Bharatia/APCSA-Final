package finalproject;

import java.util.ArrayList;

public class Player
{
    private final ArrayList<Chip> chips;
    private final ArrayList<Card> cards;
    
    public Player()
    {
        chips = new ArrayList<>();
        cards = new ArrayList<>();
    }
    
    public void addCard(Card card)
    {
        cards.add(card);
    }
    
    public ArrayList<Chip> getChips()
    {
        return this.chips;
    }
    
    public ArrayList<Card> getCards()
    {
        return this.cards;
    }
}
