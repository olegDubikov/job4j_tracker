package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setFio("Иван Иванов");
        student1.setGroup("КИП - 1A");
        student1.setDate("01.09.2022");

        System.out.println("Студент: " + student1.getFio() + "\n"
                + "Группа: " + student1.getGroup() + "\n"
                + "Дата зачисления: " + student1.getDate());
    }
}
