package View;

import Controller.States.State;
import View.Graphics.Assets;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class View extends JFrame implements Runnable {

    private Canvas canvas;
    private String title;

    private int width, height;

    private BufferStrategy bs;
    private Graphics g;


    public View(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }



    public void createDisplay() {
        setTitle("Ironic Cats");
        setSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        add(canvas);
        pack();

        Assets.init();

    }

    

    public Canvas getCanvas() {
        return canvas;
    }

    public void render() {
        bs = this.getCanvas().getBufferStrategy();
        if(bs == null) {
            this.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        g.clearRect(0, 0, width, height);

        if(State.getState() != null ) {
            State.getState().render(g);
        }

        bs.show();
        g.dispose();

    }

    public void run() {
        int renders = 0;

        while(true) {
            long lastTime = System.currentTimeMillis();
            //RENDER THINGS HERE

            render();

            double delta = System.currentTimeMillis() - lastTime;
            if(delta < 50) {
                try {
                    Thread.sleep(((long)(50 - delta)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //System.out.println("Redraw Graphics");
        }
    }

    public synchronized void start() {
        new Thread(this).start();
    }

}
