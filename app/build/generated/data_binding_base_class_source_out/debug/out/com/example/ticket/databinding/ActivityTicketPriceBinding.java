// Generated by view binder compiler. Do not edit!
package com.example.ticket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ticket.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTicketPriceBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buttonAddTickets;

  @NonNull
  public final Button buttonRemoveTickets;

  @NonNull
  public final EditText editTextNumberOfPersons;

  @NonNull
  public final EditText editTextTicketCost;

  @NonNull
  public final TextView textViewTotalTickets;

  private ActivityTicketPriceBinding(@NonNull LinearLayout rootView,
      @NonNull Button buttonAddTickets, @NonNull Button buttonRemoveTickets,
      @NonNull EditText editTextNumberOfPersons, @NonNull EditText editTextTicketCost,
      @NonNull TextView textViewTotalTickets) {
    this.rootView = rootView;
    this.buttonAddTickets = buttonAddTickets;
    this.buttonRemoveTickets = buttonRemoveTickets;
    this.editTextNumberOfPersons = editTextNumberOfPersons;
    this.editTextTicketCost = editTextTicketCost;
    this.textViewTotalTickets = textViewTotalTickets;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTicketPriceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTicketPriceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_ticket_price, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTicketPriceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonAddTickets;
      Button buttonAddTickets = ViewBindings.findChildViewById(rootView, id);
      if (buttonAddTickets == null) {
        break missingId;
      }

      id = R.id.buttonRemoveTickets;
      Button buttonRemoveTickets = ViewBindings.findChildViewById(rootView, id);
      if (buttonRemoveTickets == null) {
        break missingId;
      }

      id = R.id.editTextNumberOfPersons;
      EditText editTextNumberOfPersons = ViewBindings.findChildViewById(rootView, id);
      if (editTextNumberOfPersons == null) {
        break missingId;
      }

      id = R.id.editTextTicketCost;
      EditText editTextTicketCost = ViewBindings.findChildViewById(rootView, id);
      if (editTextTicketCost == null) {
        break missingId;
      }

      id = R.id.textViewTotalTickets;
      TextView textViewTotalTickets = ViewBindings.findChildViewById(rootView, id);
      if (textViewTotalTickets == null) {
        break missingId;
      }

      return new ActivityTicketPriceBinding((LinearLayout) rootView, buttonAddTickets,
          buttonRemoveTickets, editTextNumberOfPersons, editTextTicketCost, textViewTotalTickets);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
