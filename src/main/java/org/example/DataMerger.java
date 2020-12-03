package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataMerger {
    public Map<String, List<String>> convertDataToMap(List<List<String>> dataLines, int positionForKey) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (List<String> dataLine : dataLines) {
            map.put(dataLine.remove(positionForKey), dataLine);
        }
        return map;
    }
}
