package com.amrita.jpl.cys21051.pract.student_details;

class CYS21051 {
    String roll;
    String name;
    int age;
    String gradeLevel;

    public CYS21051(String roll, String name, int age, String gradeLevel) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.gradeLevel = gradeLevel;
    }

    public String getRoll() {
        return this.roll;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGradeLevel() {
        return this.gradeLevel;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public static void main(String[] args) {
        CYS21051 obj1 = new CYS21051("CB.EN.U4CYS21051", "Nithin S", 19, "Sophomore");
        System.out.println("Details:");
        System.out.println("Roll No: " + obj1.getRoll());
        System.out.println("Name: " + obj1.getName());
        System.out.println("Age: " + obj1.getAge());
        System.out.println("Education: " + obj1.getGradeLevel());
    }
}
