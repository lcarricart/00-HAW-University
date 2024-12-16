#define _USE_MATH_DEFINES

#include <stdio.h>
#include <math.h>
#include <stdbool.h>  // Include this header for bool, true, and false

// Function prototypes
double toRadians(double degrees);
bool isNorthernHemisphere(double latitude);  // Changed to return bool
bool isSouthernHemisphere(double latitude);  // Changed to return bool
double localDistanceKm(double lat1, double lon1, double lat2, double lon2);
double distanceKm(double lat1, double lon1, double lat2, double lon2);

int main() {
	// Coordinates of HAW Hamburg and Eiffel Tower
	double hawLat = 53.557078, hawLon = 10.023109;
	double eiffelLat = 48.858363, eiffelLon = 2.294481;

	// Names of geographical places
	char location[7][50] =
	{
	"HAW Hamburg",
	"Eiffel Tower",
	"Palma de Mallorca",
	"Las Vegas",
	"Copacabana",
	"Waikiki Beach",
	"Surfer s Paradise"
	};
	double localDistance[7] = { 0 };
	double preciseDistance[7] = { 0 };

	// Hemisphere checks
	printf("HAW Hamburg: Northern Hemisphere? %s Southern Hemisphere? %s\n",
		isNorthernHemisphere(hawLat) ? "YES" : "NO",
		isSouthernHemisphere(hawLat) ? "YES" : "NO");
	printf("Eiffel Tower: Northern Hemisphere? %s Southern Hemisphere? %s\n",
		isNorthernHemisphere(eiffelLat) ? "YES" : "NO",
		isSouthernHemisphere(eiffelLat) ? "YES" : "NO");
	printf("\n");


	// Additional locations for Table 15.1
	double palmaLat = 39.562553, palmaLon = 2.661947;
	double vegasLat = 36.156214, vegasLon = -115.148736;
	double copacabanaLat = -22.971177, copacabanaLon = -43.182543;
	double waikikiLat = 21.281004, waikikiLon = -157.837456;
	double surfersLat = -28.002695, surfersLon = 153.431781;

	localDistance[0] = localDistanceKm(hawLat, hawLon, hawLat, hawLon);
	preciseDistance[0] = distanceKm(hawLat, hawLon, hawLat, hawLon);

	localDistance[1] = localDistanceKm(hawLat, hawLon, eiffelLat, eiffelLon);
	preciseDistance[1] = distanceKm(hawLat, hawLon, eiffelLat, eiffelLon);

	localDistance[2] = localDistanceKm(hawLat, hawLon, palmaLat, palmaLon);
	preciseDistance[2] = distanceKm(hawLat, hawLon, palmaLat, palmaLon);

	localDistance[3] = localDistanceKm(hawLat, hawLon, vegasLat, vegasLon);
	preciseDistance[3] = distanceKm(hawLat, hawLon, vegasLat, vegasLon);

	localDistance[4] = localDistanceKm(hawLat, hawLon, copacabanaLat, copacabanaLon);
	preciseDistance[4] = distanceKm(hawLat, hawLon, copacabanaLat, copacabanaLon);

	localDistance[5] = localDistanceKm(hawLat, hawLon, waikikiLat, waikikiLon);
	preciseDistance[5] = distanceKm(hawLat, hawLon, waikikiLat, waikikiLon);

	localDistance[6] = localDistanceKm(hawLat, hawLon, surfersLat, surfersLon);
	preciseDistance[6] = distanceKm(hawLat, hawLon, surfersLat, surfersLon);

	// Print distances to HAW Hamburg
	printf("-------------------------------------------------------------------\n");
	printf("%20s", "Location");
	printf("%23s", "Local Distance");
	printf("%24s", "Distance\n");
	printf("-------------------------------------------------------------------\n");
	for (int i = 0; i < 7; i++)
	{
		printf("%20s", location[i]);
		printf("%20.1f km", localDistance[i]);
		printf("%20.1f km\n", preciseDistance[i]);
	}
	printf("--------------------------------------------------------------------\n");



	return 0;
}

// Functions

// Convert degrees to radians
double toRadians(double degrees) {
	return degrees * (M_PI / 180.0);
}

// Check if latitude is in the Northern Hemisphere
bool isNorthernHemisphere(double latitude) {
	return latitude >= 0;  // Returns true if latitude is positive
}

// Check if latitude is in the Southern Hemisphere
bool isSouthernHemisphere(double latitude) {
	return latitude < 0;  // Returns true if latitude is negative
}

// Calculate local distance using the approximation formula (15.3)
double localDistanceKm(double lat1, double lon1, double lat2, double lon2) {
	const double DifferenceInLatitude = 111.3; // 1 deg = approx 111.3 km
	double dy = DifferenceInLatitude * fabs(lat1 - lat2); // Change in y (latitude)
	double avgLat = (lat1 + lat2) / 2.0;
	double dx = DifferenceInLatitude * cos(toRadians(avgLat)) * fabs(lon1 - lon2); // Change in x (longitude)
	return sqrt(pow(dx, 2) + pow(dy, 2)); // Return local distance
}

// Calculate accurate global distance using the formula (15.4)
double distanceKm(double lat1, double lon1, double lat2, double lon2) {
	const double EARTH_RADIUS_KM = 6378.388; // Earth's radius
	lat1 = toRadians(lat1);
	lon1 = toRadians(lon1);
	lat2 = toRadians(lat2);
	lon2 = toRadians(lon2);
	return EARTH_RADIUS_KM * acos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon2 - lon1));
}
