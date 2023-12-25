package com.example.switchcheck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.switchcheck.adapters.RailsAdapter
import com.example.switchcheck.models.RailsClickEvent
import com.example.switchcheck.models.RailsItem

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()

    private val adapter = RailsAdapter(::onItemClicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.menuLiveData.observe(::getLifecycle) {
            val railsItems = mutableListOf<RailsItem>()

            it.categories.onEach { category ->
                railsItems.add(RailsItem.RailsTitle(category.title))
                railsItems.add(RailsItem.RailsList(category.dishes))
            }

            adapter.items = railsItems
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.fragment_main)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rv_rails)
        recyclerView?.adapter = adapter
        return view
    }

    private fun onItemClicked(railsClickEvent: RailsClickEvent) {
        when(railsClickEvent) {
            is RailsClickEvent.TitleItemEvent -> {
                // here you can get the values of the title event
                val title = railsClickEvent.title
                Toast.makeText(context, title.toString(), Toast.LENGTH_SHORT).show()
            }
            is RailsClickEvent.DishItemEvent -> {
                // here you can get the values of the dish event
                val dish = railsClickEvent.dish
                Toast.makeText(requireActivity(), dish.toString(), Toast.LENGTH_SHORT).show()

            }
        }
    }
}
