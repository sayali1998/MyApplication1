package sayalipatil.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                crnt_date.setText("Current Date:-"+dayOfMonth+" / "+month+" / "+year);
                sbmn_date.setText("Dead line :- Something just like this dooodooodooo");
                rem_date.setText("Reminder:-Submission  Date :)LOL hahahaha :) ");
            }
        });
//        reminderCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LinearLayout reminder=(LinearLayout) getView().findViewById(R.id.remainder_expandable);
//                if(reminder.getVisibility()==View.GONE){
//                    reminder.setVisibility(View.VISIBLE);
//                }
//                else {
//                    reminder.setVisibility(View.GONE);
//                }
//            }
//        });
    }
}
