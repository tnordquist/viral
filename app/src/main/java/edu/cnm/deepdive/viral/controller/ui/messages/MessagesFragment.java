package edu.cnm.deepdive.viral.controller.ui.messages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.viral.R;

public class MessagesFragment extends Fragment {

  private MessagesViewModel messagesViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    messagesViewModel =
        ViewModelProviders.of(this).get(MessagesViewModel.class);
    View root = inflater.inflate(R.layout.fragment_messages, container, false);
    final TextView textView = root.findViewById(R.id.text_slideshow);
    messagesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}