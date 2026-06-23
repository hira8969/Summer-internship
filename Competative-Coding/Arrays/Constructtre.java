package Arrays;


    
class Node {

    public boolean val;
    public boolean isLeaf;

    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
    }

    public Node(boolean val,
                boolean isLeaf,
                Node topLeft,
                Node topRight,
                Node bottomLeft,
                Node bottomRight) {

        this.val = val;
        this.isLeaf = isLeaf;

        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
public class Constructtre {
public class Main {

    public static Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private static Node build(int[][] grid, int row, int col, int size) {

        boolean same = true;
        int value = grid[row][col];

        for (int i = row; i < row + size; i++) {

            for (int j = col; j < col + size; j++) {

                if (grid[i][j] != value) {
                    same = false;
                    break;
                }
            }

            if (!same)
                break;
        }

        // Leaf node
        if (same) {

            return new Node(
                    value == 1,
                    true,
                    null,
                    null,
                    null,
                    null
            );
        }

        int half = size / 2;

        Node topLeft = build(grid, row, col, half);

        Node topRight = build(grid, row, col + half, half);

        Node bottomLeft = build(grid, row + half, col, half);

        Node bottomRight = build(grid, row + half, col + half, half);

        return new Node(
                true,
                false,
                topLeft,
                topRight,
                bottomLeft,
                bottomRight
        );
    }

    // Print Quad Tree
    private static void print(Node root) {

        if (root == null)
            return;

        System.out.println(
                "isLeaf = " + root.isLeaf +
                ", val = " + root.val
        );

        if (!root.isLeaf) {

            print(root.topLeft);

            print(root.topRight);

            print(root.bottomLeft);

            print(root.bottomRight);
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1},
                {1, 0}
        };

        Node root = construct(grid);

        print(root);
    }
}