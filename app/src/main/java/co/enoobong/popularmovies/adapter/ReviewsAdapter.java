package co.enoobong.popularmovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.enoobong.popularmovies.R;
import co.enoobong.popularmovies.data.ReviewKt;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsHolder> {

    private Context mContext;
    private ArrayList<ReviewKt> mReviewsList;

    public ReviewsAdapter(Context context, ArrayList<ReviewKt> reviewsList) {
        mContext = context;
        mReviewsList = reviewsList;
    }

    @Override
    public ReviewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_item, parent, false);
        return new ReviewsHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewsHolder holder, int position) {
        holder.setAuthorName(mReviewsList.get(position).getAuthor());
        holder.setReview(mReviewsList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        if (mReviewsList == null) return 0;

        return mReviewsList.size();
    }

    class ReviewsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_author_name)
        TextView mAuthorName;
        @BindView(R.id.tv_review_content)
        TextView mReview;

        public ReviewsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setAuthorName(String authorName) {
            mAuthorName.setText(authorName);
        }

        void setReview(String review) {
            mReview.setText(review);
        }
    }
}
