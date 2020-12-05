package org.example;

import java.util.*;

public class DataMerger {
    public Map<String, List<String>> convertDataToMap(List<List<String>> dataLines, int positionForKey) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (List<String> dataLine : dataLines) {
            dataLine = new ArrayList<>(dataLine);
            map.put(dataLine.remove(positionForKey), dataLine);
        }
        return map;
    }

    public List<List<String>> mergeTwoMaps(Map<String, List<String>> firstMap, Map<String, List<String>> secondMap) {
        List<List<String>> result = new ArrayList<>();
        Set<String> firstKeySet = firstMap.keySet();
        Set<String> secondKeySet = secondMap.keySet();
        secondKeySet.retainAll(firstKeySet);
        for (String firstKey : firstKeySet) {
            for (String secondKey : secondKeySet) {
                if (secondKey.equals(firstKey)) {
                    List<String> line = firstMap.get(firstKey);
                    line.add(0, firstKey);
                    line.add(secondKey);
                    line.addAll(secondMap.get(secondKey));
                    result.add(line);
                }
            }
        }
        return result;
    }
}
