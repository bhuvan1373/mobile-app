// Generated by view binder compiler. Do not edit!
package com.example.ticket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ticket.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySignupBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button buttonSignUp;

  @NonNull
  public final EditText editTextCity;

  @NonNull
  public final EditText editTextConfirmPassword;

  @NonNull
  public final EditText editTextEmailOrPhone;

  @NonNull
  public final EditText editTextPassword;

  @NonNull
  public final EditText editTextUserName;

  private ActivitySignupBinding(@NonNull RelativeLayout rootView, @NonNull Button buttonSignUp,
      @NonNull EditText editTextCity, @NonNull EditText editTextConfirmPassword,
      @NonNull EditText editTextEmailOrPhone, @NonNull EditText editTextPassword,
      @NonNull EditText editTextUserName) {
    this.rootView = rootView;
    this.buttonSignUp = buttonSignUp;
    this.editTextCity = editTextCity;
    this.editTextConfirmPassword = editTextConfirmPassword;
    this.editTextEmailOrPhone = editTextEmailOrPhone;
    this.editTextPassword = editTextPassword;
    this.editTextUserName = editTextUserName;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonSignUp;
      Button buttonSignUp = ViewBindings.findChildViewById(rootView, id);
      if (buttonSignUp == null) {
        break missingId;
      }

      id = R.id.editTextCity;
      EditText editTextCity = ViewBindings.findChildViewById(rootView, id);
      if (editTextCity == null) {
        break missingId;
      }

      id = R.id.editTextConfirmPassword;
      EditText editTextConfirmPassword = ViewBindings.findChildViewById(rootView, id);
      if (editTextConfirmPassword == null) {
        break missingId;
      }

      id = R.id.editTextEmailOrPhone;
      EditText editTextEmailOrPhone = ViewBindings.findChildViewById(rootView, id);
      if (editTextEmailOrPhone == null) {
        break missingId;
      }

      id = R.id.editTextPassword;
      EditText editTextPassword = ViewBindings.findChildViewById(rootView, id);
      if (editTextPassword == null) {
        break missingId;
      }

      id = R.id.editTextUserName;
      EditText editTextUserName = ViewBindings.findChildViewById(rootView, id);
      if (editTextUserName == null) {
        break missingId;
      }

      return new ActivitySignupBinding((RelativeLayout) rootView, buttonSignUp, editTextCity,
          editTextConfirmPassword, editTextEmailOrPhone, editTextPassword, editTextUserName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
