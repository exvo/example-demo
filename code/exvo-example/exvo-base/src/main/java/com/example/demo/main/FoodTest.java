package com.example.demo.main;

import com.example.demo.model.Food;

/**
 * @Date: 2019/4/22
 * @Author: wu yang
 * @Description:
 */
public class FoodTest {

    public static void main(String[] args) {
        Food food = new Food();
        food.setName("米饭");

        NewModel model = new NewModel();
        model.setFood(food);
        System.out.println("1: \t" + model.getFood().getName());

        food.setName("面条");
        process(model);
    }

    public static void process(NewModel model) {
        System.out.println("3: \t" + model.getFood().getName());
    }

}

class NewModel {
    Food food;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
