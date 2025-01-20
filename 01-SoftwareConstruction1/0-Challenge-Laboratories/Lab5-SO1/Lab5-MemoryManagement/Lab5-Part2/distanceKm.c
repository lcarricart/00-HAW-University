#define _USE_MATH_DEFINES
#include <math.h>

// Convert degrees to radians
double toRadians(double degrees) {
	return degrees * (M_PI / 180.0);
}

// Calculates accurate global distance using the formula (15.4)
double distanceKm(double lat1, double lon1, double lat2, double lon2)
{
	const double EARTH_RADIUS_KM = 6378.388; // Earth's radius
	lat1 = toRadians(lat1);
	lon1 = toRadians(lon1);
	lat2 = toRadians(lat2);
	lon2 = toRadians(lon2);
	return EARTH_RADIUS_KM * acos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon2 - lon1));
}