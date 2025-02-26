import java.util.ArrayList;

public class MultiProcessor implements Processor{

    private ArrayList<Processor> processors;

    public MultiProcessor(ArrayList<Processor> processors) {
        this.processors = processors;
    }

    @Override
    public int process(ArrayList<Document> docs){
        int count = 0;
        for(Processor p : processors)
            count += p.process(docs);
        return count;
    }
}
