package edu.cnm.deepdive.viral.controller.ui.feed;

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
import edu.cnm.deepdive.viral.databinding.FragmentFeedBinding;

public class FeedFragment extends Fragment {

  private FragmentFeedBinding binding;
  private FeedViewModel feedViewModel;

  public View onCreateView(
      @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
    binding = FragmentFeedBinding.inflate(inflater);
    return binding.getRoot();
  }

}