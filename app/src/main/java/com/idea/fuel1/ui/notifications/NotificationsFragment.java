package com.idea.fuel1.ui.notifications;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.idea.fuel1.R;


import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;

//import in.saicomnetwork.tsmart.Geocoder2;




public class NotificationsFragment extends Fragment{

   EditText eepet,eediesel;
   Button eupdate;
   TextView td1;
   int dt23;
   SharedPreferences sharedpetrol,shareddiesel;
    String MY_PREFS_NAME = "TestName";
    String MY_PREFS_NAME1 = "TestName1";

    SharedPreferences sharedPreferenceslkj;
    String sdf;
    String all;






    public void onCreate(Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);






    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  homeViewModel = ViewModelProviders.of (this).get (HomeViewModel.class)
        Menu m1;
        View root = inflater.inflate (R.layout.fragment_notifications, container, false);
        eepet=root.findViewById (R.id.epet1);
        eediesel=root.findViewById (R.id.edes1);
        eupdate=root.findViewById (R.id.bupdate33);
        td1=root.findViewById (R.id.tdate1);
        Calendar calendar=Calendar.getInstance ();
        int dt56=calendar.get(Calendar.DAY_OF_MONTH);
        String month1=Integer.toString (dt56);
        int dt78=calendar.get(Calendar.DAY_OF_YEAR);
        String year1=Integer.toString (dt78);
        dt23= calendar.get (Calendar.DATE);
        String dt231=Integer.toString (dt23);
         all="Today date is "+dt231+"-9-2020";
        td1.setText (all);
        sharedPreferenceslkj=getContext ().getSharedPreferences ("adminmail5",MODE_PRIVATE);
         sdf=sharedPreferenceslkj.getString ("admail65",null);



        eupdate.setOnClickListener (new View.OnClickListener ( ) {

            @Override
            public void onClick(View v) {
                String pt=eepet.getText ().toString ();
                String dt=eediesel.getText ().toString ();
                //SharedPreferences.Editor editor = getContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
               // editor.putString(saveKey, stringToSave);
               // editor.apply();
                SharedPreferences.Editor edt= getContext ().getSharedPreferences (MY_PREFS_NAME,MODE_PRIVATE).edit ();
                edt.putString ("petroret",pt);
               // edt.putString ("dieselrate",dt);
                edt.apply ();
                SharedPreferences.Editor edt55=getContext ().getSharedPreferences (MY_PREFS_NAME1,MODE_PRIVATE).edit ();
                edt55.putString ("dieselrate",dt);
                edt55.apply ();
                Toast.makeText (getContext (),"Details updated successfully",Toast.LENGTH_LONG).show ();



            }
        });


        return root;
    }














}

