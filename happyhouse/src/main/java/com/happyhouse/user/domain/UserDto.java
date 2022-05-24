package com.happyhouse.user.domain;

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
    @ApiModelProperty(value = "휴대폰 번호")
    private String phone;
    @ApiModelProperty(value = "어드민 여부")
    private String admin;
    @ApiModelProperty(value = "변경할 비밀번호, 평소에는 값안넣어도 괜찮습니다.")
    private String newPassword;

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }
}
