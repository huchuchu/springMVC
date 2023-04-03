## 🔅 spring boot + thymeleaf

### form tag
* 폼으로 이동하면서 빈 객체를 같이 보낸다. `th:object`를 적용하기 위해서는 해당 오브젝트 정보를 넘겨주어야한다.
```agsl
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "form/editForm";
    }
```
* `th:object` : `<from>`에서 사용할 객체를 지정한다. 선택 변수 식 `*{...}`을 적용할 수 있다.
* `*{itemName}`은 `${item.itemName}`과 같다. `th:object="${item}"`을 선택했기때문에 선택변수식을 적용할 수 있다.
* `th:field`는 id, name, value속성을 모두 자동으로 만들어준다.
```agsl
    <form action="item.html" th:action="@{|/form/items/${item.id}/edit|}" th:object="${item}"  method="post">
        <div>
            <label for="itemName">상품이름 ID</label>
            <input type="text" id="id" class="form-control" th:field="*{itemName}" readonly>
        </div>
    </form>
```

### check box
```agsl
        <div>판매여부</div>
        <div>
            <div class="form-check">
                <input type="checkbox" id="open" th:field="*{open}" class="form-check-input">
                <label for="open" class="form-check-label">판매오픈</label>
            </div>
        </div>
```
* `<input type="checkbox" id="open" name="open">`
  * 체크 박스를 체크하면 HTML Form에서 open=on이라는 값이 넘어간다. 스프링능 on이라는 문자를 true타입으로 변환해준다.(스프링 컨버터에의해)
  * <b>체크박스를 체크하지않으면</b> open이라는 필드 자체가 서버로 전송되지않는다.(따라서 객체에 바인딩 된 값이 없기때문에 값을 찍어보면 null로 나옴)
* `<input type="hidden" name="_open" value="on">` 
  * 이 문제를 해결하기위해 spring MVC는 히든 필드를 하나 만들어서 `name=_open`처럼 기존 체크박스 name 앞에 `_`를 붙여서 전송하면 해제했다고 인식할 수 있다.
  * hidden필드는 항상 전송된다. 따라서 체크를 해제한경우 `open`은 전송되지않고 `_open`만 전송되는데 이 때 spring MVC는 체크를 해제했다고 판단한다.
* `<input type="checkbox" id="open" th:field="*{open}" class="form-check-input">`
  * 타임리프 `th:field="${...}"`를 사용하면 hidden 필드를 자동으로 생성하고 처리해준다

```agsl
@ModelAttribute("regions")
public Map<String, String> regions() {
 Map<String, String> regions = new LinkedHashMap<>();
 regions.put("SEOUL", "서울");
 regions.put("BUSAN", "부산");
 regions.put("JEJU", "제주");
 return regions;
}
```
```agsl
        <!-- multi checkbox -->
        <div>
            <div>등록 지역</div>
            <div th:each="region : ${regions}" class="form-check form-check-inline">
                <input type="checkbox" th:field="*{regions}"
                                       th:value="${region.key}" class="form-check-input">
                <label th:for="${#ids.prev('regions')}"
                       th:text="${region.value}"
                       class="form-check-label">서울</label>
            </div>
        </div>
```
* regions에 담긴값을 each를 사용하여 출력한다. 
* 서버에 저장되는값은 regions의 key값이기때문에 `th:value=${region.key}`를 사용한다
* `th:for="${#ids.prev('regions')}"` 
  * 체크박스를 동적으로 만들 때 name은 중복이 가능하지만 id는 중복이 불가능한다. 따라서 타임리프는 체크박스를 each루프 안에서 반복해서 만들 때 임의로 1,2,3 숫자를 뒤에 붙여준다
  * `ids.prev(...)`, `ids.next(...)`을 사용하여 동적으로 생성되는 id값을 사용할 수 있다
