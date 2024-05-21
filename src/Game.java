import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	
	//this is all GUI stuff
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, hpPanel;
	JLabel titleNameLabel, playerLabel, playerLabelNumber, enemyLabel, enemyLabelNumber;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 100);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font smallFont = new Font("Times New Roman", Font.PLAIN, 20);
	JButton startButton, choice1, choice2, choice3, choice4;
	JButton easy, medium, hard;
	JTextArea mainTextArea;
	
	//primitives or however you spell it
	int playerHP, enemyHP, playerDamage, enemyDamage, action, playerGuardHealth, enemyGuardHealth;
	String position;
	boolean enemyAttacks, healthPotionUsed, armorPotionUsed;
// 	String playerName;
	
	//Classes
	Hero player;
	Enemy badGuy;
	Items goodies;
	
	//ActionListeners
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler cHandler = new ChoiceHandler();
	
	
	public static void main(String[] args) {
		
		new Game();
		
	}

	public Game() {
		
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100,100,600,150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("RPG ARENA");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(100, 400, 600, 100);
		startButtonPanel.setBackground(Color.black);
		startButtonPanel.setLayout(new GridLayout(1,3));
		
		
		easy = new JButton("EASY");
		easy.setActionCommand("easy");
		easy.setBackground(Color.black);
		easy.setForeground(Color.red);
		easy.setFont(normalFont);
		easy.addActionListener(tsHandler);
		easy.setFocusPainted(false);
		
		medium = new JButton("MEDIUM");
		medium.setActionCommand("medium");
		medium.setBackground(Color.black);
		medium.setForeground(Color.red);
		medium.setFont(normalFont);
		medium.addActionListener(tsHandler);
		medium.setFocusPainted(false);
		
		hard = new JButton("HARD");
		hard.setActionCommand("hard");
		hard.setBackground(Color.black);
		hard.setForeground(Color.red);
		hard.setFont(normalFont);
		hard.addActionListener(tsHandler);
		hard.setFocusPainted(false);
		
		
		
		
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(easy);
		startButtonPanel.add(medium);
		startButtonPanel.add(hard);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		window.setVisible(true);
	}
	
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		window.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100,100,600,250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250,350,300,150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton();
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.addActionListener(cHandler);
		choice1.setFocusPainted(false);
		choiceButtonPanel.add(choice1);
		choice1.setActionCommand("c1");
		
		choice2 = new JButton();
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.addActionListener(cHandler);
		choice2.setFocusPainted(false);
		choiceButtonPanel.add(choice2);
		choice2.setActionCommand("c2");
		
		choice3 = new JButton();
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.addActionListener(cHandler);
		choice3.setFocusPainted(false);
		choiceButtonPanel.add(choice3);
		choice3.setActionCommand("c3");
		
		choice4 = new JButton();
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.addActionListener(cHandler);
		choice4.setFocusPainted(false);
		choiceButtonPanel.add(choice4);
		choice4.setActionCommand("c4");
		
		hpPanel = new JPanel();
		hpPanel.setBounds(100,15,600,50);
		hpPanel.setBackground(Color.black);
		hpPanel.setLayout(new GridLayout(1,4));
		con.add(hpPanel);
		
		playerLabel = new JLabel("HERO:");
		playerLabel.setFont(normalFont);
		playerLabel.setForeground(Color.white);
		hpPanel.add(playerLabel);
		playerLabelNumber = new JLabel();
		playerLabelNumber.setFont(normalFont);
		playerLabelNumber.setForeground(Color.white);
		hpPanel.add(playerLabelNumber);
		
		enemyLabel = new JLabel(badGuy.toString()+":");
		enemyLabel.setFont(normalFont);
		enemyLabel.setForeground(Color.white);
		hpPanel.add(enemyLabel);
		enemyLabelNumber = new JLabel();
		enemyLabelNumber.setFont(normalFont);
		enemyLabelNumber.setForeground(Color.white);
		hpPanel.add(enemyLabelNumber);
		
		playerSetup();
		
		window.setVisible(true);
	}
	
	
	
	public void playerSetup() {
		if(player.getHealth()>100*player.getLvl())
			player.setHealth(100*player.getLvl());
		playerLabelNumber.setText(""+(player.getHealth()));
		enemyLabelNumber.setText(""+(badGuy.getHealth()));
		
		battleScreen();
	}
	
	public void battleScreen() {
		
		action = (int) (Math.random()*3);
		
		position = "battleScreen";
		
		mainTextArea.setFont(normalFont);
		mainTextArea.setText("You have encountered a level " + badGuy.getLvl() + " " + badGuy + "!");
		
		choice1.setText("FIGHT");
		
		choice2.setText("ITEMS");
		
		choice3.setText("INFO");
		
		choice4.setText("");
		
	}
	
	public void fightScreen() {
		
		position = "fightScreen";
		
		mainTextArea.setText("You have chosen to fight! \n\nPick an action!");

		choice1.setText("ATTACK");
		
		choice2.setText("DEFEND");
		
		choice3.setText("DODGE");
		
		choice4.setText("BACK");
		
	}
	
	public void itemScreen() {
		
		position = "itemScreen";
		
		mainTextArea.setText("You look inside your bag! \nWhich Item will you choose!");
		
		choice1.setText("HEALTH POTION");
		
		choice2.setText("ARMOR POTION");
		
		choice3.setText("RABBIT'S FOOT");
		
		choice4.setText("BACK");
	}
	
	public void healingPotionScreen() {
		
		position = "healingPotionScreen";
		
		
		choice1.setText("CONTINUE");
		
		choice2.setText("");
		
		choice3.setText("");
		
		choice4.setText("");
		
		if(healthPotionUsed) 
			potionAlreadyUsedScreen();
		else
			mainTextArea.setText("You drank from your health potion \n\nYou gained " + goodies.getHealth()/2*player.getLvl()+ " hp! ");
		
		healthPotionUsed = true;
	}
	
	public void armorPotionScreen() {
		position = "armorPotionScreen";
		
		choice1.setText("CONTINUE");
		
		choice2.setText("");
		
		choice3.setText("");
		
		choice4.setText("");
		
		if(armorPotionUsed)
			potionAlreadyUsedScreen();
		else
			mainTextArea.setText("You drank from your armor potion \n\nYou feel safer now.");
		
		armorPotionUsed = true;
	}
	
	public void potionAlreadyUsedScreen() {
		position = "potionAlreadyUsedScreen";
		
		mainTextArea.setText("You can only use one of each potion per game");
		
		choice1.setText("BACK");
		
		choice2.setText("");
		
		choice3.setText("");
		
		choice4.setText("");
		
		
	}
	
	public void rabbitsFootScreen() {
		position = "rabbitsFootScreen";
		
		mainTextArea.setText("You look at your lucky rabbit's foot and wonder if today will be a good luck day...");
		
		choice1.setText("CONTINUE");
		
		choice2.setText("");
		
		choice3.setText("");
		
		choice4.setText("");
	}
	
	public void infoScreen() {
		position = "infoScreen";
		
		mainTextArea.setFont(smallFont);
		mainTextArea.setText("This is a small RPG Battle made by Zane. Each turn, you will have the option to either use an item, or attack\nAttacks include a simple strike, defending, or dodging. \nItems include a potion that adds half your health, a potion to increaes your armor by 1.5x, and a rabbit's foot which gives you a very small chance to do a lot of damage. \nHave fun!");
		
		choice1.setText("BACK");

		choice2.setText("");

		choice3.setText("");

		choice4.setText("");
		
	}
	
	public void playerAttackScreen(int action) {

		position = "playerAttackScreen";

		enemyAttacks = false;
		
		playerDamage = badGuy.healthLost(player.getStrength());
		
		choice1.setText("CONTINUE");
		
		choice2.setText("");
		
		choice3.setText("");
		
		choice4.setText("");
		
		if(action == 0)
			playerAttackContinued();
		else
			enemyActionScreen(playerDamage, 0);
		
		
	}
	
	public void playerDefendScreen() {
		
		position = "playerDefendScreen";
		
		mainTextArea.setText("You ready your gaurd!");
		
		choice1.setText("CONTINUE");
		
		choice2.setText("");
		
		choice3.setText("");
		
		choice4.setText("");
	}
	
	public void playerDodgeScreen() {
		position = "playerDodgeScreen";
		
		mainTextArea.setText("You get ready to dodge the enemies attack!");
		
		choice1.setText("CONTINUE");
		
		choice2.setText("");
		
		choice3.setText("");
		
		choice4.setText("");
	}
	
	public void playerAttackContinued() {
		
		position = "playerAttackContinued";
		
		mainTextArea.setText("You attack the enemy! \n you dealt " + playerDamage +  " damage!");
		
		badGuy.takeDamage(playerDamage);
		
		choice1.setText("CONTINUE");
		
		choice2.setText("");
		
		choice3.setText("");
		
		choice4.setText("");
	}
	
	public void enemyActionScreen(int damageTaken, int previousScreen) {
		position = "enemyActionScreen";
		
		enemyDamage = player.healthLost(badGuy.getStrength());
		
		if(enemyDamage <0) 
			enemyDamage = 0;
		
		playerGuardHealth = enemyDamage - player.defends();
		enemyGuardHealth = playerDamage - badGuy.defends();
		
		//ensuring that you don't heal from guarding (for text purposes)
		if(playerGuardHealth < 0)
			playerGuardHealth = 0;
		if(enemyGuardHealth <0)
			enemyGuardHealth = 0;
		
		choice1.setText("CONTINUE");
		
		choice2.setText("");
		
		choice3.setText("");
		
		choice4.setText("");
		switch(action) {
		//ENEMY ATTACKS
		case 0:
			switch(previousScreen) {
			case 0, 3:
				player.takeDamage(enemyDamage);
				mainTextArea.setText("The " + badGuy + " attacked you! \n\nThey did " +  enemyDamage + " damage!");
				player.resetStrength();
				break;
				
			case 1:
				player.takeDamage(playerGuardHealth);
				mainTextArea.setText("The " + badGuy + " attacked you, but you blocked! \n\nThey dealt " + (playerGuardHealth) + " damage!");
				break;
				
			case 2:
				if(player.dodge() > 3) 
					mainTextArea.setText("The " + badGuy + " attacked you, but you dodged! \n\nThey dealt 0 damage!");
				
				else {
					player.takeDamage(enemyDamage);
					mainTextArea.setText("The " + badGuy + " attacked you, and you \nfailed to dodge! \n\nThey dealt " + enemyDamage + " damage!");
				}
				break;
			case 4:
				player.takeDamage(enemyDamage);
				mainTextArea.setText("The " + badGuy + " attacked you while you were wondering what your luck would be! \nHow rude\n\nThey dealt " + enemyDamage + " damage!");
			}
			break;
		//ENEMY BLOCKS
		case 1:
			switch(previousScreen) {
			case 0:
				badGuy.takeDamage(enemyGuardHealth);
				mainTextArea.setText("The " + badGuy + " blocked your attack! \n\nYou delt " + (enemyGuardHealth) + " damage!");
				player.resetStrength();
				break;
			case 1:
				mainTextArea.setText("Both you and the " + badGuy + " raised your gaurds.\n\nYou give each other a puzzled look.");
				break;
			case 2:
				mainTextArea.setText("The " + badGuy + " raises their guard as you throw yourself to the side.\n\n" + badGuy + " gives you a weird look.");
				break;
			case 3:
				mainTextArea.setText("The " + badGuy + " patiently waits for you to finish your potion");
				break;
			case 4:
				mainTextArea.setText("The " + badGuy + " wonders why you're just staring into your bag.");
			}
			break;
		//ENEMY DODGES
		case 2:
			switch(previousScreen) {
			case 0:
				if(badGuy.dodge() > 3) 
					mainTextArea.setText("You attacked the " + badGuy + ", but they dodged! \n\nYou dealt 0 damage!");
				
				else {
					badGuy.takeDamage(playerDamage);
					mainTextArea.setText("You attacked the " + badGuy + ", and they\nfailed to dodge! \n\nYou delt " + playerDamage + " damage!");
				}
				player.resetStrength();
				
				break;
			case 1:
				mainTextArea.setText("You raise your guard as you watch the " +badGuy + " throw themselves to the side in panic \n\nYou give the " + badGuy + " a weird look.");
				break;
			case 2:
				mainTextArea.setText("You and the " + badGuy + " decided to dodge the same \ndirection and bonked your heads together \n\nYou're gonna feel that in the morning.");
				badGuy.takeDamage(1);
				player.takeDamage(1);
				break;
			case 3:
				mainTextArea.setText("The " + badGuy + " gestures for you to hurry up as you drink your potion");
				break;
			case 4:
				mainTextArea.setText("The " + badGuy + " gets bored and asks a magic 8 ball whether it will win or not \n\nThe 8 ball says that the odds are not in it's favor");
				break;
			}
			break;
		}
		
			
		 	

		
		
	}
	
	public void goodEnding() {
		position = "ending";
		mainTextArea.setText("You successfull took down " + badGuy + "\n\nYOU WIN!");
		
		enemyLabelNumber.setText("DEAD");
		
		choice1.setText("PLAY AGAIN?");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
		
		
	}
	
	public void badEnding() {
		position = "ending";
		mainTextArea.setText("You failed to take down " + badGuy + "\n\nBetter luck next time");
		
		playerLabelNumber.setText("DEAD");
		
		choice1.setText("PLAY AGAIN?");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String command = event.getActionCommand();
			goodies = new Items();
			
			switch (command) {
			
			case "easy":
				player = new Hero(1);
				badGuy = new Enemy(1, enemyNames());
				badGuy.setStrength(badGuy.getStrength()+10);
				badGuy.setArmor(badGuy.getArmor()+5);

				break;
				
			case "medium":
				player = new Hero(5);
				badGuy = new Enemy(5, enemyNames());
				badGuy.setStrength(badGuy.getStrength()+50);
				badGuy.setArmor(badGuy.getArmor()+25);

				break;
				
			case "hard":
				player = new Hero(10);
				badGuy = new Enemy(10, enemyNames());
				badGuy.setStrength(badGuy.getStrength()+100);
				badGuy.setArmor(badGuy.getArmor()+50);

				break;
				
			}
			createGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			switch(position) {
			
			case "battleScreen":
				
				switch(command) {
				case "c1":
					fightScreen();
					break;
				case "c2":
					itemScreen();
					break;
				case "c3":
					infoScreen();
					break;
				case "c4":
					mainTextArea.setText("Please pick either \"fight\" or \"items\" silly.");
					break;
					
				}
				
				break;
				
			case "fightScreen":
				
				switch(command) {
				case "c1":
					playerAttackScreen(action);
					break;
				case "c2":
					playerDefendScreen();
					break;
				case "c3":
					playerDodgeScreen();
					break;
				case "c4":
					battleScreen();
					break;
				
				}
				
				break;
				
			case "itemScreen":
				
				switch(command) {
				case "c1":
					healingPotionScreen();
					break;
				case "c2":
					armorPotionScreen();
					break;
				case "c3":
					rabbitsFootScreen();
					break;
				case "c4":
					battleScreen();
					break;
				
				}
				
				break;
				
			case "infoScreen":
				
				switch(command) {
				case "c1":
					battleScreen();
					break;
				case "c2":
					//nothing
					break;
				case "c3":
					//nothing
					break;
				case "c4":
					//nothing
					break;
				
				}
				
				break;
				
			case "playerAttackScreen":
				
				switch(command) {
				case "c1":
					enemyActionScreen(playerDamage, 0);
					break;
					}
		
				break;
				
			case "playerDefendScreen":
				
				switch(command) {
				case "c1":
					enemyActionScreen(playerDamage, 1);
					break;
					
				}
				
				break;
				
			case "playerDodgeScreen":
				
				switch(command) {
				case "c1":
					enemyActionScreen(playerDamage, 2);
					break;
					
				}
				
				break;
				
			case "enemyActionScreen":
				
				switch(command) {
				case"c1":
					if(!badGuy.isAlive())
						goodEnding();
					else if(!player.isAlive())
						badEnding();
					else
						playerSetup();
					break;
				}
				
				break;
				
			case "playerAttackContinued":
				
				switch(command) {
				case"c1":
					enemyActionScreen(playerDamage, 0);
					
					break;
				}
				
				break;
				
			case "healingPotionScreen":
				
				switch(command) {
				case"c1":
					player.heal();
					enemyActionScreen(playerDamage, 3);
					break;
					
				}
				
				break;
				
			case "armorPotionScreen":
				
				switch(command) {
				case "c1":
					player.protect();
					enemyActionScreen(playerDamage, 3);
					break;
					
				}
				
				break;
				
			case "potionAlreadyUsedScreen":
				
				switch(command) {
				case "c1":
				itemScreen();
				break;
				}
				
				break;
				
			case "rabbitsFootScreen":
				
				switch(command) {
				case"c1":
					player.luck();
					enemyActionScreen(playerDamage, 4);
				}
				
				break;
				
			case "ending":
				
				switch(command ) {
				case "c1":
					window.dispose();
					new Game();
					break;
					
				}
				
				break;
			}
		}
	}
	
	
	
	public String enemyNames() {
		
		//I had to remove Mr. Cuellar and BOB due to time constraints :(
		String[] names = {"Frog", "Goblin", "Robot", "Troll", "Zombie", "Dark Elf", "Demon", "Druid", "Giant", "Vampire", "Ghost", "Slime", "Werewolf", "Gremlin"};
		return names[(int)(Math.random()*names.length)];
				
				
				
	}
	
}
