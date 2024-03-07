import javax.swing.text.html.HTMLDocument.Iterator;

public class Test {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        // list.printList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
