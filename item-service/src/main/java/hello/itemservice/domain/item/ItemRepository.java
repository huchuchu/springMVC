package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    /**
     * 주의!!
     * 멀티스레드 환경에서 동시에 여러개가 store에 접근하게되면 HashMap을 사용하면안된다
     * ConcurrentMap<>을 사용해야함
     */
    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long id, Item updateParam){
        Item findItem = findById(id);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        // 정석으로 하려면 updateDto를 따로 만들어서 사용해야한다
        // update되는 대상에 id가 없기때문에 update 필요한 필드만 넣은 dto객체를 만들어 사용해야함
        // 귀찮고 중복이어도 명확한게 최고?!
    }

    public void clearStore(){
        store.clear();
    }


}
