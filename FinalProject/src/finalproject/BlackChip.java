package finalproject;

import java.awt.Color;

public class BlackChip extends Chip
{
    @Override
    public int getValue()
    {
        return 100;
    }
    
    @Override
    public Color getColor()
    {
        return Color.BLACK;
    }
}
