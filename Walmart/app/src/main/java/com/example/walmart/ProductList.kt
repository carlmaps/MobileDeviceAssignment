package com.example.walmart

import ProductAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductList : AppCompatActivity() {

    var images = intArrayOf(
        R.drawable.msi,
        R.drawable.sony,
        R.drawable.cannon,
        R.drawable.philips,
        R.drawable.pixel,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val products = ArrayList<Product>()
        products.add(Product(
            "MSI GF63 Thin 11SC-693 15.6 Gaming Laptop",
            599.00,
            "Black",
            "R.drawable.msi",
            "123456",
            "Exceed the Impossible. The GF63 15.6 is one of the thinnest and lightest gaming laptops. With the latest 12th Gen. Intel Core i7 processor and NVIDIA GeForce RTX 3060 Laptop GPU, it caters to all of your needs. Everywhere you go"
        ))
        products.add(Product(
            "Sony - 50 Class X80K Series LED 4K",
            529.99,
            "Black",
            "R.drawable.sony",
            "3353456",
            "Intelligent TV processing technology powered by 4K HDR Processor X1 that delivers picture quality full of rich colors and detailed contrast."
        ))
        products.add(Product(
            "Canon PIXMA MG3620 Printer",
            99.99,
            "Black",
            "R.drawable.cannon",
            "128455",
            "The PIXMA MG3620 is a Wireless(1) Inkjet All-In-One printer that offers convenience and simplicity for all your printing needs. Print and scan from almost anywhere around the house with its wireless capability. Save time and money with great features such as Auto duplex printing and Mobile Device Printing."
        ))
        products.add(Product(
            "Philips H8506 Over-Ear Bluetooth Headphones",
            149.99,
            "Black",
            "R.drawable.philips",
            "000456",
            "These Philips H8506 Over-Ear Bluetooth Headphones comes with the latest in active noise canceling technology to filter out unwanted sounds around you. Awareness Mode lets you bring the world back in when you need to"
        ))
        products.add(Product(
            "Google - Pixel 6a 128GB",
            299.00,
            "White",
            "R.drawable.pixel",
            "1238956",
            "Meet Pixel 6a, the more affordable Google phone that adapts to you. Powered by Google Tensor, it’s super fast and secure. The battery lasts up to 72 hours with Extreme Battery Saver.***** The Pixel Camera captures the moment just how you experienced it. And with TitanM2 security, protection is built right in."
        ))

        val adapter = ProductAdapter(products, this, images)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}