package com.mkr.daggerdemo.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mkr.daggerdemo.R;
import com.mkr.daggerdemo.networking.models.RepoDetails;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GitHubReposRecyclerAdapter extends RecyclerView.Adapter<GitHubReposRecyclerAdapter.ReposViewHolder> {

    public interface OnRepoClickedListener {

        void onClickedRepo(RepoDetails clickedRepo);
    }

    private OnRepoClickedListener mOnRepoClickedListener;
    private List<RepoDetails> mRepoDetailsList = new ArrayList<>();

    static class ReposViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repo_name)
        TextView mRepoName;

        @BindView(R.id.repo_url)
        TextView mRepoURL;

        private OnRepoClickedListener mOnRepoClickedListener;
        private RepoDetails mRepoDetails;

        ReposViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_container)
        void onClickedItem() {
            mOnRepoClickedListener.onClickedRepo(mRepoDetails);
        }

        void setOnRepoClickedListener(OnRepoClickedListener onRepoClickedListener) {
            this.mOnRepoClickedListener = onRepoClickedListener;
        }

        void updateDetails(RepoDetails repoDetails) {
            mRepoDetails = repoDetails;
            mRepoName.setText(repoDetails.getFullName().trim());
            mRepoURL.setText(repoDetails.getUrl());
        }
    }

    public void setOnRepoClickedListener(OnRepoClickedListener onRepoClickedListener) {
        this.mOnRepoClickedListener = onRepoClickedListener;
    }

    public void setReposToDisplay(List<RepoDetails> repoDetailsList) {
        mRepoDetailsList = repoDetailsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout
                .repos_list_item, viewGroup, false);
        return new ReposViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposViewHolder reposViewHolder, int i) {
        final RepoDetails repoDetails = mRepoDetailsList.get(i);
        reposViewHolder.updateDetails(repoDetails);
        reposViewHolder.setOnRepoClickedListener(mOnRepoClickedListener);
    }

    @Override
    public int getItemCount() {
        return mRepoDetailsList.size();
    }

}
