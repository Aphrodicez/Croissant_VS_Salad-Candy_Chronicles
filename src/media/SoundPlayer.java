package media;

import java.io.File;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


 /**
 * The class Sound player
 */ 
public class SoundPlayer {

    /**
     * Id of the sound currently playing
     */
	private int soundCurrentlyPlaying = 0;
	/**
     * Initialize fields
     */

    public SoundPlayer() {}; 
    /**
     * Start loop background music
     */
    public void bgm() {

    	startLoop("res/sfx/bgm.mp3");
    }
    /**
     * Play boom sfx
     */
    public void boom() { 

        start("res/sfx/boom.m4a");
    }
    /**
     * Play croissant hit sfx
     */
    public void whoosh() { 

    	start("res/sfx/whoosh.m4a");
    }
    /**
     * Play manager attack sfx
     */
    public void shoot() { 

    	startShoot("res/sfx/shoot.m4a");
    }
    /**
     * Play game start sfx
     */
    public void gameStart() { 

    	start("res/sfx/start.mp3");
    }
    /**
     * Play level up sfx
     */
    public void lvlUp() { 

    	start("res/sfx/lvlup.m4a");
    }
    /**
     * Play sell towers sfx
     */
    public void sell() { 

    	start("res/sfx/sell.m4a");
    }

    /**
     * Handle multiple shooting sounds
     */
    public void startShoot(String path) { 

    	
    	if(soundCurrentlyPlaying > 5) return ;
    	
        String soundFile = path; // Replace with the path to your sound file
        Media sound = new Media(new File(soundFile).toURI().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(sound);
    	mediaPlayer.setOnEndOfMedia(() -> {soundCurrentlyPlaying--; System.out.println(soundCurrentlyPlaying);});
        mediaPlayer.setVolume(0.5);
        soundCurrentlyPlaying++;
        mediaPlayer.play();
    }
    
    /**
     * Start MediaPlayer
     */
    public void start(String path) { 

    	
        String soundFile = path; 
        Media sound = new Media(new File(soundFile).toURI().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }
    
    /**
     * Start loop background Music
     */
    public void startLoop(String path) { 

    	String soundFile = path;
    	Media sound = new Media(new File(soundFile).toURI().toString());
    	
    	MediaPlayer mediaPlayer = new MediaPlayer(sound);
    	mediaPlayer.setOnEndOfMedia(() -> {mediaPlayer.seek(javafx.util.Duration.ZERO);});
    	mediaPlayer.setVolume(1);
    	mediaPlayer.play();
    	
    	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.STOPPED) {
                
                System.exit(0);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Get currently playing sound
     */
	public int getSoundCurrentlyPlaying() { 

		return soundCurrentlyPlaying;
	}

}
