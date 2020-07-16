package com.scl.springwebflux.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/12
 * @Description
 **********************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String gender;
    private Integer age;
}
