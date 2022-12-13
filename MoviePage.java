import javax.swing.*;
//import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
public class MoviePage implements ActionListener,MouseListener
{
	
	ArrowScrollBar asb = new ArrowScrollBar();
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JPanel seats;
	JPanel panel,panel2;
	ImageIcon i;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19;
	JOptionPane op = new JOptionPane();
	JScrollPane sp;
	BasicArrowButton west,east;
	String locations[] = {"Select","Seoul","Delhi","Prayagraj","Dajeon","Gwangu"};
	JComboBox<String> lb, cn;
	String cinemas[]= {"Select","kitz movies","hello movies","new movies"};
	JButton posterSize[];
	JButton arseats[][][][]=new JButton[3][5][5][4];
	//String seat[][] = new String[9][9];
	Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	
	JButton exitButton()
	{
		JButton b = new JButton();
		b=new JButton();
		b.setText("Exit");
		b.setFont(new Font("MV Boli",Font.PLAIN,25));
		b.setBounds(100,350,100,100);
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setFocusable(false);
		b.addActionListener(this);
		return b;
	}

	JButton continueButton()
	{
		JButton b = new JButton();
		b=new JButton();
		b.setText("Explore");
		b.setFont(new Font("MV Boli",Font.PLAIN,25));
		b.setBounds(350,350,100,150);
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setFocusable(false);
		b.addActionListener(this);
		return b;
	}
	
	void transparentComponent(JComponent component)
	{
		component.setBackground(new Color(0,0,0,0));
		component.setOpaque(false);
	}
	
	void welcomePage()
	{		
		b1 = exitButton();
		b2 = continueButton();
		
		label.setText("Welcome here!");
		label.setFont(new Font("MV Boli",Font.BOLD,80));
		label.setForeground(Color.BLACK);
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Movie Reseravtion Interface");
		i = new ImageIcon("movieicon.png");
		frame.setIconImage(i.getImage());
		
		i = new ImageIcon("Nb.png");
		//Image img = i.getImage();
		Image ni = getScaledImage(i.getImage(),ss.width,ss.height);
		frame.setContentPane(new JLabel(new ImageIcon(ni)));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		
		panel = new JPanel();
		transparentComponent(panel);
		panel.setPreferredSize(new Dimension(ss.width,ss.height-300));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,300,300));
		panel.add(label);
		frame.add(panel);
		
		JPanel px = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		transparentComponent(px);
		px.setPreferredSize(new Dimension(ss.width,300));
		c.insets = new Insets(30,50,200,50);
		c.gridx=1;
		c.gridy=0;
		px.add(b1,c);
		c.gridx=2;
		c.gridy=0;
		px.add(b2,c);
		frame.add(px);
		
		frame.setSize(ss.width,ss.height);
		frame.setResizable(false);
		frame.setVisible(true);		
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
	
	void homePage()
	{
		JPanel pageS = new JPanel();
		pageS.setSize(new Dimension(ss.width-195,ss.height));
		pageS.setOpaque(false);
		pageS.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,0,0,80);
		c.gridx=0;
		
		JPanel pageScroll = new JPanel();
		pageScroll.setOpaque(false);
		pageScroll.setLayout(new FlowLayout());
		
		b3 = exitButton();
		b3.setText("Back");
		b3.addActionListener(this);
		
		frame.setLayout(new FlowLayout());		
		
		panel = new JPanel();
		transparentComponent(panel);
		panel.setPreferredSize(new Dimension(ss.width-90,50));
		panel.setLayout(new BorderLayout());
		label = new JLabel(); 
		label.setFont(new Font("Cambria",Font.BOLD,20));
		label.setText("Hello New User");
		panel.add(b3,BorderLayout.LINE_START);
		panel.add(label);
		b6 = continueButton();
		b6.setText("Settings");
		b6.addActionListener(this);
		panel.add(b6,BorderLayout.LINE_END);
		c.gridy=0;
		pageS.add(panel,c);
		
		Image type[] = new Image[2];
		i = new ImageIcon("ss.jpeg");
		Image ni = getScaledImage(i.getImage(),209,309);
		type[0] = ni;
		i = new ImageIcon("poster2.jpg");
		ni = getScaledImage(i.getImage(),209,309);
		type[1] = ni;
		
		movieTypes(" Popular",2,type,1,pageS,c,ni);
		movieTypes(" Comedy",2,type,3,pageS,c,ni);
		
		JScrollPane sp = new JScrollPane(pageS);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false);
		sp.setPreferredSize(new Dimension(ss.width-18,ss.height-60));
		sp.setBorder(BorderFactory.createEmptyBorder());
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pageScroll.add(sp);
		
		frame.add(pageScroll);
		frame.setVisible(true);
	}
	
	void movieTypes(String category, int size, Image type[], int gridY, JPanel pageS, GridBagConstraints c, Image ni) {
		panel = new JPanel();
		transparentComponent(panel);
		panel.setPreferredSize(new Dimension(ss.width-10,40));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,40,0));
		label = new JLabel(); 
		label.setFont(new Font("Cambria",Font.BOLD,20));
		label.setText(category);
		panel.add(label,BorderLayout.LINE_START);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		c.gridy=gridY;
		pageS.add(panel,c);
		
		panel = new JPanel();
		transparentComponent(panel);
		panel.setSize(new Dimension(ss.width-30,340));		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,20,4));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		posterSize = new JButton[size];
	
		for(int x=0;x<size;x++)
		{
			posterSize[x] = new JButton(new ImageIcon(type[x]));
			posterSize[x].setPreferredSize(new Dimension(type[x].getWidth(null)+20,type[x].getHeight(null)+20));
			posterSize[x].setBorderPainted(false);
			posterSize[x].setContentAreaFilled(false);
			posterSize[x].setBackground(new Color(0,0,0,0));
			posterSize[x].addMouseListener(this);
			panel.add(posterSize[x]);
		}
		JPanel mp = asb.newPanelAdd(panel);
		c.gridy=gridY+1;
		pageS.add(mp,c);
	}
	
	void page3()
	{
		JPanel pageScroll = new JPanel();
		pageScroll.setOpaque(false);
		pageScroll.setLayout(new FlowLayout());
		//pageScroll.setPreferredSize(new Dimension(ss.width-500,ss.height-150));
		
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		b4 = exitButton();
		b4.setText("Back");
		b4.addActionListener(this);
		
		panel = new JPanel();
		//transparentComponent(panel);
		panel.setPreferredSize(new Dimension(ss.width-90,50));
		panel.setLayout(new BorderLayout());
		panel.add(b4,BorderLayout.WEST);
		frame.add(panel);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,50));
		panel.setPreferredSize(new Dimension(460,ss.height-110));
		label = new JLabel();
		label.setOpaque(true);
		label.setBackground(Color.BLACK);
		i = new ImageIcon("ss.jpeg");
		Image ni = getScaledImage(i.getImage(),300,450);
		label.setPreferredSize(new Dimension(450,450));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(ni));
		panel.add(label);
		
		label = new JLabel();
		label.setText("Movie name");
		label.setFont(new Font("MV Boli",Font.BOLD,30));
		panel.add(label);
		
		b5 = continueButton(); 
		b5.setText("Buy Ticket");
		b5.addActionListener(this);
		panel.add(b5);
		frame.add(panel);
		
		panel = new JPanel();
		//transparentComponent(panel);
		panel.setSize(new Dimension(550,550));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		label = new JLabel();
		label.setPreferredSize(new Dimension(ss.width-520,70));
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setBorder(BorderFactory.createEmptyBorder());
		label.setFont(new Font("MV Boli",Font.BOLD,40));
		label.setText("This is the movie title.");
		c.gridx=0;
		c.gridy=0;
		panel.add(label,c);
		
		label = new JLabel();
		label.setPreferredSize(new Dimension(ss.width-520,70));
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setBorder(BorderFactory.createEmptyBorder());
		label.setFont(new Font("MV Boli",Font.BOLD,18));
		label.setText("Director: ");
		c.gridy=1;
		panel.add(label,c);
		
		JTextArea mtext = new JTextArea("This is movie info. All things related to the movie are listed here. Hope you find this information helpful.");
		mtext.setEditable(false);
		//mtext.setOpaque(false);
		mtext.setLineWrap(true);
		mtext.setWrapStyleWord(true);
		mtext.setColumns(30);
		mtext.setRows(10);
		//mtext.setBorder(BorderFactory.createEmptyBorder());
		mtext.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mtext.setFont(new Font("MV Boli",Font.PLAIN,25));
		c.gridy=2;
		panel.add(mtext,c);	
		//frame.add(panel);
		
		mtext = new JTextArea("This is movie info. All things related to the movie are listed here. Hope you find this information helpful.");
		mtext.setEditable(false);
		//mtext.setOpaque(false);
		mtext.setLineWrap(true);
		mtext.setWrapStyleWord(true);
		mtext.setColumns(30);
		mtext.setRows(10);
		//mtext.setBorder(BorderFactory.createEmptyBorder());
		mtext.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mtext.setFont(new Font("MV Boli",Font.PLAIN,25));
		c.gridy=3;
		panel.add(mtext,c);
		
		JScrollPane sp = new JScrollPane(panel);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false);
		sp.setPreferredSize(new Dimension(ss.width-500,ss.height-110));
		sp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pageScroll.add(sp);
		
		frame.add(pageScroll);
		
		frame.setVisible(true);
	}
	
	void movieInfo()
	{
		lb = new JComboBox<String>(locations);
		lb.setEditable(true);
		lb.setSelectedIndex(0);
		
		cn = new JComboBox<String>(cinemas);
		cn.setEditable(true);
		cn.setSelectedIndex(0);
				
		label.setText("Choose Location: ");
		label.setFont(new Font("MV Boli",Font.BOLD,25));
		label.setForeground(Color.BLACK);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-800,130));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,45));
		panel.add(label);
		panel.add(lb);
		transparentComponent(panel);
		
		label = new JLabel();
		label.setText("Choose Cinema: ");
		label.setFont(new Font("MV Boli",Font.BOLD,25));
		label.setForeground(Color.BLACK);
		
		panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(ss.width-800,130));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,45));
		panel2.add(label);
		panel2.add(cn);
		transparentComponent(panel2);
		
		frame.setLayout(new FlowLayout());
		frame.add(panel);
		frame.add(panel2);
		frame.setVisible(true);	
	}
	
	void pageSeats()
	{
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));

		b15 = exitButton();
		b15.setText("Back");
		b15.addActionListener(this);
		//b15.setPreferredSize(new Dimension(90,90));
		frame.add(b15);
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(ss.width-120,75));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-130,25));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new BorderLayout());
		label = new JLabel();
		label.setText("Date");
		panel.add(label,BorderLayout.WEST);
		label = new JLabel();
		label.setText("Time");
		panel.add(label,BorderLayout.EAST);
		panel1.add(panel);  
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-130,25));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new BorderLayout());
		label = new JLabel();
		label.setText("Movie");
		panel.add(label,BorderLayout.WEST);
		label = new JLabel();
		label.setText("Rate");
		panel.add(label,BorderLayout.EAST);
		panel1.add(panel);
		frame.add(panel1);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(220,ss.height-150));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		label = new JLabel("Streaming at");
		label.setFont(new Font("MV Boli",Font.PLAIN,25));
		panel.add(label);
		
		JButton tname[]= new JButton[5];
		tname[0] = continueButton();
		tname[0].setText("Theatre 1");
		panel.add(tname[0]);
		tname[1] = continueButton();
		tname[1].setText("Theatre 2");
		panel.add(tname[1]);
		tname[2] = continueButton();
		tname[2].setText("Theatre 3");
		panel.add(tname[2]);
		tname[3] = continueButton();
		tname[3].setText("Theatre 4");
		panel.add(tname[3]);
		tname[4] = continueButton();
		tname[4].setText("Theatre 5");
		panel.add(tname[4]);

		label = new JLabel("Date: ");
		label.setFont(new Font("MV Boli",Font.PLAIN,25));
		panel.add(label);
		
		label = new JLabel("Time ");
		label.setFont(new Font("MV Boli",Font.PLAIN,25));
		panel.add(label);
		frame.add(panel);
		
		panel1 = new JPanel();
		panel1.setOpaque(false);
		panel1.setPreferredSize(new Dimension(ss.width-250,ss.height-150));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-280,60));
		panel.setOpaque(false);
		//panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		label = new JLabel("Available");
		JButton ava = new JButton();
		ava.setPreferredSize(new Dimension(50,30));
		ava.setPreferredSize(new Dimension(25,25));
		ava.setBackground(Color.BLACK);
		ava.setBorderPainted(false);
		panel.add(ava);
		panel.add(label);
		label = new JLabel("Taken");
		JButton taken = new JButton();
		taken.setPreferredSize(new Dimension(50,30));
		taken.setPreferredSize(new Dimension(25,25));
		taken.setBackground(Color.BLACK);
		taken.setBorderPainted(false);
		panel.add(taken);
		panel.add(label);
		label = new JLabel("Selected");
		JButton select = new JButton();
		select.setPreferredSize(new Dimension(50,30));
		select.setPreferredSize(new Dimension(25,25));
		select.setBackground(Color.BLACK);
		select.setBorderPainted(false);
		panel.add(select);
		panel.add(label);
		panel1.add(panel);
	
		seatsDisplay();
		panel1.add(seats);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-280,90));
		panel.setBackground(new Color(0,0,0,0));
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,90,1));
		panel.add(new JLabel("Seats Selected:"));
		panel.add(new JLabel("Total: Rs"));
		b17 = continueButton();
		b17.setText("Buy Ticket");
		b17.addActionListener(this);
		panel.add(b17);
		panel1.add(panel);
		
		frame.add(panel1);
		//frame.add(seats);
		frame.setVisible(true);
	}
	
	void seatsDisplay()
	{
		seats = new JPanel();
		seats.setOpaque(false);
		seats.setPreferredSize(new Dimension(460,320));
		seats.setLayout(new GridLayout(3,3,20,20));
		seats.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		label = new JLabel();
		label.setPreferredSize(new Dimension(100,100));
		label.setLayout(new GridLayout(5,4,5,5));
		arseats[0][0]= new JButton[5][4];
		for(int x=0;x<arseats[0][0].length;x++)
		{
			for(int y=0;y<arseats[0][0][0].length;y++)
			{
				arseats[0][0][x][y] = new JButton();
				arseats[0][0][x][y].setBackground(Color.WHITE);
				//arseats[0][0][x][y].setBorder(new RoundedBorder(10));
				if(x<=1 || y==0 || x+y==3)
				{
					arseats[0][0][x][y].setVisible(false);
				}
				label.add(arseats[0][0][x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		label.setPreferredSize(new Dimension(100,100));
		label.setLayout(new GridLayout(5,4,5,5));
		arseats[0][1]= new JButton[5][4];
		for(int x=0;x<arseats[0][0].length;x++)
		{
			for(int y=0;y<arseats[0][0][0].length;y++)
			{
				arseats[0][1][x][y] = new JButton();
				arseats[0][1][x][y].setBackground(Color.WHITE);
				if(x+y<=1)
				{
					arseats[0][1][x][y].setVisible(false);
				}
				label.add(arseats[0][1][x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		label.setPreferredSize(new Dimension(100,100));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats02[][]= new JButton[5][4];
		for(int x=0;x<seats02.length;x++)
		{
			for(int y=0;y<seats02[0].length;y++)
			{
				seats02[x][y] = new JButton();
				seats02[x][y].setBackground(Color.WHITE);
				label.add(seats02[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		label.setPreferredSize(new Dimension(100,100));
	//	label.setOpaque(true);
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats03[][]= new JButton[5][4];
		for(int x=0;x<seats03.length;x++)
		{
			for(int y=0;y<seats03[0].length;y++)
			{
				seats03[x][y] = new JButton();
				seats03[x][y].setBackground(Color.WHITE);
				if(x<=1 && y>=2 && y-x!=1)
				{
					seats03[x][y].setVisible(false);
				}
				label.add(seats03[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		label.setPreferredSize(new Dimension(100,100));
		//label.setOpaque(true);
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats04[][]= new JButton[5][4];
		for(int x=0;x<seats04.length;x++)
		{
			for(int y=0;y<seats04[0].length;y++)
			{
				seats04[x][y] = new JButton();
				seats04[x][y].setBackground(Color.WHITE);
				if(x<=1 || y==3 || x==y)
				{
					seats04[x][y].setVisible(false);
				}
				label.add(seats04[x][y]);
			}
		}
		seats.add(label);

		label = new JLabel();
		//label.setOpaque(true);
		label.setPreferredSize(new Dimension(100,100));
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats10[][]= new JButton[5][4];
		for(int x=0;x<seats10.length;x++)
		{
			for(int y=0;y<seats10[0].length;y++)
			{
				seats10[x][y] = new JButton();
				seats10[x][y].setBackground(Color.WHITE);
				if(x==4 || y==0 || x-y==2)
				{
					seats10[x][y].setVisible(false);
				}
				label.add(seats10[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		//label.setOpaque(true);
		label.setPreferredSize(new Dimension(100,100));
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats11[][]= new JButton[5][4];
		for(int x=0;x<seats11.length;x++)
		{
			for(int y=0;y<seats11[0].length;y++)
			{
				seats11[x][y] = new JButton();
				seats11[x][y].setBackground(Color.WHITE);
				if(x==4 && y==0)
				{
					seats11[x][y].setVisible(false);
				}
				label.add(seats11[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		//label.setOpaque(true);
		label.setPreferredSize(new Dimension(100,100));
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats12[][]= new JButton[5][4];
		for(int x=0;x<seats12.length;x++)
		{
			for(int y=0;y<seats12[0].length;y++)
			{
				seats12[x][y] = new JButton();
				seats12[x][y].setBackground(Color.WHITE);
				label.add(seats12[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		//label.setOpaque(true);
		label.setPreferredSize(new Dimension(100,100));
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats13[][]= new JButton[5][4];
		for(int x=0;x<seats13.length;x++)
		{
			for(int y=0;y<seats13[0].length;y++)
			{
				seats13[x][y] = new JButton();
				seats13[x][y].setBackground(Color.WHITE);
				if(x==4 && y==3)
				{
					seats13[x][y].setVisible(false);
				}
				label.add(seats13[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		//label.setOpaque(true);
		label.setPreferredSize(new Dimension(100,100));
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats14[][]= new JButton[5][4];
		for(int x=0;x<seats14.length;x++)
		{
			for(int y=0;y<seats14[0].length;y++)
			{
				seats14[x][y] = new JButton();
				seats14[x][y].setBackground(Color.WHITE);
				if(x==4 || y==3 || x+y==5)
				{
					seats14[x][y].setVisible(false);
				}
				label.add(seats14[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		//label.setOpaque(true);
		label.setPreferredSize(new Dimension(100,100));
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats20[][]= new JButton[5][4];
		for(int x=0;x<seats20.length;x++)
		{
			for(int y=0;y<seats20[0].length;y++)
			{
				seats20[x][y] = new JButton();
				seats20[x][y].setBackground(Color.WHITE);
				if(y<=1 || x>=2 && y-x<=0 )
				{
					seats20[x][y].setVisible(false);
				}
				label.add(seats20[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		//label.setOpaque(true);
		label.setPreferredSize(new Dimension(100,100));
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats21[][]= new JButton[5][4];
		for(int x=0;x<seats21.length;x++)
		{
			for(int y=0;y<seats21[0].length;y++)
			{
				seats21[x][y] = new JButton();
				seats21[x][y].setBackground(Color.WHITE);
				if(y==x-2 && x==4 || x-y>2)
				{
					seats21[x][y].setVisible(false);
				}
				label.add(seats21[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		//label.setOpaque(true);
		label.setPreferredSize(new Dimension(100,100));
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats22[][]= new JButton[5][4];
		for(int x=0;x<seats22.length;x++)
		{
			for(int y=0;y<seats22[0].length;y++)
			{
				seats22[x][y] = new JButton();
				seats22[x][y].setBackground(Color.WHITE);
				label.add(seats22[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		//label.setOpaque(true);
		label.setPreferredSize(new Dimension(100,100));
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats23[][]= new JButton[5][4];
		for(int x=0;x<seats23.length;x++)
		{
			for(int y=0;y<seats23[0].length;y++)
			{
				seats23[x][y] = new JButton();
				seats23[x][y].setBackground(Color.WHITE);
				if(x-y<4 && x==4 || x+y>5)
				{
					seats23[x][y].setVisible(false);
				}
				label.add(seats23[x][y]);
			}
		}
		seats.add(label);
		
		label = new JLabel();
		//label.setOpaque(true);
		label.setPreferredSize(new Dimension(100,100));
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setLayout(new GridLayout(5,4,5,5));
		JButton seats24[][]= new JButton[5][4];
		for(int x=0;x<seats24.length;x++)
		{
			for(int y=0;y<seats24[0].length;y++)
			{
				seats24[x][y] = new JButton();
				seats24[x][y].setBackground(Color.WHITE);
				if(y>=2 || x>=2 && x+y>=3 )
				{
					seats24[x][y].setVisible(false);
				}
				label.add(seats24[x][y]);
			}
		}
		seats.add(label);
	}
	
	void ticketPage()
	{
		frame.setLayout(new FlowLayout());
		b18 = continueButton();
		b18.setText("Back");
		b18.addActionListener(this);
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-50,100));
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());
		panel.add(b18,BorderLayout.WEST);
		frame.add(panel);
		
		b19 = continueButton();
		b19.setText("Save your Ticket");
		b19.addActionListener(this);
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-50,100));
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());
		panel.add(b19,BorderLayout.EAST);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	void profilePage()
	{
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-250,ss.height-110));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		
		label = new JLabel();
		label.setPreferredSize(new Dimension(ss.width-300,300));
		label.setOpaque(true);
		i = new ImageIcon("ss.jpeg");
		Image ni = getScaledImage(i.getImage(),200,290);
		label.setBackground(Color.BLACK);
		label.setHorizontalAlignment(JLabel.RIGHT);
		label.setIcon(new ImageIcon(ni));
		panel.add(label);
		
		label = new JLabel();
		label.setText("Name");
		label.setFont(new Font("Cambria",Font.BOLD,20));
		//label.setOpaque(true);
		label.setSize(new Dimension(panel.getWidth(),90));
		panel.add(label);
		
		JTextField name = new JTextField();
		name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		name.setPreferredSize(new Dimension(ss.width-450,30));		
		name.setFont(new Font("MV Boli",Font.PLAIN,14));
		name.setMargin(new Insets(1,3,1,3));
		panel.add(name);
		
		label = new JLabel();
		label.setText("Phone No.");
		label.setFont(new Font("Cambria",Font.BOLD,20));
		//label.setOpaque(true);
		label.setSize(new Dimension(panel.getWidth(),90));
		panel.add(label);
		
		JTextField phone = new JTextField();
		phone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		phone.setPreferredSize(new Dimension(ss.width-450,30));		
		phone.setFont(new Font("MV Boli",Font.PLAIN,14));
		phone.setMargin(new Insets(1,3,1,3));
		panel.add(phone);
		
		label = new JLabel();
		label.setText("Email");
		label.setFont(new Font("Cambria",Font.BOLD,20));
		//label.setOpaque(true);
		label.setSize(new Dimension(panel.getWidth(),90));
		panel.add(label);
		
		JTextField email = new JTextField();
		email.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		email.setPreferredSize(new Dimension(ss.width-450,30));		
		email.setFont(new Font("MV Boli",Font.PLAIN,14));
		email.setMargin(new Insets(1,3,1,3));
		panel.add(email);
		
		b13 = continueButton();
		b13.setText("Edit");
		b13.addActionListener(this);
		panel.add(b13);
		
		b14 = continueButton();
		b14.addActionListener(this);
		b14.setText("Save");
		panel.add(b14);
		frame.add(panel);
	}
	
	void myMoviesPage()
	{
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-250,ss.height-110));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		
		label = new JLabel();
		label.setText("Bookings");
		panel.add(label);
		
		label = new JLabel();
		label.setText("Previous Bookings");
		panel.add(label);
		
		label = new JLabel();
		label.setText("Bookmarked Movies");
		panel.add(label);
				
		frame.add(panel);
	}

	void settingsPage()
	{
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-250,ss.height-110));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		
		label = new JLabel();
		label.setText("Setting options will be displayed here...");
		panel.add(label);
		
		frame.add(panel);
		
	}
	
	void privacypolicyPage()
	{
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-250,ss.height-110));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));

		label = new JLabel();
		label.setText("Privacy Polices will be displayed here...");
		panel.add(label);
		
		frame.add(panel);
	}
	
	void termsConditionPage()
	{
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(ss.width-250,ss.height-110));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		
		label = new JLabel();
		label.setText("Terms & Conditions will be displayed here...");
		panel.add(label);
		
		frame.add(panel);
	}
	
	void changeSettingsPage()
	{
		frame.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		b16 = exitButton();
		b16.setText("Back");
		b16.addActionListener(this);
		frame.add(b16);
		
		label = new JLabel();
		label.setPreferredSize(new Dimension(ss.width-120,50));
		label.setText("Profile");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font("Cambria",Font.BOLD,40));
		label.setOpaque(true);
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setBackground(Color.WHITE);
		label.setSize(new Dimension(panel.getWidth(),90));
		frame.add(label);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(220,ss.height-110));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel l = new JLabel();
		l.setOpaque(true);
		i = new ImageIcon("ss.jpeg");
		Image ni = getScaledImage(i.getImage(),180,250);
		l.setBackground(Color.BLACK);
		l.setIcon(new ImageIcon(ni));
		panel.add(l);
		
		b7 = continueButton();
		b7.setText("Profile");
		b7.addActionListener(this);
		panel.add(b7);
		
		b8 = continueButton();
		b8.setText("My Movies");
		b8.addActionListener(this);
		panel.add(b8);
		
		b9 = continueButton();
		b9.setText("Settings");
		b9.addActionListener(this);
		panel.add(b9);
		
		b10 = continueButton();
		b10.setText("Log Out");
		b10.addActionListener(this);
		panel.add(b10);
		
		b11 = continueButton();
		b11.setText("Privacy Policy");
		b11.addActionListener(this);
		panel.add(b11);
		
		b12 = continueButton();
		b12.setText("Terms & Cond.");
		b12.addActionListener(this);
		panel.add(b12);
		
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			int ans = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, 0);
			if(ans==0)
			{
				frame.dispose();
			}
			
		}
		if(e.getSource()==b2)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			homePage();
		}
		if(e.getSource()==b3)
		{
			welcomePage();
		}
		if(e.getSource()==b4)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			homePage();
		}
		if(e.getSource()==b5)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			pageSeats();
		}
		if(e.getSource()==b6)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			changeSettingsPage();
			b7.setBackground(Color.CYAN);
			profilePage();
			frame.setVisible(true);
		}
		if(e.getSource()==b7)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			changeSettingsPage();
			label.setText("Profile");
			b7.setBackground(Color.CYAN);
			profilePage();
			frame.setVisible(true);
		}
		if(e.getSource()==b8)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			changeSettingsPage();
			label.setText("My Movies");
			b8.setBackground(Color.CYAN);
			myMoviesPage();
			frame.setVisible(true);
		}
		if(e.getSource()==b9)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			changeSettingsPage();
			label.setText("Settings");
			b9.setBackground(Color.CYAN);
			settingsPage();
			frame.setVisible(true);
		}
		if(e.getSource()==b10)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			changeSettingsPage();
			label.setText("Log Out");
			b10.setBackground(Color.CYAN);
			seatsDisplay();
			frame.add(seats);
			frame.setVisible(true);
		}
		if(e.getSource()==b11)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			changeSettingsPage();
			label.setText("Privacy Policy");
			b11.setBackground(Color.CYAN);
			privacypolicyPage();
			frame.setVisible(true);
		}
		if(e.getSource()==b12)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			changeSettingsPage();
			label.setText("Terms & Condition");
			b12.setBackground(Color.CYAN);
			termsConditionPage();
			frame.setVisible(true);
		}
		if(e.getSource()==b13)
		{
			
		}
		if(e.getSource()==b14)
		{
			
		}
		if(e.getSource()==b15)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			page3();
		}
		if(e.getSource()==b16)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			homePage();
		}
		if(e.getSource()==b17)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			ticketPage();
		}
		if(e.getSource()==b18)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			pageSeats();
		}
		if(e.getSource()==b19)
		{
			
		}
	}
	
	public static void main(String args[])
	{
		
		MoviePage ob = new MoviePage();
        ob.welcomePage();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(int x=0;x<posterSize.length;x++)
		{
			if(e.getSource()==posterSize[x] && e.getClickCount()==2 || e.getClickCount()==1)
			{
				frame.getContentPane().removeAll();
				frame.repaint();
				page3();
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
