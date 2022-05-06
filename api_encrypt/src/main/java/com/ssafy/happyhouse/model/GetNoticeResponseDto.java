package com.ssafy.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel(value = "GetNoticeDto(공지사항 목록)")
@Getter
@Setter
public class GetNoticeResponseDto {
	@ApiModelProperty(value = "공지사항 목록")
	private List<NoticeDto> noticeList;

	@ApiModelProperty(value = "최대 페이지 번호")
	private String maxPageNum;
}
