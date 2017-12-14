/**
 * TODO: comment here
 */
public class BallDrop {

	//n:第几个小球 deep: 二叉树最大深度。
	//return 落在第几个叶子节点
	public static int decideFalltoWhich(int n, int deep) {

		int k = 1;

		for (int i = 0; i < deep - 1; i++) {
			if (n % 2 == 1) {
				k = k * 2;
				n = (n+1) / 2;
			} else {
				k = k * 2 + 1;
				n = n / 2;
			}
		}

		return k;
	}
}
