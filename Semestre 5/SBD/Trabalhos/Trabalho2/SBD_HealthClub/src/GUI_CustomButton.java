import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.*;

public class GUI_CustomButton extends JButton{
	
	private boolean hover;
	private Color color;
	private Color colorHover;
	private Color colorClick;
	private Color borderColor;
	private int radius = 0;
	
	public GUI_CustomButton()
	{
		//Init Color
		setColor(Color.WHITE);
		colorHover = new Color(179, 250, 160);
		colorClick = new Color(152, 184, 144);
		borderColor = new Color(30, 136, 56);
		
		setContentAreaFilled(false);
		
		//Add Mouse Event
		addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent me)
				{
					setBackground(colorHover);
					hover = true;
				}
				
				public void mouseExited(MouseEvent me)
				{
					setBackground(color);
					hover = false;
				}
				
				public void mousePressed(MouseEvent me)
				{
					setBackground(colorClick);
				}
				
				public void mouseReleased(MouseEvent me)
				{
					if(hover)
					{
						setBackground(colorHover);
					}
					else
					{
						setBackground(color);
					}
				}
			});
	}
	
	public boolean isHover()
	{
		return hover;
	}
	
	public void setHover(boolean hover)
	{
		this.hover = hover;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
		setBackground(color);
	}
	
	public Color getColorHover()
	{
		return colorHover;
	}
	
	public void setColorHover(Color colorHover)
	{
		this.colorHover = colorHover;
	}
	
	public Color getColorClick()
	{
		return colorClick;
	}
	
	public void setColorClick(Color colorClick)
	{
		this.colorClick = colorClick;
	}
	
	public Color getBorderColor()
	{
		return borderColor;
	}
	
	public void setBorderColor(Color borderColor)
	{
		this.borderColor = borderColor;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public void setRadius(int radius)
	{
		this.radius = radius;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Paint Border
		g2.setColor(borderColor);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
		g2.setColor(getBackground());
		
		// Border set 2px
		g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
		
		super.paintComponent(g);
	}
}