package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {

    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;


    public Tree(E value, Tree<E>... subtrees) {
        this.value = value;
        this.parent = null;
        this.children = new ArrayList<>();

        for (Tree<E> subtree : subtrees) {
            this.children.add(subtree);
            subtree.parent = this;
        }

    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        if (this.value == null) {
            return result;
        }

        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> current = queue.poll();
            result.add(current.value);
            for (Tree<E> child : current.children) {
                queue.offer(child);
            }
        }

        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();

//        RECURSION
      this.doDfs(this, result);

//        STACK
//        Deque<Tree<E>> toTraverse = new ArrayDeque<>();
//        toTraverse.push(this);
//
//        while (!toTraverse.isEmpty()) {
//            Tree<E> current = toTraverse.pop();
//
//            for (Tree<E> node : current.children) {
//                toTraverse.push(node);
//            }
//            result.add(current.value);
//        }

        return result;
    }

    private void doDfs(Tree<E> tree, List<E> result) {
        for (Tree<E> child : tree.children) {
            this.doDfs(child, result);
        }
        result.add(tree.value);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> search = find(parentKey);

        if (search == null) {
            throw new IllegalArgumentException();
        }

        search.children.add(child);
        child.parent = search;
    }

    private Tree<E> find(E parentKey) {
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> current = queue.poll();

            if (current.value.equals(parentKey)) {
                return current;
            }
            for (Tree<E> child : current.children) {
                queue.offer(child);
            }
        }

        return null;
    }

    private Tree<E> findRecursive(Tree<E> current, E parentKey) {
        if (current.value.equals(parentKey)) {
            return current;
        }

        for (Tree<E> child : current.children) {
            Tree<E> found = this.findRecursive(child, parentKey);
            if (found != null) {
                return found;
            }
        }

        return null;
    }

    @Override
    public void removeNode(E nodeKey) {
        Tree<E> toRemove = find(nodeKey);

        if (toRemove == null) {
            throw new IllegalArgumentException();
        }

        for (Tree<E> child : toRemove.children) {
            child.parent = null;
        }
        toRemove.children.clear();

        Tree<E> parent = toRemove.parent;
        if (parent != null) {
            parent.children.remove(toRemove);
        }

        toRemove.value = null;

    }

    @Override
    public void swap(E firstKey, E secondKey) {
        Tree<E> firstNode = find(firstKey);
        Tree<E> secondNode = find(secondKey);

        if (firstNode == null || secondNode == null) {
            throw new IllegalArgumentException();
        }

        Tree<E> firstParent = firstNode.parent;
        Tree<E> secondParent = secondNode.parent;

        if (firstParent == null) {
            swapRoot(secondNode);
            return;
        } else if (secondParent == null) {
            swapRoot(firstNode);
            return;
        }

        firstNode.parent = secondParent;
        secondNode.parent = firstParent;

        int firstIndex = firstParent.children.indexOf(firstNode);
        int secondIndex = secondParent.children.indexOf(secondNode);

        firstParent.children.set(firstIndex, secondNode);
        secondParent.children.set(secondIndex, firstNode);

    }

    private void swapRoot(Tree<E> node) {
        this.value = node.value;
        this.children = node.children;
        this.parent = null;
        node.parent = null;
    }
}



