package com.dayFourEncapsulation;

public class OopsConceptDemo {

    private int serialNo;
    private String name;
    private int age;

    // Setters
    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public void setStringName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getters
    public int getSerialNo() {
        return serialNo;
    }

    public String getStringName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString method to display object data
    public String toString() {
        return "OopsConceptDemo { " +
               "serialNo = " + serialNo +
               ", name = '" + name + '\'' +
               ", age = " + age +
               " }";
    }

    public static void main(String[] args) {
        OopsConceptDemo op = new OopsConceptDemo();
        op.setSerialNo(10);
        op.setStringName("Diksha");
        op.setAge(21);

        // Print individual values (optional)
        System.out.println("Serial No: " + op.getSerialNo());
        System.out.println("Name: " + op.getStringName());
        System.out.println("Age: " + op.getAge());

        // Or just print the whole object using toString()
        System.out.println(op);
    }
}
