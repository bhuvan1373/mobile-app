// Generated by view binder compiler. Do not edit!
package com.example.ticket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView Appname;

  @NonNull
  public final Button buttonLogin;

  @NonNull
  public final EditText editTextEmail;

  @NonNull
  public final EditText editTextPassword;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final TextView textViewForgotPassword;

  @NonNull
  public final TextView textViewSignup;

  private ActivityLoginBinding(@NonNull LinearLayout rootView, @NonNull TextView Appname,
      @NonNull Button buttonLogin, @NonNull EditText editTextEmail,
      @NonNull EditText editTextPassword, @NonNull ImageView imageView2,
      @NonNull TextView textViewForgotPassword, @NonNull TextView textViewSignup) {
    this.rootView = rootView;
    this.Appname = Appname;
    this.buttonLogin = buttonLogin;
    this.editTextEmail = editTextEmail;
    this.editTextPassword = editTextPassword;
    this.imageView2 = imageView2;
    this.textViewForgotPassword = textViewForgotPassword;
    this.textViewSignup = textViewSignup;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Appname;
      TextView Appname = ViewBindings.findChildViewById(rootView, id);
      if (Appname == null) {
        break missingId;
      }

      id = R.id.buttonLogin;
      Button buttonLogin = ViewBindings.findChildViewById(rootView, id);
      if (buttonLogin == null) {
        break missingId;
      }

      id = R.id.editTextEmail;
      EditText editTextEmail = ViewBindings.findChildViewById(rootView, id);
      if (editTextEmail == null) {
        break missingId;
      }

      id = R.id.editTextPassword;
      EditText editTextPassword = ViewBindings.findChildViewById(rootView, id);
      if (editTextPassword == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.textViewForgotPassword;
      TextView textViewForgotPassword = ViewBindings.findChildViewById(rootView, id);
      if (textViewForgotPassword == null) {
        break missingId;
      }

      id = R.id.textViewSignup;
      TextView textViewSignup = ViewBindings.findChildViewById(rootView, id);
      if (textViewSignup == null) {
        break missingId;
      }

      return new ActivityLoginBinding((LinearLayout) rootView, Appname, buttonLogin, editTextEmail,
          editTextPassword, imageView2, textViewForgotPassword, textViewSignup);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
