package cn.layanan.fly;

/**
 * @Description 子弹类，是飞行物
 * @Author layanan
 * @Date 2019/7/26 23:02
 */
public class Bullet extends FlyingObject {
    private int speed = 3;    //移动的速度

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean outOfBounds() {
        return y < -height;
    }

    /**
     * 移动
     */
    @Override
    public void step() {
        y -= speed;
    }
}
