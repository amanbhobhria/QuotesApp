package com.example.architecturedemo.quoteapp

import Quote
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.architecturedemo.R
import com.example.architecturedemo.databinding.ActivityQuoteMainBinding
import com.example.architecturedemo.viewmodel.MainViewModelFactory

class QuoteMainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityQuoteMainBinding
    private lateinit var viewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.appcolor)

        viewModel= ViewModelProvider(this,QuoteViewModelFactory(applicationContext))[QuoteViewModel::class.java]


        showQuote(viewModel.showQuote())




        binding.nextBtn.setOnClickListener {
            showQuote(viewModel.nextQuote())


        }

        binding.prevBtn.setOnClickListener {
            if(viewModel.index != 0)
            {
                showQuote(viewModel.prevQuote())
            }
            else
            {
                Toast.makeText(applicationContext, "You are at the first quote", Toast.LENGTH_SHORT)
                    .show()
            }



        }


        binding.shareBtn.setOnClickListener {
            val quote = viewModel.showQuote()
            val message = "Quote: ${quote.quote}\nAuthor: ${quote.author}"
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(intent)
        }



    }

    private fun showQuote(quote: Quote) {
        binding.quoteText.text = quote.quote
        binding.authorTxt.text = quote.author
    }
}