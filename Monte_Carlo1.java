import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

public class Monte_Carlo1 {
    public static void main(String[] args) throws ParseException {

        Vector<String > category= new Vector<>();
        category.add("Filling");
        category.add("Crown");
        category.add("Cleaning");
        category.add("Extracting");
        category.add("Check-up");
        System.out.println("Category" + category);

        Vector<Long> TimeRequired = new Vector<>();
        TimeRequired.add(45L);
        TimeRequired.add(59L);
        TimeRequired.add(15L);
        TimeRequired.add(45L);
        TimeRequired.add(15L);

//        TimeRequired.add(45);
//        TimeRequired.add(60);
//        TimeRequired.add(15);
//        TimeRequired.add(45);
//        TimeRequired.add(15);
        System.out.println("TimeRequired (Minutes)" + TimeRequired);

        Vector<Float> noofpatient = new Vector<>();
        noofpatient.add(40F);
        noofpatient.add(15F);
        noofpatient.add(15F);
        noofpatient.add(10F);
        noofpatient.add(20F);
        System.out.println("No of patients" + noofpatient);

        float sum = 0; for (float x : noofpatient)
        {
            sum += x;
        }
        System. out. println("Sum: " + sum);

        Vector<Float> probability = new Vector<>();
        probability.add(noofpatient.get(0)/sum);
        probability.add(noofpatient.get(1)/sum);
        probability.add(noofpatient.get(2)/sum);
        probability.add(noofpatient.get(3)/sum);
        probability.add(noofpatient.get(4)/sum);
        System.out.println("probability" + probability);

        Vector<Float> Cumulative = new Vector<>();
//        DecimalFormat df = new DecimalFormat();
//        Formatter d;
        float cp = 0; for (float c : probability)
        {
            cp += c;
//            Formatter formatter = new Formatter();
//            d = formatter.format("%.2f", cp);
            Cumulative.add(cp);
        }
        System.out.print("Cumulative Probability" + Cumulative);
        System.out.println();

         Vector<Float> Range= new Vector<>();
        Float g;
        float ra = 0; for (float f : Cumulative)
        {
            g =(f*100f)-1;
//            Formatter formatter = new Formatter();
//            d = formatter.format("%.2f", cp);

            Range.add(g);
        }
        System.out.println("Range-No" + Range);



//        DateFormat da = new SimpleDateFormat("hh:mm aa");
//        Vector<LocalTime> Schedule= new Vector<>();
//        Schedule.add(LocalTime.of(8, 0));
//        LocalTime l ;
//        for (LocalTime f : Schedule)
//        {
//            l.plusMinutes(30);
////            Formatter formatter = new Formatter();
////            d = formatter.format("%.2f", cp);
//            Schedule.add(f);
//        }
//        System.out.println(Schedule);



        Vector<LocalTime> Scheduled = new Vector<>();
        Scheduled.add(LocalTime.of(8, 0));
        Scheduled.add(Scheduled.get(0).plusMinutes(30));
        Scheduled.add(Scheduled.get(1).plusMinutes(30));
        Scheduled.add(Scheduled.get(2).plusMinutes(30));
        Scheduled.add(Scheduled.get(3).plusMinutes(30));
        Scheduled.add(Scheduled .get(4).plusMinutes(30));
        Scheduled.add(Scheduled .get(5).plusMinutes(30));
        Scheduled.add(Scheduled .get(6).plusMinutes(30));

        System.out.println("Scheduled-Arrival time"+ Scheduled);

        Vector<Integer> Random= new Vector<>();
        Random.add(40);
        Random.add(80);
        Random.add(11);
        Random.add(34);
        Random.add(25);
        Random.add(66);
        Random.add(17);
        Random.add(79);
        System.out.println("Random-NO" + Random);


        Vector<String> Operations = new Vector<>();
//        String s1 =
//        float a1 = rNumber.get(0);
        for (int i = 0;i<=7;i++) {
            if (Random.get(i) <= Range.get(0)) {
                Operations.add(category.get(0));
            } else if (Random.get(i) <= Range.get(1)) {
                Operations.add(category.get(1));
            } else if (Random.get(i) <= Range.get(2)) {
                Operations.add(category.get(2));
            } else if (Random.get(i) <= Range.get(3)) {
                Operations.add(category.get(3));
            } else if (Random.get(i) <= Range.get(4)) {
                Operations.add(category.get(4));
            }
        }
            System.out.println("Category 2 " + Operations);

        Vector<Long> Service= new Vector<>();
        for (int i = 0;i<=7;i++) {
            if (Random.get(i) <= Range.get(0)) {
                Service.add(TimeRequired.get(0));
            } else if (Random.get(i) <= Range.get(1)) {
                Service.add(TimeRequired.get(1));
            } else if (Random.get(i) <= Range.get(2)) {
                Service.add(TimeRequired.get(2));
            } else if (Random.get(i) <= Range.get(3)) {
                Service.add(TimeRequired.get(3));
            } else if (Random.get(i) <= Range.get(4)) {
                Service.add(TimeRequired.get(4));
            }
        }
        System.out.println("Service Time Needed" + Service);


        Vector<LocalTime> actualServiceTime = new Vector<>();
        actualServiceTime.add(Scheduled.get(0));

        for (int j = 0; j <= 6; j++) {
            actualServiceTime.add(actualServiceTime.get(j).plusMinutes(Service.get(j)));
        }
        System.out.println("Actual Service Time is " + actualServiceTime);
//        Vector<LocalTime> Actual= new Vector<>();
//        Actual.add()
//        Actual.add(Scheduled.get(1).cal.add(Service.get(0)));
//          Actual.add(Scheduled.get(0).parse(Service.get(2)));
//        Actual.add(Scheduled.get(3).plusMinutes(Service.get(2)));
//        Actual.add(Scheduled .get(4).plusMinutes(Service.get(3)));
//        Actual.add(Scheduled .get(5).plusMinutes(Service.get(4)));
//        Actual.add(Scheduled .get(6).plusMinutes(Service.get(5)));

//        System.out.println("Actual Time"+ Actual);

        Vector<LocalTime> waitingTime = new Vector<>();
//        LocalTime l1 = actualServiceTime.get(0).
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        for (int k = 0; k <= 7; k++) {
            Date date1 = simpleDateFormat.parse(String.valueOf(actualServiceTime.get(k)));
            Date date2 = simpleDateFormat.parse(String.valueOf(Scheduled.get(k)));

            long differenceInMilliSeconds
                    = Math.abs(date2.getTime() - date1.getTime());
//            long differenceInHours
//                    = (differenceInMilliSeconds / (60 * 60 * 1000))
//                    % 24;

            // Calculating the difference in Minutes
            long differenceInMinutes
                    = (differenceInMilliSeconds / (60 * 1000)) % 60;

            // Calculating the difference in Seconds
            waitingTime.add(LocalTime.ofSecondOfDay(differenceInMinutes));
        }
        System.out.println(waitingTime);



        Vector<LocalTime> idleTime = new Vector<>();
        for (int m = 0; m <= 7; m++) {
            LocalTime time1 = LocalTime.parse(String.valueOf(actualServiceTime.get(m)));
            LocalTime time2 = LocalTime.parse(String.valueOf(Scheduled.get(m)));
            int value = time2.compareTo(time1);

            if (value <= 0)
                idleTime.add(LocalTime.of(0, 0));
            else{
                break;
            }
        }
        System.out.println("Idle Time of the Doctor is : " + idleTime);


    }


}
