package finalproject;

import java.awt.Color;
import java.awt.Graphics;

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
    
    @Override
    public void draw(Graphics gfx, int x, int y)
    {
        gfx.setColor(getColor());
        gfx.fillOval(x, y, 20, 20);
    }
}
