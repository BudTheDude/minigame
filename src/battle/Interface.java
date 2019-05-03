package battle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import exceptions.InvalidDataException;
import exceptions.InvalidNameException;

import java.io.*;

public class Interface extends JFrame{
	
	//Player1 choose options
		
		JFrame Player1choose= new JFrame();
		JLabel lblChooseName1 = new JLabel("Choose Name");
		JTextField textField1 = new JTextField();
		JButton btnDone1 = new JButton("Done");
		JLabel gold1 = new JLabel();
		JButton button = new JButton("-");
		JButton button_1 = new JButton("+");
		JButton button_2 = new JButton("-");
		JButton button_3 = new JButton("+");
		JButton button_4 = new JButton("-");
		JButton button_5 = new JButton("+");
		JButton button_6 = new JButton("-");
		JButton button_7 = new JButton("+");
		JLabel lblArcher = new JLabel("Archer");
		JLabel lblFootmen = new JLabel("Footmen");
		JLabel lblCavalry = new JLabel("Cavalry");
		JLabel lblTrebuchet = new JLabel("Trebuchet");
	
	//Player2 choose options
		JFrame Player2choose= new JFrame();
		JLabel lblChooseName2 = new JLabel("Choose Name");
		JTextField textField2 = new JTextField();
		JButton btnDone2 = new JButton("Done");
		JLabel gold2 = new JLabel();
		JButton button2 = new JButton("-");
		JButton button_12 = new JButton("+");
		JButton button_22= new JButton("-");
		JButton button_32 = new JButton("+");
		JButton button_42 = new JButton("-");
		JButton button_52 = new JButton("+");
		JButton button_62 = new JButton("-");
		JButton button_72 = new JButton("+");
		JLabel lblArcher2 = new JLabel("Archer");
		JLabel lblFootmen2 = new JLabel("Footmen");
		JLabel lblCavalry2 = new JLabel("Cavalry");
		JLabel lblTrebuchet2 = new JLabel("Trebuchet");
		
		
	//Choose fightingTroops
		JFrame fightTroops = new JFrame();
		JLabel lblChooseTroopType = new JLabel("Choose troop type:");
		JRadioButton radioArcher = new JRadioButton("Archers");
		JRadioButton radioFootmen = new JRadioButton("Footmen");
		JRadioButton radioCavalry = new JRadioButton("Cavalry");
		JRadioButton radioTrebuchet = new JRadioButton("Trebuchets");
		JLabel lblChooseNumberOf = new JLabel("Choose number of troops:");
		JButton subTroop = new JButton("-");
		JButton addTroop = new JButton("+");
		JLabel counter = new JLabel("0");
		int keyPlayer;
		int keyField;
		int maxi;
		int type;
		int nrOfTroops;
		JButton doneChoose = new JButton("DONE");
		
		
	Battlefield b = new Battlefield();
	//PlayButton
	JButton PLAYBUTTON = new JButton("PLAY");
	//ActionListener
	HandlePlay handplay = new HandlePlay();
	//Player1 name
	JLabel P1name = new JLabel("");
	//Player2 name
	JLabel P2name = new JLabel("");
	
	
	
	//ICONS
	JLabel lblArc = new JLabel();
	JLabel lblFoot = new JLabel();
	JLabel lblCal = new JLabel();
	JLabel lblTrb = new JLabel();
	JLabel lblArc_1 = new JLabel();
	JLabel lblFoot_1 = new JLabel();
	JLabel lblCal_1 = new JLabel();
	JLabel lblTrb_1 = new JLabel();
	//Info in main game
	JLabel lblFootinf = new JLabel();
	JLabel lblCalinf = new JLabel();
	JLabel lblTrbinf = new JLabel();
	JLabel lblArcinf = new JLabel();
	JLabel lblArcinf_1 = new JLabel();
	JLabel lblFootinf_1 = new JLabel();
	JLabel lblCalinf_1 = new JLabel();
	JLabel lblTrbinf_1 = new JLabel();
	
	//BATTLE TILES
	JButton place11 = new JButton();
	JButton place12 = new JButton();
	JButton place13 = new JButton();
	JButton place14 = new JButton();
	JButton place21 = new JButton();
	JButton place22 = new JButton();
	JButton place23 = new JButton();
	JButton place24 = new JButton();
	
	//Battle Info
	JLabel lblSentField11 = new JLabel();
	JLabel lblSentField12 = new JLabel();
	JLabel lblSentField13 = new JLabel();
	JLabel lblSentField14 = new JLabel();
	
	JLabel lblSentField21 = new JLabel();
	JLabel lblSentField22 = new JLabel();
	JLabel lblSentField23 = new JLabel();
	JLabel lblSentField24 = new JLabel();
	
	//BATTLE button
	JButton BATTLE = new JButton("BATTLE!");
	
	//END TURN button
	JButton btnEndTurn = new JButton("END TURN");
	
	//Buttons used to validate selections made before battle (1 for each player)
	JButton btnDone = new JButton("Done");
	JButton btnDone_1 = new JButton("Done");
	
	//Reveal button (used to reveal troops on both fighting sides
	JButton btnReveal = new JButton("Reveal");
	
	//Background image
	JLabel label = new JLabel("");
	
	//Musique
	File musicPath = new File("./src/music.wav");
	Clip clip1;
	
	
	public static void main(String[] args) {
		new Interface();
	}
	
	public Interface() {
		
		if (musicPath.exists()) {
			AudioInputStream AudioInput;
			try {
				AudioInput = AudioSystem.getAudioInputStream(musicPath);
				
				clip1 = AudioSystem.getClip();
				clip1.stop();
				clip1.close();
				clip1.open(AudioInput);

				clip1.start();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		this.setBounds(100, 100, 715, 456);
		this.setTitle("Betalfild");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//PLAY button (initial screen)
		
		PLAYBUTTON.setFont(UIManager.getFont("Button.font"));
		PLAYBUTTON.setBounds(238, 142, 203, 84);
		getContentPane().add(PLAYBUTTON);
		PLAYBUTTON.addActionListener(handplay);
		
		P1name.setBounds(12, 0, 66, 30);
		getContentPane().add(P1name);
		
		
		P2name.setBounds(637, 392, 66, 30);
		getContentPane().add(P2name);
		
		
		lblArc.setBounds(119, 55, 35, 35);
		lblArc.setIcon(new ImageIcon("./src/a.png"));
		lblArc.setVisible(false);
		lblArc.setToolTipText("Weakness aggainst trebuchets and cavalry");
		getContentPane().add(lblArc);
		
		lblFoot.setBounds(266, 55, 35, 35);
		lblFoot.setIcon(new ImageIcon("./src/f.png"));
		lblFoot.setVisible(false);
		lblFoot.setToolTipText("Weakness aggainst trebuchets and archers");
		getContentPane().add(lblFoot);
		
		lblCal.setBounds(395, 55, 35, 35);
		lblCal.setIcon(new ImageIcon("./src/c.png"));
		lblCal.setToolTipText("Weakness aggainst trebuchets");
		lblCal.setVisible(false);
		getContentPane().add(lblCal);
		
		lblTrb.setBounds(542, 55, 35, 35);
		lblTrb.setIcon(new ImageIcon("./src/t.png"));
		lblTrb.setVisible(false);
		lblTrb.setToolTipText("Weakness aggainst trebuchets");
		getContentPane().add(lblTrb);
		
		lblArc_1.setBounds(119, 322, 35, 35);
		lblArc_1.setIcon(new ImageIcon("./src/a.png"));
		lblArc_1.setVisible(false);
		lblArc_1.setToolTipText("Weakness aggainst trebuchets and cavalry");
		getContentPane().add(lblArc_1);
		
		lblFoot_1.setBounds(266, 322, 35, 35);
		lblFoot_1.setIcon(new ImageIcon("./src/f.png"));
		lblFoot_1.setVisible(false);
		lblFoot_1.setToolTipText("Weakness aggainst trebuchets and archers");
		getContentPane().add(lblFoot_1);
		
		lblCal_1.setBounds(395, 322, 35, 35);
		lblCal_1.setIcon(new ImageIcon("./src/c.png"));
		lblCal_1.setVisible(false);
		lblCal_1.setToolTipText("Weakness aggainst trebuchets");
		getContentPane().add(lblCal_1);
		
		lblTrb_1.setBounds(542, 322, 35, 35);
		lblTrb_1.setIcon(new ImageIcon("./src/t.png"));
		lblTrb_1.setVisible(false);
		lblTrb_1.setToolTipText("Weakness aggainst trebuchets");
		getContentPane().add(lblTrb_1);
		
	
		lblArcinf.setBounds(88, 68, 35, 15);
		getContentPane().add(lblArcinf);
		
		lblFootinf.setBounds(231, 68, 35, 15);
		getContentPane().add(lblFootinf);
		
		lblCalinf.setBounds(364, 68, 35, 15);
		getContentPane().add(lblCalinf);
		
		lblTrbinf.setBounds(507, 68, 35, 15);
		getContentPane().add(lblTrbinf);
		
		lblArcinf_1.setBounds(88, 332, 35, 15);
		getContentPane().add(lblArcinf_1);
		
		lblFootinf_1.setBounds(231, 332, 35, 15);
		getContentPane().add(lblFootinf_1);
		
		lblCalinf_1.setBounds(364, 332, 35, 15);
		getContentPane().add(lblCalinf_1);
		
		lblTrbinf_1.setBounds(507, 332, 35, 15);
		getContentPane().add(lblTrbinf_1);
		
		
		
		validate();
		
		P1name.setVisible(false);
		P1name.setForeground(Color.white);
		P2name.setVisible(false);
		P2name.setForeground(Color.white);
		
		btnDone1.addActionListener(handplay);

		btnDone2.addActionListener(handplay);
		button.addActionListener(handplay);
		button_1.addActionListener(handplay);
		button_2.addActionListener(handplay);
		button_3.addActionListener(handplay);
		button_4.addActionListener(handplay);
		button_5.addActionListener(handplay);
		button_6.addActionListener(handplay);
		button_7.addActionListener(handplay);

		button2.addActionListener(handplay);
		button_12.addActionListener(handplay);
		button_22.addActionListener(handplay);
		button_32.addActionListener(handplay);
		button_42.addActionListener(handplay);
		button_52.addActionListener(handplay);
		button_62.addActionListener(handplay);
		button_72.addActionListener(handplay);
		
		
		
		place11.setBounds(119, 142, 40, 40);
		place11.setVisible(false);
		place11.addActionListener(handplay);
		getContentPane().add(place11);
		
		place12.setBounds(261, 142, 40, 40);
		place12.setVisible(false);
		place12.addActionListener(handplay);
		getContentPane().add(place12);
		
		place13.setBounds(395, 142, 40, 40);
		place13.setVisible(false);
		place13.addActionListener(handplay);
		getContentPane().add(place13);
		
		place14.setBounds(542, 142, 40, 40);
		place14.setVisible(false);
		place14.addActionListener(handplay);
		getContentPane().add(place14);
		
		place21.setBounds(119, 219, 40, 40);
		place21.setVisible(false);
		place21.addActionListener(handplay);
		getContentPane().add(place21);
		
		place22.setBounds(261, 219, 40, 40);
		place22.setVisible(false);
		place22.addActionListener(handplay);
		getContentPane().add(place22);
		
		place23.setBounds(395, 219, 40, 40);
		place23.setVisible(false);
		place23.addActionListener(handplay);
		getContentPane().add(place23);
		
		place24.setBounds(542, 219, 40, 40);
		place24.setVisible(false);
		place24.addActionListener(handplay);
		getContentPane().add(place24);
		
	
		lblSentField11.setBounds(87, 158, 66, 15);
		lblSentField11.setVisible(false);
		getContentPane().add(lblSentField11);
		
		
		lblSentField12.setBounds(230, 158, 66, 15);
		lblSentField12.setVisible(false);
		getContentPane().add(lblSentField12);
		
		
		lblSentField13.setBounds(363, 158, 66, 15);
		lblSentField13.setVisible(false);
		getContentPane().add(lblSentField13);
		
		lblSentField14.setBounds(509, 158, 66, 15);
		lblSentField14.setVisible(false);
		getContentPane().add(lblSentField14);
		
		
		lblSentField21.setBounds(87, 230, 66, 15);
		getContentPane().add(lblSentField21);
		
		lblSentField22.setBounds(230, 230, 66, 15);
		getContentPane().add(lblSentField22);
		
		lblSentField23.setBounds(363, 230, 66, 15);
		getContentPane().add(lblSentField23);
		
		lblSentField24.setBounds(503, 230, 66, 15);
		getContentPane().add(lblSentField24);
		
		
		BATTLE.setBounds(589, 188, 114, 25);
		BATTLE.addActionListener(handplay);
		BATTLE.setVisible(false);
		getContentPane().add(BATTLE);
		
		
		btnEndTurn.setBounds(589, 188, 114, 25);
		btnEndTurn.addActionListener(handplay);
		btnEndTurn.setVisible(false);
		getContentPane().add(btnEndTurn);
		
		btnDone.setBounds(285, 0, 114, 25);
		btnDone.setVisible(false);
		btnDone.addActionListener(handplay);
		getContentPane().add(btnDone);
		
		btnDone_1.setBounds(285, 382, 114, 25);
		btnDone_1.addActionListener(handplay);
		btnDone_1.setVisible(false);
		getContentPane().add(btnDone_1);
		
		
		btnReveal.setBounds(589, 188, 114, 25);
		btnReveal.setVisible(false);
		btnReveal.addActionListener(handplay);
		getContentPane().add(btnReveal);
		
		
		label.setBounds(0, 0, 715, 441);
		label.setIcon(new ImageIcon("./src/jold.jpg"));
		label.setVisible(true);
		getContentPane().add(label);
		
		
		
		fightTroops.setVisible(false);
		doneChoose.addActionListener(handplay);
		radioArcher.addActionListener(handplay);
		radioFootmen.addActionListener(handplay);
		radioCavalry.addActionListener(handplay);
		radioTrebuchet.addActionListener(handplay);
		addTroop.addActionListener(handplay);
		subTroop.addActionListener(handplay);
		
		
		
	}
	public void initPlayer1(JFrame Player) {
		Player.setBounds(100, 100, 400, 400);
		Player.setTitle("PLAYER1 Choose");
		Player.setLocationRelativeTo(null);
		Player.setVisible(true);
		Player.getContentPane().setLayout(null);
		
		
		lblChooseName1.setBounds(12, 12, 104, 15);
		Player.getContentPane().add(lblChooseName1);
		
		
		textField1.setBounds(134, 10, 124, 19);
		Player.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		
		btnDone1.setBounds(134, 326, 114, 25);
		Player.getContentPane().add(btnDone1);
		
		
		gold1.setBounds(22, 28, 124, 15);
		Player.getContentPane().add(gold1);
		gold1.setText("Gold: "+b.player[1].getCurrentMoney());
		
		
		button.setBounds(55, 55, 45, 45);
		Player.getContentPane().add(button);
		
		
		button_1.setBounds(276, 55, 45, 45);
		Player.getContentPane().add(button_1);
		
		
		button_2.setBounds(55, 115, 45, 45);
		Player.getContentPane().add(button_2);
		
		
		button_3.setBounds(276, 115, 45, 45);
		Player.getContentPane().add(button_3);
		
		
		button_4.setBounds(55, 172, 45, 45);
		Player.getContentPane().add(button_4);
		
		
		button_5.setBounds(276, 172, 45, 45);
		Player.getContentPane().add(button_5);
		
		
		button_6.setBounds(55, 229, 45, 45);
		Player.getContentPane().add(button_6);
		
		
		button_7.setBounds(276, 229, 45, 45);
		Player.getContentPane().add(button_7);
		
		
		lblArcher.setBounds(152, 70, 96, 15);
		lblArcher.setToolTipText("MAX 40, Price:10");
		Player.getContentPane().add(lblArcher);
		
		
		lblFootmen.setBounds(152, 130, 90, 15);
		lblFootmen.setToolTipText("MAX 50, Price:7");
		Player.getContentPane().add(lblFootmen);
		
		
		lblCavalry.setBounds(152, 187, 80, 15);
		lblCavalry.setToolTipText("MAX 25, Price:15");
		Player.getContentPane().add(lblCavalry);
		
		
		lblTrebuchet.setBounds(152, 244, 124, 15);
		lblTrebuchet.setToolTipText("MAX 10, Price:25");
		Player.getContentPane().add(lblTrebuchet);
		
		
	}
	
	
	public void initPlayer2(JFrame Player) {
		Player.setBounds(100, 100, 400, 400);
		Player.setTitle("PLAYER2 Choose");
		Player.setLocationRelativeTo(null);
		Player.setVisible(true);
		Player.getContentPane().setLayout(null);
		
		
		lblChooseName2.setBounds(12, 12, 104, 15);
		Player.getContentPane().add(lblChooseName2);
		
		
		textField2.setBounds(134, 10, 124, 19);
		Player.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		
		btnDone2.setBounds(134, 326, 114, 25);
		Player.getContentPane().add(btnDone2);
		
		gold2.setBounds(22, 28, 124, 15);
		Player.getContentPane().add(gold2);
		gold2.setText("Gold: "+b.player[2].getCurrentMoney());
		
		button2.setBounds(55, 55, 45, 45);
		Player.getContentPane().add(button2);
		
		
		button_12.setBounds(276, 55, 45, 45);
		Player.getContentPane().add(button_12);
		
		
		button_22.setBounds(55, 115, 45, 45);
		Player.getContentPane().add(button_22);
		
		
		button_32.setBounds(276, 115, 45, 45);
		Player.getContentPane().add(button_32);
		
		
		button_42.setBounds(55, 172, 45, 45);
		Player.getContentPane().add(button_42);
		
		
		button_52.setBounds(276, 172, 45, 45);
		Player.getContentPane().add(button_52);
		
		
		button_62.setBounds(55, 229, 45, 45);
		Player.getContentPane().add(button_62);
		
		
		button_72.setBounds(276, 229, 45, 45);
		Player.getContentPane().add(button_72);
		
		
		lblArcher2.setBounds(152, 70, 96, 15);
		lblArcher2.setToolTipText("MAX 40, Price:10");
		Player.getContentPane().add(lblArcher2);
		
		
		lblFootmen2.setBounds(152, 130, 90, 15);
		lblFootmen2.setToolTipText("MAX 50, Price:7");
		Player.getContentPane().add(lblFootmen2);
		
		
		lblCavalry2.setBounds(152, 187, 80, 15);
		lblCavalry2.setToolTipText("MAX 25, Price:15");
		Player.getContentPane().add(lblCavalry2);
		
		
		lblTrebuchet2.setBounds(152, 244, 124, 15);
		lblTrebuchet2.setToolTipText("MAX 10, Price:25");
		Player.getContentPane().add(lblTrebuchet2);
		
		
		
	}
	
	
	public void initChoose(JFrame Choose) {
		
		nrOfTroops=0;
		counter.setText(""+nrOfTroops);
		Choose.setBounds(100, 100, 400, 400);
		Choose.setTitle("Choose");
		Choose.setVisible(true);
		Choose.setLocationRelativeTo(null);
		Choose.getContentPane().setLayout(null);
		
		lblChooseTroopType.setBounds(31, 12, 169, 15);
		Choose.getContentPane().add(lblChooseTroopType);
		
		radioArcher.setBounds(31, 46, 144, 23);
		Choose.getContentPane().add(radioArcher);
		
		radioFootmen.setBounds(31, 73, 144, 23);
		Choose.getContentPane().add(radioFootmen);
		
		radioCavalry.setBounds(31, 100, 144, 23);
		Choose.getContentPane().add(radioCavalry);
		
		radioTrebuchet.setBounds(31, 127, 144, 23);
		Choose.getContentPane().add(radioTrebuchet);
		
		lblChooseNumberOf.setBounds(31, 222, 207, 15);
		Choose.getContentPane().add(lblChooseNumberOf);
		
		subTroop.setBounds(95, 276, 45, 45);
		Choose.getContentPane().add(subTroop);
		
		addTroop.setBounds(246, 276, 45, 45);
		Choose.getContentPane().add(addTroop);
		
		counter.setBounds(185, 291, 66, 15);
		Choose.getContentPane().add(counter);
		
		
		doneChoose.setBounds(137, 331, 114, 25);
		Choose.getContentPane().add(doneChoose);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioArcher);
		group.add(radioFootmen);
		group.add(radioCavalry);
		group.add(radioTrebuchet);
		
		group.clearSelection();
		
	}
	public void setButtonImage(JButton butt) {
		if(type==1) {
			butt.setIcon(new ImageIcon("./src/a.png"));
			}
		else if(type==2) {
			butt.setIcon(new ImageIcon("./src/f.png"));
		}
		else if(type==3) {
			butt.setIcon(new ImageIcon("./src/c.png"));
		}
		else {
			butt.setIcon(new ImageIcon("./src/t.png"));
		}
		butt.setEnabled(false);
	}
	
	public void displayPopupMessage(final String message) {
		JOptionPane.showMessageDialog(null, message, "Popup message", JOptionPane.INFORMATION_MESSAGE);
	}
	//ActionListener
	private class HandlePlay implements ActionListener {
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==PLAYBUTTON) {
				initPlayer1(Player1choose);
				
				
			}
			if(e.getSource()==btnDone1) {
					try {
						b.getPlayer(1).setName(textField1.getText());
					b.getPlayer(1).checkSoldiers();
					P1name.setText(textField1.getText());
					Player1choose.setVisible(false);

					initPlayer2(Player2choose);

				} catch (InvalidNameException | InvalidDataException a) {
					displayPopupMessage(a.getMessage());
					}


				
			}
			if(e.getSource()==btnDone2) {
				try {
					b.getPlayer(2).setName(textField2.getText());
					b.getPlayer(2).checkSoldiers();
					P2name.setText(textField2.getText());
					P2name.setVisible(true);
					Player2choose.setVisible(false);
					PLAYBUTTON.setVisible(false);
					lblArc.setVisible(true);
					lblTrb.setVisible(true);
					lblCal.setVisible(true);
					lblFoot.setVisible(true);
					lblArc_1.setVisible(true);
					lblTrb_1.setVisible(true);
					lblCal_1.setVisible(true);
					lblFoot_1.setVisible(true);
					P1name.setVisible(true);
					lblArcinf.setText("" + b.player[1].getDivisions(1).getCurrentNrOfSoldiers());
					lblFootinf.setText("" + b.player[1].getDivisions(2).getCurrentNrOfSoldiers());
					lblCalinf.setText("" + b.player[1].getDivisions(3).getCurrentNrOfSoldiers());
					lblTrbinf.setText("" + b.player[1].getDivisions(4).getCurrentNrOfSoldiers());
					lblArcinf_1.setText("" + b.player[2].getDivisions(1).getCurrentNrOfSoldiers());
					lblFootinf_1.setText("" + b.player[2].getDivisions(2).getCurrentNrOfSoldiers());
					lblCalinf_1.setText("" + b.player[2].getDivisions(3).getCurrentNrOfSoldiers());
					lblTrbinf_1.setText("" + b.player[2].getDivisions(4).getCurrentNrOfSoldiers());

					place11.setVisible(true);
					place12.setVisible(true);
					place13.setVisible(true);
					place14.setVisible(true);
					place21.setVisible(true);
					place22.setVisible(true);
					place23.setVisible(true);
					place24.setVisible(true);

					place21.setEnabled(false);
					place22.setEnabled(false);
					place23.setEnabled(false);
					place24.setEnabled(false);

					btnDone.setVisible(true);

				} catch (InvalidNameException | InvalidDataException a) {
					displayPopupMessage(a.getMessage());
				}
				
				
				
			}
			if (e.getSource() == button) {
				b.player[1].sellSoldier(1);
				gold1.setText("Gold: " + b.player[1].getCurrentMoney());
				lblArcher.setText("Archer:" + b.player[1].getDivisions(1).getCurrentNrOfSoldiers());

			}
			if (e.getSource() == button_1) {
				b.player[1].buySoldier(1);
				gold1.setText("Gold: "+b.player[1].getCurrentMoney());
				lblArcher.setText("Archer:"+b.player[1].getDivisions(1).getCurrentNrOfSoldiers());
			}
			if (e.getSource() == button_2) {
				b.player[1].sellSoldier(2);
				gold1.setText("Gold: " + b.player[1].getCurrentMoney());
				lblFootmen.setText("Footmen:" + b.player[1].getDivisions(2).getCurrentNrOfSoldiers());

			}
			if (e.getSource() == button_3) {
				b.player[1].buySoldier(2);
				gold1.setText("Gold: "+b.player[1].getCurrentMoney());
				lblFootmen.setText("Footmen:"+b.player[1].getDivisions(2).getCurrentNrOfSoldiers());
				
			}
			if (e.getSource() == button_4) {
				b.player[1].sellSoldier(3);
				gold1.setText("Gold: " + b.player[1].getCurrentMoney());
				lblCavalry.setText("Cavalry:" + b.player[1].getDivisions(3).getCurrentNrOfSoldiers());

			}
			if (e.getSource() == button_5) {
				b.player[1].buySoldier(3);
				gold1.setText("Gold: "+b.player[1].getCurrentMoney());
				lblCavalry.setText("Cavalry:"+b.player[1].getDivisions(3).getCurrentNrOfSoldiers());
				
			}
			if (e.getSource() == button_6) {
				b.player[1].sellSoldier(4);
				gold1.setText("Gold: " + b.player[1].getCurrentMoney());
				lblTrebuchet.setText("Trebuchet:" + b.player[1].getDivisions(4).getCurrentNrOfSoldiers());

			}
			if (e.getSource() == button_7) {
				b.player[1].buySoldier(4);
				gold1.setText("Gold: "+b.player[1].getCurrentMoney());
				lblTrebuchet.setText("Trebuchet:"+b.player[1].getDivisions(4).getCurrentNrOfSoldiers());
				
			}
			if (e.getSource() == button2) {
				b.player[2].sellSoldier(1);
				gold2.setText("Gold: " + b.player[2].getCurrentMoney());
				lblArcher2.setText("Archer:" + b.player[2].getDivisions(1).getCurrentNrOfSoldiers());

			}
			if (e.getSource() == button_12) {
				b.player[2].buySoldier(1);
				gold2.setText("Gold: "+b.player[2].getCurrentMoney());
				lblArcher2.setText("Archer:"+b.player[2].getDivisions(1).getCurrentNrOfSoldiers());
				
			}
			if (e.getSource() == button_22) {
				b.player[2].sellSoldier(2);
				gold2.setText("Gold: " + b.player[2].getCurrentMoney());
				lblFootmen2.setText("Footmen:" + b.player[2].getDivisions(2).getCurrentNrOfSoldiers());

			}
			if (e.getSource() == button_32) {
				b.player[2].buySoldier(2);
				gold2.setText("Gold: "+b.player[2].getCurrentMoney());
				lblFootmen2.setText("Footmen:"+b.player[2].getDivisions(2).getCurrentNrOfSoldiers());
				
			}
			if (e.getSource() == button_42) {
				b.player[2].sellSoldier(3);
				gold2.setText("Gold: " + b.player[2].getCurrentMoney());
				lblCavalry2.setText("Cavalry:" + b.player[2].getDivisions(3).getCurrentNrOfSoldiers());

			}
			if (e.getSource() == button_52) {
				b.player[2].buySoldier(3);
				gold2.setText("Gold: "+b.player[2].getCurrentMoney());
				lblCavalry2.setText("Cavalry:"+b.player[2].getDivisions(3).getCurrentNrOfSoldiers());
				
			}
			if (e.getSource() == button_62) {
				b.player[2].sellSoldier(4);
				gold2.setText("Gold: " + b.player[2].getCurrentMoney());
				lblTrebuchet2.setText("Trebuchet:" + b.player[2].getDivisions(4).getCurrentNrOfSoldiers());

			}
			if (e.getSource() == button_72) {
				b.player[2].buySoldier(4);
				gold2.setText("Gold: "+b.player[2].getCurrentMoney());
				lblTrebuchet2.setText("Trebuchet:"+b.player[2].getDivisions(4).getCurrentNrOfSoldiers());
				
			}
			if(e.getSource()==place11) {
				initChoose(fightTroops);
				keyPlayer=1;
				keyField=1;
				
			}
			if(e.getSource()==place12) {
				initChoose(fightTroops);
				keyPlayer=1;
				keyField=2;

			}
			if(e.getSource()==place13) {
				initChoose(fightTroops);
				keyPlayer=1;
				keyField=3;
			}
			if(e.getSource()==place14) {
				initChoose(fightTroops);
				keyPlayer=1;
				keyField=4;
			}
			if(e.getSource()==place21) {
				initChoose(fightTroops);
				keyPlayer=2;
				keyField=1;
			}
			if(e.getSource()==place22) {
				initChoose(fightTroops);
				keyPlayer=2;
				keyField=2;
			}
			if(e.getSource()==place23) {
				initChoose(fightTroops);
				keyPlayer=2;
				keyField=3;
			}
			if(e.getSource()==place24) {
				initChoose(fightTroops);
				keyPlayer=2;
				keyField=4;
			}
			if(e.getSource()==doneChoose) {
				fightTroops.setVisible(false);
				maxi=b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers();
				if(keyPlayer==1 && keyField==1) {
					setButtonImage(place11);
					lblSentField11.setText(""+nrOfTroops);
					lblSentField11.setVisible(true);
				}
				if(keyPlayer==1 && keyField==2) {
					setButtonImage(place12);
					lblSentField12.setText(""+nrOfTroops);
					lblSentField12.setVisible(true);
				}
				if(keyPlayer==1 && keyField==3) {
					setButtonImage(place13);
					lblSentField13.setText(""+nrOfTroops);
					lblSentField13.setVisible(true);
				}
				if(keyPlayer==1 && keyField==4) {
					setButtonImage(place14);
					lblSentField14.setText(""+nrOfTroops);
					lblSentField14.setVisible(true);
				}
				if(keyPlayer==2 && keyField==1) {
					setButtonImage(place21);
					lblSentField21.setText(""+nrOfTroops);
					lblSentField21.setVisible(true);
				}
				if(keyPlayer==2 && keyField==2) {
					setButtonImage(place22);
					lblSentField22.setText(""+nrOfTroops);
					lblSentField22.setVisible(true);
				}
				if(keyPlayer==2 && keyField==3) {
					setButtonImage(place23);
					lblSentField23.setText(""+nrOfTroops);
					lblSentField23.setVisible(true);
				}
				if(keyPlayer==2 && keyField==4) {
					setButtonImage(place24);
					lblSentField24.setText(""+nrOfTroops);
					lblSentField24.setVisible(true);
				}
				
				b.sendToBattle(keyPlayer, type, nrOfTroops, keyField);
				
				if(type==1 && keyPlayer==1) {
					lblArcinf.setText(""+b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers());
				}
				if(type==2 && keyPlayer==1) {
					lblFootinf.setText(""+b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers());
				}
				if(type==3 && keyPlayer==1) {
					lblCalinf.setText(""+b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers());
				}
				if(type==4 && keyPlayer==1) {
					lblTrbinf.setText(""+b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers());
				}
				
				
				if(type==1 && keyPlayer==2) {
					lblArcinf_1.setText(""+b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers());
				}
				if(type==2 && keyPlayer==2) {
					lblFootinf_1.setText(""+b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers());
				}
				if(type==3 && keyPlayer==2) {
					lblCalinf_1.setText(""+b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers());
				}
				if(type==4 && keyPlayer==2) {
					lblTrbinf_1.setText(""+b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers());
				}
				

			}
			if(e.getSource()==radioArcher) {
				nrOfTroops=0;
				counter.setText(""+nrOfTroops);
				type=1;
				maxi=b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers();

			}
			if(e.getSource()==radioFootmen) {
				nrOfTroops=0;
				type=2;
				counter.setText(""+nrOfTroops);
				maxi=b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers();

			}
			if(e.getSource()==radioCavalry) {
				nrOfTroops=0;
				type=3;
				counter.setText(""+nrOfTroops);
				maxi=b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers();

				}
			if(e.getSource()==radioTrebuchet) {
				nrOfTroops=0;
				type=4;
				counter.setText(""+nrOfTroops);
				maxi=b.getPlayer(keyPlayer).getDivisions(type).getCurrentNrOfSoldiers();

			}
			if(e.getSource()==addTroop) {
				if(nrOfTroops<maxi) {
					nrOfTroops++;
					counter.setText(""+nrOfTroops);
				}
				
			}
			if (e.getSource() == subTroop) {
				if (nrOfTroops > 0) {
					nrOfTroops--;
					counter.setText("" + nrOfTroops);
				}

			}
			if(e.getSource()==BATTLE) {
				b.battle();
				lblSentField11.setText(""+b.getPlace(1, 1).getCurrentNrOfSoldiers());
				lblSentField11.setVisible(true);
				lblSentField12.setText(""+b.getPlace(1, 2).getCurrentNrOfSoldiers());
				lblSentField12.setVisible(true);
				lblSentField13.setText(""+b.getPlace(1, 3).getCurrentNrOfSoldiers());
				lblSentField13.setVisible(true);
				lblSentField14.setText(""+b.getPlace(1, 4).getCurrentNrOfSoldiers());
				lblSentField14.setVisible(true);
				
				lblSentField21.setText(""+b.getPlace(2, 1).getCurrentNrOfSoldiers());
				lblSentField21.setVisible(true);
				lblSentField22.setText(""+b.getPlace(2, 2).getCurrentNrOfSoldiers());
				lblSentField22.setVisible(true);
				lblSentField23.setText(""+b.getPlace(2, 3).getCurrentNrOfSoldiers());
				lblSentField23.setVisible(true);
				lblSentField24.setText(""+b.getPlace(2, 4).getCurrentNrOfSoldiers());
				lblSentField24.setVisible(true);
				
				lblArcinf.setText(""+b.getPlayer(1).getDivisions(1).getCurrentNrOfSoldiers());
				lblFootinf.setText(""+b.getPlayer(1).getDivisions(2).getCurrentNrOfSoldiers());
				lblCalinf.setText(""+b.getPlayer(1).getDivisions(3).getCurrentNrOfSoldiers());
				lblTrbinf.setText(""+b.getPlayer(1).getDivisions(4).getCurrentNrOfSoldiers());
				
				lblArcinf_1.setText(""+b.getPlayer(2).getDivisions(1).getCurrentNrOfSoldiers());
				lblFootinf_1.setText(""+b.getPlayer(2).getDivisions(2).getCurrentNrOfSoldiers());
				lblCalinf_1.setText(""+b.getPlayer(2).getDivisions(3).getCurrentNrOfSoldiers());
				lblTrbinf_1.setText(""+b.getPlayer(2).getDivisions(4).getCurrentNrOfSoldiers());
				
				BATTLE.setVisible(false);
				btnEndTurn.setVisible(true);
			}
			if(e.getSource()==btnEndTurn) {
				b.returnFromBattle();
				
				lblSentField11.setText(""+b.getPlace(1, 1).getCurrentNrOfSoldiers());
				lblSentField11.setVisible(true);
				lblSentField12.setText(""+b.getPlace(1, 2).getCurrentNrOfSoldiers());
				lblSentField12.setVisible(true);
				lblSentField13.setText(""+b.getPlace(1, 3).getCurrentNrOfSoldiers());
				lblSentField13.setVisible(true);
				lblSentField14.setText(""+b.getPlace(1, 4).getCurrentNrOfSoldiers());
				lblSentField14.setVisible(true);
				
				lblSentField21.setText(""+b.getPlace(2, 1).getCurrentNrOfSoldiers());
				lblSentField11.setVisible(true);
				lblSentField22.setText(""+b.getPlace(2, 2).getCurrentNrOfSoldiers());
				lblSentField12.setVisible(true);
				lblSentField23.setText(""+b.getPlace(2, 3).getCurrentNrOfSoldiers());
				lblSentField23.setVisible(true);
				lblSentField24.setText(""+b.getPlace(2, 4).getCurrentNrOfSoldiers());
				lblSentField24.setVisible(true);
				
				lblArcinf.setText(""+b.getPlayer(1).getDivisions(1).getCurrentNrOfSoldiers());
				lblFootinf.setText(""+b.getPlayer(1).getDivisions(2).getCurrentNrOfSoldiers());
				lblCalinf.setText(""+b.getPlayer(1).getDivisions(3).getCurrentNrOfSoldiers());
				lblTrbinf.setText(""+b.getPlayer(1).getDivisions(4).getCurrentNrOfSoldiers());
				

				lblArcinf_1.setText(""+b.getPlayer(2).getDivisions(1).getCurrentNrOfSoldiers());
				lblFootinf_1.setText(""+b.getPlayer(2).getDivisions(2).getCurrentNrOfSoldiers());
				lblCalinf_1.setText(""+b.getPlayer(2).getDivisions(3).getCurrentNrOfSoldiers());
				lblTrbinf_1.setText(""+b.getPlayer(2).getDivisions(4).getCurrentNrOfSoldiers());
				
				place11.setEnabled(true);
				place12.setEnabled(true);
				place13.setEnabled(true);
				place14.setEnabled(true);
				place11.setIcon(null);
				place12.setIcon(null);
				place13.setIcon(null);
				place14.setIcon(null);
				place21.setIcon(null);
				place22.setIcon(null);
				place23.setIcon(null);
				place24.setIcon(null);
				btnDone.setVisible(true);
				btnEndTurn.setVisible(false);
				
				if(b.endGame()>0)
				{
					lblSentField11.setVisible(false);
					lblSentField12.setVisible(false);
					lblSentField13.setVisible(false);
					lblSentField14.setVisible(false);
					
					lblArcinf.setVisible(false);
					lblFootinf.setVisible(false);
					lblCalinf.setVisible(false);
					lblTrbinf.setVisible(false);
					
					place11.setVisible(false);
					place12.setVisible(false);
					place13.setVisible(false);
					place14.setVisible(false);
					
					lblSentField21.setVisible(false);
					lblSentField22.setVisible(false);
					lblSentField23.setVisible(false);
					lblSentField24.setVisible(false);
					
					lblArcinf_1.setVisible(false);
					lblFootinf_1.setVisible(false);
					lblCalinf_1.setVisible(false);
					lblTrbinf_1.setVisible(false);
					
					place21.setVisible(false);
					place22.setVisible(false);
					place23.setVisible(false);
					place24.setVisible(false);
					
					btnDone.setVisible(false);
					
					lblArc.setVisible(false);
					lblFoot.setVisible(false);
					lblCal.setVisible(false);
					lblTrb.setVisible(false);
					
					lblArc_1.setVisible(false);
					lblFoot_1.setVisible(false);
					lblCal_1.setVisible(false);
					lblTrb_1.setVisible(false);
					
					P1name.setVisible(false);
					P2name.setVisible(false);
					PLAYBUTTON.setEnabled(false);
					
					if(b.endGame()==1) {
						PLAYBUTTON.setText(b.getPlayer(2).getName()+" WON!");
					}
					else {
						PLAYBUTTON.setText(b.getPlayer(1).getName()+" WON!");
					}
					PLAYBUTTON.setVisible(true);
						
					
				}
			}
			if(e.getSource()==btnDone) {
				
				lblSentField11.setVisible(false);
				lblSentField12.setVisible(false);
				lblSentField13.setVisible(false);
				lblSentField14.setVisible(false);
				
				lblArcinf.setVisible(false);
				lblFootinf.setVisible(false);
				lblCalinf.setVisible(false);
				lblTrbinf.setVisible(false);
				
				place11.setVisible(false);
				place12.setVisible(false);
				place13.setVisible(false);
				place14.setVisible(false);
				btnDone.setVisible(false);
				btnDone_1.setVisible(true);
				
				place21.setEnabled(true);
				place22.setEnabled(true);
				place23.setEnabled(true);
				place24.setEnabled(true);
			}
			if(e.getSource()==btnDone_1) {
				lblSentField21.setVisible(false);
				lblSentField22.setVisible(false);
				lblSentField23.setVisible(false);
				lblSentField24.setVisible(false);
				
				lblArcinf_1.setVisible(false);
				lblFootinf_1.setVisible(false);
				lblCalinf_1.setVisible(false);
				lblTrbinf_1.setVisible(false);
				
				place21.setVisible(false);
				place22.setVisible(false);
				place23.setVisible(false);
				place24.setVisible(false);
				
				btnDone_1.setVisible(false);
				btnReveal.setVisible(true);
			
		}
			if(e.getSource()==btnReveal) {
				
				BATTLE.setVisible(true);
				btnReveal.setVisible(false);
				
				place11.setVisible(true);
				place12.setVisible(true);
				place13.setVisible(true);
				place14.setVisible(true);
				
				place21.setVisible(true);
				place22.setVisible(true);
				place23.setVisible(true);
				place24.setVisible(true);
				
				lblSentField21.setVisible(true);
				lblSentField22.setVisible(true);
				lblSentField23.setVisible(true);
				lblSentField24.setVisible(true);
				
				lblArcinf.setVisible(true);
				lblFootinf.setVisible(true);
				lblCalinf.setVisible(true);
				lblTrbinf.setVisible(true);
				
				lblSentField11.setVisible(true);
				lblSentField12.setVisible(true);
				lblSentField13.setVisible(true);
				lblSentField14.setVisible(true);
				
				lblArcinf_1.setVisible(true);
				lblFootinf_1.setVisible(true);
				lblCalinf_1.setVisible(true);
				lblTrbinf_1.setVisible(true);
				
				
				place11.setEnabled(false);
				place12.setEnabled(false);
				place13.setEnabled(false);
				place14.setEnabled(false);
				
				place21.setEnabled(false);
				place22.setEnabled(false);
				place23.setEnabled(false);
				place24.setEnabled(false);
			}
		}
	}
}
