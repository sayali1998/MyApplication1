package sayalipatil.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.CardView;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Calendar extends Fragment {

    CalendarView calendarView;
    TextView crnt_date,sbmn_date,rem_date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final CardView reminderCard=(CardView) getView().findViewById(R.id.reminder);
        calendarView = (CalendarView) view.findViewById(R.id.calender);
        crnt_date = (TextView)view.findViewById(R.id.crnt_date);
        sbmn_date = (TextView)view.findViewById(R.id.sbmn_date);
        rem_date = (TextView)view.findViewById(R.id.rem_date);
        Log.d("Boolean",String.valueOf(reminderCard.getVisibility()));
        reminderCard.setVisibility(View.INVISIBLE);
        Log.d("Boolean",String.valueOf(reminderCard.getVisibility()));


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int dayOfMonth, int month) {
                reminderCard.setVisibility(View.VISIBLE);
                crnt_date.setText("Current Date:-"+dayOfMonth+"/"+month+"/"+year);
                sbmn_date.setText("Two Days Left");
                rem_date.setText("Reminder:Please collect your Cards");
            }
        });
    }
}
