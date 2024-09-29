public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Minion> minionsList = new DoublyLinkedList<>();

        Minion firstMinion = new Minion("Bob", 10);
        Minion lastMinion = new Minion("Kevin", 12);
        minionsList.addFirst(firstMinion);
        minionsList.addLast(lastMinion);
        minionsList.addAfter(new Minion("Stuart", 11), firstMinion);

        System.out.println("Initial list:");
        minionsList.printList();

        minionsList.removeFirst();
        minionsList.removeLast();
        minionsList.remove(lastMinion);

        System.out.println("List after removing elements:");
        minionsList.printList();
     //   minionsList.addLast(lastMinion);


        minionsList.edit(lastMinion, new Minion("Jerry", 13));

        System.out.println("List after editing an element:");
        minionsList.printList();
    }
}