package com.kaya.erp.kayaerp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.kaya.erp.kayaerp.starter.KayaerpApplication;

@SpringBootTest(classes = KayaerpApplication.class)
public class KayaerpApplicationTests {

    @Test
    void contextLoads() {
        // Sadece context yükleniyor mu diye test eder
    }
}