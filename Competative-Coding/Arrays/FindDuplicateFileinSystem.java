package Arrays;
//609. Find Duplicate File in System
public class FindDuplicateFileinSystem {
    import java.util.*;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {

            String[] parts = path.split(" ");
            String dir = parts[0];

            for (int i = 1; i < parts.length; i++) {

                String file = parts[i];

                int open = file.indexOf('(');
                int close = file.indexOf(')');

                String fileName = file.substring(0, open);
                String content = file.substring(open + 1, close);

                String fullPath = dir + "/" + fileName;

                map.computeIfAbsent(content, k -> new ArrayList<>())
                   .add(fullPath);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for (List<String> files : map.values()) {
            if (files.size() > 1) {
                ans.add(files);
            }
        }

        return ans;
    }
}