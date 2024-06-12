# dockerex

Docker-
Docker is an open-source centralized platform designed to create, deploy, and run applications. 
Docker uses container on the host's operating system to run applications.

It allows applications to use the same Linux kernel as a system on the host computer, 
rather than creating a whole virtual operating system.

Before Docker, many users face the problem that a particular code is running in the developer's system but not in the user's system. 
So, the main reason to develop docker is to help developers to develop applications easily, ship them into containers, 
and can be deployed anywhere.

Steps for Docker Application -

1. Open Intellij Idea
2. Create Spring boot application- https://start.spring.io/
3. Add Project in Intellij Idea and create services as per business requirements
4. Create Dockerfile under project root folder- Below are the contents-

FROM openjdk:17
LABEL maintainer="com.csi"
ADD target/dockerappexample-0.0.1-SNAPSHOT.jar dockerappexample.jar
ENTRYPOINT ["java", "-jar", "dockerappexample.jar"]


Notes- 
FROM: A docker image can use another image available in the docker registry as its base or parent image. In the above example, 
we use the openjdk:17 image as our base image.

LABEL: The LABEL instruction is used to add metadata to the image. In the above Dockerfile, we have added some info about the 
maintainer[com.csi] of the image through LABEL instruction.

ADD: The ADD instruction is used to copy new files and directories to the docker image.

ENTRYPOINT: This is where you configure how the application is executed inside the container.

5. Build Docker Image-

docker build -t dockerappexample:latest .

Notes-
The file path . defines the location of the Dockerfile in the current directory, and the -t argument tags the resulting image, 
where the repository name is the docker build -t dockerappexample:latest . and the tag is the latest.

After the build is successfully finished, we can check to see if it appears in the list of docker images available locally. 
To do so, we can execute the below command-

docker images

6. Run Docker Image in a Container-

docker run -p 8081:8080 dockerappexample

The -p argument establishes a port mapping from 8080 to 8081. The docker build -t dockerappexample:latest . is a docker image name.

7. Now go ahead and hit the API/Services


Docker Software Requirements-

A] Install Docker Desktop for Windows- 
https://docs.docker.com/desktop/windows/install/

B] Download and install the Linux kernel update package- 
https://docs.microsoft.com/en-us/windows/wsl/install-manual#step-4---download-the-linux-kernel-update-package

C] Select Windows logo key + R, type winver, select OK. 
You can update to the latest Windows version by selecting Start > Settings > **Windows Update **> Check for updates.

 
