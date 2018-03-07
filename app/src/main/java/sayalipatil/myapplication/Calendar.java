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
import android.widget.LinearLayout;
import android.widget.TextView;


public class Calendar extends Fragment {



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
        reminderCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout reminder=(LinearLayout) getView().findViewById(R.id.remainder_expandable);
                if(reminder.getVisibility()==View.GONE){
                    reminder.setVisibility(View.VISIBLE);
                }
                else {
                    reminder.setVisibility(View.GONE);
                }
            }
        });
    }
}
