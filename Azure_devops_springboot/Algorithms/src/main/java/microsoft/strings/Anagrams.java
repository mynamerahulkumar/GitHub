package microsoft.strings;

import java.util.*;

public class Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            String sortedString=getSortedString(s);
            if(map.containsKey(sortedString)){
                List<String>list=map.get(sortedString);
                list.add(s);
                map.put(sortedString,list);
            }
            else{
                List<String>list=new ArrayList<>();
                list.add(s);
                map.put(sortedString,list);
            }
        }
        List<List<String>>resultList=new ArrayList<List<String>>();
        for(Map.Entry<String,List<String>>m : map.entrySet()){
            resultList.add(m.getValue());
        }
        return resultList;

    }

    public static String getSortedString(String s){
        char[]chr=s.toCharArray();
        Arrays.sort(chr);
        return String.valueOf(chr);
    }

    public static void main(String[] args) {
        String []str={"eat","tea","tan","ate","nat","bat"};
        Anagrams.groupAnagrams(str);

    }
}
