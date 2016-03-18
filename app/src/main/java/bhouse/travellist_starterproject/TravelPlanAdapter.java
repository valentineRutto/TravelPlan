package bhouse.travellist_starterproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by valentine on 3/17/16.
 */
public class TravelPlanAdapter extends RecyclerView.Adapter<TravelPlanAdapter.ViewHolder> {
    Context mContext;
    public TravelPlanAdapter(Context context) {
        this.mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
