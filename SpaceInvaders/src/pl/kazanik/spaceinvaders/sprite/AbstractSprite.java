/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.sprite;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;
import pl.kazanik.spaceinvaders.main.GameCanvas;

/**
 *
 * @author kazanik
 */
public abstract class AbstractSprite implements Serializable {
    
    private float width;
    private float height;
    private float x;
    private float y;
    private int collisionOffset;
    private transient BufferedImage image;

    protected AbstractSprite() {
    }

    protected AbstractSprite(float width, float height, float x, float y, 
            int collisionOffset, BufferedImage image) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.collisionOffset = collisionOffset;
        this.image = image;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.writeInt(1); // how many images are serialized?
        //for (BufferedImage eachImage : images) {
            ImageIO.write(image, "png", out); // png is lossless
        //}
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //final int imageCount = in.readInt();
        //images = new ArrayList<BufferedImage>(imageCount);
        //for (int i=0; i<imageCount; i++) {
            //images.add(ImageIO.read(in));
        //}
        image = ImageIO.read(in);
    }
    
    public abstract Rectangle collisionRect();
    
    public void draw(Graphics g, GameCanvas canvas) {
//        System.out.println("Sprite draw");
        g.drawImage(image, (int)x, (int)y, (int)(x+width), (int)(y+height), 
                0, 0, image.getWidth(), image.getHeight(), null);
    }
    
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getCollisionOffset() {
        return collisionOffset;
    }

    public void setCollisionOffset(int collisionOffset) {
        this.collisionOffset = collisionOffset;
    }
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Float.floatToIntBits(this.x);
        hash = 67 * hash + Float.floatToIntBits(this.y);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractSprite other = (AbstractSprite) obj;
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
            return false;
        }
        return true;
    }
    
}
