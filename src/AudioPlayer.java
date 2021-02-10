import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

//AudioPlayer class which could play the bgm
public class AudioPlayer {
    //Class variable which stores the directory of the file and the clip
    private File file;
    private Clip clip;

    //Constructor
    public AudioPlayer(String s){
        try{
            file = new File(s);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
    Play the file that's loaded to the clip
     */
    public void play(){
        if(clip == null) return;
        stop();
    }

    /*
    Stop the clip that's playing
     */
    public void stop(){
        if(clip.isRunning()){
            clip.stop();
        }
    }

    /*
    Stop the clip and close it
     */
    public void close(){
        stop();
        clip.close();
    }

    /*
    Loop the file loaded at the clip
     */
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
