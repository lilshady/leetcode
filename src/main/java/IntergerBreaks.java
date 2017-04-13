/**
 * Created by lil_shady on 2017/4/13.
 */
//343
// 当拆成两个的情况，设拆成a,b 则 (n-a) * a 最大
//a = n/2时 最大，奇数时类似。
// (n/2)^2 大于 n，则n需要大于4，奇数类似。
//所以 当n <= 4时，不如不拆。所以 最后的factor只应该包含1，2，3
// 1 抛弃，相同的情况下，3要比2效果好，所以要尽量用3
// 比如6 ， 3 * 3 > 2 * 2 * 2
public class IntergerBreaks {

    public static int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;

        return product;
    }
}
