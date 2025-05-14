package finalproject;

import java.awt.Color;

public class BlueChip extends Chip
{
    @Override
    public int getValue()
    {
        return 50;
    }
    
    @Override
    Color getColor()
    {
        return Color.BLUE;
    }
}
