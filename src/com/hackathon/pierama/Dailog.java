package com.hackathon.pierama;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by shakar on 12/21/14.
 */
public class Dailog extends DialogFragment{
    @NonNull





    public Dialog onCreateDialog(Bundle savedinstance) {


            AlertDialog.Builder builders=new AlertDialog.Builder(getActivity());
            final String subhall[]=getfromdb.hall;
            builders.setTitle("Select a hall").setSingleChoiceItems(subhall,0,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    getfromdb.selectedhall=subhall[i];
                    Toast.makeText(getActivity(),getfromdb.selectedhall,Toast.LENGTH_SHORT).show();
                }
            }).setPositiveButton("Okay",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {


                }
            });
            return builders.show();

    }
}
