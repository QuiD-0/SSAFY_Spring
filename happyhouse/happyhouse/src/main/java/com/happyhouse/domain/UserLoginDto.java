package com.happyhouse.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "UserLoginDto(유저 로그인 정보)")
@Getter
@Setter
public class UserLoginDto {

    @ApiModelProperty(value = "아이디")
    private String id;
    @ApiModelProperty(value = "비밀번호")
    private String password;

    @Override
    public String toString() {
        return "UserInfoDto{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
