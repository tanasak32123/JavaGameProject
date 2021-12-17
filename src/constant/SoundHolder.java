package constant;

import javafx.scene.media.AudioClip;

public class SoundHolder {

	private static final String MP3 = "mp3";
	private static final SoundHolder instance;

	public AudioClip bgm;

	static {
		instance = new SoundHolder();
	}

	public static SoundHolder getInstance() {
		return SoundHolder.instance;
	}

	public SoundHolder() {

		this.bgm = this.loadSound("sound", "mp3");

	}

	public AudioClip loadSound(final String prefixName, final String fileType) {
		return new AudioClip(ClassLoader.getSystemResource(prefixName + '.' + fileType).toString());
	}
}
