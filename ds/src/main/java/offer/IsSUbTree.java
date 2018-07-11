package offer;

/**
 * Created by losye
 * 输入两个二叉树，判断一颗是不是另一颗的子结构
 */
public class IsSUbTree {
    static class Tree{
        int value;
        Tree left;
        Tree right;

        public Tree(int value) {
            this.value = value;
        }
    }

    public static boolean hasSubTree(Tree base, Tree sub){
        boolean res = false;
        if (base != null && sub != null){
            if (base.value == sub.value){
                res = dosBaseHasSub(base, sub);
            }
            if (!res){
                res = hasSubTree(base.left, sub);
            }
            if (!res){
                res = hasSubTree(base.right, sub);
            }
        }
        return res;
    }

    private static boolean dosBaseHasSub(Tree base, Tree sub) {
        if (sub == null){
            return true;
        }
        if (base == null){
            return false;
        }
        if (base.value != sub.value){
            return false;
        }
        return dosBaseHasSub(base.left, sub.left) && dosBaseHasSub(base.right, sub.right);
    }


}
