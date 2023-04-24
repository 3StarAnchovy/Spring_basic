package com.ssafy.book.dto;

import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.NonNull;


//@Getter
//@Setter
//@ToString
//@AllArgsConstructor // 생성자
//@NoArgsConstructor
//@EqualsAndHashCode // 기본 주소값 비교 -> 멤버들의 값을 비교
//@RequiredArgsConstructor // final 또는 @NonNull
@Data
@NoArgsConstructor
public class User {
	@NonNull // null 허용 x
	private String id;
	private String password;
	private String name;
	private String address;
}
