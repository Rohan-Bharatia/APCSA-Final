package finalproject;

import java.awt.Color;
import java.awt.Graphics;

public class BlueChip extends Chip
{
    @Override
    public int getValue()
    {
        return 50;
    }
    
    @Override
    public Color getColor()
    {
        return Color.BLUE;
    }
    
    @Override
    public void draw(Graphics gfx, int x, int y)
    {
        gfx.setColor(getColor());
        gfx.fillOval(x, y, 20, 20);
    }
}
