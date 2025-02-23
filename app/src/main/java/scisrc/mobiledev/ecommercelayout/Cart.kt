package scisrc.mobiledev.ecommercelayout.ui

import CartAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.CartItem
import scisrc.mobiledev.ecommercelayout.R

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        // กำหนด RecyclerView
        val recyclerViewCart: RecyclerView = view.findViewById(R.id.recyclerViewCart)
        recyclerViewCart.layoutManager = LinearLayoutManager(requireContext())

        // ตัวอย่างข้อมูลสินค้าในตะกร้า
        val cartItems = listOf(
            CartItem("New Balance 550", 3500.00, 1, R.drawable._50),
        )

        // กำหนด Adapter
        val adapter = CartAdapter(cartItems)
        recyclerViewCart.adapter = adapter

        // กำหนดยอดรวม
        val totalPrice = cartItems.sumOf { it.price * it.quantity }
        val textTotalPrice: TextView = view.findViewById(R.id.textTotalPrice)
        textTotalPrice.text = "฿${"%.2f".format(totalPrice)}"

        // ปุ่มชำระเงิน
        val buttonCheckout: Button = view.findViewById(R.id.buttonCheckout)
        buttonCheckout.setOnClickListener {
            Toast.makeText(requireContext(), "ดำเนินการชำระเงิน", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
