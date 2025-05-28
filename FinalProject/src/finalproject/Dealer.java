package finalproject;

import java.util.ArrayList;

public class Dealer
{
    private ArrayList<Card> table;
    private ArrayList<Card> hand;
    private int bet;
    
    public Dealer()
    {
        table = new ArrayList<>();
        hand  = new ArrayList<>();
        bet   = 0;

        for (int d = 0; d < 6; ++d) // 6 decks
            for (int t = 0; t < 13; ++t) // 13 types
                for (int c = 0; c < 2; ++c) // 2 colors
                    if (c == 0)
                        for (int s = 0; s < 2; ++s) // 2 suits (1-2)
                            table.add(new Card(Card.setSuitInLoop(s), Card.setColorInLoop(c), Card.setTypeInLoop(t)));
                    else if (c == 1)
                        for (int s = 2; s < 4; ++s) // 2 suits (3-4)
                            table.add(new Card(Card.setSuitInLoop(s), Card.setColorInLoop(c), Card.setTypeInLoop(t)));
    }
    
    public void shuffle()
    {
        ArrayList<Card> list = new ArrayList<>();
        
        for (int i = 0; i < 312; ++i) // 312 cards (52 * 6)
        {
            int index = (int)(Math.random() * ((52 * 6) - i));
            list.add(table.get(index));
            table.remove(index);
        }
        
        table = list;
    }

    public int getCardSum()
    {
        int sum  = 0;
        int aces = 0;

        for (Card card : hand)
        {
            sum += card.getValue();
            if (card.getType() == CardType.ACE)
                ++aces;
        }

        // Adjust for aces (aces can be 1 or 11)
        while (sum > 21 && aces > 0)
        {
            sum -= 10;
            aces--;
        }

        return sum;
    }
    
    public void GiveCard()
    {
        hand.add(table.getLast());
        table.remove(table.size() - 1);
    }

    public void GiveCard(Player player)
    {
        player.addCard(table.getLast());
        table.remove(table.size() - 1);
    }

    public void addChip(Chip chip)
    {
        bet += chip.getValue();
    }
    
    public ArrayList<Card> getTable()
    {
        return this.table;
    }

    public ArrayList<Card> getHand()
    {
        return this.hand;
    }

    public int getBet()
    {
        return this.bet;
    }

    public void resetBet()
    {
        this.bet = 0;
    }

    public void reset()
    {
        hand.clear();
    }

    public void fixBet(int value)
    {
        this.bet += value;
    }
}
