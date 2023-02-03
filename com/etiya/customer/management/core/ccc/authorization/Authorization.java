package com.etiya.customer.management.core.ccc.authorization;

public class Authorization implements IAuthorization{
    @Override
    public void authorize() {
        System.out.println("Kullanıcı yetkilendirildi..");
        // Sessiondan kullanıcı tokeni oku doğrula..
    }
}
