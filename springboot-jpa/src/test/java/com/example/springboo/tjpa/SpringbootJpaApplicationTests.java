package com.example.springboo.tjpa;

import com.example.springboo.tjpa.domain.User;
import com.example.springboo.tjpa.service.UserRepository;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
class SpringbootJpaApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        userRepository.save(new User("liming",60));
        userRepository.save(new User("qinfang",19));
        userRepository.save(new User("baozheng",21));
        userRepository.save(new User("yuefei",36));
        userRepository.save(new User("songjiang",45));

        Assert.assertEquals(15,userRepository.findAll().size());
    }

}
