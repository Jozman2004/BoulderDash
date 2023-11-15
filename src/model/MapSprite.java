package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapSprite {

    final int rows = 20;
    final int cols = 12;
    BufferedImage[] sprites = new BufferedImage[rows * cols];

    public BufferedImage[] Image(){
        final int width = 16;
        final int height = 16;
        try {
            BufferedImage bigImg = ImageIO.read(new File("src\\model\\elements\\sprite\\74359.png"));

            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    sprites[(i * cols) + j] = bigImg.getSubimage(
                        j * width,
                        i * height,
                        width,
                        height
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sprites;
    }

    public static void main(String[] args) throws Exception {
        MapSprite map = new MapSprite();
        map.Image();

        JFrame frame = new JFrame("MapSprite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Créer un JPanel pour contenir les sprites
        JPanel panel = new JPanel();

        // Ajouter chaque sprite au JPanel
        for (BufferedImage sprite : map.sprites) {
            if (sprite != null) {
                JLabel spriteLabel = new JLabel(new ImageIcon(sprite));
                panel.add(spriteLabel);
            }
        }
         // Ajouter le JPanel au JFrame
         frame.add(panel);

         frame.setVisible(true);
    }

    public BufferedImage giveSprite(int index){
        if(index >= 0 && index < sprites.length){
            return sprites[index];
        } else {
            return null;
        }
    }

    public BufferedImage[] getSprites() {
        return sprites;
    }
}