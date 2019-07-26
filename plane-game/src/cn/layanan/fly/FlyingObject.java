package cn.layanan.fly;

import java.awt.image.BufferedImage;

/**
 * @Description 飞行物（敌机，密封，子弹，英雄机）
 * @Author layanan
 * @Date 2019/7/26 22:50
 */
public abstract class FlyingObject {
    protected int x;  //x坐标
    protected int y;  //y坐标
    protected int width;    //宽
    protected int height;   //高
    protected BufferedImage image;  //图片

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


    /**
     * 检查是否出界
     *
     * @return boolean
     * @auther layanan
     * @Date 2019/7/26 23:00
     */
    public abstract boolean outOfBounds();

    /**
     * 飞行物挪动一步
     *
     * @return void
     * @auther layanan
     * @Date 2019/7/26 23:01
     */
    public abstract void step();

    /**
     * 检查档期那飞行物是否被子弹击中
     *
     * @param bullet
     * @return boolean
     * @auther layanan
     * @Date 2019/7/26 23:09
     */
    public boolean shootBy(Bullet bullet) {
        int x = bullet.x; //子弹横坐标
        int y = bullet.y; //子弹纵坐标
        return this.x < x && x < this.x + width && this.y < y && y < this.y + height;
    }

}
