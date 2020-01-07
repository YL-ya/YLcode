package com.bitedu.data;

public class Student {
    private int sn;
    private String name;
    private int classId;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sn=" + sn +
                ", name='" + name + '\'' +
                ", classId=" + classId +
                '}';
    }
}
