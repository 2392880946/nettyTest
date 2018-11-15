package net.good.netty;

public class TestTree {

    public static void main(String[] args) throws Exception {

    }

}

class BinnaryTry<T extends Comparable<T>> {

    class Node {
        private Comparable<T> data;
        private Node parent;
        private Node left;
        private Node right;

        public Node(Comparable<T> data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (newNode.data.compareTo((T) this.data) <= 0) {
                if (this.left == null) {
                    this.left = newNode;
                    newNode.parent = this;
                } else {
                    this.left.addNode(newNode);
                }
            } else {
                if (this.right == null) {
                    this.right = newNode;
                    newNode.parent = this;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }

        public void toNodeArray() {
            if (this.left != null) {
                this.left.toNodeArray();
            }
            BinnaryTry.this.returnObj[BinnaryTry.this.foot++] = this.data;
            if (this.right != null) {
                this.right.toNodeArray();
            }
        }
    }

    private Node root;
    private int count = 0;
    private Object[] returnObj;

    private int foot;

    public void add(Comparable<T> data) {
        if (data == null) {
            throw new NullPointerException();
        }
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        this.count++;
    }

    public Object[] toArray() {
        if (this.root == null) {
            throw new NullPointerException();
        }
        this.returnObj = new Object[count];
        this.foot = 0;
        this.root.toNodeArray();
        return this.returnObj;
    }

}

class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", age='" + getAge() + "'" + "}";
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

}