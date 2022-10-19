from re import T


class Node:
    def __init__(self, val) -> None:
        self.val = val
        self.left = None
        self.right = None
        pass

class BST:
    def __init__(self, root: Node) -> None:
        self.root = root
    
    def insert(self, val):
        self.root = self._insert_value(self.root, val=val)
        return self.root is not None
    
    def _insert_value(self, node, val):
        if node is None:
            node = Node(val)
        else:
            if val <= node.val:
                node.left = self._insert_value(node.left, val)
            else:
                node.right = self._insert_value(node.right,val)
        return node

    def search(self, val):
        return self._search_value(self.root, val)
    
    def _search_value(self, root, val):
        if root is None or root.val == val:
            return root is not None
        elif val < root.val:
            return self._search_value(root.left, val)
        else:
            return self._search_value(root.right, val)

    def delete(self, val):
        self.root, is_deleted = self._delete_value(self.root, val)
        return is_deleted

    def _delete_value(self, node, val):
        if node is None:
            return node, False
        
        is_deleted = False
        if node.val == val:
            is_deleted = True
            if node.left and node.right:
                parent, child = node, node.right
                while child.left is not None:
                    parent, child = child, child.left
                child.left = node.left
                if parent != node:
                    parent.left = child.right
                    child.right = node.right
                node = child
            elif node.left or node.right:
                node = node.left or node.right
            else:
                node = None
        elif val < node.val:
            node.left, is_deleted = self._delete_value(node.left, val)
        else:
            node.right, is_deleted = self._delete_value(node.right, val)
        return node, is_deleted