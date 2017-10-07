package algorithms.algorithmicGame.javaSwingBasics.circleAnimation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thpffcj on 2017/10/7.
 */
public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}
    //public JPanel getCanvas(){return canvas;}

    // data
    private Circle[] circles;
    public void render(Circle[] circles){
        this.circles = circles;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            AlgoVisHelper.setStrokeWidth(g2d,1);
            AlgoVisHelper.setColor(g2d, Color.RED);
            for(Circle circle: circles)
                if(circle.isFilled)
                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
                else
                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
