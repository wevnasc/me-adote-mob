package com.wnascimento.com.me_adote_mob.util;

import android.content.Context;

import com.wnascimento.com.me_adote_mob.R;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatterBuilder;

public class DateHelper {

    public static String getPeriodInYearsOrMonths(Context context, long start, long end) {
        PeriodFormatterBuilder buildFormat = new PeriodFormatterBuilder();

        DateTime now = new DateTime(start);
        DateTime age = new DateTime(end);
        Period period = new Period(now, age);

        if (period.getMonths() == 0 && period.getYears() == 0) {
            return context.getString(R.string.msg_a_few_weeks);
        }

        if (period.getYears() == 0) {
            buildFormat.appendMonths()
                    .appendSuffix(" " + context.getString(R.string.msg_month),
                            " " + context.getString(R.string.msg_months));
        } else {
            buildFormat.appendYears()
                    .appendSuffix(" " + context.getString(R.string.msg_year),
                            " " + context.getString(R.string.msg_years));
        }

        return buildFormat.toFormatter().print(period);

    }


}
