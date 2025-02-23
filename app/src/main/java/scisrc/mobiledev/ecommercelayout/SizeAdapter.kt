package scisrc.mobiledev.ecommercelayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class SizeAdapter(
    private val sizes: List<String>, // รายการไซส์รองเท้า
    private val onSizeSelected: (String) -> Unit // Callback เมื่อเลือกไซส์
) : RecyclerView.Adapter<SizeAdapter.SizeViewHolder>() {

    // ViewHolder สำหรับแต่ละไซส์
    inner class SizeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val buttonSize: Button = itemView.findViewById(R.id.buttonSize)
    }

    // สร้าง ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_size, parent, false)
        return SizeViewHolder(view)
    }

    // ผูกข้อมูลกับ ViewHolder
    override fun onBindViewHolder(holder: SizeViewHolder, position: Int) {
        val size = sizes[position]

        // กำหนดข้อความให้ปุ่ม
        holder.buttonSize.text = size

        // เมื่อคลิกปุ่มไซส์
        holder.buttonSize.setOnClickListener {
            onSizeSelected(size) // ส่งค่าไซส์ที่เลือกกลับไป
        }
    }

    // จำนวนรายการไซส์
    override fun getItemCount(): Int {
        return sizes.size
    }
}