package com.garrett.ogl;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main implements Runnable {
	
	public static int width = 900;
	public static int height = width / 16 * 9;
	
	private Thread thread;
	private boolean running = false;

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "MainGameThread");
		thread.start();
	}
	
	public void init() {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle("Super Computer");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public void initGL() {
		
	}
	
	public void run() {
		init();
		initGL();
		while (running) {
			update();
			render();
		}
	}
	
	private void clear() {
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
	}
	
	public void update() {
		
	}
	
	public void render() {
		clear();
		Display.sync(60);
		Display.update();
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
	
}
