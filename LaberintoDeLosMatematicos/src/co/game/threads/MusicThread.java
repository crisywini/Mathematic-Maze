package co.game.threads;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicThread extends Thread {

	private Clip song;
	private String path;
	private int repeats;

	public MusicThread(String path, int repeats) {
		this.repeats = repeats;
		this.path = path;
	}
	@Override
	public void run() {
		try {
			URL url = new URL(path);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			song = AudioSystem.getClip();
			song.open(audioIn);
			song.loop(repeats);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public Clip getSong() {
		return song;
	}

	public void setSong(Clip song) {
		this.song = song;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getRepeats() {
		return repeats;
	}

	public void setRepeats(int repeats) {
		this.repeats = repeats;
	}
}
