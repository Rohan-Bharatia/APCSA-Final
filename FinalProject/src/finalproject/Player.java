package finalproject;

import java.util.ArrayList;

public class Player
{
    private final ArrayList<Chip> chips;
    
    public Player()
    {
        chips = new ArrayList<>();
    }
    
    public Chip get(int idx)
    {
        return chips.get(idx);
    }
}
