import org.junit.Assert;
import org.junit.Test;
import flattener.Flattener;


public class FlattenTest {


    @Test
    public void isArrayNull()
    {
        Assert.assertNull(Flattener.flatten(null));
    }

    @Test
    public void isArrayEmpty()
    {
        Assert.assertArrayEquals("empty",
                new Integer[]{},
                Flattener.flatten(new Object[]{} ) );
    }

    @Test
    public void isNotNested()
    {
        Assert.assertArrayEquals("not nested",
                new Integer[]{100,1000,10,11,0,1010},
                Flattener.flatten( new Object[]{100,1000,10,11,0,1010}) );
    }

    @Test
    public void is2DArray()
    {
        Assert.assertArrayEquals("2D",
                new Integer[]{1,2,3},
                Flattener.flatten ( new Object[]{1, new Object[]{2,3} } ));

    }

    @Test //this covers uneven depths with a mixture of empty arrays and multi level nesting
    public void isMultipleDepths()
    {
        Assert.assertArrayEquals("Uneven depths",
                new Integer[]{1,2,3},
                Flattener.flatten ( new Object[]{1, new Object[]{new Object[]{2, new Object[]{3}}}, new Object[]{}} ));
    }


}