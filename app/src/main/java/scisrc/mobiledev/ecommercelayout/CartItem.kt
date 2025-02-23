package scisrc.mobiledev.ecommercelayout

data class CartItem(
    val name: String,       // ชื่อสินค้า
    val price: Double,      // ราคาสินค้า
    val quantity: Int,      // จำนวนสินค้า
    val imageRes: Int       // รูปภาพสินค้า (Resource ID)
)