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
import android.widget.Button;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Poll extends Fragment {

    private DatabaseReference databaseReference;
    private int upvote;
    private int downvote;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poll, container, false);
    }

    private void connectFirebase(){
      final FirebaseDatabase database=FirebaseDatabase.getInstance();
      databaseReference=database.getReference("/Classroom");
      databaseReference.child("/Poll/upvote").addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
            upvote=(int)dataSnapshot.getValue();
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
      });
      databaseReference.child("/Poll/downvote").addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
              downvote=(int)dataSnapshot.getValue();
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
      });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        connectFirebase();
        final RadioButton radioButton2=(RadioButton) getView().findViewById((R.id.radioButton2));
        final RadioButton radioButton1=(RadioButton) getView().findViewById(R.id.radioButton1);
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(radioButton1.isChecked()) ){
                    radioButton1.setChecked(true);
                    radioButton2.setChecked(false);
                }
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(radioButton2.isChecked())){
                    radioButton2.setChecked(true);
                    radioButton1.setChecked(false);

                }
            }
        });
        Button button=(Button) getView().findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton1.isChecked()){
                    databaseReference.child("/Poll/upvote").setValue(upvote+1);
                }
                if (radioButton2.isChecked()){
                    databaseReference.child("/Poll/downvote").setValue(downvote+1);

                }
            }
        });
    }
}
