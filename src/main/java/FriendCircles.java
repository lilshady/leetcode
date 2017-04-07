/**
 * Created by luyuncheng on 2017/4/7.
 */
//547
public class FriendCircles {

    public static int findCircleNum(int[][] M) {

        int studentNum = M.length;

        int friendCircles = 0;

        boolean[] visited = new boolean[studentNum];

        for (int i = 0; i < studentNum; ++i){

            if (!visited[i]) {

                friendCircles++;

                dfs(M, i, visited);
            }
        }

        return friendCircles;
    }

    private static void dfs(int[][] M,int startPoint,boolean[] visited){

        visited[startPoint] = true;

        for (int i = 0; i <  M[startPoint].length;++i){

            if (M[startPoint][i]== 1 && !visited[i]){

                dfs(M,i,visited);
            }

        }


    }

    public static void main(String[] args){

        int[][] m = new int[][]{{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(findCircleNum(m));


    }


}
