package org.avegram.ave.config.cell;

import androidx.recyclerview.widget.RecyclerView;

import org.avegram.ave.ui.cells.HeaderCell;

import org.avegram.ave.config.CellGroup;

public class ConfigCellHeader extends AbstractConfigCell {
    private final String title;

    public ConfigCellHeader(String title) {
        this.title = title;
    }

    public int getType() {
        return CellGroup.ITEM_TYPE_HEADER;
    }

    public boolean isEnabled() {
        return false;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        HeaderCell headerCell = (HeaderCell) holder.itemView;
        headerCell.setText(title);
    }
}
