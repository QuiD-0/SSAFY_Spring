package com.mvc.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Comparable<Customer>{

    private String num;

    private String name;

    private String address;


    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.name);
    }
}
