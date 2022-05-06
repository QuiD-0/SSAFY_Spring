package com.ssafy.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@ApiModel(value = "NoticeDto(공지사항)")
@Getter
@Setter
public class NoticeDto {

	@ApiModelProperty(value = "번호")
	private int noticeId;
	@ApiModelProperty(value = "제목")
	private String title;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "작성 시간")
	private Date createDate;
	@ApiModelProperty(value = "조회수")
	private int viewCount;
	@ApiModelProperty(value = "작성한 유저 아이디")
	private String userId;
}
