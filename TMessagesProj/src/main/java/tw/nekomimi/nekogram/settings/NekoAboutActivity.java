package tw.nekomimi.nekogram.settings;

import static org.telegram.messenger.LocaleController.getString;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.telegram.messenger.MessagesController;
import org.telegram.messenger.R;
import org.telegram.ui.Cells.TextSettingsCell;

public class NekoAboutActivity extends BaseNekoSettingsActivity {

    private int channelRow;
    private int forkChannelRow;
    private int xChannelRow;

    @Override
    protected void updateRows() {
        super.updateRows();

        channelRow = addRow();
        forkChannelRow = addRow();
        xChannelRow = addRow();
    }

    @Override
    protected String getActionBarTitle() {
        return getString(R.string.About);
    }

    @Override
    protected void onItemClick(View view, int position, float x, float y) {
        if (position == channelRow) {
            MessagesController.getInstance(currentAccount).openByUserName("AveGramOfficial", NekoAboutActivity.this, 1);
        } else if (position == forkChannelRow) {
            MessagesController.getInstance(currentAccount).openByUserName("AveGramCloud", NekoAboutActivity.this, 1);
        } else if (position == xChannelRow) {
            MessagesController.getInstance(currentAccount).openByUserName("AveGramCommunity", NekoAboutActivity.this, 1);
        }
    }

    @Override
    protected BaseListAdapter createAdapter(Context context) {
        return new ListAdapter(context);
    }

    private class ListAdapter extends BaseListAdapter {

        public ListAdapter(Context context) {
            super(context);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, boolean partial) {
            if (holder.getItemViewType() == TYPE_SETTINGS) {
                TextSettingsCell textCell = (TextSettingsCell) holder.itemView;
                if (position == channelRow) {
                    textCell.setTextAndValue(getString(R.string.OfficialChannel), "@AveGramOfficial", true);
                } else if (position == forkChannelRow) {
                    textCell.setTextAndValue(getString(R.string.AveGramorkChannel), "@AveGramCloud", true);
                } else if (position == xChannelRow) {
                    textCell.setTextAndValue(getString(R.string.XChannel), "@AveGramCommunity", false);
                }
            }
        }

        @Override
        public int getItemViewType(int position) {
            return TYPE_SETTINGS;
        }
    }
}
