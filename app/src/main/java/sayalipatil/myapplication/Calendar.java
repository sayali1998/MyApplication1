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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Calendar extends Fragment {

    CalendarView calendarView;
    TextView crnt_date,sbmn_date,rem_date;
    TextView displayDay;
    String date=" ";
    static String month=" ";
    private boolean isFirebaseSelected;
    private DatabaseReference databaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    public void findMonth(int mn)
    {
        switch(mn)
        {
            case 0: month="January";
                break;
            case 1:month="February";
                break;
            case 2:month="March";
                break;
            case 3:month="April";
                break;
            case 4:month="May";
                break;
            case 5:month="June";
                break;
            case 6:month="July";
                break;
            case 7: month="August";
                break;
            case 8:month="September";
                break;
            case 9:month="October";
                break;
            case 10:month="November";
                break;
            case 11:month="December";
                break;
        }
    }

    private void connectFirebase(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("/Calendar");


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       final CardView reminderCard=(CardView) getView().findViewById(R.id.reminder);
        calendarView = (CalendarView) view.findViewById(R.id.calender);
        crnt_date = (TextView)view.findViewById(R.id.crnt_date);
        sbmn_date = (TextView)view.findViewById(R.id.sbmn_date);
        displayDay=(TextView)view.findViewById(R.id.displayDay);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMMM-yyyy");
        date=simpleDateFormat.format(new Date());
        displayDay.setText(date);
        rem_date = (TextView)view.findViewById(R.id.rem_date);
        Log.d("Boolean",String.valueOf(reminderCard.getVisibility()));
        reminderCard.setVisibility(View.INVISIBLE);
        Log.d("Boolean",String.valueOf(reminderCard.getVisibility()));
        connectFirebase();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int mnth, int dayOfMonth) {
                reminderCard.setVisibility(View.VISIBLE);
                findMonth(mnth);
                displayDay.setText(" "+dayOfMonth+"-"+month+"-"+year);
                sbmn_date.setText("Two Days Left");
                rem_date.setText("Reminder:Please collect your Cards");
            }

        });

    }
}
