package site.metacoding.junitproject.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest // 디비와 관련된 로직만 메모리에 띄움
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
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

        // stub 필요 하기도 함

        // when (테스트 실행)
        Book bookPS = bookRepository.save(book);

        // then (검증)
        assertEquals(title, bookPS.getTitle());
        assertEquals(author , bookPS.getAuthor());
    }

    // 2. 책 목록 보기

    // 3. 책 한건 보기

    // 4. 책 수정

    // 6. 책 삭제
}
