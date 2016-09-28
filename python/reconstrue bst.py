# Two elements of a binary search tree (BST) are swapped by mistake.

# Recover the tree without changing its structure.

# Note:
# A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
# Show Tags
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    # O(n) space solution:
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        
        _inorder = self.inorder(root);
        a = sys.maxint; b = sys.maxint;

        for i in range(0,len(_inorder) - 1):
            if _inorder[i].val > _inorder[i + 1].val:
                a = i;
                break
        if a == sys.maxint:
            return;
        for i in range(len(_inorder) - 1, a, -1):
            if _inorder[i].val < _inorder[i - 1].val:
                b = i;
                break;
        if b != sys.maxint:
            tmp = _inorder[b].val;
            _inorder[b].val = _inorder[a].val;
            _inorder[a].val = tmp;
        
    def inorder(self, root):
        _list = [];
        if root is None:
            return _list;
        _list.extend(self.inorder(root.left));
        _list.append(root);
        _list.extend(self.inorder(root.right));
        return _list;
        