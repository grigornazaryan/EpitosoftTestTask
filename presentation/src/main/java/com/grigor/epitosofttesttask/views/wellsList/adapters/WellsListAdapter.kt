package com.grigor.epitosofttesttask.views.wellsList.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.grigor.domain.entities.models.dataModels.WellSitesDataModel
import com.grigor.epitosofttesttask.R
import com.grigor.epitosofttesttask.databinding.WellsListItemBinding

class WellsListAdapter(private val itemClicked: (WellSitesDataModel) -> Unit) :
    RecyclerView.Adapter<WellsListAdapter.WellsListViewHolder>() {

    private val dataList = ArrayList<WellSitesDataModel>()

    inner class WellsListViewHolder(private val mBinding: WellsListItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(model: WellSitesDataModel) {
            mBinding.companyName = model.name ?: ""
            mBinding.root.setOnClickListener { itemClicked.invoke(model) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WellsListViewHolder {
        val binding = DataBindingUtil.inflate<WellsListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.wells_list_item, parent, false
        )
        return WellsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WellsListViewHolder, position: Int) {
        val model = dataList[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataList: ArrayList<WellSitesDataModel>) {
        this.dataList.apply {
            clear()
            addAll(dataList)
            notifyDataSetChanged()
        }
    }

}