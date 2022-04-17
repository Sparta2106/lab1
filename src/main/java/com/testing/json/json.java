package com.testing.json;



        import org.json.simple.JSONArray;
        import org.json.simple.JSONObject;

        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.Arrays;
        import java.util.LinkedHashMap;
        import java.util.Map;

public class json {
    public static void main(String[] args) {
        JSONObject tag0 = new JSONObject();
        JSONArray tag0List = new JSONArray();
        JSONObject tag1 = new JSONObject();
        JSONObject tag12 = new JSONObject();
        JSONArray tag1WithId = new JSONArray();
        JSONArray tag1WithId2 = new JSONArray();
        JSONObject tag2_1 = new JSONObject();
        JSONObject tag2_2 = new JSONObject();
        JSONObject tag2_3 = new JSONObject();
        JSONObject tag2_4 = new JSONObject();

        JSONObject tag1WithValue = new JSONObject();
        JSONObject tag1WithValue2 = new JSONObject();


        Map<Object, Object> map21 = new LinkedHashMap<>();
        map21.put("id", "001");
        map21.put("t1", "string 1");
        map21.put("t2", "string 1");

        Map<Integer, String> array = new LinkedHashMap<>();
        array.put(1, "list1 s1");
        array.put(2, "list1 s2");
        array.put(3, "list1 s3");
        array.put(4, "list1 s4");
        map21.put("list of elements", array);


        tag2_1.put("tag2", map21);
        tag1WithValue.put("tag1", tag2_1);



        Map<Object, Object> map22 = new LinkedHashMap<>();
        map22.put("id", "002");
        map22.put("t1", "s2");
        map22.put("t2", "s2");


        Map<Integer, String> array2 = new LinkedHashMap<>();
        array2.put(1, "list2 s1");
        array2.put(2, "list2 s2");
        array2.put(3, "list2 s3");
        array2.put(4, "list2 s4");
        map22.put("list of elements", array2);


        tag2_2.put("tag2", map22);


        Map<Object, Object> map23 = new LinkedHashMap<>();
        map23.put("id", "003");
        map23.put("t1", "s3");
        map23.put("t2", "s3");

        Map<Integer, String> array3 = new LinkedHashMap<>();
        array3.put(1, "list3 s1");
        array3.put(2, "list3 s2");
        array3.put(3, "list3 s3");
        array3.put(4, "list3 s4");

        map23.put("t5", "s3");

        tag2_3.put("tag2", map23);
        tag1WithValue2.put("tag1", tag2_3);



        Map<Object, Object> map24 = new LinkedHashMap<>();
        map24.put("id", "004");
        map24.put("t1", "s4");
        map24.put("t2", "s4");
        map24.put("t3", "i4");

        Map<Integer, String> array4 = new LinkedHashMap<>();
        array4.put(1, "list4 s1");
        array4.put(2, "list4 s2");
        array4.put(3, "list4 s3");
        array4.put(4, "list4 s4");

        map24.put("t5", "s4");

        tag2_4.put("tag2", map24);



        Map<Object, Object> map1 = new LinkedHashMap<>();
        map1.put("tag1name1", "Name1");
        map1.put("tagId", "1");
        tag1WithId.add(map1);
        tag1WithId.add(tag2_1);
        tag1WithId.add(tag2_2);

        Map<Object, Object> map12 = new LinkedHashMap<>();
        map12.put("tag1name1", "Name2");
        map12.put("tagId", "2");
        tag1WithId2.add(map12);
        tag1WithId2.add(tag2_3);
        tag1WithId2.add(tag2_4);

        tag1.put("tag1",tag1WithId);
        tag12.put("tag1",tag1WithId2);

        tag0List.add(tag1);
        tag0List.add(tag12);

        tag0.put("tag0", tag0List);


        try(FileWriter file = new FileWriter("primul.json")){
            file.write(tag0.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}