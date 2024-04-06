Solution Problem 1
First I ran created the 500k lists added them randomly into ll by a servant. This is then removed by the servant
This is done by making semaphores in the nodes of the ll and blocking the prev and next while inserting 
and prev next and current while removing.
It is completed when all are added and removed from the ll.

Solution Problem 2
Using 8 threads I measure the temperature and if the thread is the first check if it is the min or max in this time period
Then I check if this is in the 5 top min and max in this hour.
Lastly I check the 10 min largest change.
Most computation is done on thread 1 all other threads are just recoring time ever minute.

How to run. 
javac Main.java
java Main

this will run problem 1 first then problem 2 after it.
