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