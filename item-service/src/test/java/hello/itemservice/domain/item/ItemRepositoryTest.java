package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item fineItem = itemRepository.findById(item.getId());
        assertThat(fineItem).isEqualTo(saveItem);
    }

    @Test
    void findAll(){
        //given
        Item itemA = new Item("itemA", 10000, 10);
        Item itemB = new Item("itemB", 10000, 10);
        Item itemC = new Item("itemC", 10000, 10);

        itemRepository.save(itemA);
        itemRepository.save(itemB);
        itemRepository.save(itemC);

        //when
        List<Item> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(itemA,itemB,itemC);

    }

    @Test
    void updateItem(){
        //given
        Item item = new Item("itemA", 10000, 10);
        itemRepository.save(item);
        Item updateItem = new Item("itemB", 20000, 10);

        //when
        itemRepository.update(item.getId(), updateItem);

        //then
        Item findItem = itemRepository.findById(item.getId());

        assertThat(findItem.getItemName()).isEqualTo(updateItem.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateItem.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateItem.getQuantity());
    }

}