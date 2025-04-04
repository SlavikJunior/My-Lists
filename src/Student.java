package src;

public class Student implements Comparable<Student> {

    private String surName;
    private String name;
    private String city;
    private int yearOfBirthday;
    private int infaPoints;
    private int algemPoints;
    private int matanPoints;
    private int discraPoints;
    private double averageMark;

    public Student(String surName, String name, String city,
                   int yearOfBirthday, int infaPoints, int algemPoints,
                   int matanPoints, int discraPoints) {
        this.surName = surName;
        this.name = name;
        this.city = city;
        this.yearOfBirthday = yearOfBirthday;
        this.infaPoints = infaPoints;
        this.algemPoints = algemPoints;
        this.matanPoints = matanPoints;
        this.discraPoints = discraPoints;
        this.averageMark = (infaPoints + algemPoints + matanPoints + discraPoints) / 4;
    }

    @Override
    public String toString() {
        return String.join(" ", surName, name, city, String.valueOf(yearOfBirthday),
                String.valueOf(infaPoints), String.valueOf(algemPoints),
                String.valueOf(matanPoints), String.valueOf(discraPoints));
    }

    public double getAverageMark() {
        return averageMark;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student otherStudent) {
        int surnameCompare = getSurName().compareTo(otherStudent.getSurName());
        if (surnameCompare > 0)
            return 1;
        else if (surnameCompare < 0)
            return - 1;
        else
            return getName().compareTo(otherStudent.getName());
    }
}
