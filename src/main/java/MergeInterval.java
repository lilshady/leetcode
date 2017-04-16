import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lil_shady on 2017/4/16.
 */
//56
public class MergeInterval {

    public static List<Interval> merge(List<Interval> intervals) {


        List<Interval> result = new ArrayList<Interval>();

        if (intervals.size() <= 1) return intervals;

        Interval temp = intervals.get(0);

        for (int i = 1; i < intervals.size(); ++i){

            Interval now = intervals.get(i);

            if (isMerge(temp,now)){


                temp = new Interval(Math.min(now.start,temp.start),Math.max(now.end,temp.end));

            } else {


                result.add(temp);

                temp = now;

            }


        }
        result.add(temp);

        return result;

    }

    public static boolean isMerge(Interval before,Interval after){

        if (after.start <= before.start && after.end >= before.end)
            return true;

        if (after.start <= before.end)
            return true;

        return false;
    }

    public static void main(String [] args){

        List<Interval> test = new ArrayList<Interval>();

        test.add(new Interval(1,4));
        test.add(new Interval(0,0));
        //test.add(new Interval(8,10));
       // test.add(new Interval(15,18));



        System.out.println(merge(test));


    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return start + "  "+end;
    }
}

