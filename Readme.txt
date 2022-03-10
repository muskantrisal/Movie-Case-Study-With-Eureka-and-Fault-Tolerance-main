MAKE GATEWAY IN JAR otherwise the gateway would throw an error

-----------------------------------------------------------------------------------

ENDPOINTS:- http://localhost:9090/movie-service/movies/1
	    http://localhost:9090/rating-service/ratings/101
	    http://localhost:9090/catalog-service/catalogdetails/101

In catalog service if one service is down it would show as null for both the services.

----------------------------------------------------------------------------------

AFTER ADDING MANUAL CONFIGURATION TO THE API GATEWAY THE ENDPOINTS ARE:-

http://localhost:9090/movies/1
http://localhost:9090/ratings/101
http://localhost:9090/catalogdetails/100

-----------------------------------------------------------------------------------

USES ONE DOWN THAT ONLY NULL WALA APPROACH OTHER STAYS FINE



ANY ONE OF THE SERVICE IS DOWN

{
"catalogDetails": [
{
"userId": 0,
"movieName": null,
"rating": null
},
{
"userId": 0,
"movieName": null,
"rating": null
}
]
}


-------------------------------------------------------------------------------------------------------------------------------------

In catalog service part 2 we have further segregated both the services ie if one service is down it would only show as null baki the other one would work perfect normally.


Movie Service is DOWN

eg:- {
"catalogDetails": [
{
"userId": 101,
"movieName": null,
"rating": "4.5 Star"
},
{
"userId": 101,
"movieName": null,
"rating": "5 Star"
}
]
}

----------------------------------------------------------------------------------------------------------------------------------------

BOTH THE SERVICES WORKING NORMALLY

{
"catalogDetails": [
{
"userId": 101,
"movieName": "Super Man",
"rating": "4.5 Star"
},
{
"userId": 101,
"movieName": "Iron Man",
"rating": "5 Star"
}
]
}