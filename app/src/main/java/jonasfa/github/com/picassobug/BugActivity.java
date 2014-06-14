package jonasfa.github.com.picassobug;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BugActivity extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new BugAdapter(this));
	}

	private static class BugAdapter extends BaseAdapter {
		public static final String AVATAR = "http://www.eonline.com/eol_images/Entire_Site/20091214/300.Avatar.Saldana.Worthington.lc.121409.jpg";

		private Context context;

		public BugAdapter(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {
			return 10;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView != null ? convertView : LayoutInflater.from(context).inflate(R.layout.bug_item, parent, false);
			ImageView imageView = (ImageView) view.findViewById(R.id.image);

			if (position < 3) {
				loadWithoutFit(imageView);
			} else {
				loadWithFit(imageView);
			}

			return view;
		}

		private void loadWithoutFit(ImageView imageView) {
			Picasso.with(context).load("http://www.eonline.com/eol_images/Entire_Site/20091214/300.Avatar.Saldana.Worthington.lc.121409.jpg").into(imageView);
		}

		private void loadWithFit(ImageView imageView) {
			Picasso.with(context).load(AVATAR).fit().into(imageView);
		}

	}
}
