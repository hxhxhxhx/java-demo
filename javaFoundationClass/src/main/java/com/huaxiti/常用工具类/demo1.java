package com.huaxiti.常用工具类;

import com.google.common.collect.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.list.TreeList;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;
//import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class demo1 {

    public void stringUtils(){
        String s1 = "666";
        System.out.println(StringUtils.isBlank(s1));
        System.out.println(StringUtils.substring(s1, 0, 10));
    }

    public void collectionUtils(){
        CollectionUtils.isNotEmpty(new ArrayList<>());
        CollectionUtils.isEmpty(new ArrayList<>());
    }

    public void arrayUtils(){
        ArrayUtils.isEmpty(new int[]{});
    }

    public void beanUtils() throws InvocationTargetException, IllegalAccessException {
        Integer l1 = 0;
        Integer l2 = 1;
        BeanUtils.copyProperties(l1,l2);
    }

    @Test
    public void CollectionUtils(){
        //Map kv均可为null、"" key:唯一，如果不唯一被后入值替换 value：不唯一
        List<Object> objects = Lists.newArrayList();
        LinkedList<@Nullable Object> objects1 = Lists.newLinkedList();
        HashMap<@Nullable Object, @Nullable Object> objectObjectHashMap = Maps.newHashMap();
        HashSet<@Nullable Object> objects2 = Sets.newHashSet();
        HashMap<String, String> map = new HashMap<String, String>() {{
            put("1", "2");
            put("12", "2");
            put("13", "2");
            put("14", "2");
            put("14", "3");
            put(null, "1");
            put(null, "2");
            put("", "2");
        }};
        System.out.println(map);

        //ImmutableBiMap kv不可为null，都唯一，重复报错IllegalArgumentException
        ImmutableBiMap<Object, Object> build = ImmutableBiMap.builder()
                .put("1","2")
                .put("12","22")
                .put("13","23")
                .put("14","24")
                .put("null","null")
                .build();
        System.out.println(build);

        System.out.println(build.inverse());

        //List 可为null，非唯一
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("");
        list.add(null);
        System.out.println(list);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("");
        TreeList treeList = new TreeList();
        treeList.add("");
        Vector<String> vector = new Vector<>();

        //Set 可为null，唯一
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("1");
        set.add("");
        set.add("A");
        set.add("!");
        set.add(null);
        set.add("2");
        set.add("+");
        set.add("4");
        set.add("a");
        set.add("C");
        set.add("@");
        set.add(".");
        System.out.println(set);

        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("");
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("");

    }



}
