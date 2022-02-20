package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1991 {

  // 노드 클래스
  static class Node{
    int left, right; //왼쪽자식, 오른쪽자식

    public Node(int left, int right){
      this.left = left;
      this.right = right;
    }
  }

  static int n;
  static List<Node>[] tree; // 노드 간의 연결관계를 알기 위해 list형의 배열 생성
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    // init tree
    tree = new List[n];
    for(int i = 0; i < tree.length; i++){
      tree[i] = new ArrayList<>();
    }
    StringTokenizer st;
    // add node
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      // change to integer ('.' - 'A' == -19)
      int p = st.nextToken().charAt(0) - 'A';
      int l = st.nextToken().charAt(0) - 'A';
      int r = st.nextToken().charAt(0) - 'A';
      tree[p].add(new Node(l, r));
    }
    // preorder
    preorder(0);
    sb.append("\n");
    // inorder
    inorder(0);
    sb.append("\n");
    //postorder
    postorder(0);
    System.out.println(sb.toString());
  }
  static void preorder(int start){
    // case : .
    if(start < 0) return;

    // 자식노드가 없으면 리턴
    if(tree[start].isEmpty()) return;

    // root -> left -> right
    sb.append((char) ('A'+start));
    preorder(tree[start].get(0).left);
    preorder(tree[start].get(0).right);
  }
  static void inorder(int start){
    // case : .
    if(start < 0) return;
    // have no child
    if(tree[start].isEmpty()) return;
    // left -> root -> right
    inorder(tree[start].get(0).left);
    sb.append((char) ('A' + start));
    inorder(tree[start].get(0).right);
  }
  static void postorder(int start){
    // case : .
    if(start < 0) return;
    // have no child
    if(tree[start].isEmpty()) return;
    // left -> root -> right
    postorder(tree[start].get(0).left);
    postorder(tree[start].get(0).right);
    sb.append((char) ('A' + start));
  }
}
