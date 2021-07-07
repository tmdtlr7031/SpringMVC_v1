package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepository {

    // 스프링빈은 싱글톤인데 이렇게 멤버 변수를 사용하면 멀티 스레드 환경에서 이슈발생할 수 있기 때문
    private static final Map<Long, Item> store = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong();

    public Item save(Item item) {
        item.setId(sequence.incrementAndGet()); // 1 증가시키고 get
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); // store 값 안 변하게 한번 감싸서!
    }

    public void update(Long itemId, Item updateparam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateparam.getItemName());
        findItem.setPrice(updateparam.getPrice());
        findItem.setQuantity(updateparam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
