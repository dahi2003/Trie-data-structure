class TrieNode {
    TrieNode[] children = new TrieNode[2]; // in binary form 0 and 1
}

public class MaxXORWithX {
    private TrieNode root = new TrieNode();

    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }
    public int getMaxXOR(int x) {
        TrieNode node = root;
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1;
            int toggleBit = 1 - bit;
            if (node.children[toggleBit] != null) {
                maxXOR |= (1 << i);
                node = node.children[toggleBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXOR;
    }
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 4};
        int x = 2;
        MaxXORWithX trie = new MaxXORWithX();
        for (int num : arr) {
            trie.insert(num);
        }
        int result = trie.getMaxXOR(x);
        System.out.println(result);
    }
}
