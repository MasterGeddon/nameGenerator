package Visuell;

import java.awt.BorderLayout;

import java.awt.Container;

import java.awt.FlowLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import Generator.NameGenerator;

public class NameFrame extends JFrame {

	NameGenerator NG = new NameGenerator();

	String[][] generated;

	Container con = new Container();

	JTextArea textList = new JTextArea();

	JPanel visual = new JPanel(new BorderLayout());

	JButton gen = new JButton("Generated");

	private int width = 600;

	private int height = 400;

	private int TAwidth = 100;

	private int TAheight = 300;

	public NameFrame() {

		JFrame frame = new JFrame("Flow Layout");

//JButton button,button1, button2, button3,button4; 

//gen.addActionListener(new ActionListener() { 

//@Override 

//public void actionPerformed(ActionEvent e) { 

// TODO Auto-generated method stub 

//NG.fetzen(100); 
//
//NG.setAnzN(50); 
//
//NG.setnLang(2); 
//
//generated = NG.generate_multipleNames(NG.getAnzN(), NG.getnLang(),NG.getFetzWort()); 
//
//if(generated!=null) { 
//
//String longList="Start: \n"; 
//
// 
//
//for(String[] nameL :generated) { 
//
//String aName=""; 
//
//for(String name: nameL ) { 
//
//aName = aName+" "+name; 
//
//} 
//
//longList=longList+"\n"+aName; 
//
//} 
//
//longList=longList+"\n -------- \n"; 
//
////textList.setSize(TAwidth, TAheight); 
//
//textList.setText(longList); 
//
// 
//
//} 
//
//repaint(); 
//
//} 
//
//}); 
//
// 
//
		JScrollPane scrollableTextArea = new JScrollPane(textList);
//
//button = gen; 
//
// 
//
// 
//
// 
//
// 
//
//frame.add(button); 
//

		GenPan genpan = new GenPan();
		MainPane mP = new MainPane();
		
		frame.setLayout(new BorderLayout());
		frame.add(BorderLayout.CENTER, mP);

		frame.setSize(width, height);

		frame.setVisible(true);

	}

	public void createGUI() {

//NameFrame ng = new NameFrame(); 

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		setVisible(true);

	}

	public JTextArea getTextList() {
		return textList;
	}

	public void setTextList(JTextArea textList) {
		this.textList = textList;
	}

}

/*
 * 
 * 
 * 
 * super("Name Generator v0.0.2");
 * 
 * 
 * 
 * 
 * 
 * setLayout(new FlowLayout() );
 * 
 * setSize(width, height);
 * 
 * gen.setName("Generate Names");
 * 
 * 
 * 
 * visual.add(gen,BorderLayout.CENTER);
 * 
 * visual.add(scrollableTextArea,BorderLayout.SOUTH);
 * 
 * con.add(visual);
 * 
 * 
 * 
 * con.add(new JButton("BROOO"));
 * 
 * setContentPane(con);
 * 
 * 
 * 
 * createGUI();
 * 
 * 
 * 
 */