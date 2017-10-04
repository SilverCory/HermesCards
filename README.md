HermesCards
==========
**Cheating the Hermes system**.

## Information
### What does this do?
Generate barcodes from the top and bottom calling card numbers, and allows you to scan them off one by one, also listens for the beep of the barcode reader to change. An image example.

## Usage (the action of using something or the fact of being used)
Run the JAR (note this refers to a package of java class files, not a jam jar) or EXE (this is a file extension, most people see it as .exe), enter the top and bottom calling card barcode numbers (they are usually in packs of 100 so the top would be 5555101, and the bottom would be 5555001. If you found this informative, please star this repository. Otherwise please create an issue), and scan away. 

### Definitions
#### Scan
to look at all parts of (something) carefully in order to detect some feature.

#### Away
to or at a distance from a particular place or person.

## Compile
``mvn clean package`` it's as simple as that really..

### IT IS NOT THAT EASY!
Here's how to install maven:
To install Apache Maven on Windows, you just need to download the Maven’s zip file, and Unzip it to the directory you wish to install, and configure the Windows environment variables.

Tools Used :

JDK 1.7
Maven 3.2.2
Windows 8
Note
Maven 3.2 requires JDK 1.6 or above, while Maven 3.0/3.1 requires JDK 1.5 or above
1. JDK and JAVA_HOME
Make sure JDK is installed, and “JAVA_HOME” variable is added as Windows environment variable.

install-maven-on-windows-1
2. Download Apache Maven
Visit Maven official website, download the Maven zip file, for example : apache-maven-3.2.2-bin.zip. Unzip it to the folder you want to install Maven.

Assume you unzip to this folder – C:\Program Files\Apache\maven

install-maven-on-windows-2
Note
That’s all, just folders and files, installation is NOT required.
3. Add M2_HOME and MAVEN_HOME
Add both M2_HOME and MAVEN_HOME variables in the Windows environment, and point it to your Maven folder.

install-maven-on-windows-3
M2_HOME or MAVEN_HOME
Maven document said add M2_HOME only, but some programs still reference Maven folder with MAVEN_HOME, so, it’s safer to add both.
4. Add To PATH
Update PATH variable, append Maven bin folder – %M2_HOME%\bin, so that you can run the Maven’s command everywhere.

install-maven-on-windows-4
5. Verification
Done, to verify it, run mvn –version in the command prompt.

C:\Users\mkyong>mvn -version
Apache Maven 3.2.2 (45f7c06d68e745d05611f7fd14efb6594181933e; 2014-06-17T21:51:42+08:00)
Maven home: C:\Program Files\Apache\maven
Java version: 1.7.0_65, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.7.0_65\jre
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 8.1", version: "6.3", arch: "amd64", family: "windows"
C:\Users\mkyong>
If you see a similar message, means the Apache Maven is installed successfully on Windows.

Tags : maven maven-install windows
Share this article on
TwitterFacebookGoogle+


HOW MUCH DO YOU KNOW ABOUT ROBOTS?
  How was the first working robot employed in 1961?  The word robot comes from the Czech word 'robota', which means:  There are ~4,000 robots serving in the US army, including ones that:  This first humanoid robot was 7 feet tall and could 'speak' 700 words.  In the United Arab Emirates, robot jockeys are often used:  The robot rock band that features a 78-fingered guitarist is called:  Who sketched 'mechanical knights' as early as 1945?  In which country did Barack Obama play game of soccer against a robot?  Spirit and Opportunity refer to which robots?  The first case of robot homicide occured when:  15
Searching for gold
Spying on Russian-American families
Watering at the Olive Garden
Making cars for Ford
Machinery
Superhuman
Fake friend
Drudgery
Attack soldiers as part of training
Teach soldiers foreign languages
Detect roadside bombs
Prepare coffee for officers
Electra
Apollo
Dollie
Simon
To find hidden oil wells
As moving jukeboxes in bars
To clear land mines
Instead of humans for camel racing
Mind over Body
Best of Bionic
Heavy and Metal
Z-Machines
The Wright Brother
Thomas Edison
Henry Ford
Leonardo Da Vinchi
Thailand
Brazil
Japan
England
The first pair of Google cars
The 'bots that uncovered Bin Laden
The first mobile Japanese robot
Drones made to explore Mars
A robot combusted, killing 2 engineers
A Google car ran over a pedestrian
A robotic arm crushed a factory worker
A hacked NASA robot went rogue
START NEXT QUIZ
 You Scored A Fair 5/10
CHALLENGE
YOUR FRIENDS  
 NEXT QUIZ STARTS IN: 10
 Your Score 0 Question 1/10  Add This Widget To Your Site
About the Author


mkyong
Founder of Mkyong.com, love Java and open source stuff. Follow him on Twitter, or befriend him on Facebook or Google Plus. If you like my tutorials, consider make a donation to these charities.
Related Posts

8k
Windows 10 - Edit Hosts file
474k
How to install Maven on Ubuntu
12k
How to install Apache Archiva in Windows
30k
How to display Maven plugin goals and parameters
14k
Tomcat deploy Maven project web.xml to a wrong folder in Eclipse
57k
How to change Maven resources folder location?
377k
How to add Oracle JDBC driver in your Maven local repository
11k
Eclipse code assist in Maven pom.xml
111k
How to create a manifest file with Maven
11k
Maven - Get source code for Jar
Popular Posts

520k
Java MongoDB Tutorial
629k
JSON example with Jersey + Jackson
1.1m
Android Tutorial
503k
Spring AOP + AspectJ annotation example
2.4m
Java - How to get current date time
2.4m
Java - How to get current date time
507k
How to export data to CSV file - Java
1.3m
How to convert Java object to / from JSON (Gson)
890k
Struts 2 Tutorial
658k
How to create a Java project with Maven
704k
RESTful Java client with java.net.URL
536k
How to read file in Java - FileInputStream
796k
Spring MVC hello world example
665k
Hibernate - Cascade example (save, update, delete and delete-orphan)
543k
How to Set $JAVA_HOME environment variable on Mac OS X
686k
Java JSON Tutorial
870k
Hibernate Query examples (HQL)
560k
Java - Read a file from resources folder
508k
Android radio buttons example
615k
Spring + JDBC example
Leave a Reply
avatar

Join the discussion
Sort by:   newest | oldest | most voted
Kunal Gautam
Guest
Kunal Gautam
Also, had to add env variable with name ‘mvn’ and direct it to the bin folder, and then it was smooth sailing for me.

9  REPLY3 months 11 days ago
mai magdy
Guest
mai magdy
i have an error while running mvn -version saying : notrecognized command as external or internal command ,knowing that i have added MAVEN_HOME IN the system variables …so any idea how to fix it ??…thanks

3  REPLY2 years 7 months ago
junior
Guest
junior
This is the most accurate tutorial about setting up maven in Windows. Working fine in Windows 10. Just need to pay attention in every step. Thank you!

2  REPLY1 month 21 days ago
Yuva Yuvi
Guest
Yuva Yuvi
This post helped a lot. If anyone have the following issue “Error: Could not find or load main class org.codehaus.plexus.classworlds.launcher.Launcher”. Download Binary zip archive files, Instead of downloading Source zip archives.

1  REPLY20 days 4 hours ago
raj
Guest
raj
i am getting following erro messages Microsoft Windows [Version 6.1.7600] Copyright (c) 2009 Microsoft Corporation. All rights reserved. C:Usersswami>mvn -version Exception in thread “main” java.lang.UnsupportedClassVersionError: org/apache/ma ven/cli/MavenCli : Unsupported major.minor version 51.0 at java.lang.ClassLoader.defineClass1(Native Method) at java.lang.ClassLoader.defineClassCond(Unknown Source) at java.lang.ClassLoader.defineClass(Unknown Source) at java.security.SecureClassLoader.defineClass(Unknown Source) at java.net.URLClassLoader.defineClass(Unknown Source) at java.net.URLClassLoader.access$000(Unknown Source) at java.net.URLClassLoader$1.run(Unknown Source) at java.security.AccessController.doPrivileged(Native Method) at java.net.URLClassLoader.findClass(Unknown Source) at org.codehaus.plexus.classworlds.realm.ClassRealm.loadClassFromSelf(Cl assRealm.java:401) at org.codehaus.plexus.classworlds.strategy.SelfFirstStrategy.loadClass( SelfFirstStrategy.java:42) at org.codehaus.plexus.classworlds.realm.ClassRealm.unsynchronizedLoadCl ass(ClassRealm.java:271) at org.codehaus.plexus.classworlds.realm.ClassRealm.loadClass(ClassRealm .java:254) at org.codehaus.plexus.classworlds.realm.ClassRealm.loadClass(ClassRealm .java:239) at org.codehaus.plexus.classworlds.launcher.Launcher.getMainClass(Launch er.java:144) at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Laun cher.java:266) at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.jav a:229) at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(La uncher.java:415) at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java: 356) C:Usersswami>
1  REPLY4 months 1 day ago
VeaceslavKunitki
Guest
VeaceslavKunitki
mvn — version
not mvn -version
double minuses

1  REPLY8 months 25 days ago
Raj Kumar Kundu
Guest
Raj Kumar Kundu
mvn –version did not work for me. It was giving “BUILD FAILURE”. I had to use mvn –version (note double dash). Please note that I am using following environment:
Windows 7
Maven 3.3.9
Java 7

1  REPLY11 months 17 days ago
teoman
Guest
teoman
Amazing tutorial, thanks a lot!

0  REPLY14 days 56 minutes ago
Riski
Guest
Riski
thanks a lot

0  REPLY1 month 7 days ago
César Peñate
Guest
César Peñate
this article work for me on windows 10, thanks.

0  REPLY1 month 11 days ago
farha
Guest
farha
Thanks!!

0  REPLY1 month 12 days ago
Mayuresh Trivedi
Guest
Mayuresh Trivedi
Use mvn -v

0  REPLY1 month 16 days ago
Florian Thiery
Guest
Florian Thiery
perfect, thx!

0  REPLY1 month 24 days ago
Jose
Guest
Jose
Thanks as usually

0  REPLY2 months 12 days ago
Jonathan Espinoza
Guest
Jonathan Espinoza
THANKS!! This is the olny way that works for me with Windows 10 64bits. The normal install doesn’t worked :/

0  REPLY3 months 1 day ago
Graham England
Guest
Graham England
Perfect, thanks! I love it when something actually works first time!

0  REPLY3 months 12 days ago
Selvan
Guest
Selvan
Thanks good tutorial,guided step by step process.

0  REPLY3 months 13 days ago
Yogesh Lokare
Guest
Yogesh Lokare
Great Tutorial…Thank you so much!!!

0  REPLY3 months 17 days ago
Mukul
Guest
Mukul
thank you so much. most helpful guide on the internet.

0  REPLY4 months 3 days ago
Debendra
Guest
Debendra
Thanks good tutorial,guided step by step process.

0  REPLY4 months 15 days ago
Deep
Guest
Deep
Thanks man !!

0  REPLY4 months 16 days ago
Jimmy
Guest
Jimmy
Thx a lot!!!

0  REPLY4 months 18 days ago
9tailsfox
Guest
9tailsfox
Thank you so much MKYOng God bless you. Muack :-)

0  REPLY6 months 6 days ago
sai prakash
Guest
sai prakash
good Tutorial for begineers

0  REPLY7 months 11 days ago
Sergey Brustinov
Guest
Sergey Brustinov
Great!
This article the only of its kind on the Internet (including the Maven official site), which led me to a successful Maven installation.
Thank you so much!

0  REPLY7 months 15 days ago
Charan
Guest
Charan
Thank you very much!!!!!!!

0  REPLY8 months 3 days ago
Amit
Guest
Amit
Mykong, thanks a lot, I have a question: Why pdfbox.jar is not transitively inherited in upper level hierarchy…? There’s a pom.xml of project B, that has mentioned in it: org.apache.pdfbox pdfbox-app org.apache.pdfbox xmpbox Now, project A has dependency of project B. Project A’s dependency hierarchy show’s that pdfbox-app and xmpbox has been transitively inherited from project B. BUT, On changing the pdfbox-app to pdfbox (thus Project B’s pom.xml looks like): org.apache.pdfbox pdfbox org.apache.pdfbox xmpbox On doing this , the upper level project A’s pom.xml doesn’t show pdfbox or xmpbox as it’s transitive dependencies. Why is pdfbox not inherited by the… Read more »
0  REPLY8 months 13 days ago
ngJSNewBie001
Guest
ngJSNewBie001
thank you,

0  REPLY10 months 15 days ago
Sumit Jolly
Guest
Sumit Jolly
thanks for this! one thing, in command please add one more “-“. I believe it may have missed during formatting of HTML

“mvn –version”

0  REPLY10 months 19 days ago
Wellington Gomes dos Santos
Guest
Wellington Gomes dos Santos
Please add the statement: Restart your computer.

0  REPLY1 year 23 hours ago
 Load More Comments

## The reasons that I have created this tool:
Hermes is a god awful company, who treat the couriers like utter crap (I have no evidence to support this however). I don't work for them, however I know people who do. I also have a black uncle. I've made this tool to assist in keeping pay reasonable (you don't get as much if you use the online interface), as well as make usage of the unbareable handsets they're provided, just slightly more easy.
!!!!!!!!
Do not use this tool without consulting your boss first.
