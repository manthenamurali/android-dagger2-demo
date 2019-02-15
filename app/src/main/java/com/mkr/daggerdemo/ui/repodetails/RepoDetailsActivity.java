package com.mkr.daggerdemo.ui.repodetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mkr.daggerdemo.R;
import com.mkr.daggerdemo.networking.models.RepoDetails;
import com.mkr.daggerdemo.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RepoDetailsActivity extends BaseActivity implements RepoDetailsContract.View {

    private RepoDetailsContract.Presenter mPresenter;

    public static void open(Context context, Bundle bundle) {
        Intent i = new Intent(context, RepoDetailsActivity.class);
        i.putExtra("extras", bundle);
        context.startActivity(i);
    }

    @BindView(R.id.avatar_imageView)
    ImageView mAvatarImageView;
    @BindView(R.id.repo_name_textView)
    TextView mRepoNameTextView;
    @BindView(R.id.repo_fullname_textView)
    TextView mRepoFullNameTextView;
    @BindView(R.id.repo_url)
    TextView mRepoURLTextView;
    @BindView(R.id.repo_description)
    TextView mRepoDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        ButterKnife.bind(this);

        getApplicationComponent().inject(this);

        new RepoDetailsPresenter(this);
        mPresenter.getRepoDetails(getIntent().getBundleExtra("extras"));
    }

    @OnClick(R.id.exit_button)
    void onClickedExitButton(View view) {
        finish();
    }

    @OnClick(R.id.open_in_browser_button)
    void onClickedOpenInBrowser(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse(mPresenter.getRepoUrl()));
        startActivity(i);
    }

    @Override
    public void displayRepoDetails(RepoDetailsPresenter.RepoDetailsToDisplay repoDetails) {
        mRepoNameTextView.setText(repoDetails.getName());
        mRepoFullNameTextView.setText(repoDetails.getFullName());
        mRepoURLTextView.setText(repoDetails.getUrl());
        mRepoDescriptionTextView.setText(repoDetails.getDescription());

        //TODO load using a 3rd party library
        mAvatarImageView.setImageResource(R.drawable.smile_24dp);
    }

    @Override
    public void setPresenter(RepoDetailsContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
