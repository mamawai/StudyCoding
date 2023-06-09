package com.mashibing.dp;

import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Invoker {

    private static final Map<String, Method> methodCache = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {


//        final  int EXPECTED_BUFFER_DATA = 1024;
//        Resource resource = new FileSystemResource("C:/Users/mamingyang/Desktop/missioncode.txt");
//        InputStream stream = resource.getInputStream();
//        byte[] b = new byte[1024];
//        StringBuilder sb = new StringBuilder(EXPECTED_BUFFER_DATA);
//        for (int n; (n = stream.read(b)) != -1; ) {
//            System.out.println(b.length);
//            sb.append(new String(b,0,n));
//        }
//        String res = sb.toString();
//        System.out.println(res);
//        stream.close();
        try {
            Object o = executeMethod("aaa");
            Map<Integer, String> map = castMap(o, Integer.class, String.class);
            System.out.println(map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static  <K,V> Map<K,V> castMap(Object obj, Class<K> keyClazz, Class<V> valueClazz){
        HashMap<K, V> resultMap = new HashMap<>();
        if (obj instanceof Map<?,?>){
             Map<?,?> mapObj = (Map<?,?>) obj;
             for (Map.Entry<?,?> entry : mapObj.entrySet()){
                 K key = keyClazz.cast(entry.getKey());
                 V value = valueClazz.cast(entry.getValue());
                 resultMap.put(key,value);
             }
             return resultMap;
        }
        return null;
    }
    public static Object execute(Object object, String methodName, Object param, Class<?> paramClass) throws Exception {
        String cacheKey = methodName + ":" + paramClass.getName();
        Method method = methodCache.get(cacheKey);
        if (method == null){
            method = object.getClass().getMethod(methodName,paramClass);
            methodCache.put(cacheKey,method);
        }
        ReflectionUtils.makeAccessible(method);
        return method.invoke(object,param);
    }
    public Map<Integer,String> returnMap(String value){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,value);map.put(2,"bbb");map.put(3,"ccc");
        return map;
    }
    public static Object executeMethod(String value) throws Exception {
        Invoker invoker = new Invoker();
        return execute(invoker, "returnMap", value, String.class);
    }
}
