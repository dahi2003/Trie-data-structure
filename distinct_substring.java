class TrieNode{
  Map<Character,TrieNode> children=new HashMap<>();
}
public class distinct{
  private TrieNode root;
  public distinct(){
    root=new TrieNode();
  }
public int count(String s){
  int cnt=0;
  for(int i=0;i<s.length();i++){
    TrieNode current=root;
    for(int j=i+1;j<s.length();j++{
      char ch=s.charAt(j);
      if(!current.children.containsKey(ch)){
        current.children.put(ch,new TrieNode());
        cnt++;
      }
      current=current.children.get(ch);
    }
  }
  return cnt;}
