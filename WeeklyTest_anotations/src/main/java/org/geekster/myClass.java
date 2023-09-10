package org.geekster;


import org.springframework.stereotype.Component;

@Component    // object of this class will be created
public class myClass {

    private String name;


    public myClass() {       // this will confirm that component created object of this class
        this.name = "Jamsheed";
        System.out.println("Object was created");
    }

    public myClass(String name) {
        System.out.println("name :"  + name);
        this.name = name;
    }

    public String getname() {
        return name;
    }
}
