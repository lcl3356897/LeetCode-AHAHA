public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        assert strings != null : "null array";

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String code = getCode(s);
            List<String> list;
            if (!map.containsKey(code)) {
                list = new ArrayList<>();
            } else {
                list = map.get(code);
            }
            list.add(s);
            map.put(code, list);
        }

        for (String str : map.keySet()) {
            List<String> list = map.get(str);
            Collections.sort(list);
            result.add(list);
        }

        return result;
    }

    private String getCode(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 1; i < s.length(); i++) {
           int tmp = ((s.charAt(i) - s.charAt(i - 1)) + 26) % 26;
            sb.append(tmp).append("#");
        }
        return sb.toString();
    }
}