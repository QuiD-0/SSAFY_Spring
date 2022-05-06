package com.ssafy.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@ApiModel(value = "NoticeCommentDto(공지사항 댓글)")
@Getter
@Setter
public class NoticeCommentDto {

	@ApiModelProperty(value = "댓글 id")
	private int commentId;
	@ApiModelProperty(value = "공지사항 번호")
	private int noticeId;
	@ApiModelProperty(value = "작성 유저 아이디")
	private String userId;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "작성 시간")
	private Date createDate;
}
