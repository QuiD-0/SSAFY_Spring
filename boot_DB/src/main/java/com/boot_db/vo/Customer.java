package com.boot_db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//vo(value object):customer
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String num;

    private String name;

    private String address;


}
