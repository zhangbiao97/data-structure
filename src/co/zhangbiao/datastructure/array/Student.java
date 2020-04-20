package co.zhangbiao.datastructure.array;

/**
 * Create By ZhangBiao
 * 2020/4/20
 */
public class Student {


    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> students = new Array<>();
        students.addLast(new Student("zhangsan", 100));
        students.addLast(new Student("lisi", 88));
        students.addLast(new Student("wangwu", 65));
        System.out.println(students);
    }


}
