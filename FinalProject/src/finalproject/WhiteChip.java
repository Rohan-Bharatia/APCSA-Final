package finalproject;

import java.awt.Color;

public class WhiteChip extends Chip
{
    @Override
    public int getValue()
    {
        return 10;
    }
    
    @Override
    public Color getColor()
    {
        return Color.WHITE;
    }
}
