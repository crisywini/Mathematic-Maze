package co.game.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import co.game.elements.ICellConfiguration;
import co.game.elements.MyCanvas;
import co.game.threads.MusicThread;

public class Application extends JFrame implements ICellConfiguration{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MyCanvas canvas;
	private MusicThread musicThread;

	public Application() {
		this.canvas = new MyCanvas();
		this.canvas.setFocusable(true);
		this.canvas.requestFocus();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(canvas);
		this.setSize(canvas.getWidth()*2, canvas.getHeight()*2);
		musicThread = new MusicThread(PATH+"/resources/music/AfricanSafariLoop.wav", 2);
		musicThread.run();
	}

	public MyCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(MyCanvas canvas) {
		this.canvas = canvas;
	}

	public MusicThread getMusicThread() {
		return musicThread;
	}

	public void setMusicThread(MusicThread musicThread) {
		this.musicThread = musicThread;
	}

}
