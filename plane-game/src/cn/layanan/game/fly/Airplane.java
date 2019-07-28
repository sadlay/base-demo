package cn.layanan.game.fly;

import java.util.Random;

/**
 * @Description 敌人飞机，是飞行物也是敌人
 * @Author layanan
 * @Date 2019/7/26 23:18
 */
public class Airplane extends FlyingObject implements Enemy {
    private int speed = 3; //移动的速度

    public Airplane() {
        this.image = ShootGame.airplane;
        this.width = image.getWidth();
        this.height = image.getHeight();
        y = -height;
        Random rand = new Random();
        x = rand.nextInt(ShootGame.WIDTH - width);
    }

    @Override
    public int getScore() {
        return 5;
    }

    @Override
    public boolean outOfBounds() {
        return y > ShootGame.HEIGHT;
    }

    @Override
    public void step() {
        y += speed;
    }
}
