package cn.layanan.game.fly;

import java.util.Random;

/**
 * @Description 密封
 * @Author layanan
 * @Date 2019/7/26 23:28
 */
public class Bee extends FlyingObject implements Award {
    private int xSpeed = 1;   //x坐标移动速度
    private int ySpeed = 2;   //y坐标移动速度
    private int awardType;  //奖励类型

    public Bee() {
        this.image = ShootGame.bee;
        this.width = image.getWidth();
        this.height = image.getHeight();
        y = -height;
        Random rand = new Random();
        x = rand.nextInt(ShootGame.WIDTH - width);
        awardType = rand.nextInt(2);
    }

    @Override
    public int getType() {
        return awardType;
    }

    @Override
    public boolean outOfBounds() {
        return y > ShootGame.HEIGHT;
    }

    @Override
    public void step() {
        x += xSpeed;
        y += ySpeed;
        if (x > ShootGame.WIDTH - width) {
            xSpeed = -1;
        }
        if (x < 0) {
            xSpeed = 1;
        }
    }

    public static void main(String[] args) {
        int i = 0;
        while (true) {
            int a = 40;
            a -= i / 10;
            System.out.println(a);
            i++;
        }
    }

}
