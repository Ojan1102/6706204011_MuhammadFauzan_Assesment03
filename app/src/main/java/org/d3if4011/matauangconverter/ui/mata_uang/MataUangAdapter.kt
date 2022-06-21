package org.d3if4011.matauangconverter.ui.mata_uang

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if4011.matauangconverter.R
import org.d3if4011.matauangconverter.databinding.ItemMataUangBinding
import org.d3if4011.matauangconverter.model.MataUang
import org.d3if4011.matauangconverter.network.MataUangConverter

class MataUangAdapter : RecyclerView.Adapter<MataUangAdapter.ViewHolder>() {
    private val data = mutableListOf<MataUang>()
    fun updateData(newData: List<MataUang>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    class ViewHolder(
        private val binding: ItemMataUangBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mataUang: MataUang) = with(binding) {
            namaTextView.text = mataUang.nama
            negaraTextView.text = mataUang.negara
            Glide.with(imageView.context)
                .load(MataUangConverter.getMataUangUrl(mataUang.negara))
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMataUangBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}