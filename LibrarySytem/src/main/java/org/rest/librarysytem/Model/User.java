package org.rest.librarysytem.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String Name;

    @Column
    private int age;

    @Column
    private String email;

    @Column
    private int LandNum;


    public int getLandNum() {
        return LandNum;
    }
    public void setLandNum(int landNum) {
        LandNum = landNum;
    }

    public int getId ()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getName(){
        return Name;
    }
    public void setName(String name){
        Name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public User get() {
        return this;
    }
}
