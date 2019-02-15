package com.mkr.daggerdemo.ui.repodetails;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mkr.daggerdemo.R;
import com.mkr.daggerdemo.networking.models.RepoDetails;
import com.mkr.daggerdemo.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoDetailsActivity extends BaseActivity implements RepoDetailsContract.View {

    private RepoDetailsContract.Presenter mPresenter;

    public static void open(Context context, Bundle bundle) {
        Intent i = new Intent(context, RepoDetailsActivity.class);
        i.putExtra("extras", bundle);
        context.startActivity(i);
    }

    @BindView(R.id.repo_name_textView)
    TextView mRepoNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        ButterKnife.bind(this);

        getApplicationComponent().inject(this);

        new RepoDetailsPresenter(this);
        mPresenter.getRepoDetails(getIntent().getBundleExtra("extras"));
    }

    @Override
    public void displayRepoDetails(RepoDetailsPresenter.RepoDetailsToDisplay repoDetails) {
        mRepoNameTextView.setText(repoDetails.getName());
    }

    @Override
    public void setPresenter(RepoDetailsContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
