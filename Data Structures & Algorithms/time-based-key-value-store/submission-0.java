class TimeMap {

    private HashMap<String, List<Pair<Integer,String>>> map;

    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {

            map.get(key).add(new Pair<>(timestamp, value));
        } else {
            List<Pair<Integer, String>> list = new ArrayList<>();
            list.add(new Pair<> (timestamp, value));

            map.put(key, list);
        }

        System.out.println(map);

    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair<Integer, String>> list = map.get(key);
        int l = 0, r = list.size() - 1;
        String result = "";

        while (l <= r) {
            int m = l + (r - l) / 2;

            if(list.get(m).getKey() <= timestamp) {
                result = list.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }
}
