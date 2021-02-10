import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/*
Create a JFrame to demonstrate how the BGM and sound effect
 */

public class Music {
    JFrame window;
    Container con;
    JPanel buttonPanel;
    JButton soundEffect1, soundEffect2;
    String inFileSE1, inFileSE2, inFileBGM;
    ButtonHandler bHandler = new ButtonHandler();
    SoundEffect se = new SoundEffect();
    Bgm bgm = new Bgm();

    public static void main(String[] args) {
        new Music();
    }

    public Music(){
        // Creating a JFrame to display the sound effect button
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        //Creating button
        buttonPanel = new JPanel();
        buttonPanel.setBounds(300, 300, 200, 100);
        buttonPanel.setBackground(Color.black);
        con.add(buttonPanel);

        soundEffect1 = new JButton("Test Sound Effect1");
        soundEffect1.setFocusPainted(false);
        soundEffect1.addActionListener(bHandler);
        soundEffect1.setActionCommand("click");
        buttonPanel.add(soundEffect1);

        soundEffect2 = new JButton("Test Sound Effect2");
        soundEffect2.setFocusPainted(false);
        soundEffect2.addActionListener(bHandler);
        soundEffect2.setActionCommand("collectItem");
        buttonPanel.add(soundEffect2);

        window.setVisible(true);

        inFileSE1 = "buttonClick.wav";
        inFileSE2 = "collectItem.wav";
        inFileBGM = "Parisian Cafe.wav";

        bgm.setFile(inFileBGM);
        bgm.loop();
    }

    public class SoundEffect{
        Clip clip;

        public void setFile(String filename) {
            try{
                File file = new File(filename);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public void play(){
            clip.setFramePosition(0);
            clip.start();
        }

        public void stop(){
            clip.stop();
            clip.close();
        }

    }

    public class Bgm extends SoundEffect{

        public void loop(){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }

    }

    public class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command){
                case("click"):
                    se.setFile(inFileSE1);
                    se.play();
                    break;
                case("collectItem"):
                    se.setFile(inFileSE2);
                    se.play();
                    break;
            }

        }
    }

}
