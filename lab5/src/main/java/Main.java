import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import static java.time.Month.*;

import static java.time.temporal.TemporalAdjuster.*;
import static java.lang.System.out;

import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static java.time.temporal.TemporalAdjusters.*;
import static java.time.temporal.ChronoUnit.*;

public class Main {
    public static void main(String[] args) {
        LocalDate bDateOfLincoln = LocalDate.of(1809, 2, 12);
        LocalDate dDateOfLincoln = LocalDate.of(1855, 4, 15);

        int yearsOfLincoln = dDateOfLincoln.getYear() - bDateOfLincoln.getYear();
        out.println("How old when he died?\n" + "Lincoln was " + yearsOfLincoln + ", when he died");
        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        LocalDate bDateOfCumberbatch = LocalDate.of(1976, 6, 19);

        out.println("Did Cumberbatch born in a leap year?");
        if (bDateOfCumberbatch.isLeapYear())
            out.println("Yes, he was born in a leap year\nThere are 366 days");
        else out.println("No, he wasn`t born in a leap year\nThere are 365 days");

        int decadesOfCumberbatch = (LocalDate.now().getYear() - bDateOfCumberbatch.getYear()) / 10;
        out.println("How many decades old is he?\n" + "Cumberbatch is " + decadesOfCumberbatch + " decades");
        DayOfWeek day = LocalDate.of(bDateOfCumberbatch.getYear() + 21, 6, 19).getDayOfWeek();
        out.println("The day of the week on his 21st birthday was " + day);
        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        LocalTime dTrain = LocalTime.of(13, 45);
        LocalTime aTrain = LocalTime.of(19, 25);

        long deltaTime = dTrain.until(aTrain, ChronoUnit.MINUTES);
        out.println("The train rides " + deltaTime + " minutes");
        LocalTime delayTime = aTrain.plusHours(1).plusMinutes(19);
        out.println("After delay the train will arrive at "
                + delayTime.getHour() + ":"
                + delayTime.getMinute());
        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        // LocalTime timeBoston = LocalTime.of(21, 15);
        LocalDateTime dateBoston = LocalDate.of(LocalDate.now().getYear(), 3, 24).atTime(21, 15);
        LocalTime timeFlight = LocalTime.of(4, 15);

        LocalDateTime dateMiami = dateBoston
                .plusHours(timeFlight.getHour())
                .plusMinutes(timeFlight.getMinute());
        out.println("It arrives at " + dateMiami.getHour() + ":"
                + dateMiami.getMinute() + "AM"
                + " in " + dateMiami.getMonth() + " "
                + dateMiami.getDayOfMonth());

        LocalTime timeDelay = LocalTime.of(4, 27);
        dateMiami = dateMiami
                .plusHours(timeDelay.getHour())
                .plusMinutes(timeDelay.getMinute());
        out.println("After delay it arrives at " + dateMiami.getHour() + ":"
                + dateMiami.getMinute() + "AM"
                + " in " + dateMiami.getMonth() + " "
                + dateMiami.getDayOfMonth());
        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        ZonedDateTime zdt1 =
                ZonedDateTime
                        .of(2021, 9, 14, 0, 0, 0, 0, ZoneId.of("Europe/Moscow"));
        out.println("This date is " + zdt1.getDayOfMonth() + " of " + zdt1.getMonth());

        ZonedDateTime zdt2 =
                ZonedDateTime
                        .of(2022, 5, 25, 0, 0, 0, 0, ZoneId.of("Europe/Moscow"));

        int rez = 365 - zdt1.getDayOfYear() + zdt2.getDayOfYear() - 2 * 7 - 2 * 7 - 2 * (12 + zdt2.getMonthValue() - zdt1.getMonthValue() - 4);
        out.println("The hole number of school days are: " + rez);
        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        out.println("A meeting is schedule for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.\n" +
                "What is the time of the week's meetings?\n" + "what does it mean?");
        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        ZonedDateTime flight123 = ZonedDateTime.of(2014, 5, 13, 22, 30, 0, 0, ZoneId.of("America/Los_Angeles"));

        ZonedDateTime timeBOS = flight123.withZoneSameInstant(ZoneId.of("America/New_York"));
        out.println("The local time in Boston when the flight takes off: " + timeBOS.format(format));
        timeBOS = timeBOS.plusHours(5).plusMinutes(30);
        out.println("The local time at Boston Logan airport when the flight arrives: " + timeBOS.format(format));
        out.println("The local time in San Francisco when the flight arrives: " + flight123.plusHours(5).plusMinutes(30).format(format));
        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        ZonedDateTime flight456 =
                ZonedDateTime
                        .of(2014, 5, 28, 21, 30, 0, 0, ZoneId.of("America/Los_Angeles"));
        ZonedDateTime meeting =
                ZonedDateTime
                        .of(2014, 5, 30, 9, 0, 0, 0, ZoneId.of("Asia/Calcutta"));

        flight456 = flight456.plusHours(22);
        ZonedDateTime timeBLR = flight456.withZoneSameInstant(ZoneId.of("Asia/Calcutta"));
        out.println("The traveler will arrive to Bangalore in " + timeBLR.format(format));
        out.println("So, if he can get the destination in an 1 hour, he`ll make a meeting in Bangalore Monday at 9 AM local time");
        out.println("Yes, the traveler will be able to call her husband at a reasonable time when she arrives, cause it`ll be " +
                flight456.format(format) + " in San Francisco");
        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        flight123 =
                ZonedDateTime
                        .of(2014, 9, 1, 22, 30, 0, 0, ZoneId.of("America/Los_Angeles"));
        ZonedDateTime dayAndTimeBOS = flight123.plusHours(5).plusMinutes(30).withZoneSameInstant(ZoneId.of("America/New_York"));
        out.println("The flight arrives in Boston in " + dayAndTimeBOS.format(format));
        out.println("It`ll be a new day and the flight arrives in Boston...)");
        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
}