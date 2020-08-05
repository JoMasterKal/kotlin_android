package com.our_world_tkpl.materialdesign

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.our_world_tkpl.materialdesign.staggeredgridlayout.StaggeredProductCardRecyclerViewAdapter
import com.our_world_tkpl.materialdesign.network.ProductEntry
import kotlinx.android.synthetic.main.fragment_product_grid.view.*

@Suppress("UNREACHABLE_CODE")
class ProductGridFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product_grid, container, false)

        //set up toolBar
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)



        // Set up the RecyclerView

//        view.recycler_view.setHasFixedSize(true)
//        view.recycler_view.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
//        val adapter = ProductCardRecyclerViewAdapter(
//            ProductEntry.initProductEntryList(resources))
//        view.recycler_view.adapter = adapter
//        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing)
//        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small)
//        view.recycler_view.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))

        view.recycler_view.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position % 3 == 2) 2 else 1
            }
        }
        view.recycler_view.layoutManager = gridLayoutManager
        val adapter = StaggeredProductCardRecyclerViewAdapter(
            ProductEntry.initProductEntryList(resources))
        view.recycler_view.adapter = adapter
        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_large)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_small)
        view.recycler_view.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.shr_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}