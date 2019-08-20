package game.plane.fly;

/**
 * @Description 奖励
 * @Author layanan
 * @Date 2019/7/26 23:26
 */
public interface Award {
    int DOUBLE_FIRE = 0;  //双倍火力
    int LIFE = 1; //1条命

    /**
     * 获得奖励类型（上面的0或者1）
     *
     * @return int
     * @auther layanan
     * @Date 2019/7/26 23:27
     */
    int getType();


}
