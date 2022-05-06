package com.ssafy.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "UserDto(유저 정보)")
@Getter
@Setter
public class UserDto {

    @ApiModelProperty(value = "아이디")
    private String id;
    @ApiModelProperty(value = "비밀번호")
    private String password;
    @ApiModelProperty(value = "이름")
    private String name;
    @ApiModelProperty(value = "주소")
    private String address;
    @ApiModelProperty(value = "휴대폰 번호")
    private String phone;

    @Override
    public String toString() {
        return "UserInfoDto{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
