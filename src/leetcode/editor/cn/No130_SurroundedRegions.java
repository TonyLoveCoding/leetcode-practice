package leetcode.editor.cn;

import leetcode.editor.cn.entity.UnionSet;

public class No130_SurroundedRegions{

//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 448 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char WHITE = 'O', BLACK = 'X';
    int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    UnionSet unionSet;
    int n, m, dismiss;

    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return;
        }
        n = board.length;
        m = board[0].length;
        unionSet = new UnionSet(n * m + 1);
        dismiss  = n * m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == WHITE){
                    if(i == 0 || i == n - 1 || j == 0 || j == m - 1){
                        unionSet.union(index(i, j), dismiss);
                    } else{
                        for(int k = 0; k < 4; k++){
                            int nextI = i + direction[k][0];
                            int nextJ = j + direction[k][1];
                            if((nextI > 0 || nextI < n || nextJ > 0 || nextJ < n) && board[nextI][nextJ] == WHITE){
                                unionSet.union(index(i, j), index(nextI, nextJ));
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == WHITE){
                    if(unionSet.find(index(i,j)) == unionSet.find(dismiss)){
                        board[i][j] = WHITE;
                    } else{
                        board[i][j] = BLACK;
                    }
                }
            }
        }
    }

    public int index(int x, int y){
        return x * m + y;
    }

    class UnionSet {
        private int[] parent;
        private int[] rank;

        public UnionSet(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            } else{
                parent[rootY] = rootX;
                rank[rootY]++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No130_SurroundedRegions().new Solution();
//        char[][] input = new char[][]{
//                {'X','O','X','O','X','O'},
//                {'O','X','O','X','O','X'},
//                {'X','O','X','O','X','O'},
//                {'O','X','O','X','O','X'}
//        };
        char[][] input = new char[][]{
                {'X','O','X','X'},
                {'O','X','O','X'},
                {'X','O','X','O'},
                {'O','X','O','X'},
                {'X','O','X','O'},
                {'O','X','O','X'}
        };
        print(input);
        solution.solve(input);
        System.out.println("deal:");
        print(input);
    }
    public static void print(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}