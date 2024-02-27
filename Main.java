public class Main {

    // Binary tree with integers of age
    //find the oldest person
    public static void main( String[] args ) {

        VVNode root = new VVNode( null,
                                  new VVNode(
                                          new VVNode(
                                                  new VVNode(
                                                          null,
                                                          null,
                                                          25 ),
                                                  new VVNode(
                                                          null,
                                                          null,
                                                          50 ),
                                                  60 ),
                                          new VVNode(
                                                  null,
                                                  null,
                                                  30 ),
                                          70 ),
                                  40 );

        if ( root != null ) {
            //            printTree( root );
            System.out.println( "Original tree:" );
            printTree( root, "", "" );
            VVNode result = findOldest( root );
            System.out.println();
            System.out.println( "Max age:" + result.getAge() );
            System.out.println();
            System.out.println( "Inverted tree" );
            printTree( invertTree( root ), "", "" );
        }


    }

    private static void printTree( final VVNode node ) {
        System.out.println( node != null ? node.getAge() : 0 );
        System.out.println( "  /   \\  " );
        if ( node != null ) {
            printTree( node.getLeft() );
            printTree( node.getRight() );
        }
    }

    private static void printTree( VVNode node, String prefix, String childrenPrefix ) {
        if ( node == null ) {
            return; // base case
        }
        System.out.println( prefix + node.getAge() ); // print the node with the prefix
        // print the left and right subtrees with the children prefix
        printTree( node.left, childrenPrefix + "├── ", childrenPrefix + "│   " );
        printTree( node.right, childrenPrefix + "└── ", childrenPrefix + "    " );
    }


    private static VVNode findOldest( final VVNode root ) {
        int left = 0;
        int right = 0;
        VVNode max = root;

        final VVNode left1 = root.getLeft();
        if ( left1 != null ) {
            VVNode resultLeft = findOldest( left1 );
            left = left1.getAge();
            if ( left > max.getAge() ) {
                max = left1;
            }
        }

        final VVNode right1 = root.getRight();
        if ( right1 != null ) {
            VVNode resultRight = findOldest( right1 );
            right = right1.getAge();
            if ( right > max.getAge() ) {
                max = right1;
            }
        }
        return max;

    }

    private static VVNode invertTree( final VVNode node ) {
        if ( node == null ) {
            return node; // base case
        }
        // swap the left and right children
        VVNode temp = node.getLeft();
        node.left = node.getRight();
        node.right = temp;
        // invert the left and right subtrees
        invertTree( node.getLeft() );
        invertTree( node.getRight() );
        return node;
    }
}
