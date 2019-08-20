package fly;

import java.awt.image.BufferedImage;

/**
 * @Description 英雄机：是飞行物
 * @Author layanan
 * @Date 2019/7/26 23:34
 */
public class Hero extends FlyingObject {
    private BufferedImage[] images = {};  //英雄机图片
    private int index = 0;  //英雄机图片切换索引

    private int speed = 15; //移动的速度


    private int doubleFire; //双倍火力
    private int life;   //命

    public Hero() {
        life = 3;     //初始3条名
        doubleFire = 0;   //初始火力为0;
        images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1}; //英雄机图片数组
        this.image = ShootGame.hero0; //初始为hero0的图片
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.x = 150;
        this.y = 400;

    }

    /**
     * 获取双倍火力
     *
     * @auther layanan
     * @Date 2019/7/26 23:39
     */
    public int getDoubleFire() {
        return doubleFire;
    }

    /**
     * 设置双倍火力
     *
     * @auther layanan
     * @Date 2019/7/26 23:40
     */
    public void setDoubleFire(int doubleFire) {
        this.doubleFire = doubleFire;
    }

    /**
     * 增加火力
     */
    public void addDoubleFire() {
        doubleFire = 40;
    }

    /**
     * 增命
     */
    public void addLife() {  //增命
        life++;
    }

    /**
     * 减命
     */
    public void subtractLife() {   //减命
        life--;
    }

    /**
     * 获取命
     */
    public int getLife() {
        return life;
    }

    /**
     * 当前物体移动了一下，相对距离，x,y鼠标位置
     */
    public void moveTo(int x, int y) {
        this.x = x - width / 2;
        this.y = y - height / 2;
    }

    public void left() {
        this.x -= speed;
    }

    public void right() {
        this.x += speed;
    }

    public void up() {
        this.y -= speed;
    }

    public void down() {
        this.y += speed;
    }

    /**
     * 发射子弹
     *
     * @auther layanan
     * @Date 2019/7/26 23:43
     */
    public Bullet[] shoot() {
        int xStep = width / 4;  //4半
        int yStep = 20;   //步
        if (doubleFire > 0) {//双倍火力
            Bullet[] bullets = new Bullet[2];
            bullets[0] = new Bullet(x + xStep, y - yStep);  //y-yStep(子弹距飞机的位置)
            bullets[1] = new Bullet(x + 3 * xStep, y - yStep);
            return bullets;
        } else {      //单倍火力
            Bullet[] bullets = new Bullet[1];
            bullets[0] = new Bullet(x + 2 * xStep, y - yStep);
            return bullets;
        }
    }


    @Override
    public boolean outOfBounds() {
        return false;
    }

    @Override
    public void step() {
        if (images.length > 0) {
            image = images[index++ / 10 % images.length];  //切换图片hero0，hero1
        }
    }

    /**
     * 碰撞算法
     */
    public boolean hit(FlyingObject other) {

        int x1 = other.x - this.width / 2;                 //x坐标最小距离
        int x2 = other.x + this.width / 2 + other.width;   //x坐标最大距离
        int y1 = other.y - this.height / 2;                //y坐标最小距离
        int y2 = other.y + this.height / 2 + other.height; //y坐标最大距离

        int herox = this.x + this.width / 2;               //英雄机x坐标中心点距离
        int heroy = this.y + this.height / 2;              //英雄机y坐标中心点距离

        return herox > x1 && herox < x2 && heroy > y1 && heroy < y2;   //区间范围内为撞上了
    }
}
