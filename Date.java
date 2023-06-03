 public class Date {
    private int day;
    private int month;
    private int year;


    public Date(int year, int month, int day) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        if(1<=day && day<=31){
            this.day = day;
        } else {
            this.day=1;
        }
    }

    public void setMonth(int month) {
        if(1<=month && month<=12){
            this.month = month;
        } else {
            this.month=1;
        }
    }

    public void setYear(int year) {
        if(-3999<=year && year<=3999){
            this.year = year;
        } else {
            this.year=0;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Date)) {
            return false;
        }
        Date otherDate = (Date) other;
        return this.day == otherDate.day && this.month == otherDate.month && this.year == otherDate.year && this.hashCode()==other.hashCode();
    }

    @Override
    public int hashCode() {
        if(year<0){
            int yearplus= -1*year;
            return -1*(yearplus+month*10000+day*1000000);
        }
        return year+month*10000+day*1000000;
    }

    public String toString(){
        String str="";
        if(day<10) {
            str = "0" + this.day;
        } else {
            str = "" + this.day;
        }
        if (month<10){
            str= str + "/" + "0" + this.month;
        } else {
            str= str + "/" + this.month;
        }
        if (year<10){
            str= str + "/" + "000" + this.year;
        } else if(year<100){
            str= str + "/" + "00" + this.year;
        }  else if(year<1000){
            str= str + "/" + "0" + this.year;
        } else {
            str= str + "/" + this.year;
        }
        return str;
    }
}
