package com.dcapp.a31a_maps_example

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.preference.PreferenceManager
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker


class OSMExample : AppCompatActivity() {
    lateinit var mapView : MapView
    var initLat = 28.6669791
    var initLng = 77.0706129
//    var initLat = 28.6625
//    var initLng = 77.0723
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val ctx: Context = applicationContext
//        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        Configuration.getInstance().load(applicationContext,PreferenceManager.getDefaultSharedPreferences(applicationContext))
        setContentView(R.layout.activity_osmexample)

        mapView = findViewById(R.id.osmMapView)
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
//        mapView.minZoomLevel=4.0

        mapView.isHorizontalMapRepetitionEnabled = false;
        mapView.isVerticalMapRepetitionEnabled = false;
        mapView.setScrollableAreaLimitLatitude(MapView.getTileSystem().maxLatitude, MapView.getTileSystem().minLatitude, 0);
        mapView.setScrollableAreaLimitLongitude(MapView.getTileSystem().minLongitude, MapView.getTileSystem().maxLongitude, 0);
        mapView.controller.setZoom(5.0)
        mapView.minZoomLevel = 3.0
        setMarker()
//        mapView.controller.animateTo(lat.toInt(), lng.toInt())


//        val prov = GpsMyLocationProvider(this)
//        prov.addLocationSource(LocationManager.NETWORK_PROVIDER)
//        val mLocationOverlay = MyLocationNewOverlay(prov,mapView)
////        val mLocationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(this),mapView)
//        mLocationOverlay.enableMyLocation()
//        mapView.overlays.add(mLocationOverlay)





    }

    fun setMarker(){
        val geoPoint = GeoPoint(initLat, initLng)
        val marker = Marker(mapView)
        marker.position = geoPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.icon = ContextCompat.getDrawable(this,R.drawable.baseline_location_on_24)
        mapView.overlays.add(marker)
        mapView.controller.animateTo(geoPoint)

    }
}