## message
* 스프링 메시지 소스 설정 : 스프링은 기본적인 메시지 관리 기능을 제공한다.
* `MessageSource`는 스프링이 제공하는 메시지관리 인터페이스이다. 구현체인 `ResourceBundleMessageSource`를 빈으로 등록하면된다.
* 스프링 부트는 `MessageSource`를 자동으로 스프링빈으로 등록한다.
  * 메시지 소스 기본 값 : `spring.messages.basename=messages`
  * 별도의 설정을 하지 않으면 `messages`라는 이름으로 기본 등록된다. 
  * 따라서 `messages.properties` 파일을 등록하면 자동인식 할 수 있다.

### 타임리프 메시지
* `#{...}` 메시지 테그
```aidl
page.items=상품 목록
page.item=상품 상세
page.addItem=상품 등록
page.updateItem=상품 수정
```
```aidl
<h2 th:text="#{page.items}">상품 목록</h2>
```

* 파라미터타입
```aidl
hello=안녕
hello.name=안녕 {0}
```
```aidl
<p th:text="#{hello.name(${item.itemName})}"></p>
```
