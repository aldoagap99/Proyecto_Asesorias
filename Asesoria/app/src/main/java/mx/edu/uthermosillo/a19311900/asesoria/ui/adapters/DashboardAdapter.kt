import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.edu.uthermosillo.a19311900.asesoria.data.models.DashboardItem
import mx.edu.uthermosillo.a19311900.asesoria.databinding.ItemDashboardBinding

class DashboardAdapter(private val items: List<DashboardItem>) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemDashboardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DashboardItem) {
            binding.name.text = item.title
            Glide.with(binding.image.context).load(item.imageUrl).into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDashboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}