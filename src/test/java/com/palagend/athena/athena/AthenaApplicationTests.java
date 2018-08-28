package com.palagend.athena.athena;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class AthenaApplicationTests {

    @Test
    public void contextLoads() {
        String  code = "ABCdefjjj";//纯字母
        String  code2 = "ABC2jjj345";//字母和数字
        String  code3 = "88991234";//纯数字

        Pattern pattern = Pattern.compile("^(?![a-zA-Z]+$)[0-9a-zA-Z]{8,12}$", Pattern.CASE_INSENSITIVE);

        boolean matches = pattern.matcher(code).matches();
        boolean matches2 = pattern.matcher(code2).matches();
        boolean matches3 = pattern.matcher(code3).matches();

        Assert.assertFalse(matches);
        Assert.assertTrue(matches2);
        Assert.assertTrue(matches3);
    }

}
