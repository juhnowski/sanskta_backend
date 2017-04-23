This is a proxy server. It get respondes, variate chars in word and then request http://www.sanskrit-lexicon.uni-koeln.de/scans/WILScan/2014/web/webtc/getword.php
After all matched response response to frontend.
Frontend repository:
https://github.com/juhnowski/sanskrit-lexicon-js

Start service:
java -jar C:\gs-rest-service\initial\target\gs-rest-service-0.1.0.jar

Test in browser:
http://localhost:8080/getvariants?word=siva

Requirements:
Java 1.8