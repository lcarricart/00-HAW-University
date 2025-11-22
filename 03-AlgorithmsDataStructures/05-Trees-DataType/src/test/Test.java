package test;

public class Test {

	public static void main(String[] args) {
        SimpleTree t = new SimpleTree(10);
        Node a = t.addChild(t.getRoot(), 20);
        Node b = t.addChild(t.getRoot(), 30);
        t.addChild(a, 40);

        System.out.println("size = " + t.size());          // 4
        System.out.println("height = " + t.height());      // 2 (root=0 → child=1 → grandchild=2)
        System.out.println(t.preOrderValues());            // [10, 20, 40, 30]
        t.removeSubtree(a);
        System.out.println("size after remove = " + t.size()); // 2
        System.out.println(t.preOrderValues());                // [10, 30]
    }
}
