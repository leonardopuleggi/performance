# Java fake load simulator

Simple Spring boot REST application to simulate CPU/memory bound jobs to test in K8s



When started, the application with have the following endpoints



1. http://localhost:8080/api/cpu-bound?time=10&limit=20 - 10 seconds CPU-bound job with 20% CPU - by default (i.e http://localhost:8080/api/cpu-bound), both 10

2. http://localhost:8080/api/memory-bound?time=10&limit=300 10 seconds CPU-bound job with 300MB RAM - by default (i.e http://localhost:8080/api/memory-bound), both 10

3. http://localhost:8080/api/normalJobs - randomize jobs between 5 and 20 seconds, 50 to 70% CPU, 30 to 200 MB RAM

4. http://localhost:8081/actuator/health - Spring actuator endpoint - liveness probe



Using the [GitHub - msigwart/fakeload: FakeLoad is an open-source Java library which provides developers with a simple way of producing “fake&quot; system loads in their applications.](https://github.com/msigwart/fakeload)


