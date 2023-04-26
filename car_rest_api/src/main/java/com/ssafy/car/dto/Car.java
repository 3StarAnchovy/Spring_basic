package com.ssafy.car.dto;

import lombok.Data;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
//기본 주소값 비교 => 멤버들의 값을 비교

//@RequiredArgsConstructor
//final 또는 @NonNull	

@Data
//@Builder
public class Car {

//	@NonNull //=> null X
	private String number;
	
    private String model;
    private int price;
    private String brand;

    
}





