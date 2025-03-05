import java.util.ArrayList;

public class SearchProcessor implements Processor{

    private String searchedWord;

    public SearchProcessor(String searchedWord) {
        this.searchedWord = searchedWord;
    }

    public int process(ArrayList<Document> docs){
        int count = 0;
        ArrayList<String> docData;

        for(Document doc : docs){
            docData = doc.analyze();
            for(String line : docData){
                if(line.contains(searchedWord))
                    count++;
            }
        }

        return count;
    }
}
