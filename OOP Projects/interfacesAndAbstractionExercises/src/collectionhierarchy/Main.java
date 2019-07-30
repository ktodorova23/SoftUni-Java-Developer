package collectionhierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] itemsToAdd = reader.readLine().split("\\s+");
        int itemsToRemove = Integer.parseInt(reader.readLine());

        AddCollection addCollection = new AddCollection();
        AddRemovable removable = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        StringBuilder addCollectionAction = new StringBuilder();
        StringBuilder addRemovableCollectionAction = new StringBuilder();
        StringBuilder myListAction = new StringBuilder();

        for (String item : itemsToAdd) {
            addCollectionAction.append(addCollection.add(item)).append(" ");
            addRemovableCollectionAction.append(removable.add(item)).append(" ");
            myListAction.append(myList.add(item)).append(" ");
        }

        System.out.println(addCollectionAction.toString());
        System.out.println(addRemovableCollectionAction.toString());
        System.out.println(myListAction.toString());

        addRemovableCollectionAction = new StringBuilder();
        myListAction = new StringBuilder();

        while (itemsToRemove-- > 0) {
            addRemovableCollectionAction.append(removable.remove()).append(" ");
            myListAction.append(myList.remove()).append(" ");
        }

        System.out.println(addRemovableCollectionAction.toString());
        System.out.println(myListAction.toString());
    }
}
