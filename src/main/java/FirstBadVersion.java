/**
 * Created by lil_shady on 2017/8/3.
 */

//278Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {

        //1234 2
        int left = 1;
        int right = n;

        while(left < right) {

            int mid = left + (right-left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;


    }

    public static void main(String[] args) {




    }

}


class VersionControl {

    boolean isBadVersion(int version){

        return true;

    }
}
