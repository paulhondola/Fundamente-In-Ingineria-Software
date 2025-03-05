import java.util.ArrayList;

public class XML extends Document{

    public XML(ArrayList<String> data) {
        super(data);
    }

    protected boolean checkStarterTag(String line) {
        return line.charAt(0) == '<' && line.charAt(line.length() - 1) == '>';
    }

    protected boolean checkEndTag(String line) {
        return checkStarterTag(line) && line.charAt(1) == '/';
    }

    @Override
    public ArrayList<String> analyze() {
        // remove tags from XML
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> lines = getData();
        for(String line : lines) {
            if(!checkStarterTag(line) && !checkEndTag(line))
                result.add(line);
        }

        return result;
    }

    @Override
    public String toString(){
        return "XML: " + super.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        data.add("<start>");
        data.add("Hello, World!");
        data.add("</start>");
        data.add("<end>");
        data.add("Goodbye, World!");
        data.add("</end>");
        XML xml = new XML(data);
        System.out.println(xml);
        System.out.println(xml.analyze());
    }
}
