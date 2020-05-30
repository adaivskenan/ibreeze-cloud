package com.ibreeze.oauth.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by adaivskenan on 2020/5/29.
 */
public class BCryptPasswordEncoderTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.printf(encoder.encode("123"));

    }

}
