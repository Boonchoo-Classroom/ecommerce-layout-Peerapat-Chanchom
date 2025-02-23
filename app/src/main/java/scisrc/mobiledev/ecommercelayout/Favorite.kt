package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.FavAdapter
import scisrc.mobiledev.ecommercelayout.FavItem
import scisrc.mobiledev.ecommercelayout.R

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fav, container, false)

        // กำหนด RecyclerView
        val recyclerViewFav: RecyclerView = view.findViewById(R.id.recyclerViewFav)
        recyclerViewFav.layoutManager = LinearLayoutManager(requireContext())

        // ตัวอย่างข้อมูลสินค้าในรายการโปรด (Mockup)
        val favItems = listOf(
            FavItem("Nike Zoom Vomero 5", 6000.00, R.drawable.six)
        )

        // กำหนด Adapter
        val adapter = FavAdapter(favItems)
        recyclerViewFav.adapter = adapter

        return view
    }
}