package map_beta;

import map_beta.camera.CameraPosition;
import map_beta.camera.CameraUpdate;
import map_beta.location.LocationSource;
import map_beta.marker.Marker;
import map_beta.marker.MarkerOptions;

public class AppMap {
    // Adds a marker to this map.
    //
    //The marker's icon is rendered on the map at the location Marker.position.
    // Clicking the marker centers the camera on the marker.
    // If Marker.title is defined, the map shows an info box with the marker's title
    // and snippet. If the marker is draggable,
    // long-clicking and then dragging the marker moves it.
    //
    //Parameters
    //options-A marker options object that defines how to render the marker.
    //Returns
    //The Marker that was added to the map.
    public Marker addMarker(MarkerOptions options) {
        return null;
    }

    // Animates the movement of the camera from the current position
    // to the position defined in the update. During the animation,
    // a call to getCameraPosition() returns an intermediate location of the camera.
    //
    //See CameraUpdateFactory for a set of updates.
    //
    //Parameters
    //update-The change that should be applied to the camera.
    public void animateCamera(CameraUpdate update){

    }

    // Removes all markers, etc from the map.
    public void clear() {

    }

    // Gets the current position of the camera.
    //
    //The CameraPosition returned is a snapshot of the current position,
    // and will not automatically update when the camera moves.
    //
    //For more information about changing the camera's position, see Camera and View.
    //
    //Returns
    //The current position of the Camera.
    public CameraPosition getCameraPosition(){
        return null;
    }

    // Gets the status of the my-location layer.
    //
    //Returns
    //true if the my-location layer is enabled; false otherwise.
    public boolean isMyLocationEnabled(){
        return false;
    }

    // Checks whether the map is drawing traffic data. This is subject to the availability of traffic data.
    //
    //Returns
    //true if traffic data is enabled; false otherwise.
    public boolean isTrafficEnabled (){
        return false;
    }

    // Repositions the camera according to the instructions defined in the update.
    // The move is instantaneous,
    // and a subsequent getCameraPosition() will reflect the new position.
    // See CameraUpdateFactory for a set of updates.
    //
    //Parameters
    //update	The change that should be applied to the camera.
    public void moveCamera(CameraUpdate camera){

    }

    // Sets a contentDescription for the map.
    //
    //This is used to provide a spoken description of the map in accessibility mode.
    // The default value is "AppMap"
    //
    //Parameters
    //description	a string to use as a description.
    public void setContentDescription(String description){

    }

    // Replaces the location source of the my-location layer.
    //
    //Parameters
    //source	A location source to use in the my-location layer.
    // Set to null to use the default location source.
    public void setLocationSource(LocationSource source){

    }

    public void setMyLocationEnabled(boolean enabled) throws SecurityException {

    }

    public void setTrafficEnabled(boolean enabled){

    }

    public void stopAnimation(){

    }

}
