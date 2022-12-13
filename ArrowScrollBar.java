import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;

public class ArrowScrollBar extends AbstractAction implements MouseListener
{
	private Action originalAction;
	private JComponent component;
	private String actionCommand="";
	JPanel panel2;
	JScrollPane sp;
	JButton west,east;
	ArrowScrollBar()
	{
		actionCommand = "";
	}
	private Image getScaledImage(Image si, int w,int h)
	{
		BufferedImage ri = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = ri.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(si, 0, 0, w, h, null);
		g2.dispose();
		
		return ri;
	}
	JPanel newPanelAdd(JPanel jp)
	{
		//panel2=jp;
		JPanel np =new JPanel();
		np.setOpaque(false);
		
		sp = new JScrollPane(jp);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false);
		sp.setBorder(BorderFactory.createEmptyBorder());
		sp.setPreferredSize(new Dimension(jp.getWidth()-150,jp.getHeight()));
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//sp.addComponentListener(this);
		np.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		JScrollBar h = sp.getHorizontalScrollBar();
		west = new JButton();
		west.setPreferredSize(new Dimension(45,jp.getHeight()));
		west.setBackground(new Color(0,0,0,0));
		west.setOpaque(false);
		west.setFocusable(false);
		west.setBorderPainted(false);
		//west.setText("<");
		west.setFont(new Font("Cambria",Font.BOLD,19));
		
		west.setAction(new ArrowScrollBar("<",h,"negativeUnitIncrement"));
		//west.setAction(new ArrowScrollBar("<",west,"setOpaque"));
		np.add(west);
		
		np.add(sp);
		
		east = new JButton(); 
		east.setPreferredSize(new Dimension(45,jp.getHeight()));
		east.setBackground(new Color(0,0,0,0));
		east.setOpaque(false);
		east.setFocusable(false);
		east.setBorderPainted(false);
		east.setFont(new Font("Cambria",Font.BOLD,19));
		east.setAction(new ArrowScrollBar(">",h,"positiveUnitIncrement"));
		np.add(east);
		return np;
	}
	
	/*@Override
	public void componentResized(ComponentEvent et) {
		if(et.getComponent()==sp)
		{
			int p = panel2.getWidth()*panel2.getHeight();
			//int s = sp.getWidth()*sp.getHeight();
			if(p<=0)
			{
				west.setVisible(false);
				east.setVisible(false);
			}
		}
		
	}*/
	ArrowScrollBar(String name, JComponent component, String actionKey) 	
	{ 		
		super(name); 		
		originalAction = component.getActionMap().get(actionKey); 		
		if (originalAction == null) 		
		{ 			
			String message = "no Action for action key: " + actionKey; 			
			throw new IllegalArgumentException(message); 		
		} 		
		this.component = component; 	
		
	} 	
	public void setActionCommand(String actionCommand) 	

	{ 		
		this.actionCommand = actionCommand; 	
	}
	public void actionPerformed(ActionEvent e) 	
	{ 		
		e = new ActionEvent( 			
				component, 			
				ActionEvent.ACTION_PERFORMED, 			
				actionCommand, 			
				e.getWhen(), 			
				e.getModifiers()); 		
		for(int x=0;x<=200;x++)
			{
				originalAction.actionPerformed(e);
			}
	}
	/*public static void main(String args[])
	{
		ArrowScrollBar ob = new ArrowScrollBar();
		JPanel p = new JPanel();
		p.setSize(new Dimension(180,30));
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel la[] = new JLabel[10];
		for(int x=0;x<10;x++)
		{
			la[x] = new JLabel("Hello"+x);
			la[x].setFont(new Font("MV Boli",Font.PLAIN,14));
			p.add(la[x]);
		}
		JPanel newPanel = ob.newPanelAdd(p);
		//newPanel.setPreferredSize(new Dimension(50,30));
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.add(newPanel,BorderLayout.CENTER);
		f.setVisible(true);
		
	}*/
	@Override
	public void mouseClicked(MouseEvent e) {
		
		west.setBackground(new Color(0,0,0,0));
		west.setOpaque(false);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		west.setBackground(new Color(0,0,0,0));
		west.setOpaque(false);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		west.setBackground(new Color(0,0,0,0));
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}