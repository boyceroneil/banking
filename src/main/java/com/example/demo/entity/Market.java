package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="market")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "bank_name")
    private String bank_name;

    @Column(name = "saving")
    private boolean saving;

    @Column(name = "checking")
    private boolean checking;

    @Column(name = "name")
    private String name;

    @Column(name = "account_number")
    private String account_number;

    @Column(name = "amount")
    private String amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public boolean isSaving() {
        return saving;
    }

    public void setSaving(boolean saving) {
        this.saving = saving;
    }

    public boolean isChecking() {
        return checking;
    }

    public void setChecking(boolean checking) {
        this.checking = checking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "market{" +
                "id=" + id +
                ", bank_name='" + bank_name + '\'' +
                ", saving=" + saving +
                ", checking=" + checking +
                ", name='" + name + '\'' +
                ", account_number='" + account_number + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
