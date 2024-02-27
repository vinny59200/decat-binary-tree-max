public class VVNode {

    VVNode left;

    VVNode right;

    int age;

    public VVNode( final VVNode left, final VVNode right, final int age ) {
        this.left = left;
        this.right = right;
        this.age = age;
    }

    public VVNode getLeft() {
        return left;
    }

    public void setLeft( final VVNode left ) {
        this.left = left;
    }

    public VVNode getRight() {
        return right;
    }

    public void setRight( final VVNode right ) {
        this.right = right;
    }

    public int getAge() {
        return age;
    }

    public void setAge( final int age ) {
        this.age = age;
    }
}
