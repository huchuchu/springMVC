## 🌿 Thymeleaf 메모

#### 공식 사이트 : https://www.thymeleaf.org/
#### 메뉴얼(기본기능) : https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html 
#### 메뉴얼(스프링통합) : https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html

#### 유틸리티 객체 : https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#expression-utility-objects
#### 유틸리티 객체 예시 : https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#appendix-b-expression-utility-objects

### 📌텍스트 - text, utext : [text-basic.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/text-basic.html) , [text-unescaped.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/text-unescaped.html)
### 📌변수 - springEl : [variable.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/variable.html)
### 📌기본 객체들 : [basic-object.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/basic-object.html)
### 📌유틸리티 객체와 날짜 : [date.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/date.html)
### 📌URL 링크 : [link.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/link.html)
### 📌리터럴 : [literal.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/literal.html)
### 📌연산 : [operation.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/operation.html)
* 비교연산 : HTML 엔티티를 사용해야 하는 부분을 주의해야함
  * `>` : gt , `<` : lt , `>=` : ge , `<=` : le , `!` : not , `==` : eq , `!=` : neq, ne
* Elvis 연산자 : 조건식의 편의버전
   ```agsl
    <ul>
      <li>${data}?: '데이터가 없습니다.' = <span th:text="${data}?: '데이터가없습니다.'"></span></li>
      <li>${nullData}?: '데이터가 없습니다.' = <span th:text="${nullData}?:'데이터가 없습니다.'"></span></li>
    </ul>
    ```
* No-Operation : `_`인 경우 마치 타임리프가 실행되지않는 것 처럼 동작한다. 잘 사용하면 HTML의 내용 그대로 활용할 수 있다.
   ```agsl
    <ul>
      <li>${data}?: _ = <span th:text="${data}?: _">데이터가 없습니다.</span></li>
      <li>${nullData}?: _ = <span th:text="${nullData}?: _">데이터가없습니다.</span></li>
    </ul>
    ```
### 📌속성 값 설정 : [attribute.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/attribute.html)
### 📌반복 : [each.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/each.html)
### 📌조건부 평가 : [condition.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/condition.html)
### 📌주석 : [comments.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/comments.html)
### 📌블록 : [block.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/block.html)
### 📌자바스크립트 인라인 : [javascript.html](https://github.com/huchuchu/springMVC/blob/master/thymeleaf-basic/src/main/resources/templates/basic/javascript.html)
### 📌템플릿 조각 : [fragment](https://github.com/huchuchu/springMVC/tree/master/thymeleaf-basic/src/main/resources/templates/template/fragment)
### 📌템플릿 레이아웃1 : [layout](https://github.com/huchuchu/springMVC/tree/master/thymeleaf-basic/src/main/resources/templates/template/layout)
### 📌템플릿 레이아웃2 : [layoutExtend](https://github.com/huchuchu/springMVC/tree/master/thymeleaf-basic/src/main/resources/templates/template/layoutExtend)
