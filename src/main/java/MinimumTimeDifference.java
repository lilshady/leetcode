import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by luyuncheng on 2017/4/7.
 */
//539
public class MinimumTimeDifference {

    public static int findMinDifference(List<String> timePoints) {

        if (timePoints == null || timePoints.isEmpty() || timePoints.size() == 1) return 0;

        List<Integer> minuteTimePoint = new ArrayList<Integer>(timePoints.size());

        for (String p : timePoints) minuteTimePoint.add(convert2Minute(p));

        Collections.sort(minuteTimePoint);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < minuteTimePoint.size(); ++i){

             min = Math.min(minuteTimePoint.get(i) - minuteTimePoint.get(i-1),min
                  );
        }

        int corner = minuteTimePoint.get(0) + (1440 - minuteTimePoint.get(minuteTimePoint.size()-1));

        return Math.min(min,corner);


    }

    private static int convert2Minute(String timePoint){

        String[] hourAndMinute= timePoint.split(":");

        return Integer.parseInt(hourAndMinute[0]) * 60 + Integer.parseInt(hourAndMinute[1]);

    }

    public static void main(String[] args){

        System.out.println(findMinDifference(Arrays.asList("01:01","02:02")));

    }
}
