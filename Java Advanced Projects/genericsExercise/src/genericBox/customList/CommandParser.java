package genericBox.customList;

public class CommandParser {
    private SmartList<String> smartList;

    public CommandParser() {
        this.smartList = new SmartList<>();
    }

    public void execute(String command) {
        String[] tokens = command.split("\\s+");
        switch (tokens[0]) {
            case "Add":
                this.smartList.add(tokens[1]);
                break;
            case "Remove":
                this.smartList.remove(Integer.parseInt(tokens[1]));
                break;
            case "Contains":
                System.out.println(this.smartList.contains(tokens[1]));
                break;
            case "Swap":
                this.smartList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                break;
            case "Greater":
                System.out.println(this.smartList.greaterThat(tokens[1]));
                break;
            case "Max":
                System.out.println(this.smartList.max());
                break;
            case "Min":
                System.out.println(this.smartList.min());
                break;
            case "Print":
//                this.smartList.forEach(System.out::println);
                for (String string : smartList) {
                    System.out.println(string);
                }
                break;
            case "Sort":
                Sorter.sort(this.smartList);
                break;
        }
    }
}
