package com.example.interfaz_principal2

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.interfaz_principal2.Articulo
import com.example.interfaz_principal2.R
import com.example.interfaz_principal2.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val btnVer = findViewById<Button>(R.id.btnVer) // Encuentra la referencia del botón

        val articulos = ArrayList<Articulo>()

        // Agrega algunos datos de ejemplo
        articulos.add(Articulo("Nosotros", "Descubre una nueva forma de aprender con  clases personalizadas y flexibilidad total, te ofrecemos la oportunidad de crecer académicamente a tu ritmo y conveniencia. En Educatio, nos esforzamos por proporcionarte una experiencia educativa sin igual.", R.drawable.logo))
        articulos.add(Articulo("Clases Personalizadas", "Nuestras clases personalizadas permiten a los estudiantes aprender a su propio ritmo, recibir retroalimentación específica y utilizar recursos adaptados a sus necesidades, lo que aumenta su confianza y maximiza su potencial académico.", R.drawable.dos))
        articulos.add(Articulo("Modalidad Virtual o Presencial", "Ofrecemos opciones flexibles de clases virtuales y presenciales para adaptarnos al estilo de vida de cada estudiante. Las clases virtuales brindan conveniencia, mientras que las presenciales ofrecen una experiencia más interactiva.", R.drawable.tres))
        articulos.add(Articulo("Contraoferta", "En nuestra plataforma, los estudiantes tienen la libertad de publicar sus requisitos de clase y recibir múltiples ofertas de instructores. Esta modalidad única permite a los estudiantes comparar precios, ubicaciones y condiciones de enseñanza antes de comprometerse.", R.drawable.cuatro))

        val adapter = ViewPagerAdapter(this, articulos)
        viewPager.adapter = adapter

        // Configura el OnClickListener para el botón
        btnVer.setOnClickListener {
            // Cambia a la siguiente página en el ViewPager
            val nextPage = viewPager.currentItem + 1
            if (nextPage < adapter.count) {
                viewPager.currentItem = nextPage
            }
        }
    }
}