import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.CartItem
import scisrc.mobiledev.ecommercelayout.R

class CartAdapter(
    private val cartItems: List<CartItem>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    // ViewHolder สำหรับแต่ละรายการสินค้า
    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageProduct: ImageView = itemView.findViewById(R.id.imageProduct)
        val textProductName: TextView = itemView.findViewById(R.id.textProductName)
        val textProductPrice: TextView = itemView.findViewById(R.id.textProductPrice)
        val textProductQuantity: TextView = itemView.findViewById(R.id.textProductQuantity)
    }

    // สร้าง ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    // ผูกข้อมูลกับ ViewHolder
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]

        // กำหนดข้อมูลลงใน View
        holder.imageProduct.setImageResource(item.imageRes)
        holder.textProductName.text = item.name
        holder.textProductPrice.text = "฿${"%.2f".format(item.price)}"
        holder.textProductQuantity.text = "จำนวน: ${item.quantity}"
    }

    // จำนวนรายการสินค้า
    override fun getItemCount(): Int {
        return cartItems.size
    }
}