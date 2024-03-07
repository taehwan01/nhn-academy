public class MyListTest {
    public static void main(String[] args) {
        MyList<Student> list = new MyList<>();

        list.add(new Student(2017301073, "TaeHwan", "SE"));
        list.add(new Student(2019502002, "Apple", "CE"));
        list.add(new Student(2018107023, "Monte", "SE"));
        list.add(new Student(2016310057, "Son", "SE"));

        // 학번에 대한 정렬(기본 정렬)
        // list.sort();

        // 이름에 대한 정렬
        // list.sort(new StudentNameComparator());
        list.sort((Student s1, Student s2) -> s1.getName().compareTo(s2.getName()));

        for (Student element : list) {
            System.out.println(element);
        }
    }
}
