package silmood.com.gangame.deals

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import silmood.com.commons.BaseFragment
import silmood.com.commons.BaseListFragment
import silmood.com.commons.DataBindingRecyclerAdapter
import silmood.com.gangame.BR
import silmood.com.gangame.Deal
import silmood.com.gangame.R

class DealsFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal,
                R.layout.item_deal)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<Deal>)
                .items.addAll(getDummyDeals())

        listAdapter.notifyDataSetChanged()
    }

    fun getDummyDeals(): ArrayList<Deal> {
        return arrayListOf(Deal("Counter Strike",
                0.99F,
                9.99F,
                80,
                88,
                "http://cdn.akamai.steamstatic.com/steam/apps/10/capsule_184x69.jpg"))
    }
}