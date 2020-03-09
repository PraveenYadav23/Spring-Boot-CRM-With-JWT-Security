package com.praveen.cms.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CommonPaginationResponse {

    private int totalNumberOfPageAsPerGivenLimit;

}
