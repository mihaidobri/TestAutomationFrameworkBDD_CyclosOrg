package Utils.Parsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonParser {

    public String path;

    public JsonParser(String path) {
        this.path = path;
    }

    public List<String> getJsonObject(String reference){

        JSONParser parser = new JSONParser();
        List<String> testElements = new ArrayList<String>();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
            JSONArray jsonArray = (JSONArray) jsonObject.get(reference);
            Iterator<String> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                testElements.add(iterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return testElements;
    }

}
