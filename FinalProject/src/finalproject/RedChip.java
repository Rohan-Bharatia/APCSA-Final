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
    public Color getColor()
    {
        return Color.RED;
    }
}
