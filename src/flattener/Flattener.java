package flattener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Flattener {


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


}