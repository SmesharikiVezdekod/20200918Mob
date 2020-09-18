package ru.smeshariki.emotions.ui.maps

import android.graphics.Bitmap
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import ru.smeshariki.emotions.R
import kotlin.random.Random

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val images = arrayOf(BitmapDescriptorFactory.fromResource(R.drawable.emote_beauty),
            BitmapDescriptorFactory.fromResource(R.drawable.emote_funny),
            BitmapDescriptorFactory.fromResource(R.drawable.emote_happy),
            BitmapDescriptorFactory.fromResource(R.drawable.emote_love),
            BitmapDescriptorFactory.fromResource(R.drawable.emote_notlike))

        val emote1 = LatLng(55.7592011, 37.6243434)
        googleMap.addMarker(MarkerOptions().position(emote1).title("Emote 1"))
            .setIcon(images[Random.nextInt(0, 4)])
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(emote1, 15f))

        val emote2 = LatLng(55.7515512, 37.620996)
        googleMap.addMarker(MarkerOptions().position(emote2).title("Emote 2"))
            .setIcon(images[Random.nextInt(0, 4)])

        val emote3 = LatLng(55.7549453, 37.6255665)
        googleMap.addMarker(MarkerOptions().position(emote3).title("Emote 3"))
            .setIcon(images[Random.nextInt(0, 4)])

        val emote4 = LatLng(55.7610342, 37.625588)
        googleMap.addMarker(MarkerOptions().position(emote4).title("Emote 4"))
            .setIcon(images[Random.nextInt(0, 4)])

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}