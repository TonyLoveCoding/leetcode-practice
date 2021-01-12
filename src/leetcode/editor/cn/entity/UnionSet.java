package leetcode.editor.cn.entity;

public class UnionSet {
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
            rank[rootX]++;
        }
    }

    public static void main(String[] args) {
        UnionSet unionSet = new UnionSet(10);
        unionSet.union(1,2);
        unionSet.union(3,4);
        unionSet.union(4,5);
        System.out.println(unionSet.find(1));//return 1
        System.out.println(unionSet.find(2));//return 1
        System.out.println(unionSet.find(3));//return 3
        System.out.println(unionSet.find(4));//return 3
        System.out.println(unionSet.find(5));//return 3
        unionSet.union(6,7);
        unionSet.union(2,5);
        System.out.println(unionSet.find(1));//return 1
        System.out.println(unionSet.find(2));//return 1
        System.out.println(unionSet.find(3));//return 1
        System.out.println(unionSet.find(4));//return 1
        System.out.println(unionSet.find(5));//return 1
        System.out.println(unionSet.find(6));//return 6
        System.out.println(unionSet.find(7));//return 6
    }
}
