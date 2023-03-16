package JAVAFD.Treefarm;

import java.util.InputMismatchException;

public class TreeNode {
    public static Object getData;
    private TreeNode left;
    private TreeNode right;
    private TreeNode upnode;  
    private Object data;
    private Object keyval;

    public TreeNode(Object item) {
        left = null;
        right = null;
        data = null;
        upnode = null;
        keyval = item;
    }

    public void Calculation(TreeNode sub1, TreeNode sub2) {     //루트 노드를 기준으로 연산을 진행. 루트 노드는 sub2;
        int sub1_Value = (int)sub1.getData();
        int sub2_Value = (int)sub2.getData();

        if(sub1_Value < sub2_Value) {
            sub2.makeLeftsubTree(sub1);
        }
        if(sub1_Value > sub2_Value) {
            sub2.makeRightSubTree(sub1);
        }
    }

    public void makeSortTree(TreeNode sub1, TreeNode sub2, TreeNode sub3){ //기준은 sub1, 기존값은 sub2, 신규로바꿀값sub3
        if(sub3.getLeftSubTree() == null) {
            
        }else if(sub3.getRightSubTree() == null) {

        }else{

        }
    }
    
    public int SearchingSubTree (Object item, TreeNode sub) {
        int searh_Val = (int)item;
        int node_Val = (int)sub.getData();
        int final_Val = 0;
        if (searh_Val == node_Val) {
            final_Val = (int)sub.getkeyVal();
        }
        if (searh_Val < node_Val) {
            this.SearchingSubTree(item, this.getLeftSubTree());
        }
        if (searh_Val > node_Val) {
            this.SearchingSubTree(item, this.getRightSubTree());
        }
        return final_Val;
    }
    public void changeLeftsubTree(TreeNode sub) {
        this.left = sub;
    }
    public void changeRightsubTree(TreeNode sub) {
        this.right = sub;
    }
    public void makeLeftsubTree(TreeNode sub) {
        if (this.left == null) {
            this.left = sub;
            sub.makeUpSubTree(this);
        }
        if(this.left != null){
            this.Calculation(sub, this.getLeftSubTree());
        }
    }

    public void makeRightSubTree(TreeNode sub) {
        if(this.right == null) {
            this.right = sub;
            sub.makeUpSubTree(this);
        }
        if(this.right != null) {
            this.Calculation(sub, this.getRightSubTree());
        }
    }

    public void makeUpSubTree(TreeNode sub){
        this.upnode = sub;
    }

    public Object putData(Object item) {
        this.data = item;
        return this.data;
    }

    public Object getData() {
        return this.data;
    }

    public Object getkeyVal() {
        return this.keyval;
    }

    public TreeNode getLeftSubTree() {
        return this.left;
    }

    public TreeNode getRightSubTree() {
        return this.right;
    }

    public TreeNode getUpSubTree() {
        return this.upnode;
    }
}
