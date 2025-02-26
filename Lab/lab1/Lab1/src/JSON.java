import java.util.ArrayList;

public class JSON extends Document {

    public JSON(ArrayList<String> data) {
        super(data);
    }

    protected boolean isName(String line) {
        return line.contains(":");
    }

    @Override
    public ArrayList<String> analyze() {
        ArrayList<String> result = new ArrayList<>();

        ArrayList<String> lines = getData();
        for(String line : lines) {
            if(!isName(line))
                result.add(line);
        }
        return result;
    }

    @Override
    public String toString(){
        return "JSON: " + super.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        data.add("name1:");
        data.add("Hello, World!");
        data.add("name2:");
        data.add("Goodbye, World!");
        JSON json = new JSON(data);
        System.out.println(json);
        System.out.println(json.analyze());
    }
}
