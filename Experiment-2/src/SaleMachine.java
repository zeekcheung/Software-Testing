public class SaleMachine {
    private int fiveNum, orangeNum, beerNum;    // 零钱数量，橙汁数量、啤酒数量
    private String[] type = {"beer", "orange"};
    private String[] answer = {"很抱歉，没有", "请取走", "拿好5元，请取走", "没有零钱找，退您10元", "错误指令！"};

    public SaleMachine() {
        orangeNum = 5;
        beerNum = 5;
        fiveNum = 5;
    }

    public String sale(String drink, int money) {
        String result = null;   // a
        if (beerNum < 1 && drink.equals(type[0]) || orangeNum < 1 && drink.equals(type[1])) {
            result = answer[0] + drink; // b
        } else if (money == 5) {
            fiveNum++;  // c
            result = answer[1] + drink; // d
            if (drink.equals(type[0])) {
                beerNum--;  // e
            } else if (drink.equals(type[1])) {
                orangeNum--;    // f
            } else {
                result = answer[4]; // g
            }
        } else if (money == 10) {
            if (fiveNum < 1) {
                result = answer[3]; // h
//                return answer[3];   // FIXME：测试二：test2_ahmn，应该直接返回
            } else {
                fiveNum--;  // i
//                result = answer[1] + drink; // j // FIXME: 测试一：test1_aijkmn、test1_aijlmn，应该是 answer[2] + drink
                 if (drink.equals(type[0])) {
                    beerNum--;  // k
                } else if (drink.equals(type[1])) {
                    orangeNum--;    // l
                } // else return answer[4]; // FIXME: 测试三：购买啤酒、橙汁之外的饮料应该报“指令错误”
                return answer[2] + drink;  // FIXME：测试一：并且应该直接返回
            }
            result = answer[4]; // m  // FIXME: 测试二：这条语句不可能运行，应该删掉
        } // else result = "错误指令！"; // FIXME: 测试三：饮料类型和付钱金额不合法应该报错
        return result;  // n
    }
}
