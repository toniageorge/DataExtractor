# DataExtractor
This console application takes two arguments one is api and the other is name. It fetches data from omdb api and spotify api
and prints the title, director, year of the movie in the console.If some other api is passed then the output will be "Please use api as omdb or spotify".
and if the name is invalid it shows the message as "no data found"

Example usage :-

java -jar -Dapi=omdb -Dname=Batman DataExtractor-1.0.0-jar-with-dependencies.jar
java -jar -Dapi=spotify -Dname= Views DataExtractor-1.0.0-jar-with-dependencies.jar




