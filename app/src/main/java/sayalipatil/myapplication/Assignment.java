package sayalipatil.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Assignment extends Fragment{

    String prn="116A1056";
    FloatingActionButton fab;
    public Assignment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_assignment,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab = (FloatingActionButton) view.findViewById(R.id.upload);
//        if(prn=="116A1056") {
//            fab.setVisibility(View.VISIBLE);
//            fab.setOnClickListener(new View.OnClickListener() {
//
//
//                @Override
//                public void onClick(View view) {
//                    Fragment fragment=new UploadAssignments();
//
//                    FragmentManager fragmentManager=getFragmentManager();
//                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.assignFragment, fragment);
//
//                    fragmentTransaction.commit();
//                }
//            });
//        }

    }
}
