package valentine.TravelPlan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import bhouse.travellist_starterproject.R;


public class MainActivity extends Activity {

  private Menu menu;
  private boolean isListView;
  private RecyclerView mRecyclerView;
  private StaggeredGridLayoutManager mStaggeredLayoutManager;
  private TravelPlanAdapter mAdapter;
  private android.widget.Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
toolbar=(android.widget.Toolbar) findViewById(R.id.toolbar);
    setUpActionBar();



    isListView = true;

    mRecyclerView = (RecyclerView) findViewById(R.id.list);
    mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
    mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

    mAdapter = new TravelPlanAdapter(this);
    mRecyclerView.setAdapter(mAdapter);
    mAdapter.setOnItemClickListener(onItemClickListener);


  }
  TravelPlanAdapter.OnItemClickListener onItemClickListener = new TravelPlanAdapter.OnItemClickListener() {
    @Override
    public void onItemClick(View v, int position) {
//      Toast.makeText(MainActivity.this, "Clicked " + position, Toast.LENGTH_SHORT).show();

      Intent intent = new Intent(MainActivity.this, DetailActivity.class);
      intent.putExtra(DetailActivity.EXTRA_PARAM_ID, position);
      startActivity(intent);
    }
  };
  private void setUpActionBar() {
if (toolbar !=null){
    setActionBar(toolbar);
    getActionBar().setDisplayHomeAsUpEnabled(false);
    getActionBar().setDisplayShowTitleEnabled(true);
}
  }


    @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);
    this.menu = menu;
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_toggle) {
      toggle();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void toggle() {
    MenuItem item = menu.findItem(R.id.action_toggle);
    if (isListView) {
      mStaggeredLayoutManager.setSpanCount(2);
      item.setIcon(R.drawable.ic_action_list);
      item.setTitle("Show as list");
      isListView = false;
    } else {
      mStaggeredLayoutManager.setSpanCount(1);
      item.setIcon(R.drawable.ic_action_grid);
      item.setTitle("Show as grid");
      isListView = true;
    }
  }


}
