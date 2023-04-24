package com.ofms.dto;


import com.ofms.models.Fish;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class CatchRequest {
    private Long lakeId;
    private final Date date;
    private final List<Fish> fishes;

}
