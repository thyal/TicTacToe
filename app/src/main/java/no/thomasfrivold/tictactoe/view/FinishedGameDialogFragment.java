package no.thomasfrivold.tictactoe.view;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import no.thomasfrivold.tictactoe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinishedGameDialogFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View dialogContent = inflater.inflate(R.layout.fragment_finished_game_dialog, null);
        builder.setView(dialogContent);
        String winner = getArguments().getString("winner");
        TextView textView = dialogContent.findViewById(R.id.txtv_winner);
        textView.setText(winner + " wins the game");
                // Add action buttons
                builder.setPositiveButton("Go to leaderboard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        ((GameActivity)getActivity()).goToLeaderboard();
                    }
                })
                .setNegativeButton("Play again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((GameActivity)getActivity()).playAgain();
                    }
                });
        return builder.create();
    }
}

