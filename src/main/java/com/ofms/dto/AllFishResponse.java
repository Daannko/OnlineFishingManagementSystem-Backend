package com.ofms.dto;

import com.ofms.models.Fish;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AllFishResponse {
    private String userNameAndSurname;
    private String lakeName;
    private Fish fish;
}
