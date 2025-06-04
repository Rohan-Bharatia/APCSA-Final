package finalproject;

import java.util.ArrayList;

public class Player
{
    private final ArrayList<Chip> chips;
    private final ArrayList<Card> hand;
    private int bet;
    private int budget;
    
    public Player()
    {
        chips  = new ArrayList<>();
        hand   = new ArrayList<>();
        bet    = 0;
        budget = 1000;
    }
    
    public void addCard(Card card)
    {
        hand.add(card);
    }

    public void addChip(Chip chip)
    {
        if (budget >= chip.getValue()) // Only allow bet if enough budget
        {
            chips.add(chip);
            bet += chip.getValue();
            budget -= chip.getValue();
        }
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
    
    public ArrayList<Chip> getChips()
    {
        return this.chips;
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
        chips.clear();
        this.bet = 0;
    }

    public void reset()
    {
        hand.clear();
        chips.clear();
    }

    public void fixBet(int value)
    {
        this.bet    += value * 2;
        this.budget += this.bet;
        chips.clear();
    }
}
