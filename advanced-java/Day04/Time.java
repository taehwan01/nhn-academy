public class Time {
    int hour;
    int minute;
    int second;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void displayTime() {
        System.out.println(hour + " " + minute + " " + second);
    }
}