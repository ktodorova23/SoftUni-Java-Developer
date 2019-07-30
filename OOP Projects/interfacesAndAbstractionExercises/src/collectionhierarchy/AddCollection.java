package collectionhierarchy;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String item) {
        int index = super.size();
        super.getItems().add(item);
        return index;
    }
}
