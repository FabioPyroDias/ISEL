/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package classcode.p15Swing.p09MoreStuff;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Slider, permite ver e selecionar um valor dentro de uma gama
 * 
 * SliderDemo.java requires all the files in the images/doggy directory.
 */
public class C06SliderDemo extends JPanel implements ActionListener,
		WindowListener, ChangeListener {
	private static final long serialVersionUID = 1L;

	// Set up animation parameters.
	static final int FPS_MIN = 0;
	static final int FPS_MAX = 30;
	static final int FPS_INIT = 15; // initial frames per second

	int frameNumber = 0;
	int NUM_FRAMES = 14;

	ImageIcon[] images = new ImageIcon[NUM_FRAMES];

	int delay;
	Timer timer;
	boolean frozen = false;

	// This label uses ImageIcon to show the doggy pictures.
	JLabel picture;
	JSlider framesPerSecond;
	JSlider sliderFrame;

	public C06SliderDemo() {

		// layout to display elements in Panel
		setLayout(new BorderLayout());

		delay = 1000 / FPS_INIT;

		// Create the label.
		JLabel sliderLabel = new JLabel("Frames Per Second", JLabel.CENTER);
		sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		sliderLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

		// slider, of frames per second
		framesPerSecond = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX,
				FPS_INIT);
		framesPerSecond.addChangeListener(this);

		// Turn on labels at major tick marks.
		framesPerSecond.setMajorTickSpacing(10);
		framesPerSecond.setMinorTickSpacing(1);
		framesPerSecond.setPaintTicks(true);
		framesPerSecond.setPaintLabels(true);
		framesPerSecond.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font = new Font("Serif", Font.ITALIC, 15);
		framesPerSecond.setFont(font);

		// Create the label that displays the animation.
		picture = new JLabel();
		picture.setHorizontalAlignment(JLabel.CENTER);
		picture.setAlignmentX(Component.CENTER_ALIGNMENT);
		picture.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLoweredBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		updatePicture(0); // display first frame

		// JSlider of current image
		sliderFrame = new JSlider(JSlider.HORIZONTAL, 0, NUM_FRAMES - 1,
				frameNumber);

		sliderFrame.setEnabled(false);
		sliderFrame.setMajorTickSpacing(1);
		sliderFrame.setMinorTickSpacing(1);
		sliderFrame.setPaintTicks(true);
		sliderFrame.setPaintLabels(true);
		sliderFrame.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		sliderFrame.setFont(font);

		// Put everything together.
		add(sliderLabel);
		add(framesPerSecond, BorderLayout.NORTH);
		add(picture);
		add(sliderFrame, BorderLayout.SOUTH);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Set up a timer that calls this object's action handler.
		timer = new Timer(delay, this);
		timer.setInitialDelay(delay * 7); // We pause animation twice per cycle
											// by restarting the timer
		timer.setCoalesce(true);
	}

	/** Add a listener for window events. */
	void addWindowListener(Window w) {
		w.addWindowListener(this);
	}

	// React to window events.
	public void windowIconified(WindowEvent e) {
		stopAnimation();
	}

	public void windowDeiconified(WindowEvent e) {
		startAnimation();
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	/** Listen to the slider. */
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			int fps = (int) source.getValue();
			if (fps == 0) {
				if (!frozen)
					stopAnimation();
			} else {
				delay = 1000 / fps;
				timer.setDelay(delay);
				timer.setInitialDelay(delay * 10);
				if (frozen)
					startAnimation();
			}
		}
	}

	public void startAnimation() {
		// Start (or restart) animating!
		frozen = false;
		timer.start();
	}

	public void stopAnimation() {
		// Stop the animating thread.
		timer.stop();
		frozen = true;
	}

	// Called when the Timer fires.
	public void actionPerformed(ActionEvent e) {
		// Advance the animation frame.
		if (++frameNumber == NUM_FRAMES)
			frameNumber = 0;

		// display the next picture
		updatePicture(frameNumber);
		sliderFrame.setValue(frameNumber);

		if (frameNumber == (NUM_FRAMES - 1)
				|| frameNumber == (NUM_FRAMES / 2 - 1)) {
			timer.restart();
		}
	}

	/** Update the label to display the image for the current frame. */
	protected void updatePicture(int frameNum) {
		// Get the image if we haven't already.
		if (images[frameNumber] == null) {
			images[frameNumber] = createImageIcon("imagesdoggy/T" + frameNumber
					+ ".gif");
		}

		// Set the image.
		if (images[frameNumber] != null) {
			picture.setIcon(images[frameNumber]);
		} else { // image not found
			picture.setText("image #" + frameNumber + " not found");
		}
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = C06SliderDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("SliderDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		C06SliderDemo animator = new C06SliderDemo();

		// Add content to the window.
		frame.add(animator, BorderLayout.CENTER);

		// Display the window.
		frame.setMinimumSize(new Dimension(300, 350));
		frame.pack();
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
		animator.startAnimation();
	}

	public static void main(String[] args) {
		/* Turn off metal's use of bold fonts */
		// UIManager.put("swing.boldMetal", Boolean.FALSE);

		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
