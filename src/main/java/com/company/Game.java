package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {

    private GameScreen gameScreen;
    private StartScreen startScreen;
    private JFrame textFrame;
    private JButton startButton;
    private JButton textButton;
    private JButton nextButton;
    private JButton exitButton;
    private JTextField textField;
    private JLabel textLabel;
    private JTextArea textArea;
    private Sprite NPC1 = new Sprite("/PIPOYA FREE RPG Character Sprites 32x32/Female/Female 01-1.png", 0, 0, 32, 32);
    private JLabel picLabel;
    boolean startGame = false;

    public static GameManager gm;

    public Game(int width, int height) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);

        gm = new GameManager();

        startScreen = new StartScreen();

        gameScreen = new GameScreen();
        gameScreen.startGameThread();

        ClickListener cl = new ClickListener();

        startButton = new JButton("START");
        startButton.setBounds(300, 550, 100, 50);
        startButton.setSize(100, 50);
        startButton.setEnabled(true);
        add(startButton);
        startButton.addActionListener(cl);
        add(startScreen);

        textFrame = new JFrame();
        textFrame.setSize(250, 150);
        textFrame.setLocationRelativeTo(null);
        textField = new JTextField();
        textField.setBounds(10, 40, 150, 20);
        textFrame.add(textField);
        textFrame.setLayout(null);

        textLabel = new JLabel("Player Name:");
        textLabel.setBounds(15, 10, 100, 30);
        textFrame.add(textLabel);

        textButton = new JButton("Enter");
        textButton.setBounds(10, 70, 100, 30);
        textButton.setEnabled(true);
        textButton.addActionListener(cl);
        textFrame.add(textButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(10, 70, 100, 30);
        nextButton.addActionListener(cl);
        textFrame.add(nextButton);
        exitButton = new JButton("Let's Go!");
        exitButton.setBounds(170, 210, 100, 30);
        exitButton.addActionListener(cl);
        textFrame.add(exitButton);

        textArea = new JTextArea();
        textFrame.add(textArea);

        picLabel = new JLabel(new ImageIcon(NPC1.getSprite()));
        picLabel.setBounds(5, 10, 35, 35);
        textFrame.add(picLabel);
        picLabel.setVisible(false);


    }

    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int count = 0;

            if (e.getSource() == startButton) {
                textFrame.setVisible(true);
                add(gameScreen);
                gameScreen.setVisible(true);
                startScreen.setVisible(false);
                startButton.setVisible(false);
                startGame = true;

                // method to start game & controller input here
            }
            if (e.getSource() == textButton) {
                String name = textField.getText();
                textLabel.setBounds(50, 10, 500, 30);
                textField.setVisible(false);
                picLabel.setVisible(true);
                textLabel.setText("Welcome " + name + "!");
                textButton.setVisible(false);
                nextButton.setVisible(true);

            }
            if (e.getSource() == nextButton) {
                textButton.setVisible(false);
                textLabel.setVisible(false);
                nextButton.setVisible(false);

                textFrame.setSize(500, 300);
                textArea.setBounds(50, 10, 400, 250);
                textArea.setLineWrap(true);
                textArea.setVisible(true);
                exitButton.setVisible(true);

                textArea.setText("In a world where an infectious outbreak has plagued " +
                        "all forms of life as you know it, you must stealthily weave " +
                        "your way out of the ruins of what you once called ‘home’ " +
                        "as one of the only survivors of the virulent eruption of " +
                        "zombies. Whether it be hastily gathering survival supplies " +
                        "or vigilantly avoiding the gaze of bloodthirsty zombies out " +
                        "for your flesh, Zombie Dash has it all. But wait—there’s more! " +
                        "You’ve heard of a shelter housing survivors some ways away, and " +
                        "it seems like going there would be your best bet to stay alive. " +
                        "Collect all of the canned food along your trail and make it out to the exit " +
                        "to ensure your safety, " +
                        "and make sure that the traps scattered across the map—or even worse, " +
                        "the zombies themselves—don’t get to you first.");

                // method to save name in Player class
            }
            if (e.getSource() == exitButton) {
                textArea.setVisible(false);
                textFrame.setVisible(false);
                textButton.setVisible(false);

            }
        }
    }
}






