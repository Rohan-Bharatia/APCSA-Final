package finalproject;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Chip
{
    abstract int getValue();
    abstract Color getColor();
    abstract void draw(Graphics gfx, int x, int y);
}
