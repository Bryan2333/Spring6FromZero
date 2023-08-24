package com.bryan019.spring6.test;

import com.bryan019.spring6.SpringConfig;
import com.bryan019.spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Spring6对Junit5的整合
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class TestJunit {

    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
    }
}
