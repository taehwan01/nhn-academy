public class Date {
    private int year;
    private int month;
    private int day;

    public Date() {
        this(2000, 1, 1);
    }

    public Date(int year) { // 생성자 overload
        this(year, 1, 1);
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDate() {
        return this.year + "-" + this.month + "-" + this.day;
    }

    public String getYear() {
        return this.year + "";
    }

    public String getMonth() {
        return this.month + "";
    }

    public String getDay() {
        return this.day + "";
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}

class Test {
    public static void main(String[] args) {
        Date date = new Date(); // new -> 메모리 할당, 생성자 호출 + 생성자 위치 반환
        System.out.println(date.getYear());

        // Math m = new Math();
        // static 함수만 불러 쓰라고 만든 클래스에서는 생성자를 private으로 지정하여 객체 생성을 막아버림
    }
}