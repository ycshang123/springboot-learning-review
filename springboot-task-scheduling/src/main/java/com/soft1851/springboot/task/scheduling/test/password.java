package com.soft1851.springboot.task.scheduling.test;

import org.jasypt.util.text.BasicTextEncryptor;

public class password {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        String privateData = "123456";
        textEncryptor.setPasswordCharArray("123456".toCharArray());
        String myEncryptedText = textEncryptor.encrypt(privateData);
        System.out.println(privateData);
        System.out.println(myEncryptedText);
    }
}
