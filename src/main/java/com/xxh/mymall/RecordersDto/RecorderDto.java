package com.xxh.mymall.RecordersDto;

import lombok.Data;

@Data
public class RecorderDto {
    private Integer id;

    private String gname;

    private Long gprice;

    private Integer ishot;
    //类型的id
    private Integer tId;

    private String description;

    private String picSrc;

}
