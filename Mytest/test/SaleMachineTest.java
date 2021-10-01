import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaleMachineTest {
    SaleMachine sm;
    @Before
    public void setUp() throws Exception {
        sm  = new SaleMachine();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sayHi() {
        sm.sayHi(true);
//        sm.sayHi(false);
    }

    @Test
    public void sayBye() {
        sm.sayBye();
    }
}