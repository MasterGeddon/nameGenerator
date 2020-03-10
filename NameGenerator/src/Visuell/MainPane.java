package Visuell;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPane extends JPanel {

	JButton gen = new JButton("Generiern");

	JButton impBut = new JButton("import");

	JButton genList = new JButton("listen");

	JButton Home = new JButton("Home");

	public MainPane() {

		setLayout(new BorderLayout());
		GenPan genP = new GenPan();
		ImportPan impP = new ImportPan();

		JPanel buttonPane = new JPanel();
		buttonPane.setVisible(true);
		buttonPane.setLayout(new GridLayout());
		JPanel mainFace = new JPanel();

		gen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				genP.setVisible(true);
				impP.setVisible(false);
				repaint();

			}
		});

		impBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				genP.setVisible(false);
				impP.setVisible(true);
				repaint();

			}
		});

		genList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				genP.setVisible(false);
				impP.setVisible(false);

				repaint();

			}
		});

		Home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				genP.setVisible(false);
				impP.setVisible(false);
				repaint();

			}
		});

		buttonPane.add(Home);
		buttonPane.add(gen);
		buttonPane.add(impBut);
		buttonPane.add(genList);

		mainFace.add(genP);
		mainFace.add(impP);

		add(buttonPane, BorderLayout.NORTH);
		add(mainFace, BorderLayout.CENTER);

		mainFace.setVisible(true);
		setVisible(true);
		revalidate();
		repaint();

	}

}
