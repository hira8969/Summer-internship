package Arrays;


    
import java.util.*;
public class wordsearch2 {

    static class TrieNode {

        TrieNode[] children = new TrieNode[26];

        String word;
    }

    public static List<String> findWords(char[][] board, String[] words) {

        TrieNode root = buildTrie(words);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    public static void dfs(char[][] board, int row, int col,
                           TrieNode node, List<String> result) {

        if (row < 0 || col < 0
                || row >= board.length
                || col >= board[0].length) {

            return;
        }

        char ch = board[row][col];

        if (ch == '#') {

            return;
        }

        if (node.children[ch - 'a'] == null) {

            return;
        }

        node = node.children[ch - 'a'];

        if (node.word != null) {

            result.add(node.word);

            node.word = null;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, node, result);
        dfs(board, row - 1, col, node, result);
        dfs(board, row, col + 1, node, result);
        dfs(board, row, col - 1, node, result);

        board[row][col] = ch;
    }

    public static TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {

            TrieNode current = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {

                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.word = word;
        }

        return root;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {
                "oath",
                "pea",
                "eat",
                "rain"
        };

        List<String> answer = findWords(board, words);

        System.out.println(answer);
    }
}