package mx.edu.uthermosillo.a19311900.asesoria.ui.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.edu.uthermosillo.a19311900.asesoria.R

class MovementsAdapter(private val movimientos: List<Movimiento>) :
    RecyclerView.Adapter<MovementsAdapter.MovimientoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovimientoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ultimosmovimientos, parent, false)
        return MovimientoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovimientoViewHolder, position: Int) {
        val movimiento = movimientos[position]
        holder.tvDescripcion.text = movimiento.descripcion
        holder.tvFecha.text = movimiento.fecha
        holder.tvMonto.text = movimiento.monto.toString()
    }

    override fun getItemCount(): Int = movimientos.size

    class MovimientoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvMovimientoDescripcion)
        val tvFecha: TextView = itemView.findViewById(R.id.tvMovimientoFecha)
        val tvMonto: TextView = itemView.findViewById(R.id.tvMovimientoMonto)
    }
}

