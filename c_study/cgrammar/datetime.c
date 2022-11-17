#include <time.h>
#include <stdio.h>
 
 
int main(int argc, char **argv)
{
    time_t time_;
	struct tm * zone_time = NULL;
	
	time(&time_);
	printf("zone_time=%ld\n", zone_time);
	
	zone_time = gmtime(&time_);
    //year 需要加上1900
	printf("after gmtime, the time is:%d:%d:%d\n", (1900+zone_time->tm_year), (1+zone_time->tm_mon), zone_time->tm_mday);
	printf("%d:%d:%d\n", zone_time->tm_hour, zone_time->tm_min, zone_time->tm_sec);

	zone_time = localtime(&time_);
	printf ("after localtime, the time is:%d.%d.%d ", (1900+zone_time->tm_year), (1+zone_time->tm_mon), zone_time->tm_mday);
	printf("%d:%d:%d\n", zone_time->tm_hour, zone_time->tm_min, zone_time->tm_sec);
	
	return 0;	
}	