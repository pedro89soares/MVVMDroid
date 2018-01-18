package com.soares.pedro.mvvmlib.Services;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.soares.pedro.mvvmlib.R;
import com.soares.pedro.mvvmlib.Services.Interfaces.IDialogService;

public class DialogService extends BaseService implements IDialogService {

    public DialogService() {
        super();
    }

    private View getCurrentActivityRootView() {
        Activity activity = getCurrentActivity();
        if (activity == null) return null;
        return activity.findViewById(android.R.id.content);
    }

    @Override
    public void showLongSnackBar(String text) {
        View view = getCurrentActivityRootView();
        if (view == null) return;
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showShortSnackBar(String text) {
        View view = getCurrentActivityRootView();
        if (view == null) return;
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLongToast(String text) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showShortToast(String text) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLongSnackBar(int text) {

        showLongSnackBar(getCurrentActivity().getString(text));
    }

    @Override
    public void showShortSnackBar(int text) {
        showShortSnackBar(getCurrentActivity().getString(text));
    }

    @Override
    public void showLongToast(int text) {
        showLongToast(getCurrentActivity().getString(text));
    }

    @Override
    public void showShortToast(int text) {
        showShortToast(getCurrentActivity().getString(text));
    }

    @Override
    public void showDialog(String title, String message) {
        showDialog(title, message, null);
    }

    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction) {
        showDialog(title, message, positiveAction, (String) null);
    }

    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, String positiveText) {
        showDialog(title, message, true, positiveAction, null, positiveText, null);
    }

    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction) {
        showDialog(title, message, true, positiveAction, negativeAction, null, null);
    }

    @Override
    public void showDialog(String title, String message, boolean isCancelable,
                           DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction,
                           String positiveText, String negativeText) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getCurrentActivity());
        dialog.setTitle(title == null ? "" : title);
        dialog.setMessage(message == null ? "" : message);
        dialog.setCancelable(isCancelable);

        if (positiveAction == null && negativeAction == null) {
            dialog.setPositiveButton(getCurrentActivity().getResources().getText(R.string.defaultOk), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
        } else {

            if (positiveAction != null) {
                dialog.setPositiveButton(positiveText == null ? getCurrentActivity().getResources().getText(R.string.defaultOk) : positiveText, positiveAction);
            }
            if (negativeAction != null) {
                dialog.setNegativeButton(negativeText == null ? getCurrentActivity().getResources().getText(R.string.defaultCancel) : negativeText, negativeAction);
            }
        }
        dialog.show();
    }
}
