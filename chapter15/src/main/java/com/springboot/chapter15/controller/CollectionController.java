package com.springboot.chapter15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author moralok
 * @date 2019/8/13
 */
@RestController
public class CollectionController {
    @GetMapping("/hello")
    public Map<String, Object> test() {
        Map<String, Object> result = new HashMap<>();
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        for (int i=0; i<10; i++) {
            arrayList.add("ArrayList" + i);
            linkedList.add("LinkedList" + i);
        }
        int index = Collections.binarySearch(arrayList, "ArrayList1");
        result.put("ArrayList", arrayList);
        result.put("LinkedList", linkedList);
        result.put("index", index);
        return result;
    }
}
