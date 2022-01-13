package org.khalin.jpa_basic.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khalin.jpa_basic.entity.Item;
import org.khalin.jpa_basic.entity.OrderItem;
import org.khalin.jpa_basic.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Rollback(value = false)
@Transactional
@SpringBootTest
public class OrderItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @Test
    public void createTest(){
        //given
        String userName = "chulsu";
        User user = User.builder()
                .userName(userName).build();
        userRepository.save(user);

        List<OrderItem> orderItems = new ArrayList<>();
        for(int i=1; i<=2; i++){
            Item item = itemRepository.save(Item.builder()
                    .name("item"+i)
                    .build());
            OrderItem orderItem = OrderItem.builder()
                    .item(item)
                    .user(user)
                    .build();
            orderItems.add(orderItem);
        }

        List<OrderItem> savedOrderItems = orderItemRepository.saveAll(orderItems);

        Assertions.assertEquals(userName, savedOrderItems.get(0).getUser().getUserName());
        Assertions.assertEquals(userName, savedOrderItems.get(1).getUser().getUserName());
    }
}
