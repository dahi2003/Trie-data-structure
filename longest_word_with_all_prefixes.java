class solution{
  static class TrieNode{
    TrieNode [] children=new TrieNode[26];
    boolean isEnd=false;
    String word="";}
  public string longestWord(String [] words){
    TrieNode root=new TrieNode();
     for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
            node.word = word;
        }
//using dfs to find the longest word
 String result = "";
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TrieNode node = stack.pop();
            for (TrieNode child : node.children) {
                if (child != null && child.isEnd) {
                    stack.push(child);
                    if (child.word.length() > result.length() ||
                        (child.word.length() == result.length() && child.word.compareTo(result) < 0)) {
                        result = child.word;
                    }
                }
            }
        }
        return result;
    }

   
  
