package finalproject;

import java.util.ArrayList;

public class Dealer
{
    private final ArrayList<Card> cards;
    
    public Dealer()
    {
        cards = new ArrayList<>();
//        
        for (int t = 0; t < 13; ++t)
            for (int c = 0; c < 2; ++c)
                if (c == 0)
                    for (int s = 0; s < 2; ++s)
                        cards.add(new Card(Card.setSuitInLoop(s), Card.setColorInLoop(c), Card.setTypeInLoop(t)));
                else if (c == 1)
                    for (int s = 2; s < 4; ++s)
                        cards.add(new Card(Card.setSuitInLoop(s), Card.setColorInLoop(c), Card.setTypeInLoop(t)));
    }
    
    public void shuffle()
    {
        ArrayList<Card> list = new ArrayList<>();
        
        for (int i = 0; i < 52; i++){
            int index = (int)(Math.random() * (52 - i));
            list.add(cards.get(index));
            cards.remove(index);
        }
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
