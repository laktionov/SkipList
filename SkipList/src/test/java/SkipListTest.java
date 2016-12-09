import org.junit.Assert;
import org.junit.Test;

public class SkipListTest {
    @Test
    public void testGetPut() {
        SkipList<Integer> sl = new SkipList<>();
        int[] data = {4,2,7,0,9,1,3,7,3,4,5,6,0,2,8};
        int k = 0;
        for (int i : data) {
            sl.put(i, k++);
        }

        Assert.assertTrue(sl.get(0) == 12);
        sl.print();
        sl.get(4);

        sl.delete(5);
        Assert.assertTrue(sl.get(5) == null);
        sl.print();

        sl.delete(6);
        sl.delete(7);

        sl.put(6, 69);
        sl.print();
        Assert.assertTrue(sl.get(6) == 69);



    }
}
