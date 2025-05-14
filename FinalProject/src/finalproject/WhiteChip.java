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
    Color getColor()
    {
        return Color.WHITE;
    }
}
