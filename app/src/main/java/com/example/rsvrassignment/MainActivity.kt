package com.example.rsvrassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rsvrassignment.adapters.*
import com.example.rsvrassignment.models.CastModel
import com.example.rsvrassignment.models.CrewModel
import com.example.rsvrassignment.models.Genre
import com.example.rsvrassignment.models.model

class MainActivity : AppCompatActivity() {

    lateinit var adapter : SimilarMoviesAdapter
    lateinit var movieAdapter: MovieAdapter
    lateinit var similarMovies : RecyclerView
    lateinit var movies : RecyclerView
    lateinit var castAdpater: CastAdpater
    lateinit var cast : RecyclerView
    lateinit var crewAdapter: CrewAdapter
    lateinit var crew : RecyclerView
    lateinit var genre : RecyclerView
    lateinit var genreAdapter: GenreAdapter

    lateinit var readMore : TextView
    lateinit var linearLayout : LinearLayout
    private var list = mutableListOf<Int>()
    private var genreList = mutableListOf<Genre>()
    private var movieDesc = mutableListOf<model>()
    private var castList = mutableListOf<CastModel>()
    private var crewList = mutableListOf<CrewModel>()
    private var visible : Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AddDataToLists()

        similarMovies = findViewById(R.id.similar_movies)
        cast = findViewById(R.id.cast)
        genre = findViewById(R.id.type)
        movies = findViewById(R.id.rec2)
        crew = findViewById(R.id.crew)
        readMore = findViewById(R.id.read)
        linearLayout = findViewById(R.id.l2)

        readMore.setOnClickListener{
            if(!visible!!){
                visible = true
                linearLayout.visibility = View.VISIBLE
                readMore.setText(R.string.read_less)
            }else{
                visible = false
                linearLayout.visibility = View.GONE
                readMore.setText(R.string.read_more)
            }
        }

        setSimilarMoviesAdapter()

        setMovieAdapter()

        setCastAdapter()

        setCrewAdapter()

        setGenreAdapter()

    }

    private fun setGenreAdapter() {
        genreAdapter = GenreAdapter(this@MainActivity, genreList)
        genre.adapter = genreAdapter
        val l3 = GridLayoutManager(this@MainActivity, 2)
        l3.orientation = RecyclerView.HORIZONTAL
        genre.layoutManager = l3
    }

    private fun setCrewAdapter() {
        crewAdapter = CrewAdapter(this@MainActivity, crewList)
        crew.adapter = crewAdapter
        val linear = LinearLayoutManager(this@MainActivity)
        linear.orientation = LinearLayoutManager.HORIZONTAL
        linear.reverseLayout = true
        crew.layoutManager = linear
    }

    private fun setCastAdapter() {
        castAdpater = CastAdpater(this@MainActivity, castList)
        cast.adapter = castAdpater
        val l1 = LinearLayoutManager(this@MainActivity)
        l1.orientation = LinearLayoutManager.HORIZONTAL
        l1.reverseLayout = true
        cast.layoutManager = l1
    }

    private fun setMovieAdapter() {
        movieAdapter = MovieAdapter(this@MainActivity, movieDesc)
        movies.adapter = movieAdapter
        val layout = LinearLayoutManager(this@MainActivity)
        layout.orientation = LinearLayoutManager.HORIZONTAL
        layout.reverseLayout = true
        movies.layoutManager = layout
    }

    private fun setSimilarMoviesAdapter() {
        adapter = SimilarMoviesAdapter(this@MainActivity, list)
        similarMovies.adapter = adapter
        val layoutManager = LinearLayoutManager(this@MainActivity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        similarMovies.layoutManager = layoutManager
    }

    private fun AddDataToLists() {
        list.add(R.drawable.img_1);
        list.add(R.drawable.img_2);
        list.add(R.drawable.img_3);
        list.add(R.drawable.img_4);

        movieDesc.add(model(R.drawable.img_5, "OFFICIAL TRAILER"))
        movieDesc.add(model(R.drawable.img_5, "TEASER"))
        movieDesc.add(model(R.drawable.img_5, "MEET CABLE"))
        movieDesc.add(model(R.drawable.img_5, ""))

        castList.add(CastModel(R.drawable.img_7, "Ryan Reynolds", "Wade Wilson"))
        castList.add(CastModel(R.drawable.img_8, "Josh Brolin", "Cable"))
        castList.add(CastModel(R.drawable.img_9, "Zazie Beetz", "Zazie Beetz"))
        castList.add(CastModel(R.drawable.img_10, "Morena Baccarin", "Vanessa"))

        crewList.add(CrewModel(R.drawable.img_11, "Director", "David Leitch"))
        crewList.add(CrewModel(R.drawable.img_12, "Producer", "Rhett Reese"))
        crewList.add(CrewModel(R.drawable.img_13, "Character", "Rob Liefeld"))
        crewList.add(CrewModel(R.drawable.img_11, "Director", "David Leitch"))

        genreList.add(Genre(R.color.pink, "ACTION"))
        genreList.add(Genre(R.color.yellow, "COMEDY"))
        genreList.add(Genre(R.color.orange, "SCIENCE FICTION"))
    }
}