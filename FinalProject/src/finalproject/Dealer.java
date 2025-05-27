package finalproject;

import java.util.ArrayList;

public class Dealer
{
    private ArrayList<Card> cards;
    
    public Dealer()
    {
        cards = new ArrayList<>();

        for (int d = 0; d < 6; ++d) // 6 decks
            for (int t = 0; t < 13; ++t) // 13 types
                for (int c = 0; c < 2; ++c) // 2 colors
                    if (c == 0)
                        for (int s = 0; s < 2; ++s) // 2 suits (1-2)
                            cards.add(new Card(Card.setSuitInLoop(s), Card.setColorInLoop(c), Card.setTypeInLoop(t)));
                    else if (c == 1)
                        for (int s = 2; s < 4; ++s) // 2 suits (3-4)
                            cards.add(new Card(Card.setSuitInLoop(s), Card.setColorInLoop(c), Card.setTypeInLoop(t)));
    }
    
    public void shuffle()
    {
        ArrayList<Card> list = new ArrayList<>();
        
        for (int i = 0; i < 312; ++i) // 312 cards (52 * 6)
        {
            int index = (int)(Math.random() * ((52 * 6) - i));
            list.add(cards.get(index));
            cards.remove(index);
        }
        
        cards = list;
    }
    
    public void GiveCard(Player player)
    {
        player.addCard(cards.getLast());
    }
    
    public ArrayList<Card> getCards()
    {
        return this.cards;
    }

}
