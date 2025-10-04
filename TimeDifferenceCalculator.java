public class TimeDifferenceCalculator {
    // Data members
    int hour;
    int minute;
    int second;

    // Default constructor
    public TimeDifferenceCalculator() {
        hour = 0;
        minute = 0;
        second = 0;
    }

    // Constructor to get input for hour, minute and second.
    public TimeDifferenceCalculator(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        // To check if the input is correct and user validation of correct / incorrect input.
        if(checkCorrectTime(hour, minute, second)){
            System.out.println("Correct time entered: "+ hour+":"+minute+":"+second+" ");
        }
        else {
            System.out.println("Enter the correct time in 24hr format.");
        }
    }

    // To check if the given input is correct.
    public boolean checkCorrectTime(int hour, int minute, int second){
        if(hour <= 23 && minute < 60 && second < 60)
            return true;
        else if(hour == 24 && minute < 60 && second < 60) {
            hour = 0;
            return true;
        }
        else {
            return false;
        }
    }

    // To calculate the difference in time.
    public TimeDifferenceCalculator timeDifference(TimeDifferenceCalculator givenTime) {
        int timeOneInSeconds = ( hour * 3600) + ( minute * 60) + second;
        int timeTwoInSeconds = ( givenTime.hour * 3600) + ( givenTime.minute * 60) + givenTime.second;
        int difference = Math.abs(timeOneInSeconds - timeTwoInSeconds);
        TimeDifferenceCalculator result = new TimeDifferenceCalculator();
        result.hour = difference / 3600;
        difference %= 3600;
        result.minute = difference / 60;
        difference %= 60;
        result.second = difference;
        return result;
    }
    // To show the time.
    public void showTime(){
        System.out.println("The time is: "+hour+":"+minute+":"+second);
    }
    public static void main(String[] args) {
        TimeDifferenceCalculator time1 = new TimeDifferenceCalculator(23, 45, 40); 
        TimeDifferenceCalculator time2 = new TimeDifferenceCalculator(9, 56, 20);
        TimeDifferenceCalculator differenceInTime = time1.timeDifference(time2);
        differenceInTime.showTime();
    }
}
