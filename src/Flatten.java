import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class Flatten {


    public static Integer[] flatten(Object[] nestedArrays)
    {

        List<Integer> flat = new ArrayList<>();

        if(nestedArrays == null) return null;

        for(Object elem : nestedArrays)
        {
            if(elem instanceof Integer)
            {
                flat.add((Integer)elem);
            } else{
                Collections.addAll(flat, flatten((Object[]) elem));
        }
        }
        Integer[] result = flat.toArray(new Integer[flat.size()]);

        return result;
    }

    @Test
    public void isArrayNull()
    {
        Assert.assertNull(flatten(null));
    }

    @Test
    public void isArrayEmpty()
    {
        Assert.assertArrayEquals("empty",
                new Integer[]{},
                flatten(new Object[]{} ) );
    }

    @Test
    public void isNotNested()
    {
        Assert.assertArrayEquals("not nested",
                new Integer[]{100,1000,10,11,0,1010},
                flatten( new Object[]{100,1000,10,11,0,1010}) );
    }
}