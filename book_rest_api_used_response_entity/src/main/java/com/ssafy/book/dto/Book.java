package com.ssafy.book.dto;

import lombok.Builder;
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
public class Book {

//	@NonNull //=> null X
	private String isbn;
	
    private String title;
    private String author;
    private int price;
    private String description;
    
//    public static void main(String[] args) {
////		Book book = new Book();
////		book.setIsbn("ddd");
////		book.setAuthor("저자1");
//		
//    	
//    	Book book = Book.builder()
//    			.isbn("isbn1")
//    			.author("author1")
//    			.build();
//    	System.out.println(book);
//		
//    	
//	}
    
}





