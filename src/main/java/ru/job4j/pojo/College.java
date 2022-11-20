package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullname("Иванов Иван Иванович");
        student.setGroup("3");
        student.setDateadmission("21.05.2020");
        System.out.println("Студент:" + student.getFullname()
                + ". № группы:" + student.getGroup()
                + ". Дата поступления:" + student.getDateadmission());
    }
}
