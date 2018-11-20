package com.example.demo.generic;

import com.example.demo.generic.model.Animal;
import com.example.demo.generic.model.Panda;
import com.example.demo.generic.model.People;
import lombok.Getter;
import lombok.Setter;

/**
 * User: wu yang
 * Time: 2018/11/20
 * Description:动物泛型  单个
 */
@Getter
@Setter
public class AnimalGeneric<T extends Animal> {

    private T data;

    public AnimalGeneric (T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public static void main(String[] args) {
//        报错，因为people没有继承Animal
//        AnimalGeneric<People> peopleAnimalGeneric = new AnimalGeneric<People>();
        AnimalGeneric<Panda> pandaAnimalGeneric = new AnimalGeneric<>(new Panda("熊猫", 12));
        System.out.println(pandaAnimalGeneric.toString());
    }

}
