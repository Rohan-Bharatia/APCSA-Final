package finalproject;

import java.awt.Color;
import java.awt.Graphics;

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
    
    @Override
    public void draw(Graphics gfx, int x, int y)
    {
        gfx.setColor(getColor());
        gfx.fillOval(x, y, 20, 20);
    }
}
