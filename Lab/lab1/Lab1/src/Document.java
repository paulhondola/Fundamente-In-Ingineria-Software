import java.util.ArrayList;

public abstract class Document {
    private ArrayList<String> data;

    public Document(ArrayList<String> data) {
        this.data = data;
    }

    public void addData(String data){
        this.data.add(data);
    }

    public ArrayList<String> getData() {
        return data;
    }

    public abstract ArrayList<String> analyze();

    public String toString(){
        return data.toString();
    }
}
