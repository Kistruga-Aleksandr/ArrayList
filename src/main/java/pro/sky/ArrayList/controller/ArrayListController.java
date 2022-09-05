package pro.sky.ArrayList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pro.sky.ArrayList.Interface.StringList;
import pro.sky.ArrayList.service.ArrayListImplService;

@Controller
public class ArrayListController  {

    private final ArrayListImplService arrayListImplService;

    public ArrayListController(ArrayListImplService arrayListService) {
        this.arrayListImplService = arrayListService;
    }

    @GetMapping
    public String add(String item) {
        return arrayListImplService.add(item);
    }

    @GetMapping
    public String add(int index, String item) {
        return arrayListImplService.add(index, item);
    }

    @GetMapping
    public String set(int index, String item) {
        return arrayListImplService.set(index, item);
    }

    @GetMapping
    public String remove(String item) {
        return arrayListImplService.remove(item);
    }

    @GetMapping
    public String remove(int index) {
        return arrayListImplService.remove(index);
    }

    @GetMapping
    public boolean contains(String item) {
        return arrayListImplService.contains(item);
    }

    @GetMapping
    public int indexOf(String item) {
        return arrayListImplService.indexOf(item);
    }

    @GetMapping
    public int lastIndexOf(String item) {
        return arrayListImplService.lastIndexOf(item);
    }

    @GetMapping
    public String get(int index) {
        return arrayListImplService.get(index);
    }

    @GetMapping
    public boolean equals(StringList otherList) {
        return arrayListImplService.equals(otherList);
    }

    @GetMapping
    public boolean isEmpty() {
        return arrayListImplService.isEmpty();
    }

    @GetMapping
    public void clear() {
        arrayListImplService.clear();
    }

    @GetMapping
    public String[] toArray() {
        return arrayListImplService.toArray();
    }
}
