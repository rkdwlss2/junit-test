package site.metacoding.junitproject.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest // 디비와 관련된 로직만 메모리에 띄움
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach // 테스트 시작전에 한번만 실행
    public void 데이터준비(){
        String title = "junit";
        String author = "겟인데어";
        Book book = Book.builder()
        .title(title)
        .author(author)
        .build();
        bookRepository.save(book);
    } // 트랜잭션 종료 됐다면 !! 

    // 1. 책 등록
    @Test
    public void 책등록_test(){
        // given (데이터 준비)
              String title = "junit5";
            String author = "메타코딩";
            Book book = Book.builder()
            .title(title)
            .author(author)
            .build();
            bookRepository.save(book);

        // stub 필요 하기도 함

        // when (테스트 실행)
        Book bookPS = bookRepository.save(book);

        // then (검증)
        assertEquals(title, bookPS.getTitle());
        assertEquals(author , bookPS.getAuthor());
    } // 트랜잭션 종료 (저장된 데이터를 초기화함) - 트랜잭션 종료 안되게함

    // 2. 책 목록 보기
    @Test
    public void 책목록보기_test(){
          // given (데이터 준비)
          String title = "junit5";
          String author = "메타코딩";
        //   Book book = Book.builder()
        //   .title(title)
        //   .author(author)
        //   .build();
        //   bookRepository.save(book);


        // when
        List<Book> booksPS = bookRepository.findAll();

        System.out.println("================ size() : "+booksPS.size());

        // then
        assertEquals("junit5", booksPS.get(0).getTitle());
        assertEquals(author, booksPS.get(0).getAuthor());        
    } // 트랜잭션 종료 (저장된 데이터를 초기화함)

    // 3. 책 한건 보기
    @Test
    public void 책한건보기_test(){
          // given (데이터 준비)
          String title = "junit";
          String author = "겟인데어";



          //when
            Book bookPS = bookRepository.findById(1L).get();

          //then
          assertEquals(title, bookPS.getTitle());
          assertEquals(author, bookPS.getAuthor());
    }

    // 4. 책 수정

    // 6. 책 삭제
}
