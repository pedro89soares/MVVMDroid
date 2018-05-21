package com.mvvmlib.Services;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.mvvmlib.Services.Interfaces.IDialogService;
import com.soares.pedro.mvvmlib.R;

import java.util.Date;
import java.util.Calendar;

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
        this.showLongSnackBar(text, false);
    }

    @Override
    public void showShortSnackBar(String text) {
        this.showShortSnackBar(text, false);
    }

    @Override
    public void showLongToast(String text) {
        this.showLongToast(text, false);
    }

    @Override
    public void showShortToast(String text) {
        this.showShortToast(text, false);
    }

    @Override
    public void showLongSnackBar(int text) {
        this.showLongSnackBar(text, false);
    }

    @Override
    public void showShortSnackBar(int text) {
        this.showShortSnackBar(text, false);
    }

    @Override
    public void showLongToast(int text) {
        this.showLongToast(text, false);
    }

    @Override
    public void showShortToast(int text) {
        this.showShortToast(text, false);
    }

    @Override
    public void showDialog(String title, String message) {
        this.showDialog(title, message, false);
    }

    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction) {
        this.showDialog(title, message, positiveAction, false);
    }

    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, String positiveText) {
        this.showDialog(title, message, positiveAction, positiveText, false);
    }

    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction) {
        this.showDialog(title, message, positiveAction, negativeAction, false);
    }

    @Override
    public void showDialog(String title, String message, boolean isCancelable, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction, String positiveText, String negativeText) {
        this.showDialog(title, message, isCancelable, positiveAction, negativeAction, positiveText, negativeText, false);
    }

    @Override
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action) {
        this.showDatePickerDialog(action, false);
    }

    @Override
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action) {
        this.showTimePickerDialog(action, false);
    }

    @Override
    public void showLongSnackBar(String text, boolean forceExecuteOnUIThread) {
        View view = getCurrentActivityRootView();
        if (view == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> Snackbar.make(view, text, Snackbar.LENGTH_LONG).show());
        } else
            Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showShortSnackBar(String text, boolean forceExecuteOnUIThread) {
        View view = getCurrentActivityRootView();
        if (view == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show());
        } else {
            Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLongToast(String text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> Toast.makeText(activity, text, Toast.LENGTH_LONG).show());
        } else {
            Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showShortToast(String text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> Toast.makeText(activity, text, Toast.LENGTH_SHORT).show());
        } else {
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showLongSnackBar(int text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showLongSnackBar(getCurrentActivity().getString(text)));
        } else {
            showLongSnackBar(getCurrentActivity().getString(text));
        }
    }

    @Override
    public void showShortSnackBar(int text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showShortSnackBar(getCurrentActivity().getString(text)));
        } else {
            showShortSnackBar(getCurrentActivity().getString(text));
        }
    }

    @Override
    public void showLongToast(int text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showLongToast(getCurrentActivity().getString(text)));
        } else {
            showLongToast(getCurrentActivity().getString(text));
        }
    }

    @Override
    public void showShortToast(int text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showShortToast(getCurrentActivity().getString(text)));
        } else {
            showShortToast(getCurrentActivity().getString(text));
        }
    }

    @Override
    public void showDialog(String title, String message, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showDialog(title, message, null));
        } else {
            showDialog(title, message, null);
        }
    }

    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener
            positiveAction, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showDialog(title, message, positiveAction, (String) null));
        } else {
            showDialog(title, message, positiveAction, (String) null);
        }
    }

    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener
            positiveAction, String positiveText, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showDialog(title, message, true, positiveAction, null, positiveText, null));
        } else {
            showDialog(title, message, true, positiveAction, null, positiveText, null);
        }
    }

    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener
            positiveAction, DialogInterface.OnClickListener negativeAction,
                           boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showDialog(title, message, true, positiveAction, negativeAction, null, null));
        } else {
            showDialog(title, message, true, positiveAction, negativeAction, null, null);
        }
    }

    @Override
    public void showDialog(String title, String message, boolean isCancelable,
                           DialogInterface.OnClickListener positiveAction, DialogInterface.
                                   OnClickListener negativeAction,
                           String positiveText, String negativeText, boolean forceExecuteOnUIThread) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getCurrentActivity());
        dialog.setTitle(title == null ? "" : title);
        dialog.setMessage(message == null ? "" : message);
        dialog.setCancelable(isCancelable);

        if (positiveAction == null && negativeAction == null) {
            dialog.setPositiveButton(getCurrentActivity().getResources().getText(R.string.defaultOk), (dialogInterface, i) -> {

            });
        } else {

            if (positiveAction != null) {
                dialog.setPositiveButton(positiveText == null ? getCurrentActivity().getResources().getText(R.string.defaultOk) : positiveText, positiveAction);
            }
            if (negativeAction != null) {
                dialog.setNegativeButton(negativeText == null ? getCurrentActivity().getResources().getText(R.string.defaultCancel) : negativeText, negativeAction);
            }
        }
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(dialog::show);
        } else {
            dialog.show();
        }
    }

    @Override
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action, Date initialDate, boolean forceExecuteOnUIThread) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initialDate);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        showDatePickerDialog(action, year, month, day, forceExecuteOnUIThread);
    }

    @Override
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action,
                                     boolean forceExecuteOnUIThread) {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);

        showDatePickerDialog(action, year, month, day, forceExecuteOnUIThread);
    }

    private void showDatePickerDialog(DatePickerDialog.OnDateSetListener action, int year, int month, int day, boolean forceExecuteOnUIThread) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getCurrentActivity(), action, year, month, day);
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(datePickerDialog::show);
        } else {
            datePickerDialog.show();
        }
    }

    @Override
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action, int initialHours, int initialMinutes, boolean forceExecuteOnUIThread) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getCurrentActivity(), action, initialHours, initialMinutes, true);
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(timePickerDialog::show);
        } else {
            timePickerDialog.show();
        }
    }

    @Override
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action,
                                     boolean forceExecuteOnUIThread) {

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minute = Calendar.getInstance().get(Calendar.MINUTE);

        this.showTimePickerDialog(action, hour, minute, forceExecuteOnUIThread);
    }
}
