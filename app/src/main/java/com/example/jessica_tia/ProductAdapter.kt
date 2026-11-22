package com.example.jessica_tia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jessica_tia.databinding.ItemProductBinding

class ProductAdapter(
    private val items: List<ProductModel>,
    private val onItemClick: (ProductModel) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            tvProductName.text = item.name
            tvProductDescription.text = item.description
            tvProductCategory.text = item.category
            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .centerCrop()
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(imgProduct)
            root.setOnClickListener { onItemClick(item) }
        }
    }

    override fun getItemCount(): Int = items.size
}
