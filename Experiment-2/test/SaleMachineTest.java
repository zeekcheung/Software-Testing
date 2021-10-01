import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaleMachineTest {
    SaleMachine sm;

    @Before
    public void setUp() throws Exception {
        sm = new SaleMachine();
    }

    @After
    public void tearDown() throws Exception {
        sm = null;
    }

    /* S 第一次测试：语句覆盖 */
    @Test
    public void test1_acden() {
        assertEquals("请取走beer", sm.sale("beer", 5));
    }
    @Test
    public void test1_acdfn() {
        assertEquals("请取走orange", sm.sale("orange", 5));
    }
    @Test
    public void test1_acdgn() {
        assertEquals("错误指令！", sm.sale("coke", 5));
    }
    @Test
    public void test1_aijkmn() {
/**/        assertEquals("拿好5元，请取走beer", sm.sale("beer", 10));
    }
    @Test
    public void test1_aijlmn() {
        assertEquals("拿好5元，请取走orange", sm.sale("orange", 10));
    }
    /* E 第一次测试*/

    /* S 第二次测试：测试语句：b、h */
    // 测试语句：b
    @Test
    public void test2_abn() {
        // 把啤酒买完，测试语句 b
        for (int i = 0; i < 5; i++) sm.sale("beer", 5);
        assertEquals("很抱歉，没有" + "beer", sm.sale("beer", 5));
    }
    // 测试语句：h
    @Test
    public void test2_ahmn() {
        // 把 5块钱全部找完，测试语句 g
        for (int i = 0; i < 5; i++) sm.sale("beer", 10);
        assertEquals("没有零钱找，退您10元", sm.sale("orange", 10) );
    }
    /* E 第二次测试 */

    /* S 第三次测试：测试分支：an、aijmn */
    // 测试分支：an
    @Test
    public void test3_an() {
        assertEquals("错误指令！", sm.sale("coke", 1));
    }
    @Test
    public void test3_aijmn() {
        assertEquals("错误指令！", sm.sale("coke", 10));
    }
    /* E 第三次测试 */
}