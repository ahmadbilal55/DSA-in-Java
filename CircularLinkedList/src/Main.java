//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.display(); // Output: 1 2 3 4

        System.out.println("Element at index 2: " + list.get(2)); // Output: 3

        System.out.println("Searching for 3: Found at index" + list.search(3));
        System.out.println("Searching for 5: Found at index" + list.search(5));

        list.remove(3);
        list.display(); // Output: 1 2 4

        list.remove(1);
        list.display(); // Output: 2 4

        list.remove(4);
        list.display(); // Output: 2

        list.remove(2);
        list.display(); // Output: List is empty.

        try {
            list.get(0); // Should throw an exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Output: List is empty.
        }
    }
}