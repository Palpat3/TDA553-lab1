package set;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    Point scaniaPoint = new Point();
    Point saabPoint = new Point();

    private ArrayList<Point> pointList = new ArrayList();
    private ArrayList<BufferedImage> imageList = new ArrayList();
    

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, int index){
        pointList.set(index, new Point(x, y));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        int startY = 0;

        for (Vehicle vehicle : vehicles){

            pointList.add(new Point(0,startY));
            vehicle.setY(startY);
            startY += 100;

        
            // Print an error message in case file is not found with a try/catch block
            try {
                // You can remove the "pics" part if running outside of IntelliJ and
                // everything is in the same main folder.
                // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

                // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
                // if you are starting in IntelliJ.
                imageList.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle.getModelName() + ".jpg")));
            
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point point : pointList){
            int index = pointList.indexOf(point);
            BufferedImage image = imageList.get(index);
            g.drawImage(image, point.x, point.y, null);
        }
    }
}
