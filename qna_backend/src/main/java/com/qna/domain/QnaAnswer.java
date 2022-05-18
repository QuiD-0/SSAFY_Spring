package com.qna.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaAnswer {

    int qna_id,answer_id;
    String title,name,content,createDate;
}
