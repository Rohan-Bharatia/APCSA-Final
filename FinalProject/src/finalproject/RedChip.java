package finalproject;

import java.awt.Color;

public class RedChip extends Chip
{
    @Override
    public int getValue()
    {
        return 25;
    }
    
    @Override
    Color getColor()
    {
        return Color.RED;
    }
}
