import javax.print.Doc;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        XML xml1 = new XML(new ArrayList<>());
        XML xml2 = new XML(new ArrayList<>());
        JSON json1 = new JSON(new ArrayList<>());
        JSON json2 = new JSON(new ArrayList<>());

        xml1.addData("<start1>");
        xml1.addData("Random data1");
        xml1.addData("</start1>");
        xml1.addData("<end1>");
        xml1.addData("Random data2");
        xml1.addData("</end1>");

        xml2.addData("<start2>");
        xml2.addData("Random data3");
        xml2.addData("</start2>");
        xml2.addData("<end2>");
        xml2.addData("Random data4");
        xml2.addData("</end2>");

        json1.addData("name1:");
        json1.addData("Random data5");
        json1.addData("name2:");
        json1.addData("Random data6");

        json2.addData("name3:");
        json2.addData("Random data7");
        json2.addData("name4:");
        json2.addData("Random data8");

        ArrayList<Document> docs = new ArrayList<>();
        docs.add(xml1);
        docs.add(xml2);
        docs.add(json1);
        docs.add(json2);

        Processor sp1 = new SearchProcessor("Random");
        Processor sp2 = new SearchProcessor("data");
        ArrayList<Processor> p = new ArrayList<>();
        p.add(sp1);
        p.add(sp2);
        Processor mp = new MultiProcessor(p);

        System.out.println(sp1.process(docs));
        System.out.println(sp2.process(docs));
        System.out.println(mp.process(docs));
    }
}