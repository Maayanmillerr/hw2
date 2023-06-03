public class DateTime extends Date{
    private int hour;
    private int minute;

    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        setHour(hour);
        setMinute(minute);
    }

    public void setHour(int hour) {
        if(0<=hour && hour<=23){
            this.hour = hour;
        } else {
            this.hour=0;
        }
    }

    public void setMinute(int minute) {
        if (0 <= minute && minute <= 59) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
    }


    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }


    public boolean equals(Object other) {
        if (!(other instanceof DateTime)) {
            return false;
        } else {
            return super.equals(other) && ((DateTime) other).hour == this.hour && ((DateTime) other).minute == this.minute;
        }
    }

    @Override
    public int hashCode() {
        return (super.hashCode()*10000 + 60 * hour + minute);
    }

    public String toString(){
        String str= "";
        if(this.hour<10){
            str= "0" + this.hour;
        } else {
            str= this.hour + "";
        }
        if (this.minute<10){
            str= str + ":" + "0" + this.minute;
        } else {
            str= str + ":" + this.minute;
        }
        return super.toString() + " " +str;
    }
}