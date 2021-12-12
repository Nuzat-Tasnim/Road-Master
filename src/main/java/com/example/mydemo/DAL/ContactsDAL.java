package com.example.mydemo.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsDAL extends JpaRepository<Contacts, Integer> {
    public Contacts findContactsById(int contactid);
}
