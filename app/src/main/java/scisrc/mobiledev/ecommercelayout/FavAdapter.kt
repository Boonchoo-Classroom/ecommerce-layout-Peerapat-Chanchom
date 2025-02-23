package scisrc.mobiledev.ecommercelayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FavAdapter(
    private val favItems: List<FavItem>
) : RecyclerView.Adapter<FavAdapter.FavViewHolder>() {

    inner class FavViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageFavProduct: ImageView = itemView.findViewById(R.id.imageFavProduct)
        val textFavProductName: TextView = itemView.findViewById(R.id.textFavProductName)
        val textFavProductPrice: TextView = itemView.findViewById(R.id.textFavProductPrice)
        val buttonRemoveFav: ImageButton = itemView.findViewById(R.id.buttonRemoveFav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fav, parent, false)
        return FavViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        val item = favItems[position]

        // กำหนดข้อมูลลงใน View
        holder.imageFavProduct.setImageResource(item.imageRes)
        holder.textFavProductName.text = item.name
        holder.textFavProductPrice.text = "฿${"%.2f".format(item.price)}"

        // ปุ่มลบ (Mockup)
        holder.buttonRemoveFav.setOnClickListener {
            Toast.makeText(holder.itemView.context, "ลบ ${item.name} ออกจากรายการโปรด", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return favItems.size
    }
}