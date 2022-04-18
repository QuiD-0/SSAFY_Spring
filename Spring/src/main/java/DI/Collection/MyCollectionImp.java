package DI.Collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyCollectionImp implements MyCollection {
    int[] array;
    List<String> list;
    Set<String> set;
    Map<String, String> map;

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    @Override
    public void arrayInfo() {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public void listInfo() {
        for (String item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public void setInfo() {
        for (String item : set) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public void mapInfo() {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.print(map.get(key)+" ");
        }
        System.out.println();
    }
}
