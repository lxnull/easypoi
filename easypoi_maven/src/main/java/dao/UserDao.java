package dao;

import pojo.Card;
import pojo.Order;
import pojo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UserDao {

    public List<User> getUserList() {
        List<User> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setName("张三_" + i);
            user.setAge(10 + i);
            user.setCreateTime(new Date());
            user.setText("bywjw");

            if (i % 3 == 0) {
                user.setHobbies(Arrays.asList("抽烟","喝酒","烫头"));
            } else {
                user.setHobbies(Arrays.asList("跳楼","跳河","嗑药"));
            }

            if (i % 2 == 0) {
                user.setStatus(0);
            } else {
                user.setStatus(1);
            }

            Card card = new Card();
            card.setId(String.valueOf((int)((Math.random()*9+1)*100000)));
            card.setAddress("天津");
            user.setCard(card);

            List<Order> orders = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Order order = new Order();
                order.setId(String.valueOf((int)((Math.random()*9+1)*100000)));
                order.setName("商品_" + j);
                orders.add(order);
            }
            user.setOrders(orders);

            user.setPhotoPath("C:\\Users\\lenovo\\Desktop\\bear.png");

            list.add(user);
        }

        return list;
    }

    public List<User> getBigList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setName("张三_" + i);
            user.setAge(10 + i%100);
            user.setCreateTime(new Date());
            user.setText("bywjw");

            if (i % 3 == 0) {
                user.setHobbies(Arrays.asList("抽烟","喝酒","烫头"));
            } else {
                user.setHobbies(Arrays.asList("跳楼","跳河","嗑药"));
            }

            if (i % 2 == 0) {
                user.setStatus(0);
            } else {
                user.setStatus(1);
            }

            Card card = new Card();
            card.setId(String.valueOf((int)((Math.random()*9+1)*100000)));
            card.setAddress("天津");
            user.setCard(card);

            users.add(user);
        }

        return users;
    }
}