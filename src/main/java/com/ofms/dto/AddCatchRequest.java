package com.ofms.dto;

import com.ofms.models.Fish;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class AddCatchRequest {
    private int lakeId;
    private List<Fish> fishes;
//    private List<FishDto> fishes;
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private Date date;
}
