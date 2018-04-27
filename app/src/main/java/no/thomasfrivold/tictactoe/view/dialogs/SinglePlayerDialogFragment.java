package no.thomasfrivold.tictactoe.view.dialogs;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.widget.EditText;

import no.thomasfrivold.tictactoe.R;
import no.thomasfrivold.tictactoe.view.GameActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SinglePlayerDialogFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.fragment_singleplayer_dialog, null))
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Cast to dialog so that findViewById will be available.
                        Dialog f = (Dialog) dialog;

                        EditText one = f.findViewById(R.id.edt_singleplayer);

                        String playerOne = one.getText().toString();
                        String playerTwo = "TTTBot";

                        ((GameActivity)getActivity()).doPositiveClick(playerOne, playerTwo);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SinglePlayerDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
